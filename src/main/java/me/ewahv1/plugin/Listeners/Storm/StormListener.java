package me.ewahv1.plugin.Listeners.Storm;

import me.ewahv1.plugin.CreateFiles.JsonManager;
import me.ewahv1.plugin.Database.DatabaseSyncManager;
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

import java.io.File;

public class StormListener implements Listener {

    private JavaPlugin plugin;
    private DatabaseSyncManager databaseSyncManager;
    private int remainingStormTime;
    private int defaultStormTime = 600;
    private boolean stormActive;
    private int playerDeathCounter;
    private Scoreboard scoreboard = Bukkit.getScoreboardManager().getMainScoreboard();
    private Objective objective;
    private BossBar bossBar = Bukkit.createBossBar(ChatColor.GRAY + "Tiempo restante de la tormenta: ", BarColor.WHITE,
            BarStyle.SOLID);
    private BukkitTask stormTask;

    private File configFile;

    // Constructor del listener de tormentas
    public StormListener(JavaPlugin plugin, DatabaseSyncManager databaseSyncManager) {
        this.plugin = plugin;
        this.databaseSyncManager = databaseSyncManager;
        this.configFile = new File(plugin.getDataFolder(), "stormsettings.json");
        loadSettingsFromFile(); // Carga los ajustes de la tormenta desde el archivo JSON
        if (scoreboard.getObjective("stormTime") == null) {
            objective = scoreboard.registerNewObjective("stormTime", "dummy", ChatColor.GRAY + "Quedan ");
        } else {
            objective = scoreboard.getObjective("stormTime");
        }
    }

    // Carga los ajustes de la tormenta desde el archivo JSON
    private void loadSettingsFromFile() {
        if (!configFile.exists()) {
            saveSettingsToFile(); // Crea el archivo con valores por defecto si no existe
        }
        StormSettings config = JsonManager.loadConfig(configFile, StormSettings.class);
        if (config != null) {
            remainingStormTime = config.getRemainingStormTime();
            defaultStormTime = config.getDefaultStormTime();
            stormActive = config.isStormActive();
            playerDeathCounter = config.getPlayerDeathCounter();
        }
    }

    // Guarda los ajustes de la tormenta en el archivo JSON y sincroniza con la base
    // de datos
    private void saveSettingsToFile() {
        StormSettings config = new StormSettings(remainingStormTime, defaultStormTime, stormActive, playerDeathCounter);
        JsonManager.saveConfig(configFile, config);
        databaseSyncManager.syncToDatabase(config); // Sincroniza con la base de datos en tiempo real
    }

    // Establece el tiempo restante de la tormenta y guarda los ajustes
    public void setRemainingStormTime(int time) {
        this.remainingStormTime = time;
        saveSettingsToFile();
    }

    // Establece el tiempo base de la tormenta y guarda los ajustes
    public void setDefaultStormTime(int time) {
        this.defaultStormTime = time;
        saveSettingsToFile();
    }

    // Establece el estado de la tormenta (activa o no) y guarda los ajustes
    public void setStormActive(boolean active) {
        this.stormActive = active;
        saveSettingsToFile();
    }

    // Obtiene el estado de la tormenta (activa o no)
    public boolean isStormActive() {
        return this.stormActive;
    }

    // Obtiene el tiempo restante de la tormenta
    public int getRemainingStormTime() {
        return this.remainingStormTime;
    }

    // Obtiene el tiempo base de la tormenta
    public int getDefaultStormTime() {
        return this.defaultStormTime;
    }

    // Obtiene el contador de muertes de jugadores durante la tormenta
    public int getPlayerDeathCounter() {
        return this.playerDeathCounter;
    }

    // Establece el contador de muertes de jugadores y guarda los ajustes
    public void setPlayerDeathCounter(int count) {
        this.playerDeathCounter = count;
        saveSettingsToFile();
    }

    // Oculta la barra de estado de la tormenta
    public void hideBossBar() {
        this.bossBar.setVisible(false);
    }

    // Detiene el temporizador de la tormenta
    public void stopStormTimer() {
        if (stormTask != null) {
            stormTask.cancel();
            stormTask = null;
        }
    }

    // Evento que se dispara cuando un jugador muere
    @EventHandler
    public void onPlayerDeath(PlayerDeathEvent event) {
        Player player = event.getEntity();
        if (stormActive) {
            new BukkitRunnable() {
                @Override
                public void run() {
                    playerDeathCounter++;
                    remainingStormTime += defaultStormTime * playerDeathCounter;
                    saveSettingsToFile();

                    // Asegurarse de que la tormenta esté activa (con truenos)
                    new BukkitRunnable() {
                        @Override
                        public void run() {
                            player.getWorld().setStorm(true);
                            player.getWorld().setThundering(true);
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
                                    player.getWorld().setThundering(false);
                                }
                                saveSettingsToFile();
                            }
                        }
                    }, 0L, 20L);
                }
            }.runTaskAsynchronously(plugin);
        }
    }

    // Evento que se dispara cuando un jugador se une al servidor
    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld().hasStorm()) {
            bossBar.addPlayer(player);
        }
    }

    // Evento que se dispara cuando un jugador intenta dormir
    @EventHandler
    public void onPlayerBedEnter(PlayerBedEnterEvent event) {
        Player player = event.getPlayer();
        if (player.getWorld().hasStorm()) {
            event.setCancelled(true);
            player.sendMessage(ChatColor.RED + "No puedes dormir durante una tormenta!");
        }
    }

    // Actualiza la barra de estado de la tormenta con el tiempo restante
    private void updateBossBar() {
        int hours = remainingStormTime / 3600;
        int minutes = (remainingStormTime % 3600) / 60;
        int seconds = remainingStormTime % 60;
        bossBar.setTitle(
                ChatColor.GRAY + "Tiempo restante de la tormenta: " + hours + "h " + minutes + "m " + seconds + "s");
    }
}
