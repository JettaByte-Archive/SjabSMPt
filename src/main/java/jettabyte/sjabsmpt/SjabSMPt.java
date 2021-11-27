package jettabyte.sjabsmpt;

import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

public final class SjabSMPt extends JavaPlugin {

    @Override
    public void onEnable() {
        // Plugin startup logic
        System.out.println(ChatColor.GREEN + "!");
        getServer().getPluginManager().registerEvents(new Event(), this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        System.out.println(ChatColor.RED + "*");
    }
}
