package net.simple.armor.stand.pose;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.util.EulerAngle;

public class ArmorSpawn implements Listener {
    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent evt) {
        Entity ent = evt.getEntity();
        if(ent instanceof ArmorStand) {
            ArmorStand armorstand = (ArmorStand) evt.getEntity();
            if (ArmorPose.pose.get(armorstand.getLocation()) != null) {
                ArmorPose.pose.remove(armorstand.getLocation(), ArmorPose.pose.get(armorstand.getLocation()));
            }
            armorstand.setArms(true);
            armorstand.setBodyPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
            armorstand.setHeadPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
            armorstand.setLeftLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
            armorstand.setRightLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
            armorstand.setLeftArmPose(new EulerAngle(Math.toRadians(339), Math.toRadians(0), Math.toRadians(346)));
            armorstand.setRightArmPose(new EulerAngle(Math.toRadians(339), Math.toRadians(0), Math.toRadians(15)));
        }
    }
}
