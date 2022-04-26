package com.special70.antioffhand;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerSwapHandItemsEvent;
import org.bukkit.inventory.ItemStack;

public class EventsList implements Listener {
    public EventsList() {
    }
    @EventHandler()
    public void onMoveWithFKey(PlayerSwapHandItemsEvent event){
        Player player = event.getPlayer();
        ItemStack mainHandHand = player.getInventory().getItemInMainHand();
        ItemStack offhandHand = player.getInventory().getItemInOffHand();

        Material materialInHand = mainHandHand.getType();
        Material materialInOffHand = offhandHand.getType();

        String worldcheck = player.getWorld().getName();
        if (worldcheck.equals("KitsPlus") || worldcheck.equals("KitsPlus2"))
            // IF the player is in the correct world, accept
            if (materialInHand != Material.AIR && materialInOffHand != Material.AIR) {
                // IF the mainhand and offhand has items, accept. Else, deny
                boolean cmdataInHand = mainHandHand.getItemMeta().hasCustomModelData();
                boolean cmdataInOffHand = offhandHand.getItemMeta().hasCustomModelData();

                if (!(cmdataInHand && cmdataInOffHand))
                    // IF both items does not have cmdata, run cancel event.
                        event.setCancelled(true);
            }
            else if (materialInHand != Material.AIR || materialInOffHand != Material.AIR) {
                // IF mainhand or offhand has no items, run cancel event.
                event.setCancelled(true);
            }

    }
}
