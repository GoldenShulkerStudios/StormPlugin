package me.ewahv1.plugin;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.ewahv1.plugin.Database.DatabaseConnection;
import me.ewahv1.plugin.Database.DatabaseConfig;
import me.ewahv1.plugin.Listeners.Storm.StormListener;
import me.ewahv1.plugin.Commands.CommandHandler;
import me.ewahv1.plugin.Commands.CommandTabCompleter;
import me.ewahv1.plugin.Commands.Storm.*;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main extends JavaPlugin {

    private static Main instance;
    private DatabaseConnection databaseConnection;

    @Override
    public void onEnable() {
        instance = this;
        File configFile = new File(getDataFolder(), "db_config.json");
        DatabaseConfig config = loadOrCreateConfig(configFile);
        databaseConnection = new DatabaseConnection(config.getUrl(), config.getUsername(), config.getPassword());
        StormListener stormListener = new StormListener(this, databaseConnection);
        getServer().getPluginManager().registerEvents(stormListener, this);
        CommandHandler commandHandler = new CommandHandler(
                new ResetStormCommand(stormListener, databaseConnection),
                new SetStormTimeCommand(stormListener, databaseConnection),
                new ToggleStormCommand(stormListener, databaseConnection),
                new StormStatusCommand(stormListener, databaseConnection),
                new SetBaseStormTimeCommand(stormListener, databaseConnection),
                new ReverseStormCommand(stormListener, databaseConnection)
        );
        getCommand("storm").setExecutor(commandHandler);
        getCommand("storm").setTabCompleter(new CommandTabCompleter());
    }

    @Override
    public void onDisable() {
        databaseConnection.close();
    }

    public static Main getInstance() {
        return instance;
    }

    private DatabaseConfig loadOrCreateConfig(File file) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        if (!file.exists()) {
            file.getParentFile().mkdirs();
            DatabaseConfig defaultConfig = new DatabaseConfig();
            defaultConfig.setUrl("jdbc:mysql://localhost:3306/stormdb");
            defaultConfig.setUsername("root");
            defaultConfig.setPassword("root");
            try (FileWriter writer = new FileWriter(file)) {
                gson.toJson(defaultConfig, writer);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return defaultConfig;
        } else {
            try (FileReader reader = new FileReader(file)) {
                return gson.fromJson(reader, DatabaseConfig.class);
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
