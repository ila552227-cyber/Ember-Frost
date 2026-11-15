package com.emberandfrost;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModCreativeTabs {
    public static final DeferredRegister<CreativeModeTab> TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, EmberAndFrost.MOD_ID);

    public static final DeferredHolder<CreativeModeTab, CreativeModeTab> EMBER_AND_FROST =
            TABS.register("emberandfrost", () -> CreativeModeTab.builder()
                    .title(Component.translatable("itemGroup.emberandfrost"))
                    .icon(() -> new ItemStack(ModItems.CINDER_INGOT.get()))
                    .displayItems((parameters, output) ->
                            ModItems.ITEMS.getEntries().forEach(item -> output.accept(item.get())))
                    .build());

    private ModCreativeTabs() {}
}
