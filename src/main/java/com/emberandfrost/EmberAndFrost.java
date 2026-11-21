package com.emberandfrost;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;

@Mod(EmberAndFrost.MOD_ID)
public final class EmberAndFrost {
    public static final String MOD_ID = "emberandfrost";
    public EmberAndFrost(IEventBus modEventBus) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.TABS.register(modEventBus);
        ModFeatures.FEATURES.register(modEventBus);
    }
}
