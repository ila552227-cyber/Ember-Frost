package com.emberandfrost;

import java.util.EnumMap;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.equipment.EquipmentAsset;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.util.Util;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(EmberAndFrost.MOD_ID);

    private static TagKey<net.minecraft.world.item.Item> repairTag(String name) {
        return TagKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(EmberAndFrost.MOD_ID, name));
    }

    private static ResourceKey<EquipmentAsset> equipmentAsset(String name) {
        return ResourceKey.create(EquipmentAssets.ROOT_ID, Identifier.fromNamespaceAndPath(EmberAndFrost.MOD_ID, name));
    }

    private static ArmorMaterial armor(String asset, int durability, int helmet, int chest, int legs, int boots, int enchant, float toughness) {
        return new ArmorMaterial(durability, Util.make(new EnumMap<>(ArmorType.class), map -> {
            map.put(ArmorType.HELMET, helmet);
            map.put(ArmorType.CHESTPLATE, chest);
            map.put(ArmorType.LEGGINGS, legs);
            map.put(ArmorType.BOOTS, boots);
            map.put(ArmorType.BODY, chest);
        }), enchant, SoundEvents.ARMOR_EQUIP_IRON, toughness, 0.0F, repairTag("repairs_armor"), equipmentAsset(asset));
    }

    private static final ArmorMaterial CINDER_ARMOR = armor("cinder", 28, 3, 7, 5, 2, 15, 1.0F);
    private static final ArmorMaterial CRYOLITE_ARMOR = armor("cryolite", 34, 3, 8, 6, 3, 18, 2.0F);
    private static final ArmorMaterial ASHEN_ARMOR = armor("ashen", 36, 3, 8, 6, 3, 18, 2.5F);
    private static final ArmorMaterial MAGMA_ARMOR = armor("magma", 40, 3, 9, 6, 3, 20, 3.0F);

    private static ToolMaterial tool(int durability, float speed, float attack, TagKey<net.minecraft.world.level.block.Block> incorrect, String repair) {
        return new ToolMaterial(incorrect, durability, speed, attack, 18, repairTag(repair));
    }

    private static final ToolMaterial CINDER_TOOL = tool(450, 7.0F, 2.5F, BlockTags.INCORRECT_FOR_IRON_TOOL, "repairs_cinder");
    private static final ToolMaterial CRYOLITE_TOOL = tool(900, 9.0F, 3.0F, BlockTags.INCORRECT_FOR_DIAMOND_TOOL, "repairs_cryolite");
    private static final ToolMaterial ASHEN_TOOL = tool(1100, 8.5F, 3.2F, BlockTags.INCORRECT_FOR_DIAMOND_TOOL, "repairs_ashen");
    private static final ToolMaterial MAGMA_TOOL = tool(1600, 10.0F, 4.0F, BlockTags.INCORRECT_FOR_NETHERITE_TOOL, "repairs_magma");

    public static final DeferredItem<Item> CINDER_INGOT = ITEMS.registerSimpleItem("cinder_ingot");
    public static final DeferredItem<Item> CINDER_RAW = ITEMS.registerSimpleItem("raw_cinder");
    public static final DeferredItem<Item> CRYOLITE_INGOT = ITEMS.registerSimpleItem("cryolite_ingot");
    public static final DeferredItem<Item> CRYOLITE_RAW = ITEMS.registerSimpleItem("raw_cryolite");
    public static final DeferredItem<Item> ASHEN_INGOT = ITEMS.registerSimpleItem("ashen_ingot");
    public static final DeferredItem<Item> ASHEN_RAW = ITEMS.registerSimpleItem("raw_ashen");
    public static final DeferredItem<Item> MAGMA_INGOT = ITEMS.registerSimpleItem("magma_ingot");
    public static final DeferredItem<Item> MAGMA_RAW = ITEMS.registerSimpleItem("raw_magma");
    public static final DeferredItem<Item> CHAROLITE_SHARD = ITEMS.registerSimpleItem("charolite_shard");

    static {
        ITEMS.registerSimpleBlockItem("cinder_ore", ModBlocks.CINDER_ORE);
        ITEMS.registerSimpleBlockItem("cryolite_ore", ModBlocks.CRYOLITE_ORE);
        ITEMS.registerSimpleBlockItem("ashen_ore", ModBlocks.ASHEN_ORE);
        ITEMS.registerSimpleBlockItem("magma_ore", ModBlocks.MAGMA_ORE);
        ITEMS.registerSimpleBlockItem("charolite_ore", ModBlocks.CHAROLITE_ORE);
    }

    private static void armorSet(String id, ArmorMaterial material) {
        ITEMS.registerItem(id + "_helmet", p -> new Item(p.humanoidArmor(material, ArmorType.HELMET)));
        ITEMS.registerItem(id + "_chestplate", p -> new Item(p.humanoidArmor(material, ArmorType.CHESTPLATE)));
        ITEMS.registerItem(id + "_leggings", p -> new Item(p.humanoidArmor(material, ArmorType.LEGGINGS)));
        ITEMS.registerItem(id + "_boots", p -> new Item(p.humanoidArmor(material, ArmorType.BOOTS)));
    }

    private static void toolSet(String id, ToolMaterial material) {
        ITEMS.registerItem(id + "_sword", p -> new Item(p.sword(material, 3.0F, -2.4F)));
        ITEMS.registerItem(id + "_pickaxe", p -> new Item(p.pickaxe(material, 1.0F, -2.8F)));
        ITEMS.registerItem(id + "_axe", p -> new Item(p.axe(material, 5.0F, -3.0F)));
        ITEMS.registerItem(id + "_shovel", p -> new Item(p.shovel(material, 1.5F, -3.0F)));
        ITEMS.registerItem(id + "_hoe", p -> new Item(p.hoe(material, 0.0F, -3.0F)));
    }

    static {
        armorSet("cinder", CINDER_ARMOR);
        armorSet("cryolite", CRYOLITE_ARMOR);
        armorSet("ashen", ASHEN_ARMOR);
        armorSet("magma", MAGMA_ARMOR);
        toolSet("cinder", CINDER_TOOL);
        toolSet("cryolite", CRYOLITE_TOOL);
        toolSet("ashen", ASHEN_TOOL);
        toolSet("magma", MAGMA_TOOL);
    }

    private ModItems() {}
}
