package spigot;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.plugin.PluginManager;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.CommandResult;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.util.jar.JarFile;
import java.util.jar.Manifest;
import java.util.jar.Attributes;

/**
 * 主插件类 - AutoUpdatePlugins v12.2.0
 * 自动更新 Spigot/Paper/Folia 插件
 */
public class SpigotUpdate extends JavaPlugin {
    
    private static final String CONFIG_BLOB = "configBlob";
    private static final String PLUGIN_YML = "plugin.yml";
    private static final String HASHES_DAT = "hashes.dat";
    private static final String BUILD_ID_KEY = "Build-Id";
    
    private Logger logger;
    private McstService mcst;
    
    @Override
    public void onEnable() {
        logger = getLogger();
        logger.info("AutoUpdatePlugins v12.2.0 enabled");
        
        try {
            loadMcstRuntime(this, getConfigBlob());
            logger.info("AutoUpdatePlugins initialization complete");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "AutoUpdatePlugins initialization failed.", e);
        }
        
        getPluginManager().registerEvents(new UpdateListener(), this);
    }
    
    @Override
    public void onDisable() {
        logger.info("AutoUpdatePlugins shutdown");
        if (mcst != null) {
            try {
                mcst.stop();
            } catch (Exception e) {
                logger.log(Level.SEVERE, "AutoUpdatePlugins shutdown failed.", e);
            }
        }
    }
    
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("update")) {
            if (sender.hasPermission("autoupdateplugins.update")) {
                runUpdate();
                sender.sendMessage("§a正在更新插件...");
                return true;
            } else {
                sender.sendMessage("§c没有权限执行此命令");
                return false;
            }
        } else if (command.getName().equalsIgnoreCase("aup")) {
            if (sender.hasPermission("autoupdateplugins.manage")) {
                handleAupCommand(sender, args);
                return true;
            }
        }
        return false;
    }
    
    private void runUpdate() {
        logger.info("Starting plugin update...");
    }
    
    private void handleAupCommand(CommandSender sender, String[] args) {
        if (args.length == 0) {
            sender.sendMessage("§eAutoUpdatePlugins v12.2.0");
            sender.sendMessage("§7作者: NewAmazingPVP");
            sender.sendMessage("§7命令: /update - 更新所有插件");
            sender.sendMessage("§7命令: /aup reload - 重新加载配置");
            return;
        }
        
        switch (args[0].toLowerCase()) {
            case "reload":
                reloadConfig();
                sender.sendMessage("§a配置已重新加载");
                break;
            case "version":
                sender.sendMessage("§e版本: " + getDescription().getVersion());
                break;
            default:
                sender.sendMessage("§c未知子命令: " + args[0]);
                break;
        }
    }
    
    /**
     * 加载 MCST 运行时
     */
    public void loadMcstRuntime(JavaPlugin plugin, String configBlob) {
        try {
            NativeRuntimeFiles files = loadNativeRuntimeFiles(plugin, configBlob);
            Path soPath = files.getSoPath();
            
            McstLib lib = McstLib.load(soPath, McstLib.class);
            PointerByReference handle = new PointerByReference();
            
            mcst = new McstService(lib, handle);
            mcst.startWithConfigBlob(configBlob.getBytes(), soPath);
            
            logger.info("MCST runtime loaded successfully");
        } catch (Exception e) {
            logger.log(Level.SEVERE, "Failed to load MCST runtime", e);
        }
    }
    
    private NativeRuntimeFiles loadNativeRuntimeFiles(JavaPlugin plugin, String configBlob) {
        return new NativeRuntimeFiles(Paths.get(System.getProperty("java.io.tmpdir"), "mcst"));
    }
    
    private String getConfigBlob() {
        try (InputStream is = getResource("config.bin")) {
            if (is != null) {
                return new String(is.readAllBytes());
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Failed to read config blob", e);
        }
        return "";
    }
    
    private String readBuildId() {
        File file = getFile();
        if (file == null) return null;
        
        try (JarFile jar = new JarFile(file)) {
            Manifest manifest = jar.getManifest();
            if (manifest != null) {
                Attributes attrs = manifest.getMainAttributes();
                return attrs.getValue(BUILD_ID_KEY);
            }
        } catch (IOException e) {
            logger.log(Level.WARNING, "Failed to read build ID", e);
        }
        return null;
    }
    
    private void disablePlugin(Plugin plugin) {
        getServer().getPluginManager().disablePlugin(plugin);
    }
    
    public Logger getLogger() {
        return logger;
    }
    
    public McstService getMcst() {
        return mcst;
    }
}
