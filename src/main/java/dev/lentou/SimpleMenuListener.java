package dev.lentou;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;

public class SimpleMenuListener implements Listener {

    public static Map<Player, SimpleMenu> openMenus = new HashMap<>();

    public SimpleMenuListener(JavaPlugin plugin) {
        plugin.getServer().getPluginManager().registerEvents(this, plugin);
    }

    @EventHandler
    public void onClick(InventoryClickEvent e){

        Player p = (Player) e.getWhoClicked();

        if(!openMenus.containsKey(p)) return;

        SimpleMenu menu = openMenus.get(p);

        if(!e.getInventory().equals(menu.getInventory())) return;

        if(menu.isCancelled()){
            e.setCancelled(true);
        }

        if(e.getRawSlot() >= menu.getInventory().getSize()) return;

        menu.click(p, e.getSlot());
    }

    @EventHandler
    public void onClose(InventoryCloseEvent e){
        Player p = (Player) e.getPlayer();

        if(!openMenus.containsKey(p)) return;

        SimpleMenu menu = openMenus.remove(p);
        menu.close(p);
    }
}

