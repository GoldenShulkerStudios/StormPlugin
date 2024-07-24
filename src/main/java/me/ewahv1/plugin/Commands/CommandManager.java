package me.ewahv1.plugin.Commands;

import me.ewahv1.plugin.Listeners.Storm.StormListener;
import org.bukkit.plugin.java.JavaPlugin;

public class CommandManager {

    public CommandManager(JavaPlugin plugin, StormListener stormListener) {
        plugin.getCommand("storm").setExecutor(new CommandHandler(plugin, stormListener));
        plugin.getCommand("storm").setTabCompleter(new CommandTabCompleter());
    }
}
