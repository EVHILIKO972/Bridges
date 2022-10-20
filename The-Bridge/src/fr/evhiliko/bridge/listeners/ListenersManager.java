package fr.evhiliko.bridge.listeners;

import org.bukkit.Bukkit;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.PluginManager;

public class ListenersManager {
    public Plugin plugin;
    public PluginManager pm;

    public ListenersManager(Plugin plugin) {

        this.plugin = plugin;
        this.pm = Bukkit.getPluginManager();

    }

    public void registerListeners() {

        this.pm.registerEvents(new Join(), this.plugin);
        this.pm.registerEvents(new Damage(), this.plugin);
        this.pm.registerEvents(new Parameters(), this.plugin);
        this.pm.registerEvents(new Portal(), this.plugin);

    }

}
