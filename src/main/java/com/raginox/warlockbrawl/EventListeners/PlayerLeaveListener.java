package com.raginox.warlockbrawl.EventListeners;

import com.raginox.warlockbrawl.Arena.Arena;
import com.raginox.warlockbrawl.Arena.ArenaManager;
import com.raginox.warlockbrawl.WarlockBrawl;
import org.bukkit.entity.Player;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerLeaveListener {

    private ArenaManager arenaManager;

    public PlayerLeaveListener(WarlockBrawl plugin) {
        this.arenaManager = plugin.getArenaManager();
    }

    public void onQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();
        Arena arena = arenaManager.getArena(player);
        if(arena == null) return;
        arena.removePlayer(player.getPlayer());
    }

}
