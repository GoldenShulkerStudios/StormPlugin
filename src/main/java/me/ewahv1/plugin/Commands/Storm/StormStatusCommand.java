package me.ewahv1.plugin.Commands.Storm;

import me.ewahv1.plugin.Main;
import me.ewahv1.plugin.Listeners.Storm.StormListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class StormStatusCommand implements CommandExecutor {

    private final StormListener stormListener;

    public StormStatusCommand(StormListener stormListener) {
        this.stormListener = stormListener;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            new BukkitRunnable() {
                @Override
                public void run() {
                    boolean isActive = stormListener.isStormActive();
                    int remainingStormTime = stormListener.getRemainingStormTime();
                    int defaultStormTime = stormListener.getDefaultStormTime();
                    int playerDeathCounter = stormListener.getPlayerDeathCounter();

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.sendMessage("Estado de la tormenta: " + (isActive ? "Activada" : "Desactivada"));
                            player.sendMessage("Tiempo restante de la tormenta: " + remainingStormTime + " segundos");
                            player.sendMessage("Tiempo base de la tormenta: " + defaultStormTime + " segundos");
                            player.sendMessage("Contador de muertes de jugadores: " + playerDeathCounter);
                        }
                    }.runTask(Main.getInstance());
                }
            }.runTaskAsynchronously(Main.getInstance());
            return true;
        } else {
            sender.sendMessage("Este comando solo puede ser utilizado por un jugador.");
        }
        return false;
    }
}
