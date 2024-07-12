package me.ewahv1.plugin.Commands.Storm;

import me.ewahv1.plugin.Main;
import me.ewahv1.plugin.Listeners.Storm.StormListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ReverseStormCommand implements CommandExecutor {

    private final StormListener stormListener;

    public ReverseStormCommand(StormListener stormListener) {
        this.stormListener = stormListener;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            new BukkitRunnable() {
                @Override
                public void run() {
                    int remainingStormTime = stormListener.getRemainingStormTime();
                    int defaultStormTime = stormListener.getDefaultStormTime();
                    int playerDeathCounter = stormListener.getPlayerDeathCounter();

                    final int[] newRemainingStormTime = {
                            remainingStormTime - (defaultStormTime * playerDeathCounter) };
                    if (newRemainingStormTime[0] < 0)
                        newRemainingStormTime[0] = 0;

                    if (playerDeathCounter > 0) {
                        playerDeathCounter--; // Reduce the player death counter by 1
                    }

                    stormListener.setRemainingStormTime(newRemainingStormTime[0]);
                    stormListener.setPlayerDeathCounter(playerDeathCounter);

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.getWorld().setWeatherDuration(newRemainingStormTime[0] * 20);
                            player.sendMessage(
                                    "El tiempo de la tormenta ha sido revertido y el contador de muertes ha sido reducido en 1.");
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
