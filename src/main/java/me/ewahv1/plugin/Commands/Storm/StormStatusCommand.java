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
import java.io.IOException;

public class StormStatusCommand implements CommandExecutor {

    private final JavaPlugin plugin;

    public StormStatusCommand(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
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
                            int remainingStormTime = config.getRemainingStormTime();
                            int defaultStormTime = config.getDefaultStormTime();
                            int playerDeathCounter = config.getPlayerDeathCounter();

                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    player.sendMessage(
                                            "Estado de la tormenta: " + (isActive ? "Activada" : "Desactivada"));
                                    player.sendMessage(
                                            "Tiempo restante de la tormenta: " + remainingStormTime + " segundos");
                                    player.sendMessage("Tiempo base de la tormenta: " + defaultStormTime + " segundos");
                                    player.sendMessage("Contador de muertes de jugadores: " + playerDeathCounter);
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
            sender.sendMessage("Este comando solo puede ser utilizado por un jugador.");
        }
        return false;
    }
}
