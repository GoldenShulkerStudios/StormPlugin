package me.ewahv1.plugin.Listeners.Storm;

public class StormSettings {
    private int remainingStormTime;
    private int defaultStormTime;
    private boolean stormActive;
    private int playerDeathCounter;

    public StormSettings(int remainingStormTime, int defaultStormTime, boolean stormActive, int playerDeathCounter) {
        this.remainingStormTime = remainingStormTime;
        this.defaultStormTime = defaultStormTime;
        this.stormActive = stormActive;
        this.playerDeathCounter = playerDeathCounter;
    }

    public int getRemainingStormTime() {
        return remainingStormTime;
    }

    public void setRemainingStormTime(int remainingStormTime) {
        this.remainingStormTime = remainingStormTime;
    }

    public int getDefaultStormTime() {
        return defaultStormTime;
    }

    public void setDefaultStormTime(int defaultStormTime) {
        this.defaultStormTime = defaultStormTime;
    }

    public boolean isStormActive() {
        return stormActive;
    }

    public void setStormActive(boolean stormActive) {
        this.stormActive = stormActive;
    }

    public int getPlayerDeathCounter() {
        return playerDeathCounter;
    }

    public void setPlayerDeathCounter(int playerDeathCounter) {
        this.playerDeathCounter = playerDeathCounter;
    }
}
