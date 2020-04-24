package mc.virtualplanet.es.serie;

import mc.virtualplanet.es.serie.command.Test;
import mc.virtualplanet.es.serie.listeners.EventManager;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        System.out.println("Esto es una prueba para youtube!");
        this.initCommand();
        this.initEvents();
    }

    private void initCommand() {
        getCommand("test").setExecutor(new Test());
    }

    private void initEvents() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new EventManager(), this);
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
