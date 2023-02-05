package net.simple.armor.stand.pose.listeners;

import java.util.UUID;
import net.simple.armor.stand.pose.utils.ArmorSetPose;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;

import java.util.HashMap;

public class ArmorSpawn implements Listener {
    private final HashMap<UUID, Integer> armorPose;
    private final ArmorSetPose armorSetPose;

    public ArmorSpawn(HashMap<UUID, Integer> armorPose, ArmorSetPose armorSetPose) {
        this.armorPose = armorPose;
        this.armorSetPose = armorSetPose;
    }

    @EventHandler (priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onEntitySpawn(EntitySpawnEvent event) {
        Entity entity = event.getEntity();
        if(entity instanceof ArmorStand) {
            ArmorStand armorStand = (ArmorStand) event.getEntity();
            armorPose.remove(armorStand.getUniqueId());

            armorSetPose.setPose(armorStand, 1);
        }
    }
}
