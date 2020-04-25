package com.raginox.warlockbrawl;

import com.raginox.warlockbrawl.Arena.ArenaManager;
import com.raginox.warlockbrawl.Spells.Spells;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

public final class WarlockBrawl extends JavaPlugin {

    private ArenaManager arenaManager;

    @Override
    public void onEnable() {
        arenaManager = new ArenaManager(this);
        arenaManager.deserialize();

        Bukkit.getServer().getPluginManager().registerEvents(new Spells(), this);
        // Plugin startup logic
        getServer().getConsoleSender().sendMessage(ChatColor.GOLD + "\n\nPlugin Enabled\n\n");
        loadConfig();
    }

    @Override
    public void onDisable() {
        arenaManager.serialize();
    }

    public void loadConfig() {
        getConfig().options().copyDefaults(true);
        saveConfig();
    }

    public ArenaManager getArenaManager() {
        return arenaManager;
    }
}
