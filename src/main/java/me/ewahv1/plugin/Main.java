package me.ewahv1.plugin;

import me.ewahv1.plugin.Commands.CommandManager;
import me.ewahv1.plugin.CreateFiles.JsonManager;
import me.ewahv1.plugin.Listeners.Storm.StormListener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        StormListener stormListener = new StormListener(this);
        getServer().getPluginManager().registerEvents(stormListener, this);
        new CommandManager(this, stormListener);
        new JsonManager().initialize();
        getLogger().info("StormPlugin has been enabled!");
    }

    @Override
    public void onDisable() {
        getLogger().info("StormPlugin has been disabled!");
    }
}
