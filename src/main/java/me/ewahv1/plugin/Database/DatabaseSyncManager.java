package me.ewahv1.plugin.Database;

import me.ewahv1.plugin.Listeners.Storm.StormSettings;
import me.ewahv1.plugin.CreateFiles.JsonManager;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseSyncManager {

    private DatabaseConnection databaseConnection;
    private File configFile;

    // Constructor que inicializa la conexión a la base de datos y el archivo de
    // configuración
    public DatabaseSyncManager(DatabaseConnection databaseConnection, File configFile) {
        this.databaseConnection = databaseConnection;
        this.configFile = configFile;
    }

    // Método para sincronizar los datos de la tormenta desde el archivo JSON a la
    // base de datos
    public void syncToDatabase(StormSettings config) {
        try (Connection connection = databaseConnection.getConnection()) {
            // Preparar la declaración SQL para actualizar los datos de la tormenta
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "UPDATE stormsettings SET RemainingStormTime = ?, DefaultStormTime = ?, StormActive = ?, PlayerDeathCounter = ? WHERE ID = 1");
            preparedStatement.setInt(1, config.getRemainingStormTime());
            preparedStatement.setInt(2, config.getDefaultStormTime());
            preparedStatement.setBoolean(3, config.isStormActive());
            preparedStatement.setInt(4, config.getPlayerDeathCounter());
            // Ejecutar la actualización
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir el error en caso de fallo
        }
    }

    // Método para sincronizar los datos de la tormenta desde la base de datos al
    // archivo JSON
    public void syncFromDatabase() {
        try (Connection connection = databaseConnection.getConnection();
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery("SELECT * FROM stormsettings WHERE ID = 1")) {
            // Si hay un resultado, cargar los datos en un objeto StormSettings y guardarlo
            // en el archivo JSON
            if (resultSet.next()) {
                StormSettings config = new StormSettings(
                        resultSet.getInt("RemainingStormTime"),
                        resultSet.getInt("DefaultStormTime"),
                        resultSet.getBoolean("StormActive"),
                        resultSet.getInt("PlayerDeathCounter"));
                JsonManager.saveConfig(configFile, config); // Guardar la configuración en el archivo JSON
            }
        } catch (Exception e) {
            e.printStackTrace(); // Imprimir el error en caso de fallo
        }
    }
}
