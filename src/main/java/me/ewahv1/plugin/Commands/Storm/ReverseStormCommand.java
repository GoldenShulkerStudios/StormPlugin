package me.ewahv1.plugin.Commands.Storm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import me.ewahv1.plugin.Listeners.Storm.StormListener;
import me.ewahv1.plugin.Listeners.Storm.StormListener.StormSettings;
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

public class ReverseStormCommand implements CommandExecutor {

    private final JavaPlugin plugin;
    private final StormListener stormListener;

    public ReverseStormCommand(JavaPlugin plugin, StormListener stormListener) {
        this.plugin = plugin;
        this.stormListener = stormListener;
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
                            StormSettings config = gson.fromJson(reader, StormSettings.class);
                            int remainingStormTime = config.getRemainingStormTime();
                            int defaultStormTime = config.getDefaultStormTime();
                            int playerDeathCounter = config.getPlayerDeathCounter();

                            int newRemainingStormTime = remainingStormTime - (defaultStormTime * playerDeathCounter);
                            if (newRemainingStormTime < 0) {
                                newRemainingStormTime = defaultStormTime;
                                player.sendMessage(
                                        "El tiempo restante de la tormenta era menor a 0. Se ha restablecido al valor base.");
                            }

                            if (playerDeathCounter > 0) {
                                playerDeathCounter--; // Reduce the player death counter by 1
                            }

                            final int finalNewRemainingStormTime = newRemainingStormTime;
                            config.setRemainingStormTime(finalNewRemainingStormTime);
                            config.setPlayerDeathCounter(playerDeathCounter);

                            try (FileWriter writer = new FileWriter(configFile)) {
                                writer.write(gson.toJson(config));
                                plugin.getLogger().info("Storm configuration has been updated.");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    player.getWorld().setStorm(false);
                                    player.getWorld().setThundering(false);
                                    player.sendMessage(
                                            "El tiempo de la tormenta ha sido revertido y el contador de muertes ha sido reducido en 1.");
                                    stormListener.updateBossBar(config); // Actualiza la barra de jefe
                                    stormListener.saveSettingsToFile(config); // Guarda los cambios en el JSON
                                    stormListener.restartStormTimer(config); // Reinicia el temporizador de la tormenta
                                                                             // con los nuevos valores
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
