package mc.virtualplanet.es.serie.command;

import mc.virtualplanet.es.serie.items.HotbarItems;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Test implements CommandExecutor {

    private static final HotbarItems items = HotbarItems.getInstance();

    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {

        if (commandSender instanceof Player) {
            this.manageCommand((Player) commandSender, args);
        } else {
            commandSender.sendMessage("La consola no puede ejecutar este comando.");
        }
        return true;
    }


    private void manageCommand(Player launcher, String[] args) {
        if (args.length == 0) {
            launcher.sendMessage("§6Oye dime que opcion quieres:");
            launcher.sendMessage("§f(1) /test hola");
            launcher.sendMessage("§f(2) /test adios");
            return;
        } else {
            if (args[0].equalsIgnoreCase("hola")) {
                launcher.sendMessage("Hola como estas guapeton");
                return;
            }
            if (args[0].equalsIgnoreCase("adios")) {
                launcher.sendMessage("Ya te vas? quedate un ratito porfa");
                return;
            }
            if (args[0].equalsIgnoreCase("item")) {
                launcher.getInventory().setItem(4, items.getBook());
                return;
            }
        }

    }

}
