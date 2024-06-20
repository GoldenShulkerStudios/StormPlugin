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

public class ResetStormCommand implements CommandExecutor {

    private final StormListener stormListener;
    private final DatabaseConnection databaseConnection;

    public ResetStormCommand(StormListener stormListener, DatabaseConnection databaseConnection) {
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
                        // Detener el contador que disminuye el StormTime
                        stormListener.stopStormTimer();

                        // Reiniciar la tormenta
                        stormListener.setStormTime(0);
                        stormListener.setBaseStormTime(600);
                        stormListener.hideBossBar();

                        // Limpiar el clima en el mundo del jugador
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                player.getWorld().setStorm(false);
                                player.sendMessage("La tormenta ha sido restablecida y el clima ha sido despejado.");
                            }
                        }.runTask(Main.getInstance());

                        // Actualizar los valores en la base de datos
                        PreparedStatement updateStatement = connection.prepareStatement("UPDATE stormsettings SET StormTime = 0, BaseStormTime = 600 WHERE ID = 1");
                        updateStatement.executeUpdate();
                    } catch (Exception e) {
                        e.printStackTrace();
                        new BukkitRunnable() {
                            @Override
                            public void run() {
                                player.sendMessage("Ocurrió un error al intentar restablecer la tormenta.");
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
