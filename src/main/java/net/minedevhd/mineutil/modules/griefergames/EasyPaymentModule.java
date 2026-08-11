package net.minedevhd.mineutil.modules.griefergames;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Locale;

import net.labymod.api.events.MessageSendEvent;
import net.minedevhd.mineutil.settings.UtilCore;

public final class EasyPaymentModule implements UtilCore {

    private EasyPaymentModule() {
    }

    public static void initModule() {
        mineUtil.getApi().getEventManager().register(new MessageSendEvent() {
            @Override
            public boolean onSend(final String message) {
                if (message == null
                        || !mineUtil.getSettings().isModEnabled()
                        || !mineUtil.isOnGrieferGames()) {
                    return false;
                }

                final String lowerMessage = message.toLowerCase(Locale.ROOT);
                if (!lowerMessage.startsWith("/pay ") && !lowerMessage.startsWith("/bank ")) {
                    return false;
                }

                final String[] parts = message.trim().split("\\s+");
                if (parts.length < 3) {
                    return false;
                }

                final String convertedAmount = convertAmount(parts[2]);
                if (convertedAmount == null) {
                    return false;
                }

                if (mineUtil.getMinecraft().thePlayer == null) {
                    return false;
                }

                mineUtil.getMinecraft().thePlayer.sendChatMessage(
                        parts[0] + " " + parts[1] + " " + convertedAmount
                );
                return true;
            }
        });
    }

    private static String convertAmount(final String rawAmount) {
        if (rawAmount == null) {
            return null;
        }

        final String normalized = rawAmount.trim().toLowerCase(Locale.ROOT).replace(',', '.');
        final String numberPart;
        final BigDecimal multiplier;

        if (normalized.endsWith("mio")) {
            numberPart = normalized.substring(0, normalized.length() - 3);
            multiplier = new BigDecimal("1000000");
        } else if (normalized.endsWith("m")) {
            numberPart = normalized.substring(0, normalized.length() - 1);
            multiplier = new BigDecimal("1000000");
        } else if (normalized.endsWith("k")) {
            numberPart = normalized.substring(0, normalized.length() - 1);
            multiplier = new BigDecimal("1000");
        } else {
            return null;
        }

        if (numberPart.trim().isEmpty()) {
            return null;
        }

        try {
            final BigDecimal amount = new BigDecimal(numberPart.trim()).multiply(multiplier);
            if (amount.signum() < 0) {
                return null;
            }
            return amount.setScale(0, RoundingMode.FLOOR).toPlainString();
        } catch (final NumberFormatException exception) {
            return null;
        }
    }
}
