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

public class SetBaseStormTimeCommand implements CommandExecutor {

    private final JavaPlugin plugin;
    private final StormListener stormListener;

    public SetBaseStormTimeCommand(JavaPlugin plugin, StormListener stormListener) {
        this.plugin = plugin;
        this.stormListener = stormListener;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && sender.isOp()) {
            Player player = (Player) sender;
            if (args.length < 3 || !args[0].equalsIgnoreCase("set") || !args[1].equalsIgnoreCase("BaseTime")) {
                player.sendMessage("Uso: /storm set BaseTime <tiempo>");
                return true;
            }

            try {
                int baseTime = Integer.parseInt(args[2]);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        File configFile = new File(plugin.getDataFolder(), "StormConfig.json");
                        if (configFile.exists()) {
                            Gson gson = new GsonBuilder().setPrettyPrinting().create();
                            try (FileReader reader = new FileReader(configFile)) {
                                StormSettings config = gson.fromJson(reader, StormSettings.class);
                                config.setDefaultStormTime(baseTime);

                                try (FileWriter writer = new FileWriter(configFile)) {
                                    writer.write(gson.toJson(config));
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }

                                new BukkitRunnable() {
                                    @Override
                                    public void run() {
                                        player.sendMessage("El tiempo base de la tormenta ha sido establecido a "
                                                + baseTime + " segundos.");
                                        stormListener.saveSettingsToFile(config);
                                        stormListener.restartStormTimer(config);
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
            } catch (NumberFormatException e) {
                player.sendMessage("Por favor, introduce un número válido.");
                return true;
            }
        } else {
            sender.sendMessage("You do not have permission to use this command or you are not a player.");
        }
        return false;
    }
}
