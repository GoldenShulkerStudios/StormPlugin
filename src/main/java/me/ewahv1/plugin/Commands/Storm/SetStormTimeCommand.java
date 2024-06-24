package me.ewahv1.plugin.Commands.Storm;

import me.ewahv1.plugin.Main;
import me.ewahv1.plugin.Database.DatabaseConnection;
import me.ewahv1.plugin.Listeners.Storm.StormListener;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class SetStormTimeCommand implements CommandExecutor {

    private final StormListener stormListener;
    private final DatabaseConnection databaseConnection;

    public SetStormTimeCommand(StormListener stormListener, DatabaseConnection databaseConnection) {
        this.stormListener = stormListener;
        this.databaseConnection = databaseConnection;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            if (args.length < 3 || !args[0].equalsIgnoreCase("set") || !args[1].equalsIgnoreCase("CurrentTime")) {
                player.sendMessage("Uso: /storm set CurrentTime <tiempo>");
                return true;
            }
            try {
                int time = Integer.parseInt(args[2]);
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        try (Connection connection = databaseConnection.getConnection()) {
                            stormListener.setRemainingStormTime(time);
                            PreparedStatement updateStatement = connection.prepareStatement("UPDATE stormsettings SET RemainingStormTime = ? WHERE ID = 1");
                            updateStatement.setInt(1, time);
                            updateStatement.executeUpdate();
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    player.sendMessage("El tiempo de la tormenta ha sido establecido a " + time + " segundos.");
                                }
                            }.runTask(Main.getInstance());
                        } catch (Exception e) {
                            e.printStackTrace();
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    player.sendMessage("Ocurrió un error al intentar establecer el tiempo de la tormenta.");
                                }
                            }.runTask(Main.getInstance());
                        }
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
