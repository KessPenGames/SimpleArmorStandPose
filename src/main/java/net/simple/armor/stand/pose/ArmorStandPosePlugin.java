package net.simple.armor.stand.pose;

import com.sk89q.worldguard.bukkit.WorldGuardPlugin;
import net.simple.armor.stand.pose.listeners.ArmorChangePoseListener;
import net.simple.armor.stand.pose.listeners.ArmorSpawnListener;
import net.simple.armor.stand.pose.utils.ArmorSetPose;
import net.simple.armor.stand.pose.config.MainConfig;
import net.simple.armor.stand.pose.worldguard.WorldGuardFlag;
import net.simple.armor.stand.pose.worldguard.WorldGuardRegions;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.Arrays;
import java.util.HashMap;

public final class ArmorStandPosePlugin extends JavaPlugin {
    private MainConfig config = null;
    private final HashMap<Location, Integer> armorPose = new HashMap<>();

    @Override
    public void onLoad() {
        registerConfig();
        this.config = new MainConfig(getConfig());
        if (isWorldGuardEnabled() && config.worldGuard.getEnableWorldGuard()) {
            new WorldGuardFlag(config).registerFlag();
            getLogger().info("WorldGuard found!");
        }
    }

    @Override
    public void onEnable() {
        registerEvents();
        getLogger().info("Started up!");
    }

    private void registerConfig() {
        File fileConfig = new File(getDataFolder() + File.separator + "config.yml");
        if(!fileConfig.exists()) {
            getConfig().options().copyDefaults(true);
            saveDefaultConfig();
        }
    }

    private void registerEvents() {
        ArmorSetPose armorSetPose = new ArmorSetPose(config);
        registerEvents(
                new ArmorChangePoseListener(armorPose, armorSetPose, config, getWGRegions()),
                new ArmorSpawnListener(armorPose, armorSetPose)
        );
    }

    private void registerEvents(Listener... args) {
        Arrays.stream(args).forEach(listener -> Bukkit.getPluginManager().registerEvents(listener, this));
    }

    @Override
    public void onDisable() {
        getLogger().info("Disabled up!");
    }

    private WorldGuardRegions getWGRegions() {
        if (isWorldGuardEnabled()) return new WorldGuardRegions(isWorldGuardEnabled());
        return null;
    }

    private boolean isWorldGuardEnabled() {
        Plugin plugin = this.getServer().getPluginManager().getPlugin("WorldGuard");
        return plugin instanceof WorldGuardPlugin;
    }
}
