package com.special70.antioffhand;

import org.bukkit.plugin.java.JavaPlugin;

public final class AntiOffHand extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println("[AntiOffHand] Plugin has loaded");
        getServer().getPluginManager().registerEvents(new EventsList(), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println("[AntiOffHand] Plugin has unloaded");
    }
}
