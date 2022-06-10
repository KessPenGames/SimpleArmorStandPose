package net.simple.armor.stand.pose.listeners;

import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import net.simple.armor.stand.pose.utils.ArmorSetPose;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractAtEntityEvent;

import java.util.HashMap;

public class ArmorPose implements Listener {
    private final HashMap<Location, Integer> armorPose;
    private final ArmorSetPose armorSetPose;

    public ArmorPose(HashMap<Location, Integer> armorPose, ArmorSetPose armorSetPose) {
        this.armorPose = armorPose;
        this.armorSetPose = armorSetPose;
    }

    @EventHandler
    public void onClick(PlayerInteractAtEntityEvent event) {
        Entity entity = event.getRightClicked();
        if (entity instanceof ArmorStand) {
            if (!event.getPlayer().isSneaking()) return;
            event.setCancelled(true);
            ArmorStand armorStand = (ArmorStand) event.getRightClicked();
            if (armorPose.containsKey(armorStand.getLocation())) {
                int pose = armorPose.get(armorStand.getLocation());
                armorPose.remove(armorStand.getLocation());
                if (pose == 13) {
                    armorPose.put(armorStand.getLocation(), 1);
                } else {
                    armorPose.put(armorStand.getLocation(), pose + 1);
                }
                armorSetPose.setPose(armorStand, pose);

                event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD + "Pose: " + pose));
            } else {
                armorPose.put(armorStand.getLocation(), 2);
                armorSetPose.setPose(armorStand, 1);

                event.getPlayer().spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GOLD + "Pose: 1"));
            }
        }
    }
}
