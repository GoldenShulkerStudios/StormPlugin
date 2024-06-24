package me.ewahv1.plugin.Listeners.Storm;

import me.ewahv1.plugin.Database.DatabaseConnection;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class StormListener implements Listener {

    private JavaPlugin plugin;
    private DatabaseConnection databaseConnection;
    private int remainingStormTime;
    private int defaultStormTime = 600;
    private boolean stormActive;
    private int playerDeathCounter;
    private Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
    private Objective objective;
    private BossBar bossBar = Bukkit.createBossBar(ChatColor.GRAY + "Tiempo restante de la tormenta: ", BarColor.WHITE, BarStyle.SOLID);
    private BukkitTask stormTask;

    public StormListener(JavaPlugin plugin, DatabaseConnection databaseConnection) {
        this.plugin = plugin;
        this.databaseConnection = databaseConnection;
        loadSettingsFromDatabase();
        if (scoreboard.getObjective("stormTime") == null) {
            objective = scoreboard.registerNewObjective("stormTime", "dummy", ChatColor.GRAY + "Quedan ");
        } else {
            objective = scoreboard.getObjective("stormTime");
        }
    }

    private void loadSettingsFromDatabase() {
        try (Connection connection = databaseConnection.getConnection();
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery("SELECT * FROM stormsettings WHERE ID = 1")) {
            while (resultSet.next()) {
                remainingStormTime = resultSet.getInt("RemainingStormTime");
                defaultStormTime = resultSet.getInt("DefaultStormTime");
                stormActive = resultSet.getBoolean("StormActive");
                playerDeathCounter = resultSet.getInt("PlayerDeathCounter");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setRemainingStormTime(int time) {
        this.remainingStormTime = time;
    }

    public void setDefaultStormTime(int time) {
        this.defaultStormTime = time;
    }

    public void setStormActive(boolean active) {
        this.stormActive = active;
    }

    public int getRemainingStormTime() {
        return this.remainingStormTime;
    }

    public void hideBossBar() {
        this.bossBar.setVisible(false);
    }

    public void stopStormTimer() {
        if (stormTask != null) {
            stormTask.cancel();
            stormTask = null;
        }
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (stormActive) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    try (Connection connection = databaseConnection.getConnection()) {
                        PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM stormsettings WHERE ID = 1");
                        ResultSet resultSet = preparedStatement.executeQuery();
                        if (resultSet.next()) {
                            playerDeathCounter = resultSet.getInt("PlayerDeathCounter");
                            remainingStormTime = resultSet.getInt("RemainingStormTime");
                            defaultStormTime = resultSet.getInt("DefaultStormTime");

                            playerDeathCounter++;
                            remainingStormTime += defaultStormTime * playerDeathCounter;

                            PreparedStatement updateStatement = connection.prepareStatement("UPDATE stormsettings SET PlayerDeathCounter = ?, RemainingStormTime = ? WHERE ID = 1");
                            updateStatement.setInt(1, playerDeathCounter);
                            updateStatement.setInt(2, remainingStormTime);
                            updateStatement.executeUpdate();
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    // Asegurarse de que la tormenta esté activa
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.getWorld().setStorm(true);
                            player.getWorld().setWeatherDuration(remainingStormTime * 20);
                        }
                    }.runTask(plugin);

                    bossBar.setVisible(true);
                    Score score = objective.getScore(ChatColor.WHITE + " segundos de tormenta");
                    score.setScore(remainingStormTime);
                    for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                        bossBar.addPlayer(onlinePlayer);
                    }
                    updateBossBar();
                    if (stormTask != null) {
                        stormTask.cancel();
                    }
                    stormTask = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
                        @Override
                        public void run() {
                            if (player.getWorld().hasStorm()) {
                                remainingStormTime--;
                                updateBossBar();
                                if (remainingStormTime <= 0) {
                                    stopStormTimer();
                                    bossBar.removeAll();
                                    player.getWorld().setStorm(false);
                                }
                                try (Connection connection = databaseConnection.getConnection();
                                     PreparedStatement preparedStatement = connection.prepareStatement("UPDATE stormsettings SET RemainingStormTime = ? WHERE ID = 1")) {
                                    preparedStatement.setInt(1, remainingStormTime);
                                    preparedStatement.executeUpdate();
                                } catch (Exception e) {
                                    e.printStackTrace();
                                }
                            }
                        }
                    }, 0L, 20L);
                }
            }.runTaskAsynchronously(plugin);
        }
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld().hasStorm()) {
            bossBar.addPlayer(player);
        }
    }

    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld().hasStorm()) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "No puedes dormir durante una tormenta!");
        }
    }

    private void updateBossBar() {
        int hours = remainingStormTime / 3600;
        int minutes = (remainingStormTime % 3600) / 60;
        int seconds = remainingStormTime % 60;
        bossBar.setTitle(ChatColor.GRAY + "Tiempo restante de la tormenta: " + hours + "h " + minutes + "m " + seconds + "s");
    }
}
