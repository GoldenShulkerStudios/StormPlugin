package me.ewahv1.plugin.CreateFiles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class InitialStormConfigJson {

    public static void createJson() {
        StormConfig config = new StormConfig(0, 600, false, 0);

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(config);

        File file = new File("plugins/StormPlugin/StormConfig.json");
        if (!file.exists()) {
            file.getParentFile().mkdirs();
        }

        try (FileWriter writer = new FileWriter(file)) {
            writer.write(json);
            System.out.println("StormConfig.json has been created.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static class StormConfig {
        private int RemainingStormTime;
        private int DefaultStormTime;
        private boolean StormActive;
        private int PlayerDeathCounter;

        public StormConfig(int remainingStormTime, int defaultStormTime, boolean stormActive, int playerDeathCounter) {
            this.RemainingStormTime = remainingStormTime;
            this.DefaultStormTime = defaultStormTime;
            this.StormActive = stormActive;
            this.PlayerDeathCounter = playerDeathCounter;
        }

        public int getRemainingStormTime() {
            return RemainingStormTime;
        }

        public void setRemainingStormTime(int remainingStormTime) {
            RemainingStormTime = remainingStormTime;
        }

        public int getDefaultStormTime() {
            return DefaultStormTime;
        }

        public void setDefaultStormTime(int defaultStormTime) {
            DefaultStormTime = defaultStormTime;
        }

        public boolean isStormActive() {
            return StormActive;
        }

        public void setStormActive(boolean stormActive) {
            StormActive = stormActive;
        }

        public int getPlayerDeathCounter() {
            return PlayerDeathCounter;
        }

        public void setPlayerDeathCounter(int playerDeathCounter) {
            PlayerDeathCounter = playerDeathCounter;
        }
    }
}
