package me.ewahv1.plugin.Commands.Storm;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonSyntaxException;
import me.ewahv1.plugin.CreateFiles.InitialStormConfigJson.StormConfig;
import org.bukkit.ChatColor;
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
                                    player.sendMessage(ChatColor.GOLD + "Estado de la tormenta: " +
                                            (isActive ? ChatColor.GREEN + "Activada" : ChatColor.RED + "Desactivada"));
                                    player.sendMessage(ChatColor.GOLD + "Tiempo restante de la tormenta: " +
                                            ChatColor.AQUA + remainingStormTime + ChatColor.GOLD + " segundos");
                                    player.sendMessage(ChatColor.GOLD + "Tiempo base de la tormenta: " +
                                            ChatColor.AQUA + defaultStormTime + ChatColor.GOLD + " segundos");
                                    player.sendMessage(ChatColor.GOLD + "Contador de muertes de jugadores: " +
                                            ChatColor.AQUA + playerDeathCounter);
                                }
                            }.runTask(plugin);
                        } catch (IOException | JsonSyntaxException e) {
                            sender.sendMessage(
                                    ChatColor.RED + "An error occurred while reading the storm configuration.");
                            e.printStackTrace();
                        }
                    } else {
                        sender.sendMessage(ChatColor.RED + "StormConfig.json not found.");
                    }
                }
            }.runTaskAsynchronously(plugin);
            return true;
        } else {
            sender.sendMessage(ChatColor.RED + "Este comando solo puede ser utilizado por un jugador.");
        }
        return false;
    }
}
