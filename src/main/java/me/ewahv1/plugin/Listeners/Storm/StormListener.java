package me.ewahv1.plugin.Listeners.Storm;

import me.ewahv1.plugin.CreateFiles.JsonManager;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.PlayerBedEnterEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.io.File;

public class StormListener implements Listener {

    private JavaPlugin plugin;
    private Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
    private Objective objective;
    private BossBar bossBar = Bukkit.createBossBar(ChatColor.GRAY + "Tiempo restante de la tormenta: ", BarColor.WHITE,
            BarStyle.SOLID);
    private BukkitTask stormTask;

    private File configFile;

    public StormListener(JavaPlugin plugin) {
        this.plugin = plugin;
        this.configFile = new File(plugin.getDataFolder(), "StormConfig.json");
        StormSettings config = loadSettingsFromFile();
        if (scoreboard.getObjective("stormTime") == null) {
            objective = scoreboard.registerNewObjective("stormTime", "dummy", ChatColor.GRAY + "Quedan ");
        } else {
            objective = scoreboard.getObjective("stormTime");
        }

        if (config.isStormActive()) {
            startStormTimer(config);
        }
    }

    public StormSettings loadSettingsFromFile() {
        StormSettings config = JsonManager.loadConfig(configFile, StormSettings.class);
        if (config == null) {
            config = new StormSettings(0, 600, false, 0); // Valores por defecto si no se puede cargar el JSON
        }
        return config;
    }

    public void saveSettingsToFile(StormSettings config) {
        JsonManager.saveConfig(configFile, config);
    }

    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        StormSettings config = loadSettingsFromFile();
        if (config.isStormActive()) {
            config.setPlayerDeathCounter(config.getPlayerDeathCounter() + 1);
            config.setRemainingStormTime(
                    config.getRemainingStormTime() + config.getDefaultStormTime() * config.getPlayerDeathCounter());
            saveSettingsToFile(config);

            new BukkitRunnable() {
                @Override
                public void run() {
                    player.getWorld().setStorm(true);
                    player.getWorld().setThundering(true);
                    player.getWorld().setWeatherDuration(config.getRemainingStormTime() * 20);
                }
            }.runTask(plugin);

            bossBar.setVisible(true);
            updateBossBar(config);
            for (Player onlinePlayer : Bukkit.getOnlinePlayers()) {
                bossBar.addPlayer(onlinePlayer);
            }
            if (stormTask != null) {
                stormTask.cancel();
            }
            startStormTimer(config);
        }
    }

    public void startStormTimer(StormSettings config) {
        stormTask = Bukkit.getScheduler().runTaskTimer(plugin, new Runnable() {
            @Override
            public void run() {
                for (World world : Bukkit.getWorlds()) {
                    if (world.hasStorm()) {
                        config.setRemainingStormTime(config.getRemainingStormTime() - 1);
                        updateBossBar(config);
                        if (config.getRemainingStormTime() <= 0) {
                            stopStormTimer();
                            bossBar.removeAll();
                            world.setStorm(false);
                            world.setThundering(false);
                        }
                        saveSettingsToFile(config);
                    }
                }
            }
        }, 20L, 20L);
    }

    public void restartStormTimer(StormSettings config) {
        stopStormTimer();
        startStormTimer(config);
    }

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        StormSettings config = loadSettingsFromFile();
        if (player.getWorld().hasStorm()) {
            bossBar.addPlayer(player);
        }
    }

    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        StormSettings config = loadSettingsFromFile();
        if (player.getWorld().hasStorm()) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "No puedes dormir durante una tormenta!");
        }
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

    public void updateBossBar(StormSettings config) {
        int hours = config.getRemainingStormTime() / 3600;
        int minutes = (config.getRemainingStormTime() % 3600) / 60;
        int seconds = config.getRemainingStormTime() % 60;
        double progress = Math.max(0, Math.min(1, config.getRemainingStormTime()
                / (double) (config.getDefaultStormTime() * config.getPlayerDeathCounter())));
        bossBar.setTitle(
                ChatColor.GRAY + "Tiempo restante de la tormenta: " + hours + "h " + minutes + "m " + seconds + "s");
        bossBar.setProgress(progress);
    }

    public static class StormSettings {
        private int RemainingStormTime;
        private int DefaultStormTime;
        private boolean StormActive;
        private int PlayerDeathCounter;

        public StormSettings(int remainingStormTime, int defaultStormTime, boolean stormActive,
                int playerDeathCounter) {
            this.RemainingStormTime = remainingStormTime;
            this.DefaultStormTime = defaultStormTime;
            this.StormActive = stormActive;
            this.PlayerDeathCounter = playerDeathCounter;
        }

        public int getRemainingStormTime() {
            return RemainingStormTime;
        }

        public void setRemainingStormTime(int remainingStormTime) {
            RemainingStormTime = remainingStormTime;
        }

        public int getDefaultStormTime() {
            return DefaultStormTime;
        }

        public void setDefaultStormTime(int defaultStormTime) {
            DefaultStormTime = defaultStormTime;
        }

        public boolean isStormActive() {
            return StormActive;
        }

        public void setStormActive(boolean stormActive) {
            StormActive = stormActive;
        }

        public int getPlayerDeathCounter() {
            return PlayerDeathCounter;
        }

        public void setPlayerDeathCounter(int playerDeathCounter) {
            PlayerDeathCounter = playerDeathCounter;
        }
    }
}
