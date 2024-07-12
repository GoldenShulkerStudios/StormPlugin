package me.ewahv1.plugin.Commands.Storm;

import me.ewahv1.plugin.Main;
import me.ewahv1.plugin.Listeners.Storm.StormListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ToggleStormCommand implements CommandExecutor {

    private final StormListener stormListener;

    public ToggleStormCommand(StormListener stormListener) {
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

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            if (isActive) {
                                player.getWorld().setStorm(false);
                                stormListener.setStormActive(false);
                                stormListener.setRemainingStormTime(0);
                                stormListener.hideBossBar();
                                player.sendMessage("La tormenta ha sido desactivada.");
                            } else {
                                stormListener.setStormActive(true);
                                player.sendMessage("La tormenta ha sido activada. Comenzará cuando un jugador muera.");
                            }
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
