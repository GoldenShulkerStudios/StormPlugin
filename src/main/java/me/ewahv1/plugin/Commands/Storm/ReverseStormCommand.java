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

public class ReverseStormCommand implements CommandExecutor {

    private final StormListener stormListener;
    private final DatabaseConnection databaseConnection;

    public ReverseStormCommand(StormListener stormListener, DatabaseConnection databaseConnection) {
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
                            int remainingStormTime = resultSet.getInt("RemainingStormTime");
                            int defaultStormTime = resultSet.getInt("DefaultStormTime");
                            int playerDeathCounter = resultSet.getInt("PlayerDeathCounter");

                            final int[] newRemainingStormTime = {remainingStormTime - (defaultStormTime * playerDeathCounter)};
                            if (newRemainingStormTime[0] < 0) newRemainingStormTime[0] = 0;

                            if (playerDeathCounter > 0) {
                                playerDeathCounter--; // Reduce the player death counter by 1
                            }

                            PreparedStatement updateStatement = connection.prepareStatement("UPDATE stormsettings SET RemainingStormTime = ?, PlayerDeathCounter = ? WHERE ID = 1");
                            updateStatement.setInt(1, newRemainingStormTime[0]);
                            updateStatement.setInt(2, playerDeathCounter);
                            updateStatement.executeUpdate();

                            stormListener.setRemainingStormTime(newRemainingStormTime[0]);

                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    player.getWorld().setWeatherDuration(newRemainingStormTime[0] * 20);
                                    player.sendMessage("El tiempo de la tormenta ha sido revertido y el contador de muertes ha sido reducido en 1.");
                                }
                            }.runTask(Main.getInstance());
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                player.sendMessage("Ocurrió un error al intentar revertir el tiempo de la tormenta.");
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
