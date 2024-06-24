package me.ewahv1.plugin;

import org.bukkit.plugin.java.JavaPlugin;
import me.ewahv1.plugin.Database.DatabaseConnection;
import me.ewahv1.plugin.Listeners.Storm.StormListener;
import me.ewahv1.plugin.Commands.CommandHandler;
import me.ewahv1.plugin.Commands.CommandTabCompleter;
import me.ewahv1.plugin.Commands.Storm.*;

public class Main extends JavaPlugin {

    private static Main instance;
    private DatabaseConnection databaseConnection;

    @Override
    public void onEnable() {
        instance = this;
        databaseConnection = new DatabaseConnection();
        StormListener stormListener = new StormListener(this, databaseConnection);
        getServer().getPluginManager().registerEvents(stormListener, this);
        CommandHandler commandHandler = new CommandHandler(
                new ResetStormCommand(stormListener, databaseConnection),
                new SetStormTimeCommand(stormListener, databaseConnection),
                new ToggleStormCommand(stormListener, databaseConnection),
                new StormStatusCommand(stormListener, databaseConnection),
                new SetBaseStormTimeCommand(stormListener, databaseConnection),
                new ReverseStormCommand(stormListener, databaseConnection) // Agregar ReverseStormCommand
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
}
