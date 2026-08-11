package net.minedevhd.mineutil.command.impl;

import net.labymod.main.LabyMod;
import net.minedevhd.mineutil.command.Category;
import net.minedevhd.mineutil.command.Command;
import net.minedevhd.mineutil.command.CommandManager;
import net.minedevhd.mineutil.settings.UtilCore;

public final class Spammer extends Command implements UtilCore {

    private static final int DEFAULT_DELAY_TICKS = 80;
    private static final int MIN_DELAY_TICKS = 1;
    private static final int MAX_DELAY_TICKS = 399;

    private int delayTicks = DEFAULT_DELAY_TICKS;
    private int ticksUntilSend = DEFAULT_DELAY_TICKS;
    private boolean activated;
    private String spamMessage = "";

    public Spammer() {
        super("Spammer", "Spammer [Singletake]",
                "Repeatedly sends a configured chat message or command",
                "spammer", Category.PLAYER);
    }

    @Override
    public void onCommand(final String[] args, final String command) {
        if (args == null || args.length == 0) {
            toggleIfConfigured();
            return;
        }

        if ("setmessage".equalsIgnoreCase(args[0])) {
            if (args.length < 2) {
                showMessageSyntax();
                return;
            }

            final StringBuilder builder = new StringBuilder();
            for (int i = 1; i < args.length; i++) {
                if (builder.length() > 0) {
                    builder.append(' ');
                }
                builder.append(args[i]);
            }

            spamMessage = builder.toString().trim();
            LabyMod.getInstance().displayMessageInChat(
                    mineUtil.getSettings().getPrefix() + "§7Spam-Message set to §e" + spamMessage
            );
            return;
        }

        if ("setdelay".equalsIgnoreCase(args[0])) {
            if (args.length < 2) {
                showDelaySyntax();
                return;
            }

            try {
                final int parsedDelay = Integer.parseInt(args[1]);
                if (parsedDelay < MIN_DELAY_TICKS || parsedDelay > MAX_DELAY_TICKS) {
                    LabyMod.getInstance().displayMessageInChat(
                            mineUtil.getSettings().getPrefix()
                                    + "§cThe number must be between §e1 and 399§c ticks."
                    );
                    return;
                }

                delayTicks = parsedDelay;
                ticksUntilSend = Math.min(ticksUntilSend, delayTicks);
                LabyMod.getInstance().displayMessageInChat(
                        mineUtil.getSettings().getPrefix() + "§7Spam-Delay set to §e" + delayTicks
                                + (delayTicks == DEFAULT_DELAY_TICKS ? " (default)" : "")
                );
            } catch (final NumberFormatException exception) {
                showDelaySyntax();
            }
            return;
        }

        showMessageSyntax();
        showDelaySyntax();
    }

    @Override
    public void update() {
        if (!activated || spamMessage.isEmpty()) {
            return;
        }

        ticksUntilSend--;
        if (ticksUntilSend > 0) {
            return;
        }

        mineUtil.sendQueued(spamMessage);
        ticksUntilSend = delayTicks;
    }

    private void toggleIfConfigured() {
        if (spamMessage.isEmpty()) {
            LabyMod.getInstance().displayMessageInChat(
                    mineUtil.getSettings().getPrefix() + "§cYou must first specify a message or command."
            );
            showMessageSyntax();
            return;
        }

        if (delayTicks < MIN_DELAY_TICKS || delayTicks > MAX_DELAY_TICKS) {
            LabyMod.getInstance().displayMessageInChat(
                    mineUtil.getSettings().getPrefix() + "§cYou must first specify a valid delay."
            );
            showDelaySyntax();
            return;
        }

        activated = !activated;
        ticksUntilSend = delayTicks;
        LabyMod.getInstance().displayMessageInChat(transformMessage(getDisplayName(), activated));
    }

    private void showMessageSyntax() {
        LabyMod.getInstance().displayMessageInChat(
                mineUtil.getSettings().getPrefix() + "§cSyntax§8: §e"
                        + CommandManager.getPrefix() + getSyntax() + " setmessage <Message/Command>"
        );
    }

    private void showDelaySyntax() {
        LabyMod.getInstance().displayMessageInChat(
                mineUtil.getSettings().getPrefix() + "§cSyntax§8: §e"
                        + CommandManager.getPrefix() + getSyntax() + " setdelay <1-399 ticks>"
        );
    }

    @Override
    public boolean isActiv() {
        return activated;
    }
}
