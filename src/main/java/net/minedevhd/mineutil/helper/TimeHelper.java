package net.minedevhd.mineutil.helper;

import java.util.concurrent.TimeUnit;

public final class TimeHelper {

    private long lastMs;

    public TimeHelper() {
        reset();
    }

    public boolean isDelayComplete(final float milliseconds) {
        return hasReached((long) Math.max(0F, milliseconds));
    }

    public static long getCurrentMS() {
        return TimeUnit.NANOSECONDS.toMillis(System.nanoTime());
    }

    public void setLastMS(final long lastMs) {
        this.lastMs = lastMs;
    }

    public int convertToMS(final int perSecond) {
        if (perSecond <= 0) {
            return 0;
        }
        return 1000 / perSecond;
    }

    public boolean hasReached(final long milliseconds) {
        return getCurrentMS() - lastMs >= Math.max(0L, milliseconds);
    }

    public void reset() {
        this.lastMs = getCurrentMS();
    }
}
