package net.simple.armor.stand.pose;

import java.util.UUID;
import net.simple.armor.stand.pose.hooks.LWCXHook;
import net.simple.armor.stand.pose.listeners.ArmorPose;
import net.simple.armor.stand.pose.listeners.ArmorSpawn;
import net.simple.armor.stand.pose.utils.ArmorSetPose;
import net.simple.armor.stand.pose.utils.MainConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;

public final class ArmorStandPose extends JavaPlugin {
    private final HashMap<UUID, Integer> armorPose = new HashMap<>();

    @Override
    public void onEnable() {
        File fileConfig = new File(getDataFolder() + File.separator + "config.yml");
        if(!fileConfig.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }

        MainConfig config = new MainConfig(getConfig());

        ArmorSetPose armorSetPose = new ArmorSetPose(config);

        Bukkit.getPluginManager().registerEvents(new ArmorPose(armorPose, armorSetPose, config), this); // ArmorStand Poses
        Bukkit.getPluginManager().registerEvents(new ArmorSpawn(armorPose, armorSetPose), this); // ArmorStand Spawn change pose

        if (Bukkit.getPluginManager().getPlugin("LWC") != null) {
            new LWCXHook(this);
        }

        getLogger().info("Started up!");
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled up!");
    }
}
