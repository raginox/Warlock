package com.raginox.warlockbrawl.EventListeners;

import com.raginox.warlockbrawl.Arena.Arena;
import com.raginox.warlockbrawl.Arena.ArenaManager;
import com.raginox.warlockbrawl.WarlockBrawl;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoinListener implements Listener {

    private ArenaManager arenaManager;

    public PlayerJoinListener(WarlockBrawl plugin) {
        this.arenaManager = plugin.getArenaManager();
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent e) {
        Arena arena = arenaManager.getArena("Test");
        if (arena == null) return;
        Player player = e.getPlayer();
        arena.addPlayer(player.getPlayer());
        player.teleport(arena.getLocation());
    }
}
