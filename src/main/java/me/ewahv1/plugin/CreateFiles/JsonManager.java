package me.ewahv1.plugin.CreateFiles;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class JsonManager {

    // Instancia de Gson para la serialización y deserialización de JSON con formato
    // de impresión bonita
    private static final Gson gson = new GsonBuilder().setPrettyPrinting().create();

    // Método genérico para cargar la configuración desde un archivo JSON
    public static <T> T loadConfig(File file, Class<T> clazz) {
        if (!file.exists()) {
            return null; // Retorna null si el archivo no existe
        }
        try (FileReader reader = new FileReader(file)) {
            return gson.fromJson(reader, clazz); // Deserializa el JSON en una instancia de la clase especificada
        } catch (IOException e) {
            e.printStackTrace(); // Imprime el error en caso de fallo
            return null;
        }
    }

    // Método para guardar la configuración en un archivo JSON
    public static void saveConfig(File file, Object config) {
        try {
            file.getParentFile().mkdirs(); // Crea el directorio si no existe
            try (FileWriter writer = new FileWriter(file)) {
                gson.toJson(config, writer); // Serializa el objeto en formato JSON y lo guarda en el archivo
            }
        } catch (IOException e) {
            e.printStackTrace(); // Imprime el error en caso de fallo
        }
    }
}
