package mc.virtualplanet.es.serie.gui;

import mc.virtualplanet.es.serie.items.HotbarItems;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Menu {

    private static final HotbarItems items = HotbarItems.getInstance();

    public static void getMenu(Player target) {
        Inventory inv = Bukkit.createInventory(target, 5*9, "§d§lEsto es un menu custom");
        inv.setItem(5, items.getBook());

        target.openInventory(inv);
    }
}
