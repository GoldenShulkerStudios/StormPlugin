package me.ewahv1.plugin.Commands.Storm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import me.ewahv1.plugin.CreateFiles.InitialStormConfigJson.StormConfig;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class ToggleStormCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public ToggleStormCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && sender.isOp()) {
            Player player = (Player) sender;
            new BukkitRunnable() {
                @Override
                public void run() {
                    File configFile = new File(plugin.getDataFolder(), "StormConfig.json");
                    if (configFile.exists()) {
                        Gson gson = new GsonBuilder().setPrettyPrinting().create();
                        try (FileReader reader = new FileReader(configFile)) {
                            StormConfig config = gson.fromJson(reader, StormConfig.class);
                            boolean isActive = config.isStormActive();
                            config.setStormActive(!isActive);

                            try (FileWriter writer = new FileWriter(configFile)) {
                                writer.write(gson.toJson(config));
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    player.sendMessage(
                                            "La tormenta ha sido " + (isActive ? "desactivada." : "activada."));
                                }
                            }.runTask(plugin);
                        } catch (IOException | JsonSyntaxException e) {
                            sender.sendMessage("An error occurred while reading the storm configuration.");
                            e.printStackTrace();
                        }
                    } else {
                        sender.sendMessage("StormConfig.json not found.");
                    }
                }
            }.runTaskAsynchronously(plugin);
            return true;
        } else {
            sender.sendMessage("You do not have permission to use this command or you are not a player.");
        }
        return false;
    }
}
