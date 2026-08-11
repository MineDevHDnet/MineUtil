package net.minedevhd.mineutil.command;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import net.minedevhd.mineutil.command.impl.*;
import net.minedevhd.mineutil.settings.UtilCore;

public final class CommandManager implements UtilCore {

    private static final List<Command> COMMANDS = new ArrayList<Command>();
    private static final String DEFAULT_PREFIX = ".";

    private CommandManager() {
    }

    public static String getPrefix() {
        if (mineUtil == null || mineUtil.getSettings() == null) {
            return DEFAULT_PREFIX;
        }

        final String configuredPrefix = mineUtil.getSettings().getCommandPrefix();
        if (configuredPrefix == null || configuredPrefix.trim().isEmpty()) {
            return DEFAULT_PREFIX;
        }
        return configuredPrefix;
    }

    public static List<Command> getCommands() {
        return Collections.unmodifiableList(COMMANDS);
    }

    public static void setup() {
        COMMANDS.clear();

        // General
        COMMANDS.add(new Help());
        COMMANDS.add(new NBT());
        COMMANDS.add(new Join());
        COMMANDS.add(new Author());
        COMMANDS.add(new Reload());
        COMMANDS.add(new LabyNet());
        COMMANDS.add(new Credits());
        COMMANDS.add(new Vote());

        // Movement
        COMMANDS.add(new Fly());
        COMMANDS.add(new Glide());
        COMMANDS.add(new Sneak());
        COMMANDS.add(new NoFall());
        COMMANDS.add(new Sprint());
        COMMANDS.add(new Parkour());
        COMMANDS.add(new Dolphin());
        COMMANDS.add(new Autowalk());

        // World
        COMMANDS.add(new KillArmorStands());

        // Fun
        COMMANDS.add(new MoneyDropGrabber());
        COMMANDS.add(new DlSkin());

        // Player
        COMMANDS.add(new AFK());
        COMMANDS.add(new Say());
        COMMANDS.add(new AutoRespawn());
        COMMANDS.add(new Autobreak());
        COMMANDS.add(new AutouseItem());
        COMMANDS.add(new Spammer());

        // Legacy commands. Kept for compatibility; no new exploit behaviour is added here.
        COMMANDS.add(new Give());
        COMMANDS.add(new CmdBook());
        COMMANDS.add(new Hologram());
        COMMANDS.add(new ArmorSpammer());
        COMMANDS.add(new MurderMystery());
    }
}
