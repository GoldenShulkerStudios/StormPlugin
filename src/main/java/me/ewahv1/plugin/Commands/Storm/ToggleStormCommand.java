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

public class ToggleStormCommand implements CommandExecutor {

    private StormListener stormListener;
    private DatabaseConnection databaseConnection;

    public ToggleStormCommand(StormListener stormListener, DatabaseConnection databaseConnection) {
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
                    boolean isActive = false;
                    try (Connection connection = databaseConnection.getConnection()) {
                        PreparedStatement preparedStatement = connection.prepareStatement("SELECT StormActive FROM stormsettings WHERE ID = 1");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                            isActive = resultSet.getBoolean("StormActive");
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                player.sendMessage("Ocurrió un error al intentar cambiar el estado de la tormenta.");
                            }
                        }.runTask(Main.getInstance());
                        return;
                    }

                    final boolean finalIsActive = isActive;
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            try (Connection connection = databaseConnection.getConnection()) {
                                PreparedStatement updateStatement;
                                if (finalIsActive) {
                                    player.getWorld().setStorm(false);
                                    stormListener.setStormActive(false);
                                    stormListener.setRemainingStormTime(0);
                                    stormListener.hideBossBar();
                                    updateStatement = connection.prepareStatement("UPDATE stormsettings SET StormActive = false, RemainingStormTime = 0 WHERE ID = 1");
                                    updateStatement.executeUpdate();
                                    player.sendMessage("La tormenta ha sido desactivada.");
                                } else {
                                    stormListener.setStormActive(true);
                                    updateStatement = connection.prepareStatement("UPDATE stormsettings SET StormActive = true WHERE ID = 1");
                                    updateStatement.executeUpdate();
                                    player.sendMessage("La tormenta ha sido activada. Comenzará cuando un jugador muera.");
                                }
                            } catch (Exception e) {
                                e.printStackTrace();
                                player.sendMessage("Ocurrió un error al intentar cambiar el estado de la tormenta.");
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
