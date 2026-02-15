# SimpleMenu
a simple static inventory menu api for spigotmc/papermc

usage example:
```java
// create rules gui with 27 size (chest-size)
SimpleMenu rulesGui = new SimpleMenu("§lRules", 27, (menu, player, slot) -> {
  if (slot == 13) {
    player.sendMessage("§7Rules: §aNo Griefing, No Hacking, No Stealing");
    menu.close(player);
  }
});

// this api is from bukkit
ItemStack sword = new ItemStack(Material.IRON_SWORD);
ItemMeta swordmeta = sword.getItemMeta();
swordmeta.setDisplayName("§lRules");
sword.setItemMeta(swordmeta);

// adding buttons on rules gui
// 13 is slot and our item icon is iron sword
rulesGui.setButton(13, sword);
rulesGui.open(sender);
```
and you're done, simple as it is!<br>inspired by FormAPI library from pmmp xd
