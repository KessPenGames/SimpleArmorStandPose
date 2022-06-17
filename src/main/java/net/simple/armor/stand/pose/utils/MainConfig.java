package net.simple.armor.stand.pose.utils;

import org.bukkit.configuration.file.FileConfiguration;

import java.util.List;

public class MainConfig {

    private final FileConfiguration config;

    public MainConfig(FileConfiguration config) {
        this.config = config;
    }

    public boolean getEnableActionBarPose() {
        return config.getBoolean("enable-actionbar-pose");
    }

    public boolean getEnableChangeArmorStandPerm() {
        return config.getBoolean("enable-change-armorstand-perm");
    }

    public boolean getEnableBlacklistWorlds() {
        return config.getBoolean("enable-blacklist-worlds");
    }

    public String getActionBarMessage() {
        return ColorText.getColor(config.getString("messages.action-bar-message"));
    }

    public String getChangePosePerm() {
        return config.getString("messages.change-pose-perm");
    }

    public String getNotHavePerm() {
        return ColorText.getColor(config.getString("messages.not-have-perm"));
    }

    public String getDisableInWorld() {
        return ColorText.getColor(config.getString("messages.disable-in-world"));
    }

    public List<String> getBlacklistWorlds() {
        return config.getStringList("blacklist-worlds");
    }

    public List<Integer> getBodyPose(int pose) {
        return config.getIntegerList("armor.standPose." + pose +".bodyPose");
    }

    public List<Integer> getHeadPose(int pose) {
        return config.getIntegerList("armor.standPose." + pose +".headPose");
    }

    public List<Integer> getLeftLegPose(int pose) {
        return config.getIntegerList("armor.standPose." + pose +".leftLegPose");
    }

    public List<Integer> getRightLegPose(int pose) {
        return config.getIntegerList("armor.standPose." + pose +".rightLegPose");
    }

    public List<Integer> getLeftArmPose(int pose) {
        return config.getIntegerList("armor.standPose." + pose +".leftArmPose");
    }

    public List<Integer> getRightArmPose(int pose) {
        return config.getIntegerList("armor.standPose." + pose +".rightArmPose");
    }
}
