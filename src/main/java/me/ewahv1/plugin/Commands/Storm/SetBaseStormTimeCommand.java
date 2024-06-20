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

public class SetBaseStormTimeCommand implements CommandExecutor {

    private final StormListener stormListener;
    private final DatabaseConnection databaseConnection;

    public SetBaseStormTimeCommand(StormListener stormListener, DatabaseConnection databaseConnection) {
        this.stormListener = stormListener;
        this.databaseConnection = databaseConnection;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            Player player = (Player) sender;

            // Verificar que los argumentos sean correctos
            if (args.length < 3 || !args[0].equalsIgnoreCase("set") || !args[1].equalsIgnoreCase("BaseTime")) {
                player.sendMessage("Uso: /storm set BaseTime <tiempo>");
                player.sendMessage("Argumentos recibidos: " + String.join(", ", args));
                return true;
            }

            try {
                int baseTime = Integer.parseInt(args[2]);

                // Ejecutar la tarea de actualización de forma asíncrona
                new BukkitRunnable() {
                    @Override
                    public void run() {
                        try (Connection connection = databaseConnection.getConnection()) {
                            // Actualizar el tiempo base de la tormenta en el listener
                            stormListener.setBaseStormTime(baseTime);

                            // Actualizar la base de datos
                            PreparedStatement updateStatement = connection.prepareStatement("UPDATE stormsettings SET BaseStormTime = ? WHERE ID = 1");
                            updateStatement.setInt(1, baseTime);
                            updateStatement.executeUpdate();

                            // Enviar mensaje al jugador en el hilo principal
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    player.sendMessage("El tiempo base de la tormenta ha sido establecido a " + baseTime + " segundos.");
                                }
                            }.runTask(Main.getInstance());
                        } catch (Exception e) {
                            e.printStackTrace();
                            // Manejar errores y enviar mensaje al jugador
                            new BukkitRunnable() {
                                @Override
                                public void run() {
                                    player.sendMessage("Ocurrió un error al intentar establecer el tiempo base de la tormenta.");
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
