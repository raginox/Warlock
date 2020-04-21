package com.raginox.warlockbrawl.Spells;

import com.raginox.warlockbrawl.WarlockBrawl;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.ProjectileHitEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.ArrayList;
import java.util.HashMap;

public class Spells implements Listener{

    private ArrayList<Integer> Spells = new ArrayList<>();
    public Material spellWand = Material.DIAMOND_AXE;

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        Player spellCaster = e.getPlayer();
        Action spellTrigger = Action.RIGHT_CLICK_AIR;

        if(e.getAction().equals(spellTrigger)) {
            // If the player was holding diamond horse armour
            if(spellCaster.getInventory().getItemInMainHand().getType().equals(spellWand)) {
                Player player = e.getPlayer();
                // Launch the snowball where the player is looking
                Snowball bullet = player.launchProjectile(Snowball.class, player.getLocation().getDirection());
                // Save the launched snowball's id
                Spells.add(bullet.getEntityId());
            }
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {

    }
}
