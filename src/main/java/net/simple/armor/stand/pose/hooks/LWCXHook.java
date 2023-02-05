package net.simple.armor.stand.pose.hooks;

import com.griefcraft.bukkit.EntityBlock;
import com.griefcraft.lwc.LWC;
import net.simple.armor.stand.pose.events.ArmorStandPoseChangeEvent;
import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class LWCXHook implements Listener {

  private final LWC lwc;

  public LWCXHook(JavaPlugin plugin) {
    lwc = LWC.getInstance();
    Bukkit.getPluginManager().registerEvents(this, plugin);
  }

  @EventHandler
  public void onSetPose(ArmorStandPoseChangeEvent event) {
    // read current armorstand as LWC entity block
    EntityBlock block = new EntityBlock(event.getArmorStand());
    // check if player is allowed to modify armorstand
    if (!this.lwc.canAccessProtection(event.getPlayer(), lwc.findProtection(block))) {
      // if not, do not modify armorstand
      event.setCancelled(true);
    }
  }
}
