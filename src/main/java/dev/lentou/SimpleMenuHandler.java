package dev.lentou;

import org.bukkit.entity.Player;

public interface SimpleMenuHandler {
    void handle(SimpleMenu menu, Player player, int slot);
}
