package mc.virtualplanet.es.serie.items;

import net.minecraft.server.v1_8_R3.ItemMapEmpty;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.ArrayList;
import java.util.List;

public class HotbarItems {

    private static HotbarItems INSTANCE = null;

    private HotbarItems() {

    }

    public static HotbarItems getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            synchronized (HotbarItems.class) {
                if (INSTANCE == null) {
                    INSTANCE = new HotbarItems();
                }
            }
        }
    }

    public ItemStack getBook() {
        ItemStack item = new ItemStack(Material.BOOK);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName("§d§lEsto es un item personalizado");
        List<String> lore = new ArrayList<String>();
        lore.add("§c");
        lore.add("§fEsto es un lore personalizado");
        meta.setLore(lore);
        meta.addEnchant(Enchantment.DURABILITY, 5, false);
        meta.addItemFlags(ItemFlag.HIDE_ENCHANTS);
        item.setItemMeta(meta);
        return item;
    }

}
