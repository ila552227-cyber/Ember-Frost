package com.emberandfrost;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.common.NeoForge;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import terrablender.api.Regions;
import terrablender.api.SurfaceRuleManager;

@Mod(EmberAndFrost.MOD_ID)
public final class EmberAndFrost {
    public static final String MOD_ID = "emberandfrost";
    public EmberAndFrost(IEventBus modEventBus) {
        ModBlocks.BLOCKS.register(modEventBus);
        ModItems.ITEMS.register(modEventBus);
        ModCreativeTabs.TABS.register(modEventBus);
        NeoForge.EVENT_BUS.addListener(CharoliteEnchantingEvents::onEnchantmentLevelSet);
        modEventBus.addListener(this::commonSetup);
    }
    private void commonSetup(final FMLCommonSetupEvent event) {
        event.enqueueWork(() -> {
            Regions.register(new EmberOverworldRegion());
            Regions.register(new EmberNetherRegion());
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.OVERWORLD, MOD_ID, EmberSurfaceRules.overworld());
            SurfaceRuleManager.addSurfaceRules(SurfaceRuleManager.RuleCategory.NETHER, MOD_ID, EmberSurfaceRules.nether());
        });
    }
}
