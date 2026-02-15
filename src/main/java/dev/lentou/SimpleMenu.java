package dev.lentou;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.HashMap;
import java.util.Map;

public class SimpleMenu {
    
    private Inventory inventory;
    private Map<Integer, ItemStack> items = new HashMap<>();
    private boolean cancelled = true;

    private SimpleMenuHandler handler;

    public SimpleMenu(String title, int size, SimpleMenuHandler handler) {
        this.inventory = Bukkit.createInventory(null, size, title);
        this.handler = handler;
    }

    public void setCancelled(boolean value) {
        this.cancelled = value;
    }

    public boolean isCancelled() {
        return cancelled;
    }

    public void setButton(int slot, ItemStack item){
        items.put(slot, item);
        inventory.setItem(slot, item);
    }

    public ItemStack getButton(int slot) {
        return items.get(slot);
    }

    public void open(Player player){
        SimpleMenuListener.openMenus.put(player, this);
        player.openInventory(inventory);
    }

    public void click(Player player, int slot){
        if(handler != null){
            handler.handle(this, player, slot);
        }
    }

    public void close(Player player){
        player.closeInventory();
    }

    public Inventory getInventory(){ 
        return inventory; 
    }

}