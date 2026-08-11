package spigot;

import org.bukkit.plugin.java.JavaPlugin;
import java.io.InputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;
import java.util.logging.Level;

/**
 * 插件资源配置加载器
 */
public class RuntimeResources {
    
    private static final Logger logger = Logger.getLogger(RuntimeResources.class.getName());
    public static final String PLUGIN_YML = "plugin.yml";
    public static final String HASHES_DAT = "hashes.dat";
    public static final String CONFIG_BLOB = "config.bin";
    
    private final JavaPlugin plugin;
    
    public RuntimeResources(JavaPlugin plugin) {
        this.plugin = plugin;
    }
    
    public byte[] readResource(String name) {
        try (InputStream is = plugin.getResource(name)) {
            return is != null ? is.readAllBytes() : null;
        } catch (IOException e) {
            logger.log(Level.WARNING, "Failed to read resource: " + name, e);
            return null;
        }
    }
}
