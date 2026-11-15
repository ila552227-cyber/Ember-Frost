package com.emberandfrost;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

/**
 * Main entry point for Ember & Frost.
 */
@Mod(EmberAndFrost.MOD_ID)
public final class EmberAndFrost {
    public static final String MOD_ID = "emberandfrost";

    public EmberAndFrost(IEventBus modEventBus) {
        ModItems.ITEMS.register(modEventBus);
    }
}
