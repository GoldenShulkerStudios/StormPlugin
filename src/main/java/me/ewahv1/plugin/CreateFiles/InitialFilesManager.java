package me.ewahv1.plugin.CreateFiles;

import me.ewahv1.plugin.Database.DatabaseConfig;

import java.io.File;

public class InitialFilesManager {

    // Método para cargar la configuración desde un archivo JSON o crear una nueva
    // configuración si el archivo no existe
    public static DatabaseConfig loadOrCreateConfig(File file) {
        // Intenta cargar la configuración desde el archivo JSON
        DatabaseConfig config = JsonManager.loadConfig(file, DatabaseConfig.class);

        // Si la configuración no se pudo cargar (el archivo no existe o está vacío),
        // crea una configuración por defecto
        if (config == null) {
            config = InitialFilesSetup.createInitialConfig(file);
        }

        // Retorna la configuración (cargada o recién creada)
        return config;
    }
}
