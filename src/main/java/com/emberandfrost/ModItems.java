package com.emberandfrost;

import net.minecraft.world.item.Item;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EmberAndFrost.MOD_ID);

    public static final DeferredItem<Item> CINDER_INGOT = ITEMS.registerSimpleItem("cinder_ingot");
    public static final DeferredItem<Item> CINDER_RAW = ITEMS.registerSimpleItem("raw_cinder");

    public static final DeferredItem<Item> CRYOLITE_INGOT = ITEMS.registerSimpleItem("cryolite_ingot");
    public static final DeferredItem<Item> CRYOLITE_RAW = ITEMS.registerSimpleItem("raw_cryolite");

    public static final DeferredItem<Item> ASHEN_INGOT = ITEMS.registerSimpleItem("ashen_ingot");
    public static final DeferredItem<Item> ASHEN_RAW = ITEMS.registerSimpleItem("raw_ashen");

    public static final DeferredItem<Item> MAGMA_INGOT = ITEMS.registerSimpleItem("magma_ingot");
    public static final DeferredItem<Item> MAGMA_RAW = ITEMS.registerSimpleItem("raw_magma");

    public static final DeferredItem<Item> CHAROLITE_SHARD = ITEMS.registerSimpleItem("charolite_shard");

    private ModItems() {}
}
