package mc.virtualplanet.es.serie;

import mc.virtualplanet.es.serie.command.Test;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

    @Override
    public void onEnable() {
        super.onEnable();
        System.out.println("Esto es una prueba para youtube!");
        this.initCommand();
    }

    private void initCommand() {
        getCommand("test").setExecutor(new Test());
    }

    @Override
    public void onDisable() {
        super.onDisable();
    }
}
