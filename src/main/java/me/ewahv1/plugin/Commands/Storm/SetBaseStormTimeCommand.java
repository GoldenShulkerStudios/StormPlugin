package me.ewahv1.plugin.Commands.Storm;

import me.ewahv1.plugin.Main;
import me.ewahv1.plugin.Listeners.Storm.StormListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class SetBaseStormTimeCommand implements CommandExecutor {

    private final StormListener stormListener;

    public SetBaseStormTimeCommand(StormListener stormListener) {
        this.stormListener = stormListener;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
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
                        stormListener.setDefaultStormTime(baseTime);
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                player.sendMessage("El tiempo base de la tormenta ha sido establecido a " + baseTime
                                        + " segundos.");
                            }
                        }.runTask(Main.getInstance());
                    }
                }.runTaskAsynchronously(Main.getInstance());
                return true;
            } catch (NumberFormatException e) {
                player.sendMessage("Por favor, introduce un número válido.");
                return true;
            }
        } else {
            sender.sendMessage("Este comando solo puede ser utilizado por un jugador.");
        }
        return false;
    }
}
