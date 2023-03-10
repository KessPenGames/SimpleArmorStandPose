package net.simple.armor.stand.pose.worldguard;

import com.sk89q.worldedit.bukkit.BukkitAdapter;
import com.sk89q.worldedit.math.BlockVector3;
import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.ApplicableRegionSet;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.managers.RegionManager;
import com.sk89q.worldguard.protection.regions.ProtectedRegion;
import com.sk89q.worldguard.protection.regions.RegionContainer;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class WorldGuardRegions {
    private final boolean wgEnable;

    public WorldGuardRegions(boolean wgEnable) {
        this.wgEnable = wgEnable;
    }

    public boolean isWGRegion(Location loc, Player player) {
        if (!wgEnable) return false;
        RegionContainer container = WorldGuard.getInstance().getPlatform().getRegionContainer();
        RegionManager regionManager = container.get(BukkitAdapter.adapt(loc.getWorld()));
        if (regionManager != null) {
            ApplicableRegionSet applicableRGSet = regionManager.getApplicableRegions(BlockVector3.at(
                    loc.getBlockX(), loc.getBlockY(), loc.getBlockZ()
            ));
            return applicableRGSet.getRegions().stream().anyMatch(rg -> {
                if (rg.getFlag(WorldGuardFlag.DISABLE_INTERACT) == null) return false;
                if (isOwnerOrMemberRG(player, rg)) return false;
                return rg.getFlag(WorldGuardFlag.DISABLE_INTERACT).equals(StateFlag.State.ALLOW);
            });
        }
        return false;
    }

    private boolean isOwnerOrMemberRG(Player player, ProtectedRegion rg) {
        boolean containsMember = rg.getMembers().contains(player.getName()) || rg.getMembers().contains(player.getUniqueId());
        boolean containsOwner = rg.getOwners().contains(player.getName()) || rg.getOwners().contains(player.getUniqueId());
        return containsMember || containsOwner;
    }
}
