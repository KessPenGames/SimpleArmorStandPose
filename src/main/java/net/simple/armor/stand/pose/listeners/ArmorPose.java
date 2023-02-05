package net.simple.armor.stand.pose.listeners;

import java.util.UUID;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.simple.armor.stand.pose.events.ArmorStandPoseChangeEvent;
import net.simple.armor.stand.pose.utils.ArmorSetPose;
import net.simple.armor.stand.pose.utils.MainConfig;
import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.HashMap;

public class ArmorPose implements Listener {
    /**
     * A map of entity UUIDs and their pose index. UUID instead of location so that moving
     * armorstands are still contained in the mapping.
     */
    private final HashMap<UUID, Integer> armorPose;
    private final ArmorSetPose armorSetPose;
    private final MainConfig config;

    public ArmorPose(HashMap<UUID, Integer> armorPose, ArmorSetPose armorSetPose, MainConfig config) {
        this.armorPose = armorPose;
        this.armorSetPose = armorSetPose;
        this.config = config;
    }

    @EventHandler (priority = EventPriority.HIGHEST, ignoreCancelled = true)
    public void onClick(PlayerInteractAtEntityEvent event) {
        Entity entity = event.getRightClicked();
        if (!(entity instanceof ArmorStand)) return;

        Player player = event.getPlayer();
        if (!player.isSneaking()) return;

        ArmorStand armorStand = (ArmorStand) event.getRightClicked();

        // inform everybody that this plugin is about to change the pose
        ArmorStandPoseChangeEvent poseEvent = new ArmorStandPoseChangeEvent(armorStand, player, -1);
        Bukkit.getPluginManager().callEvent(poseEvent);

        // if any plugin does not want this to happen (like lwcx due to protections) return
        if (poseEvent.isCancelled()) {
            return;
        }

        // all preconditions for cancelling met, cancel actual event
        event.setCancelled(true);

        if (config.getEnableChangeArmorStandPerm()) {
            if (!player.hasPermission(config.getChangePosePerm())) {
                player.sendMessage(config.getNotHavePerm());
                return;
            }
        }

        if (config.getEnableBlacklistWorlds()) {
            if (config.getBlacklistWorlds().contains(player.getWorld().getName())) {
                player.sendMessage(config.getDisableInWorld());
                return;
            }
        }

        int pose = armorPose.compute(armorStand.getUniqueId(), (uuid, index) -> {
            // not yet contained in mapping
            if (index == null) {
                return 2;
            }
            // last pose, go back to pose 1
            if (armorSetPose.isLastPose(index)) {
                return 1;
            }
            // simply increase
            return index + 1;
        });

        armorSetPose.setPose(armorStand, pose);

        if (config.getEnableActionBarPose()) player.spigot()
            .sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(config.getActionBarMessage() + pose));
    }
}
