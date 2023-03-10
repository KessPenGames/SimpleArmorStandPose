package net.simple.armor.stand.pose.worldguard;

import com.sk89q.worldguard.WorldGuard;
import com.sk89q.worldguard.protection.flags.Flag;
import com.sk89q.worldguard.protection.flags.StateFlag;
import com.sk89q.worldguard.protection.flags.registry.FlagConflictException;
import com.sk89q.worldguard.protection.flags.registry.FlagRegistry;
import net.simple.armor.stand.pose.config.MainConfig;

public class WorldGuardFlag {
    public static StateFlag DISABLE_INTERACT;
    private final MainConfig config;

    public WorldGuardFlag(MainConfig config) {
        this.config = config;
    }

    public void registerFlag() {
        FlagRegistry registry = WorldGuard.getInstance().getFlagRegistry();
        try {
            StateFlag disableInteract = new StateFlag(config.worldGuard.getArmorStandInteractDisableFlagId(), true);
            registry.register(disableInteract);
            DISABLE_INTERACT = disableInteract;
        } catch (FlagConflictException e) {
            Flag<?> existingDisableInteract = registry.get(config.worldGuard.getArmorStandInteractDisableFlagId());
            if (existingDisableInteract instanceof  StateFlag) {
                DISABLE_INTERACT = (StateFlag) existingDisableInteract;
            }
        }
    }
}
