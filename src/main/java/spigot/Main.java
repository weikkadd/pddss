package com.github.weikkadd.pddss;

import org.bukkit.plugin.java.JavaPlugin;

/**
 * Main plugin class for AutoUpdatePlugins analysis demo.
 * This is a placeholder to enable Maven builds.
 */
public class Main extends JavaPlugin {
    
    @Override
    public void onEnable() {
        getLogger().info("AutoUpdatePlugins loaded!");
    }
    
    @Override
    public void onDisable() {
        getLogger().info("AutoUpdatePlugins disabled!");
    }
}
