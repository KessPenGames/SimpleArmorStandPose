package net.simple.armor.stand.pose.utils;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.ArmorStand;
import org.bukkit.util.EulerAngle;

public class ArmorSetPose {
    private final FileConfiguration config;

    public ArmorSetPose(FileConfiguration config) {
        this.config = config;
    }

    public void setPose(ArmorStand armorStand, int pose) {
        armorStand.setArms(true);
        armorStand.setBodyPose(new EulerAngle(Math.toRadians(config.getIntegerList("armor.standPose." + pose +".bodyPose").get(0)),
                Math.toRadians(config.getIntegerList("armor.standPose." + pose +".bodyPose").get(1)),
                Math.toRadians(config.getIntegerList("armor.standPose." + pose +".bodyPose").get(2))));
        armorStand.setHeadPose(new EulerAngle(Math.toRadians(config.getIntegerList("armor.standPose." + pose +".headPose").get(0)),
                Math.toRadians(config.getIntegerList("armor.standPose." + pose +".headPose").get(1)),
                Math.toRadians(config.getIntegerList("armor.standPose." + pose +".headPose").get(2))));
        armorStand.setLeftLegPose(new EulerAngle(Math.toRadians(config.getIntegerList("armor.standPose." + pose +".LeftLegPose").get(0)),
                Math.toRadians(config.getIntegerList("armor.standPose." + pose +".LeftLegPose").get(1)),
                Math.toRadians(config.getIntegerList("armor.standPose." + pose +".LeftLegPose").get(2))));
        armorStand.setRightLegPose(new EulerAngle(Math.toRadians(config.getIntegerList("armor.standPose." + pose +".RightLegPose").get(0)),
                Math.toRadians(config.getIntegerList("armor.standPose." + pose +".RightLegPose").get(1)),
                Math.toRadians(config.getIntegerList("armor.standPose." + pose +".RightLegPose").get(2))));
        armorStand.setLeftArmPose(new EulerAngle(Math.toRadians(config.getIntegerList("armor.standPose." + pose +".LeftArmPose").get(0)),
                Math.toRadians(config.getIntegerList("armor.standPose." + pose +".LeftArmPose").get(1)),
                Math.toRadians(config.getIntegerList("armor.standPose." + pose +".LeftArmPose").get(2))));
        armorStand.setRightArmPose(new EulerAngle(Math.toRadians(config.getIntegerList("armor.standPose." + pose +".RightArmPose").get(0)),
                Math.toRadians(config.getIntegerList("armor.standPose." + pose +".RightArmPose").get(1)),
                Math.toRadians(config.getIntegerList("armor.standPose." + pose +".RightArmPose").get(2))));
    }
}
