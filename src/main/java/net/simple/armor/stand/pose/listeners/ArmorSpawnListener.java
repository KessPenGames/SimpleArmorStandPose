package net.simple.armor.stand.pose.listeners;

import net.simple.armor.stand.pose.utils.ArmorSetPose;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.HashMap;

public class ArmorSpawnListener implements Listener {
    private final HashMap<Location, Integer> armorPose;
    private final ArmorSetPose armorSetPose;

    public ArmorSpawnListener(HashMap<Location, Integer> armorPose, ArmorSetPose armorSetPose) {
        this.armorPose = armorPose;
        this.armorSetPose = armorSetPose;
    }

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent event) {
        Entity entity = event.getEntity();
        if(entity instanceof ArmorStand) {
            ArmorStand armorStand = (ArmorStand) event.getEntity();
            armorPose.remove(armorStand.getLocation());

            armorSetPose.setPose(armorStand, 1);
        }
    }
}
