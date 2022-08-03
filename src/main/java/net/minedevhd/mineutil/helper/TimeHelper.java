package net.minedevhd.mineutil.helper;

public class TimeHelper {
	
    private static long lastMS;
    
    public boolean isDelayComplete(final float f) {
        return System.currentTimeMillis() - TimeHelper.lastMS >= f;
    }
    
    public static long getCurrentMS() {
        return System.nanoTime() / 1000000L;
    }
    
    public void setLastMS(final long lastMS) {
        TimeHelper.lastMS = lastMS;
    }
    
    public int convertToMS(final int perSecond) {
        return 1000 / perSecond;
    }
    
    public boolean hasReached(final long milliseconds) {
        return getCurrentMS() - TimeHelper.lastMS >= milliseconds;
    }
    
    public void reset() {
        TimeHelper.lastMS = getCurrentMS();
    }
    
    static {
        TimeHelper.lastMS = 0L;
    }
}
