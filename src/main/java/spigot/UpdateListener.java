package spigot;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.PluginEnableEvent;
import org.bukkit.event.server.PluginDisableEvent;
import org.bukkit.scheduler.BukkitRunnable;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * 插件事件监听器
 */
public class UpdateListener implements Listener {
    
    private static final Logger logger = Logger.getLogger(UpdateListener.class.getName());
    private final SpigotUpdate plugin;
    private final NativeLoader loader;
    
    public UpdateListener(SpigotUpdate plugin) {
        this.plugin = plugin;
        this.loader = new NativeLoader();
    }
    
    @EventHandler
    public void onPluginEnable(PluginEnableEvent event) {
        logger.fine("Plugin enabled: " + event.getPlugin().getName());
    }
    
    @EventHandler
    public void onPluginDisable(PluginDisableEvent event) {
        logger.fine("Plugin disabled: " + event.getPlugin().getName());
    }
    
    public void scheduleUpdateCheck() {
        new BukkitRunnable() {
            @Override
            public void run() {
                try {
                    plugin.runUpdate();
                } catch (Exception e) {
                    logger.log(Level.SEVERE, "Error during update check", e);
                }
            }
        }.runTaskTimerAsynchronously(plugin, 20L * 60 * 10, 20L * 60 * 10);
    }
}
