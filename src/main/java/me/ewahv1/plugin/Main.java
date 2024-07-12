package me.ewahv1.plugin;

import me.ewahv1.plugin.CreateFiles.InitialFilesManager;
import me.ewahv1.plugin.Database.DatabaseConnection;
import me.ewahv1.plugin.Database.DatabaseConfig;
import me.ewahv1.plugin.Database.DatabaseSyncManager;
import me.ewahv1.plugin.Listeners.Storm.StormListener;
import me.ewahv1.plugin.Listeners.Storm.StormSettings;
import me.ewahv1.plugin.Commands.CommandHandler;
import me.ewahv1.plugin.Commands.CommandTabCompleter;
import me.ewahv1.plugin.Commands.Storm.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public class Main extends JavaPlugin {

    private static Main instance;
    private DatabaseConnection databaseConnection;
    private DatabaseSyncManager databaseSyncManager;
    private StormListener stormListener;

    // Método que se ejecuta al habilitar el plugin
    @Override
    public void onEnable() {
        instance = this; // Establece la instancia del plugin
        File configFile = new File(getDataFolder(), "db_config.json");

        // Crea el directorio del archivo de configuración si no existe
        if (!configFile.getParentFile().exists()) {
            configFile.getParentFile().mkdirs();
        }

        // Carga o crea la configuración inicial de la base de datos
        DatabaseConfig config = InitialFilesManager.loadOrCreateConfig(configFile);

        // Establece la conexión con la base de datos
        databaseConnection = new DatabaseConnection(config.getUrl(), config.getUsername(), config.getPassword());

        // Inicializa el administrador de sincronización de la base de datos
        databaseSyncManager = new DatabaseSyncManager(databaseConnection, configFile);

        // Sincroniza los datos desde la base de datos al iniciar
        databaseSyncManager.syncFromDatabase();

        // Inicializa el listener de tormentas
        stormListener = new StormListener(this, databaseSyncManager);

        // Registra el listener de eventos de tormentas
        getServer().getPluginManager().registerEvents(stormListener, this);

        // Inicializa y registra los comandos de tormentas
        CommandHandler commandHandler = new CommandHandler(
                new ResetStormCommand(stormListener),
                new SetStormTimeCommand(stormListener),
                new ToggleStormCommand(stormListener),
                new StormStatusCommand(stormListener),
                new SetBaseStormTimeCommand(stormListener),
                new ReverseStormCommand(stormListener));
        getCommand("storm").setExecutor(commandHandler);
        getCommand("storm").setTabCompleter(new CommandTabCompleter());
    }

    // Método que se ejecuta al deshabilitar el plugin
    @Override
    public void onDisable() {
        // Sincroniza los datos a la base de datos al desactivar
        databaseSyncManager.syncToDatabase(new StormSettings(
                stormListener.getRemainingStormTime(),
                stormListener.getDefaultStormTime(),
                stormListener.isStormActive(),
                stormListener.getPlayerDeathCounter()));
        databaseConnection.close(); // Cierra la conexión con la base de datos
    }

    // Método estático para obtener la instancia del plugin
    public static Main getInstance() {
        return instance;
    }
}
