package net.simple.armor.stand.pose.utils;

import org.bukkit.entity.ArmorStand;
import org.bukkit.util.EulerAngle;

public class ArmorSetPose {
    private final MainConfig config;

    public ArmorSetPose(MainConfig config) {
        this.config = config;
    }

    public boolean isLastPose(int pose) {
        pose = pose + 1;
        return config.getBodyPose(pose).isEmpty();
    }

    public void setPose(ArmorStand armorStand, int pose) {
        armorStand.setArms(true);
        armorStand.setBodyPose(new EulerAngle(Math.toRadians(config.getBodyPose(pose).get(0)),
                Math.toRadians(config.getBodyPose(pose).get(1)), Math.toRadians(config.getBodyPose(pose).get(2))));
        armorStand.setHeadPose(new EulerAngle(Math.toRadians(config.getHeadPose(pose).get(0)),
                Math.toRadians(config.getHeadPose(pose).get(1)), Math.toRadians(config.getHeadPose(pose).get(2))));
        armorStand.setLeftLegPose(new EulerAngle(Math.toRadians(config.getLeftLegPose(pose).get(0)),
                Math.toRadians(config.getLeftLegPose(pose).get(1)), Math.toRadians(config.getLeftLegPose(pose).get(2))));
        armorStand.setRightLegPose(new EulerAngle(Math.toRadians(config.getRightLegPose(pose).get(0)),
                Math.toRadians(config.getRightLegPose(pose).get(1)), Math.toRadians(config.getRightLegPose(pose).get(2))));
        armorStand.setLeftArmPose(new EulerAngle(Math.toRadians(config.getLeftArmPose(pose).get(0)),
                Math.toRadians(config.getLeftArmPose(pose).get(1)), Math.toRadians(config.getLeftArmPose(pose).get(2))));
        armorStand.setRightArmPose(new EulerAngle(Math.toRadians(config.getRightArmPose(pose).get(0)),
                Math.toRadians(config.getRightArmPose(pose).get(1)), Math.toRadians(config.getRightArmPose(pose).get(2))));
    }
}
