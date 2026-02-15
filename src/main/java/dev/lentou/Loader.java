package dev.lentou;

import org.bukkit.plugin.java.JavaPlugin;

public class Loader extends JavaPlugin {
    
    @Override
    public void onEnable() {
        getLogger().info("SimpleMenu has been enabled!");
        new SimpleMenuListener(this);
    }

    @Override
    public void onDisable() {
        getLogger().info("SimpleMenu has been disabled!");
    }
    
}