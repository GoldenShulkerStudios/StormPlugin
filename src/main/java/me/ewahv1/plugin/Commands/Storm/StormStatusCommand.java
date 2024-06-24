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
import java.sql.ResultSet;

public class StormStatusCommand implements CommandExecutor {

    private final StormListener stormListener;
    private final DatabaseConnection databaseConnection;

    public StormStatusCommand(StormListener stormListener, DatabaseConnection databaseConnection) {
        this.stormListener = stormListener;
        this.databaseConnection = databaseConnection;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;
            new BukkitRunnable() {
                @Override
                public void run() {
                    try (Connection connection = databaseConnection.getConnection()) {
                        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM stormsettings WHERE ID = 1");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                            boolean isActive = resultSet.getBoolean("StormActive");
                            int remainingStormTime = resultSet.getInt("RemainingStormTime");
                            int defaultStormTime = resultSet.getInt("DefaultStormTime");
                            int playerDeathCounter = resultSet.getInt("PlayerDeathCounter");

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
                    } catch (Exception e) {
                        e.printStackTrace();
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                player.sendMessage("Ocurrió un error al intentar obtener el estado de la tormenta.");
                            }
                        }.runTask(Main.getInstance());
                    }
                }
            }.runTaskAsynchronously(Main.getInstance());
            return true;
        } else {
            sender.sendMessage("Este comando solo puede ser utilizado por un jugador.");
        }
        return false;
    }
}
