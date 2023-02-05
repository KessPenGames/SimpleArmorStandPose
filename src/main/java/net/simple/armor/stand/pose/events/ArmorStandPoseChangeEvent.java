package net.simple.armor.stand.pose.events;

import net.simple.armor.stand.pose.listeners.ArmorPose;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.event.Cancellable;
import org.bukkit.event.Event;
import org.bukkit.event.HandlerList;

public class ArmorStandPoseChangeEvent extends Event implements Cancellable {

  private static final HandlerList HANDLERS = new HandlerList();

  private boolean cancelled = false;
  private final ArmorStand armorStand;
  private final Player player;
  private final int pose;

  public ArmorStandPoseChangeEvent(ArmorStand armorStand, Player player, int pose) {
    this.armorStand = armorStand;
    this.player = player;
    this.pose = pose;
  }

  public static HandlerList getHandlerList() {
    return HANDLERS;
  }

  public ArmorStand getArmorStand() {
    return armorStand;
  }

  public Player getPlayer() {
    return player;
  }

  public int getPose() {
    return pose;
  }

  @Override
  public HandlerList getHandlers() {
    return HANDLERS;
  }

  @Override
  public boolean isCancelled() {
    return cancelled;
  }

  @Override
  public void setCancelled(boolean cancelled) {
    this.cancelled = cancelled;
  }
}
