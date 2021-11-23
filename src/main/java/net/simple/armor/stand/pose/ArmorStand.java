package net.simple.armor.stand.pose;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntitySpawnEvent;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;
import org.bukkit.event.player.PlayerInteractEntityEvent;
import org.bukkit.util.EulerAngle;

import java.util.HashMap;
import java.util.List;

public class ArmorStand implements Listener {
    private Main plugin;
    public ArmorStand(Main plugin) {
        this.plugin = plugin;
    }
    public HashMap<Location, Integer> pose = new HashMap<Location, Integer>();

    @EventHandler
    public void click(PlayerInteractAtEntityEvent event) {
        Entity entity = event.getRightClicked();
        if (entity instanceof org.bukkit.entity.ArmorStand) {
            if (!event.getPlayer().isSneaking()) return;
            event.setCancelled(true);
            org.bukkit.entity.ArmorStand armorstand = (org.bukkit.entity.ArmorStand) event.getRightClicked();
            if (pose.containsKey(armorstand.getLocation())) {
                Integer position_pose = pose.get(armorstand.getLocation());
                switch (position_pose) {
                    case 1:
                        pose.put(armorstand.getLocation(), 2);
                        armorstand.setArms(true);
                        armorstand.setBodyPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setHeadPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setLeftLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setRightLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setLeftArmPose(new EulerAngle(Math.toRadians(339), Math.toRadians(0), Math.toRadians(346)));
                        armorstand.setRightArmPose(new EulerAngle(Math.toRadians(339), Math.toRadians(0), Math.toRadians(15)));
                        break;
                    case 2:
                        pose.put(armorstand.getLocation(), 3);
                        armorstand.setArms(true);
                        armorstand.setBodyPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setHeadPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setLeftLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setRightLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setLeftArmPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setRightArmPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        break;
                    case 3:
                        pose.put(armorstand.getLocation(), 4);
                        armorstand.setArms(true);
                        armorstand.setBodyPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setHeadPose(new EulerAngle(Math.toRadians(14), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setLeftLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setRightLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setLeftArmPose(new EulerAngle(Math.toRadians(312), Math.toRadians(0), Math.toRadians(39)));
                        armorstand.setRightArmPose(new EulerAngle(Math.toRadians(312), Math.toRadians(0), Math.toRadians(323)));
                        break;
                    case 4:
                        pose.put(armorstand.getLocation(), 5);
                        armorstand.setArms(true);
                        armorstand.setBodyPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setHeadPose(new EulerAngle(Math.toRadians(356), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setLeftLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setRightLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setLeftArmPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(343)));
                        armorstand.setRightArmPose(new EulerAngle(Math.toRadians(282), Math.toRadians(0), Math.toRadians(0)));
                        break;
                    case 5:
                        pose.put(armorstand.getLocation(), 6);
                        armorstand.setArms(true);
                        armorstand.setBodyPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setHeadPose(new EulerAngle(Math.toRadians(346), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setLeftLegPose(new EulerAngle(Math.toRadians(11), Math.toRadians(0), Math.toRadians(353)));
                        armorstand.setRightLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(8)));
                        armorstand.setLeftArmPose(new EulerAngle(Math.toRadians(31), Math.toRadians(0), Math.toRadians(353)));
                        armorstand.setRightArmPose(new EulerAngle(Math.toRadians(248), Math.toRadians(37), Math.toRadians(0)));
                        break;
                    case 6:
                        pose.put(armorstand.getLocation(), 7);
                        armorstand.setArms(true);
                        armorstand.setBodyPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setHeadPose(new EulerAngle(Math.toRadians(346), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setLeftLegPose(new EulerAngle(Math.toRadians(11), Math.toRadians(0), Math.toRadians(353)));
                        armorstand.setRightLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(8)));
                        armorstand.setLeftArmPose(new EulerAngle(Math.toRadians(254), Math.toRadians(37), Math.toRadians(0)));
                        armorstand.setRightArmPose(new EulerAngle(Math.toRadians(254), Math.toRadians(324), Math.toRadians(0)));
                        break;
                    case 7:
                        pose.put(armorstand.getLocation(), 8);
                        armorstand.setArms(true);
                        armorstand.setBodyPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setHeadPose(new EulerAngle(Math.toRadians(346), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setLeftLegPose(new EulerAngle(Math.toRadians(11), Math.toRadians(0), Math.toRadians(353)));
                        armorstand.setRightLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(8)));
                        armorstand.setLeftArmPose(new EulerAngle(Math.toRadians(254), Math.toRadians(341), Math.toRadians(0)));
                        armorstand.setRightArmPose(new EulerAngle(Math.toRadians(241), Math.toRadians(40), Math.toRadians(0)));
                        break;
                    case 8:
                        pose.put(armorstand.getLocation(), 9);
                        armorstand.setArms(true);
                        armorstand.setBodyPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setHeadPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setLeftLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setRightLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setLeftArmPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(346)));
                        armorstand.setRightArmPose(new EulerAngle(Math.toRadians(309), Math.toRadians(338), Math.toRadians(15)));
                        break;
                    case 9:
                        pose.put(armorstand.getLocation(), 10);
                        armorstand.setArms(true);
                        armorstand.setBodyPose(new EulerAngle(Math.toRadians(0), Math.toRadians(6), Math.toRadians(0)));
                        armorstand.setHeadPose(new EulerAngle(Math.toRadians(356), Math.toRadians(47), Math.toRadians(0)));
                        armorstand.setLeftLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(40), Math.toRadians(350)));
                        armorstand.setRightLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(304), Math.toRadians(0)));
                        armorstand.setLeftArmPose(new EulerAngle(Math.toRadians(18), Math.toRadians(0), Math.toRadians(353)));
                        armorstand.setRightArmPose(new EulerAngle(Math.toRadians(248), Math.toRadians(47), Math.toRadians(0)));
                        break;
                    case 10:
                        pose.put(armorstand.getLocation(), 11);
                        armorstand.setArms(true);
                        armorstand.setBodyPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setHeadPose(new EulerAngle(Math.toRadians(14), Math.toRadians(23), Math.toRadians(0)));
                        armorstand.setLeftLegPose(new EulerAngle(Math.toRadians(18), Math.toRadians(141), Math.toRadians(350)));
                        armorstand.setRightLegPose(new EulerAngle(Math.toRadians(349), Math.toRadians(108), Math.toRadians(0)));
                        armorstand.setLeftArmPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(225)));
                        armorstand.setRightArmPose(new EulerAngle(Math.toRadians(265), Math.toRadians(334), Math.toRadians(0)));
                        break;
                    case 11:
                        pose.put(armorstand.getLocation(), 12);
                        armorstand.setArms(true);
                        armorstand.setBodyPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setHeadPose(new EulerAngle(Math.toRadians(346), Math.toRadians(348), Math.toRadians(0)));
                        armorstand.setLeftLegPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(353)));
                        armorstand.setRightLegPose(new EulerAngle(Math.toRadians(315), Math.toRadians(0), Math.toRadians(0)));
                        armorstand.setLeftArmPose(new EulerAngle(Math.toRadians(268), Math.toRadians(13), Math.toRadians(0)));
                        armorstand.setRightArmPose(new EulerAngle(Math.toRadians(268), Math.toRadians(348), Math.toRadians(0)));
                        break;
                    case 12:
                        pose.put(armorstand.getLocation(), 13);
                        armorstand.setArms(true);
                        armorstand.setBodyPose(new EulerAngle(Math.toRadians(0), Math.toRadians(355), Math.toRadians(0)));
                        armorstand.setHeadPose(new EulerAngle(Math.toRadians(356), Math.toRadians(30), Math.toRadians(0)));
                        armorstand.setLeftLegPose(new EulerAngle(Math.toRadians(238), Math.toRadians(0), Math.toRadians(306)));
                        armorstand.setRightLegPose(new EulerAngle(Math.toRadians(349), Math.toRadians(33), Math.toRadians(343)));
                        armorstand.setLeftArmPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(242)));
                        armorstand.setRightArmPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(120)));
                        break;
                    case 13:
                        pose.put(armorstand.getLocation(), 1);
                        armorstand.setArms(true);
                        armorstand.setBodyPose(new EulerAngle(Math.toRadians(0), Math.toRadians(351), Math.toRadians(0)));
                        armorstand.setHeadPose(new EulerAngle(Math.toRadians(356), Math.toRadians(324), Math.toRadians(0)));
                        armorstand.setLeftLegPose(new EulerAngle(Math.toRadians(346), Math.toRadians(0), Math.toRadians(12)));
                        armorstand.setRightLegPose(new EulerAngle(Math.toRadians(248), Math.toRadians(324), Math.toRadians(0)));
                        armorstand.setLeftArmPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(242)));
                        armorstand.setRightArmPose(new EulerAngle(Math.toRadians(0), Math.toRadians(0), Math.toRadians(120)));
                        break;
                    default:
                        break;
                }
            } else {
                pose.put(armorstand.getLocation(), 2);
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

    @EventHandler
    public void onEntitySpawn(EntitySpawnEvent evt) {
        Entity ent = evt.getEntity();
        if(ent instanceof org.bukkit.entity.ArmorStand) {
            org.bukkit.entity.ArmorStand armorstand = (org.bukkit.entity.ArmorStand) evt.getEntity();
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
