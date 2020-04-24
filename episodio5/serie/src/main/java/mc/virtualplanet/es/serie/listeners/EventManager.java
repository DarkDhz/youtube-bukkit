package mc.virtualplanet.es.serie.listeners;

import mc.virtualplanet.es.serie.gui.Menu;
import mc.virtualplanet.es.serie.items.HotbarItems;
import org.bukkit.entity.Item;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

public class EventManager implements Listener {

    private static final HotbarItems items = HotbarItems.getInstance();

    @EventHandler
    public void onBlock(BlockBreakEvent event) {
        Player player = event.getPlayer();
        if (!player.hasPermission("virtual.break")) {
            player.sendMessage("Hey no puedes romper bloques");
            event.setCancelled(true);
        } else {
            player.sendMessage("Enhorabuena estas chetado y puedes romper lo que te de la gana");
        }

    }

    @EventHandler
    public void onDamage(EntityDamageByEntityEvent event) {
        if (event.getEntity() instanceof Player) {
            Player hitted = (Player) event.getEntity();
            hitted.sendMessage("Hey eres inmortal papi");
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onPlace(BlockPlaceEvent event) {
        event.setCancelled(true);
    }

    @EventHandler
    public void onInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        if (event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() == Action.RIGHT_CLICK_BLOCK ) {
            if (compareTwoItems(player.getItemInHand(), items.getBook())) {
                Menu.getMenu(player);
            }
        }
    }

    private static boolean compareTwoItems(ItemStack original, ItemStack toCompare) {
        if (original.getType() != toCompare.getType()) {
            return false;
        }
        if (!original.hasItemMeta()) {
            return false;
        }
        return original.getItemMeta().getDisplayName().equals(toCompare.getItemMeta().getDisplayName());
    }

}
