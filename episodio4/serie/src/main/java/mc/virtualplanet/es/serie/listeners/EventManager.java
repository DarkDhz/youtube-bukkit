package mc.virtualplanet.es.serie.listeners;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

public class EventManager implements Listener {

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

}
