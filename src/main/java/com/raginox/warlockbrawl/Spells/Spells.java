package com.raginox.warlockbrawl.Spells;

import com.raginox.warlockbrawl.WarlockBrawl;
import org.bukkit.*;
import org.bukkit.entity.LargeFireball;
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

import static org.bukkit.Bukkit.getServer;

public class Spells implements Listener{

    private ArrayList<Integer> Spells = new ArrayList<>();
    public Material spellWand = Material.DIAMOND_AXE;
    String fireBall = "Fireball";
    String dash = "Dash";
    String boomerang = "Boomerang";

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent e) {

        Player spellCaster = e.getPlayer();
        Action spellTrigger = Action.RIGHT_CLICK_AIR;
        float getPlayerX = spellCaster.getLocation().getBlockX();
        float getPlayerY = spellCaster.getLocation().getBlockY();
        float getPlayerZ = spellCaster.getLocation().getBlockZ();
        float getPlayerPitch = spellCaster.getLocation().getPitch();
        float getPlayerYaw = spellCaster.getLocation().getYaw();
        Location dashLocation = new Location(spellCaster.getWorld(), getPlayerX, getPlayerY, getPlayerZ, getPlayerYaw, 0);

        if(e.getAction().equals(spellTrigger) && spellWand.name().equals("TEST")) {
            // If the player was holding diamond horse armour
            if(spellCaster.getInventory().getItemInMainHand().getType().equals(spellWand)) {
                //if(spellWand.name() != fireBall) { return; }
                Player player = e.getPlayer();
                // Launch the snowball where the player is looking
                LargeFireball spellProjectile = player.launchProjectile(LargeFireball.class, player.getLocation().getDirection());
                spellProjectile.setVelocity(spellProjectile.getVelocity().multiply(2));
                // Save the launched snowball's id
                Spells.add(spellProjectile.getEntityId());

            }
        }

        if(e.getAction().equals(spellTrigger)) {
            if(spellCaster.getInventory().getItemInMainHand().getType().equals(spellWand)){
                //if(spellWand.name() != dash) { return; }
                spellCaster.setVelocity(dashLocation.getDirection().multiply(5));
                getServer().getConsoleSender().sendMessage(ChatColor.GOLD + dashLocation.toString());
                }
        }
    }

    @EventHandler
    public void onProjectileHit(ProjectileHitEvent e) {

    }
}
