package net.simple.armor.stand.pose;

import net.simple.armor.stand.pose.listeners.ArmorPose;
import net.simple.armor.stand.pose.listeners.ArmorSpawn;
import net.simple.armor.stand.pose.utils.ArmorSetPose;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;

public final class ArmorStandPose extends JavaPlugin {
    private final HashMap<Location, Integer> armorPose = new HashMap<>();

    @Override
    public void onEnable() {
        File config = new File(getDataFolder() + File.separator + "config.yml");
        if(!config.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }

        Bukkit.getPluginManager().registerEvents(new ArmorPose(armorPose, new ArmorSetPose(getConfig())), this); // ArmorStand Poses
        Bukkit.getPluginManager().registerEvents(new ArmorSpawn(armorPose, new ArmorSetPose(getConfig())), this); // ArmorStand Spawn change pose

        getLogger().info("Started up!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled up!");
    }
}
