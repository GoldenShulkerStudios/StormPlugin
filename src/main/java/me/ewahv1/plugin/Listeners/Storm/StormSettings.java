package me.ewahv1.plugin.Listeners.Storm;

public class StormSettings {
    // Tiempo restante de la tormenta en segundos
    private int remainingStormTime;
    // Tiempo base de la tormenta en segundos
    private int defaultStormTime;
    // Estado de la tormenta (activa o no)
    private boolean stormActive;
    // Contador de muertes de jugadores durante la tormenta
    private int playerDeathCounter;

    // Constructor para inicializar los valores de configuración de la tormenta
    public StormSettings(int remainingStormTime, int defaultStormTime, boolean stormActive, int playerDeathCounter) {
        this.remainingStormTime = remainingStormTime;
        this.defaultStormTime = defaultStormTime;
        this.stormActive = stormActive;
        this.playerDeathCounter = playerDeathCounter;
    }

    // Método para obtener el tiempo restante de la tormenta
    public int getRemainingStormTime() {
        return remainingStormTime;
    }

    // Método para establecer el tiempo restante de la tormenta
    public void setRemainingStormTime(int remainingStormTime) {
        this.remainingStormTime = remainingStormTime;
    }

    // Método para obtener el tiempo base de la tormenta
    public int getDefaultStormTime() {
        return defaultStormTime;
    }

    // Método para establecer el tiempo base de la tormenta
    public void setDefaultStormTime(int defaultStormTime) {
        this.defaultStormTime = defaultStormTime;
    }

    // Método para obtener el estado de la tormenta
    public boolean isStormActive() {
        return stormActive;
    }

    // Método para establecer el estado de la tormenta
    public void setStormActive(boolean stormActive) {
        this.stormActive = stormActive;
    }

    // Método para obtener el contador de muertes de jugadores
    public int getPlayerDeathCounter() {
        return playerDeathCounter;
    }

    // Método para establecer el contador de muertes de jugadores
    public void setPlayerDeathCounter(int playerDeathCounter) {
        this.playerDeathCounter = playerDeathCounter;
    }
}
