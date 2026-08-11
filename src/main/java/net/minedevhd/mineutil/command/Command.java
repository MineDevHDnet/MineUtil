package net.minedevhd.mineutil.command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import net.labymod.api.events.MessageSendEvent;
import net.labymod.main.LabyMod;
import net.minedevhd.mineutil.settings.UtilCore;

public abstract class Command implements UtilCore {

    private String name;
    private String displayName;
    private String description;
    private String syntax;
    private Category category;
    private final List<String> aliases = new ArrayList<String>();

    protected Command(final String name, final String displayName, final String description,
                      final String syntax, final Category category) {
        this.name = name;
        this.displayName = displayName;
        this.description = description;
        this.syntax = syntax;
        this.category = category;
    }

    public abstract void onCommand(String[] args, String command);

    public abstract void update();

    public abstract boolean isActiv();

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(final String displayName) {
        this.displayName = displayName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(final String description) {
        this.description = description;
    }

    public String getSyntax() {
        return syntax;
    }

    public void setSyntax(final String syntax) {
        this.syntax = syntax;
    }

    public Category getCategory() {
        return category;
    }

    public List<String> getAliases() {
        return aliases;
    }

    public static String transformMessage(final String module, final boolean value) {
        return mineUtil.getSettings().getPrefix() + "§7Module §e" + module + "§7 is now "
                + (value ? "§aactivated" : "§cdeactivated") + "§7.";
    }

    public static void initCmdBase() {
        CommandManager.setup();

        mineUtil.getApi().getEventManager().register(new MessageSendEvent() {
            @Override
            public boolean onSend(final String rawMessage) {
                if (rawMessage == null) {
                    return false;
                }

                final String prefix = CommandManager.getPrefix();
                if (!rawMessage.startsWith(prefix) || rawMessage.equals(prefix)) {
                    return false;
                }

                final String message = rawMessage.substring(prefix.length()).trim();
                if (message.isEmpty()) {
                    return false;
                }

                final String[] parts = message.split("\\s+");
                final String commandName = parts[0];

                for (final Command command : CommandManager.getCommands()) {
                    if (!matches(command, commandName)) {
                        continue;
                    }

                    if (!mineUtil.getSettings().isModEnabled()) {
                        LabyMod.getInstance().displayMessageInChat(
                                mineUtil.getSettings().getPrefix()
                                        + "§cThe addon is deactivated, so commands are unavailable."
                        );
                        return true;
                    }

                    try {
                        command.onCommand(Arrays.copyOfRange(parts, 1, parts.length), message);
                    } catch (final RuntimeException exception) {
                        System.err.println("[MineUtil] Command failed: " + command.getName());
                        exception.printStackTrace();
                        LabyMod.getInstance().displayMessageInChat(
                                mineUtil.getSettings().getPrefix()
                                        + "§cCommand failed. Check the game log for details."
                        );
                    }
                    return true;
                }

                LabyMod.getInstance().displayMessageInChat(
                        mineUtil.getSettings().getPrefix()
                                + "§4Error! §cThe command §8(§6" + rawMessage
                                + "§8) §ccannot be found! §b(" + prefix + "help)"
                );
                return true;
            }
        });
    }

    private static boolean matches(final Command command, final String commandName) {
        if (command.getName() != null && command.getName().equalsIgnoreCase(commandName)) {
            return true;
        }

        for (final String alias : command.getAliases()) {
            if (alias != null && alias.equalsIgnoreCase(commandName)) {
                return true;
            }
        }

        if (command.getSyntax() != null) {
            final String trimmedSyntax = command.getSyntax().trim();
            if (!trimmedSyntax.isEmpty()) {
                final String syntaxCommand = trimmedSyntax.split("\\s+", 2)[0];
                return syntaxCommand.equalsIgnoreCase(commandName);
            }
        }
        return false;
    }
}
