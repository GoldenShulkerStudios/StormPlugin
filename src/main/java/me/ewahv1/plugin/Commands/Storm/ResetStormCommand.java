package me.ewahv1.plugin.Commands.Storm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import me.ewahv1.plugin.CreateFiles.InitialStormConfigJson.StormConfig;
import me.ewahv1.plugin.Listeners.Storm.StormListener;
import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class ResetStormCommand implements CommandExecutor {

    private final JavaPlugin plugin;
    private final StormListener stormListener;

    public ResetStormCommand(JavaPlugin plugin, StormListener stormListener) {
        this.plugin = plugin;
        this.stormListener = stormListener;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && sender.isOp()) {
            File configFile = new File(plugin.getDataFolder(), "StormConfig.json");
            if (configFile.exists()) {
                StormConfig config = new StormConfig(0, 600, false, 0);

                Gson gson = new GsonBuilder().setPrettyPrinting().create();
                String json = gson.toJson(config);

                try (FileWriter writer = new FileWriter(configFile)) {
                    writer.write(json);
                    sender.sendMessage("Storm has been reset to default values.");

                    // Apagar la tormenta si está activa
                    for (World world : Bukkit.getWorlds()) {
                        if (world.hasStorm()) {
                            world.setStorm(false);
                            world.setThundering(false);
                        }
                    }

                    // Detener el temporizador de la tormenta y ocultar la barra de jefe
                    stormListener.stopStormTimer();
                    stormListener.hideBossBar();

                } catch (IOException e) {
                    sender.sendMessage("An error occurred while resetting the storm.");
                    e.printStackTrace();
                }
            } else {
                sender.sendMessage("StormConfig.json not found.");
            }
        } else {
            sender.sendMessage("You do not have permission to use this command.");
        }
        return true;
    }
}
