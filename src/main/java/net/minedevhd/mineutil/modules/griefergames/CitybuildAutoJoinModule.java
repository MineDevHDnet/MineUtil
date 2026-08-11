package net.minedevhd.mineutil.modules.griefergames;

import java.util.Timer;
import java.util.TimerTask;

import net.labymod.api.events.MessageReceiveEvent;
import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.minedevhd.mineutil.settings.ModSettings.Citybuilds;
import net.minedevhd.mineutil.settings.UtilCore;
import net.minedevhd.mineutil.utils.CbAutoJoin;

public final class CitybuildAutoJoinModule implements UtilCore {

    private static final Object TIMER_LOCK = new Object();
    private static Timer timer;

    private CitybuildAutoJoinModule() {
    }

    public static void initModule() {
        mineUtil.getApi().getEventManager().register(new MessageReceiveEvent() {
            @Override
            public boolean onReceive(final String formatted, final String unformatted) {
                if (!mineUtil.isOnGrieferGames()
                        || !mineUtil.getSettings().isModGGAutoJoinCB()
                        || unformatted == null) {
                    return false;
                }

                if (unformatted.contains("[GrieferGames] Du bist im Portalraum. Wähle deinen Citybuild aus.")) {
                    startAutoJoin();
                } else if (unformatted.contains("[Switcher] Lade Daten herunter!")) {
                    shutdown();
                }
                return false;
            }
        });
    }

    private static void startAutoJoin() {
        cancelAutoJoin();

        synchronized (TIMER_LOCK) {
            timer = new Timer("MineUtil-CitybuildAutoJoin", true);
            final Timer activeTimer = timer;
            activeTimer.scheduleAtFixedRate(new TimerTask() {
                private int secondsLeft = 20;

                @Override
                public void run() {
                    secondsLeft--;
                    final int currentSecond = secondsLeft;

                    final Minecraft minecraft = mineUtil.getMinecraft();
                    if (minecraft == null) {
                        cancelAutoJoin();
                        return;
                    }

                    minecraft.addScheduledTask(new Runnable() {
                        @Override
                        public void run() {
                            if (activeTimer != timer) {
                                return;
                            }

                            if (Citybuilds.getTTCB() != null && Citybuilds.getTTCB().equalsIgnoreCase("cb2")) {
                                CbAutoJoin.Script.CB2.init(minecraft.gameSettings, currentSecond);
                            }

                            if (currentSecond <= 0) {
                                shutdown();
                            }
                        }
                    });
                }
            }, 900L, 900L);
        }
    }

    public static void shutdown() {
        cancelAutoJoin();
        releaseMovementKeys();
    }

    private static void cancelAutoJoin() {
        synchronized (TIMER_LOCK) {
            if (timer != null) {
                timer.cancel();
                timer.purge();
                timer = null;
            }
        }
    }

    private static void releaseMovementKeys() {
        final Minecraft minecraft = mineUtil.getMinecraft();
        if (minecraft == null || minecraft.gameSettings == null) {
            return;
        }

        KeyBinding.setKeyBindState(minecraft.gameSettings.keyBindForward.getKeyCode(), false);
        KeyBinding.setKeyBindState(minecraft.gameSettings.keyBindJump.getKeyCode(), false);
        KeyBinding.setKeyBindState(minecraft.gameSettings.keyBindLeft.getKeyCode(), false);
        KeyBinding.setKeyBindState(minecraft.gameSettings.keyBindRight.getKeyCode(), false);
    }
}
