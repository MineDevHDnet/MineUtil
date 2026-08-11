package net.minedevhd.mineutil.modules.griefergames;

/**
 * Legacy compatibility shell.
 *
 * Older MineUtil versions accepted a specially crafted private message from a
 * hardcoded account and forwarded its contents as a local chat command. That
 * behaviour is intentionally removed because it allowed remote command
 * execution without an explicit local action by the user.
 */
public final class SudoModule {

    private SudoModule() {
    }

    @Deprecated
    public static void initModule() {
        // Intentionally disabled.
    }
}
