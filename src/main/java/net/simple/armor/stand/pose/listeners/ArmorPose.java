package net.simple.armor.stand.pose.listeners;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.simple.armor.stand.pose.utils.ArmorSetPose;
import net.simple.armor.stand.pose.utils.MainConfig;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.HashMap;

public class ArmorPose implements Listener {
    private final HashMap<Location, Integer> armorPose;
    private final ArmorSetPose armorSetPose;
    private final MainConfig config;

    public ArmorPose(HashMap<Location, Integer> armorPose, ArmorSetPose armorSetPose, MainConfig config) {
        this.armorPose = armorPose;
        this.armorSetPose = armorSetPose;
        this.config = config;
    }

    @EventHandler
    public void onClick(PlayerInteractAtEntityEvent event) {
        Entity entity = event.getRightClicked();
        if (entity instanceof ArmorStand) {
            Player player = event.getPlayer();

            if (config.getEnableChangeArmorStandPerm()) {
                if (!player.hasPermission(config.getChangePosePerm())) {
                    event.setCancelled(true);
                    player.sendMessage(config.getNotHavePerm());
                    return;
                }
            }

            if (config.getEnableBlacklistWorlds()) {
                if (config.getBlacklistWorlds().contains(player.getWorld().getName())) {
                    event.setCancelled(true);
                    player.sendMessage(config.getDisableInWorld());
                    return;
                }
            }

            if (!player.isSneaking()) return;
            event.setCancelled(true);

            ArmorStand armorStand = (ArmorStand) event.getRightClicked();
            if (armorPose.containsKey(armorStand.getLocation())) {
                int pose = armorPose.get(armorStand.getLocation());
                armorPose.remove(armorStand.getLocation());

                if (armorSetPose.isLastPose(pose)) {
                    armorPose.put(armorStand.getLocation(), 1);
                } else {
                    armorPose.put(armorStand.getLocation(), pose + 1);
                }
                armorSetPose.setPose(armorStand, pose);

                if (config.getEnableActionBarPose()) player.spigot()
                        .sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(config.getActionBarMessage() + pose));
            } else {
                armorPose.put(armorStand.getLocation(), 2);
                armorSetPose.setPose(armorStand, 1);

                if (config.getEnableActionBarPose()) player.spigot()
                        .sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(config.getActionBarMessage() + 1));
            }
        }
    }
}
