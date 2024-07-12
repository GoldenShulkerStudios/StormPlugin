package me.ewahv1.plugin.Commands.Storm;

import me.ewahv1.plugin.Main;
import me.ewahv1.plugin.Listeners.Storm.StormListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class ResetStormCommand implements CommandExecutor {

    private final StormListener stormListener;

    public ResetStormCommand(StormListener stormListener) {
        this.stormListener = stormListener;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            new BukkitRunnable() {
                @Override
                public void run() {
                    stormListener.stopStormTimer();
                    stormListener.setRemainingStormTime(0);
                    stormListener.setDefaultStormTime(600);
                    stormListener.hideBossBar();

                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.getWorld().setStorm(false);
                            player.sendMessage("La tormenta ha sido restablecida y el clima ha sido despejado.");
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
