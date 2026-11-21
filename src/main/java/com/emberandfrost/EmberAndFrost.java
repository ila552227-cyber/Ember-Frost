package com.emberandfrost;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraft.resources.Identifier;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(EmberAndFrost.MOD_ID)
public final class EmberAndFrost {
    public static final String MOD_ID = "emberandfrost";
    public EmberAndFrost(IEventBus modEventBus) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.TABS.register(modEventBus);
        ModFeatures.FEATURES.register(modEventBus);
        modEventBus.addListener(this::commonSetup);
    }

    private void commonSetup(FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new AshenWastesRegion(Identifier.fromNamespaceAndPath(MOD_ID, "ashen_wastes"), 3));
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, MOD_ID, AshenWastesSurfaceRules.makeRules());
        });
    }
}
