package net.minedevhd.mineutil.utils;

import java.awt.Desktop;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Base64;
import java.util.Collection;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.lwjgl.input.Keyboard;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.authlib.properties.Property;

import net.labymod.api.events.MessageSendEvent;
import net.labymod.main.LabyMod;
import net.labymod.utils.ModColor;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntitySkull;
import net.minecraft.util.BlockPos;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.MovingObjectPosition;
import net.minedevhd.mineutil.settings.UtilCore;

public final class HeadDownloaderUtil implements UtilCore {

    private static final JsonParser JSON_PARSER = new JsonParser();
    private static final DateTimeFormatter FILE_FORMAT = DateTimeFormatter.ofPattern("dd.MM.yyyy_HH-mm-ss-SSS");
    private static final String INTERNAL_COMMAND = "/mmucp_hod";
    private static final String ALLOWED_TEXTURE_HOST = "textures.minecraft.net";

    private static final ThreadPoolExecutor DOWNLOAD_EXECUTOR = new ThreadPoolExecutor(
            1,
            1,
            0L,
            TimeUnit.MILLISECONDS,
            new ArrayBlockingQueue<Runnable>(10),
            new ThreadFactory() {
                @Override
                public Thread newThread(final Runnable runnable) {
                    final Thread thread = new Thread(runnable, "MineUtil-HeadDownloader");
                    thread.setDaemon(true);
                    thread.setPriority(Thread.MIN_PRIORITY);
                    return thread;
                }
            },
            new ThreadPoolExecutor.DiscardOldestPolicy()
    );

    private HeadDownloaderUtil() {
    }

    public static void register() {
        LabyMod.getInstance().getEventManager().register(new MessageSendEvent() {
            @Override
            public boolean onSend(final String message) {
                if (message == null || !message.startsWith(INTERNAL_COMMAND)) {
                    return false;
                }

                handleInternalCommand(message);
                return true;
            }
        });
    }

    private static void handleInternalCommand(final String message) {
        final String[] parts = message.trim().split("\\s+");
        if (parts.length != 3 || !isSafeFilename(parts[2])) {
            displayError("Ungültiger interner Datei-Befehl.");
            return;
        }

        final String action = parts[1];
        final File file;
        try {
            file = resolveTextureFile(parts[2]);
        } catch (final IOException exception) {
            displayError("Dateipfad konnte nicht aufgelöst werden.");
            return;
        }

        try {
            if ("show".equalsIgnoreCase(action)) {
                revealFile(file);
            } else if ("open".equalsIgnoreCase(action)) {
                openFile(file);
            } else if ("delete".equalsIgnoreCase(action)) {
                final boolean deleted = Files.deleteIfExists(file.toPath());
                LabyMod.getInstance().displayMessageInChat(
                        mineUtil.getSettings().getPrefix()
                                + (deleted ? "§aDie Datei wurde gelöscht." : "§eDie Datei existiert nicht mehr.")
                );
            } else {
                displayError("Unbekannte Datei-Aktion.");
            }
        } catch (final IOException | RuntimeException exception) {
            System.err.println("[MineUtil] Head texture file action failed: " + exception.getMessage());
            displayError("Die Datei-Aktion konnte nicht ausgeführt werden.");
        }
    }

    public static String buildClickable(final String display, final String hover, final String command) {
        final JsonObject component = new JsonObject();
        component.addProperty("text", display == null ? "" : display);

        final JsonObject clickEvent = new JsonObject();
        clickEvent.addProperty("action", "run_command");
        clickEvent.addProperty("value", command == null ? "" : command);
        component.add("clickEvent", clickEvent);

        final JsonObject hoverEvent = new JsonObject();
        hoverEvent.addProperty("action", "show_text");
        hoverEvent.addProperty("value", hover == null ? "" : hover);
        component.add("hoverEvent", hoverEvent);
        return component.toString();
    }

    private static void revealFile(final File file) throws IOException {
        if (file == null || !file.exists()) {
            throw new IOException("File does not exist");
        }

        final String os = System.getProperty("os.name", "").toLowerCase();
        if (os.contains("win")) {
            new ProcessBuilder("explorer.exe", "/select,", file.getCanonicalPath()).start();
            return;
        }

        final File parent = file.getCanonicalFile().getParentFile();
        if (Desktop.isDesktopSupported() && parent != null) {
            Desktop.getDesktop().open(parent);
            return;
        }
        throw new IOException("Desktop integration is not supported");
    }

    private static void openFile(final File file) throws IOException {
        if (file == null || !file.exists()) {
            throw new IOException("File does not exist");
        }
        if (!Desktop.isDesktopSupported() || !Desktop.getDesktop().isSupported(Desktop.Action.OPEN)) {
            throw new IOException("Desktop OPEN action is not supported");
        }
        Desktop.getDesktop().open(file);
    }

    public static TileEntity getTileEntityLooking() {
        try {
            final Minecraft minecraft = mineUtil.getMinecraft();
            if (minecraft == null || minecraft.thePlayer == null || minecraft.theWorld == null) {
                return null;
            }

            final MovingObjectPosition hit = minecraft.thePlayer.rayTrace(10.0D, 1.0F);
            if (hit == null) {
                return null;
            }

            final BlockPos blockPos = hit.getBlockPos();
            return blockPos == null ? null : minecraft.theWorld.getTileEntity(blockPos);
        } catch (final RuntimeException exception) {
            return null;
        }
    }

    public static String getValueHovering() {
        final Minecraft minecraft = mineUtil.getMinecraft();
        if (minecraft == null || !(minecraft.currentScreen instanceof GuiContainer)) {
            return null;
        }

        final Slot slot = ((GuiContainer) minecraft.currentScreen).getSlotUnderMouse();
        if (slot == null || !slot.getHasStack()) {
            return null;
        }

        final ItemStack item = slot.getStack();
        if (item == null) {
            return null;
        }

        final NBTTagCompound nbt = item.writeToNBT(new NBTTagCompound());
        try {
            final String value = nbt.getCompoundTag("tag")
                    .getCompoundTag("SkullOwner")
                    .getCompoundTag("Properties")
                    .getTagList("textures", 10)
                    .getCompoundTagAt(0)
                    .getString("Value");
            return value == null || value.trim().isEmpty() ? "notex" : value;
        } catch (final RuntimeException exception) {
            return "notex";
        }
    }

    public static String getValueLooking() {
        final TileEntity tileEntity = getTileEntityLooking();
        if (!(tileEntity instanceof TileEntitySkull)) {
            return null;
        }

        final TileEntitySkull skull = (TileEntitySkull) tileEntity;
        if (skull.getPlayerProfile() == null) {
            return "notex";
        }

        final Collection<Property> textures = skull.getPlayerProfile().getProperties().get("textures");
        if (textures == null || textures.isEmpty()) {
            return "notex";
        }

        for (final Property property : textures) {
            if (property != null && property.getValue() != null && !property.getValue().trim().isEmpty()) {
                return property.getValue();
            }
        }
        return "notex";
    }

    public static void onKeyPress() {
        if (mineUtil.getSettings() == null || !mineUtil.getSettings().isModEnabled()) {
            return;
        }

        final Integer configuredKey = mineUtil.getSettings().getHeadDownloadKey();
        if (configuredKey == null || configuredKey == -1) {
            return;
        }

        final boolean keyDown = Keyboard.isKeyDown(configuredKey);
        if (keyDown == mineUtil.isGuiKeyPressed) {
            return;
        }

        mineUtil.isGuiKeyPressed = keyDown;
        if (!keyDown) {
            return;
        }

        String value = getValueHovering();
        if (value == null) {
            value = getValueLooking();
        }

        if (value == null) {
            LabyMod.getInstance().displayMessageInChat(
                    mineUtil.getSettings().getPrefix() + ModColor.cl('c') + "Bitte schaue auf einen Kopf!"
            );
            return;
        }
        if ("notex".equalsIgnoreCase(value)) {
            LabyMod.getInstance().displayMessageInChat(
                    mineUtil.getSettings().getPrefix() + ModColor.cl('c') + "Dieser Kopf hat keine Textur."
            );
            return;
        }

        final String encodedTexture = value;
        DOWNLOAD_EXECUTOR.execute(new Runnable() {
            @Override
            public void run() {
                downloadTexture(encodedTexture);
            }
        });
    }

    private static void downloadTexture(final String encodedTexture) {
        try {
            final String jsonText = new String(Base64.getDecoder().decode(encodedTexture), StandardCharsets.UTF_8);
            final JsonElement root = JSON_PARSER.parse(jsonText);
            if (root == null || !root.isJsonObject()) {
                throw new IOException("Texture payload is not a JSON object");
            }

            final JsonObject rootObject = root.getAsJsonObject();
            final JsonObject textures = getObject(rootObject, "textures");
            final JsonObject skin = getObject(textures, "SKIN");
            final JsonElement urlElement = skin.get("url");
            if (urlElement == null || !urlElement.isJsonPrimitive()) {
                throw new IOException("Missing skin texture URL");
            }

            final URL textureUrl = new URL(urlElement.getAsString());
            if (!ALLOWED_TEXTURE_HOST.equalsIgnoreCase(textureUrl.getHost())) {
                throw new IOException("Blocked texture host: " + textureUrl.getHost());
            }
            if (!"https".equalsIgnoreCase(textureUrl.getProtocol())
                    && !"http".equalsIgnoreCase(textureUrl.getProtocol())) {
                throw new IOException("Unsupported texture protocol");
            }

            final BufferedImage image = readImage(textureUrl);
            if (image == null) {
                throw new IOException("Downloaded data is not an image");
            }

            final String filename = "mu_" + FILE_FORMAT.format(LocalDateTime.now());
            final File target = resolveTextureFile(filename);
            if (!ImageIO.write(image, "PNG", target)) {
                throw new IOException("No PNG writer available");
            }

            postDownloadSuccess(filename);
        } catch (final Exception exception) {
            System.err.println("[MineUtil] Head texture download failed: " + exception.getMessage());
            postChat(mineUtil.getSettings().getPrefix()
                    + "§4Fehler! §cDie Kopftextur konnte nicht heruntergeladen werden. Siehe Log-Datei.");
        }
    }

    private static JsonObject getObject(final JsonObject parent, final String key) throws IOException {
        if (parent == null || !parent.has(key) || !parent.get(key).isJsonObject()) {
            throw new IOException("Missing JSON object: " + key);
        }
        return parent.getAsJsonObject(key);
    }

    private static BufferedImage readImage(final URL url) throws IOException {
        final URLConnection connection = url.openConnection();
        connection.setConnectTimeout(8000);
        connection.setReadTimeout(12000);
        connection.setRequestProperty("User-Agent", "MineUtil/1.4.0");

        try (InputStream input = new BufferedInputStream(connection.getInputStream())) {
            return ImageIO.read(input);
        } finally {
            if (connection instanceof HttpURLConnection) {
                ((HttpURLConnection) connection).disconnect();
            }
        }
    }

    private static void postDownloadSuccess(final String filename) {
        final Minecraft minecraft = mineUtil.getMinecraft();
        if (minecraft == null) {
            return;
        }

        minecraft.addScheduledTask(new Runnable() {
            @Override
            public void run() {
                LabyMod.getInstance().displayMessageInChat(
                        mineUtil.getSettings().getPrefix()
                                + "§7Die Kopftextur wurde unter " + ModColor.cl('a') + filename + ".png"
                                + ModColor.cl('7') + " gespeichert."
                );

                if (minecraft.thePlayer == null) {
                    return;
                }

                final String json = "[\"" + escapeJson(mineUtil.getSettings().getPrefix()) + "\"," 
                        + buildClickable(ModColor.cl('a') + "[Anzeigen]", "Zeigt die Datei im Dateiexplorer an", INTERNAL_COMMAND + " show " + filename)
                        + ",\" \","
                        + buildClickable(ModColor.cl('e') + "[Öffnen]", "Öffnet die Datei im Standardprogramm", INTERNAL_COMMAND + " open " + filename)
                        + ",\" \","
                        + buildClickable(ModColor.cl('c') + "[Löschen]", "Löscht die Datei", INTERNAL_COMMAND + " delete " + filename)
                        + "]";
                minecraft.thePlayer.addChatMessage(IChatComponent.Serializer.jsonToComponent(json));
            }
        });
    }

    private static void postChat(final String message) {
        final Minecraft minecraft = mineUtil.getMinecraft();
        if (minecraft == null) {
            return;
        }
        minecraft.addScheduledTask(new Runnable() {
            @Override
            public void run() {
                LabyMod.getInstance().displayMessageInChat(message);
            }
        });
    }

    private static File resolveTextureFile(final String filename) throws IOException {
        if (!isSafeFilename(filename)) {
            throw new IOException("Unsafe filename");
        }

        final File directory = new File(mineUtil.getMinecraft().mcDataDir, "MineUtil/head_textures").getCanonicalFile();
        if (!directory.exists() && !directory.mkdirs()) {
            throw new IOException("Could not create texture directory");
        }

        final File target = new File(directory, filename + ".png").getCanonicalFile();
        if (!directory.equals(target.getParentFile())) {
            throw new IOException("Path escaped texture directory");
        }
        return target;
    }

    private static boolean isSafeFilename(final String filename) {
        return filename != null && filename.matches("[A-Za-z0-9._-]{1,120}");
    }

    private static String escapeJson(final String text) {
        if (text == null) {
            return "";
        }
        return text.replace("\\", "\\\\").replace("\"", "\\\"");
    }

    private static void displayError(final String message) {
        LabyMod.getInstance().displayMessageInChat(
                mineUtil.getSettings().getPrefix() + "§4Fehler! §c" + message
        );
    }
}
