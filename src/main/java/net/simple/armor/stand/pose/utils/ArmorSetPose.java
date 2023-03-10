package net.simple.armor.stand.pose.utils;

import net.simple.armor.stand.pose.config.MainConfig;
import org.bukkit.entity.ArmorStand;
import org.bukkit.util.EulerAngle;

public class ArmorSetPose {
    private final MainConfig config;

    public ArmorSetPose(MainConfig config) {
        this.config = config;
    }

    public boolean isLastPose(int pose) {
        pose = pose + 1;
        return config.armorPose.getBodyPose(pose).isEmpty();
    }

    public void setPose(ArmorStand armorStand, int pose) {
        armorStand.setArms(true);
        armorStand.setBodyPose(new EulerAngle(
                Math.toRadians(config.armorPose.getBodyPose(pose).get(0)),
                Math.toRadians(config.armorPose.getBodyPose(pose).get(1)),
                Math.toRadians(config.armorPose.getBodyPose(pose).get(2))
        ));
        armorStand.setHeadPose(new EulerAngle(
                Math.toRadians(config.armorPose.getHeadPose(pose).get(0)),
                Math.toRadians(config.armorPose.getHeadPose(pose).get(1)),
                Math.toRadians(config.armorPose.getHeadPose(pose).get(2))
        ));
        armorStand.setLeftLegPose(new EulerAngle(
                Math.toRadians(config.armorPose.getLeftLegPose(pose).get(0)),
                Math.toRadians(config.armorPose.getLeftLegPose(pose).get(1)),
                Math.toRadians(config.armorPose.getLeftLegPose(pose).get(2))
        ));
        armorStand.setRightLegPose(new EulerAngle(
                Math.toRadians(config.armorPose.getRightLegPose(pose).get(0)),
                Math.toRadians(config.armorPose.getRightLegPose(pose).get(1)),
                Math.toRadians(config.armorPose.getRightLegPose(pose).get(2))
        ));
        armorStand.setLeftArmPose(new EulerAngle(
                Math.toRadians(config.armorPose.getLeftArmPose(pose).get(0)),
                Math.toRadians(config.armorPose.getLeftArmPose(pose).get(1)),
                Math.toRadians(config.armorPose.getLeftArmPose(pose).get(2))
        ));
        armorStand.setRightArmPose(new EulerAngle(
                Math.toRadians(config.armorPose.getRightArmPose(pose).get(0)),
                Math.toRadians(config.armorPose.getRightArmPose(pose).get(1)),
                Math.toRadians(config.armorPose.getRightArmPose(pose).get(2))
        ));
    }
}
