package net.minedevhd.mineutil.utils;

import net.minecraft.client.settings.GameSettings;
import net.minecraft.client.settings.KeyBinding;

public final class CbAutoJoin {

    private CbAutoJoin() {
    }

    public static final class Script {

        private Script() {
        }

        public static final class CB2 {

            private CB2() {
            }

            public static void init(final GameSettings gameSettings, final int secondsLeft) {
                if (gameSettings == null) {
                    return;
                }

                switch (secondsLeft) {
                    case 0:
                        KeyBinding.setKeyBindState(gameSettings.keyBindForward.getKeyCode(), false);
                        KeyBinding.setKeyBindState(gameSettings.keyBindJump.getKeyCode(), false);
                        KeyBinding.setKeyBindState(gameSettings.keyBindLeft.getKeyCode(), false);
                        KeyBinding.setKeyBindState(gameSettings.keyBindRight.getKeyCode(), false);
                        break;
                    case 6:
                        KeyBinding.setKeyBindState(gameSettings.keyBindJump.getKeyCode(), true);
                        break;
                    case 7:
                        KeyBinding.setKeyBindState(gameSettings.keyBindForward.getKeyCode(), true);
                        break;
                    case 8:
                        KeyBinding.setKeyBindState(gameSettings.keyBindLeft.getKeyCode(), false);
                        break;
                    case 16:
                        KeyBinding.setKeyBindState(gameSettings.keyBindLeft.getKeyCode(), true);
                        KeyBinding.setKeyBindState(gameSettings.keyBindForward.getKeyCode(), false);
                        break;
                    case 19:
                        KeyBinding.setKeyBindState(gameSettings.keyBindForward.getKeyCode(), true);
                        break;
                    default:
                        break;
                }
            }
        }
    }
}
