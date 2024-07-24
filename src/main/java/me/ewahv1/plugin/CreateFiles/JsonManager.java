package me.ewahv1.plugin.CreateFiles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {

    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    public void initialize() {
        InitialStormConfigJson.createJson();
    }

    public static <T> T loadConfig(File file, Class<T> clazz) {
        if (!file.exists()) {
            return null;
        }
        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, clazz);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T> void saveConfig(File file, T config) {
        try (FileWriter writer = new FileWriter(file)) {
            gson.toJson(config, writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
