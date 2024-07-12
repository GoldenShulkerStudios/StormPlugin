package me.ewahv1.plugin.CreateFiles;

import me.ewahv1.plugin.Database.DatabaseConfig;

import java.io.File;

public class InitialFilesSetup {

    // Método para crear la configuración inicial de la base de datos y guardarla en
    // un archivo JSON
    public static DatabaseConfig createInitialConfig(File file) {
        // Crea una configuración por defecto para la base de datos
        DatabaseConfig defaultConfig = new DatabaseConfig("jdbc:mysql://localhost:3306/stormplugindb", "root", "root");

        // Guarda la configuración por defecto en el archivo JSON
        JsonManager.saveConfig(file, defaultConfig);

        // Retorna la configuración por defecto
        return defaultConfig;
    }
}
