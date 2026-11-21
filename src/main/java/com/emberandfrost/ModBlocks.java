package com.emberandfrost;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.AmethystClusterBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EmberAndFrost.MOD_ID);
    public static final DeferredBlock<Block> CINDER_ORE = ore("cinder_ore", MapColor.STONE, 3.0F);
    public static final DeferredBlock<Block> CINDER_BLOCK = BLOCKS.registerSimpleBlock("cinder_block", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> CRYOLITE_BLOCK = BLOCKS.registerSimpleBlock("cryolite_block", BlockBehaviour.Properties.of().mapColor(MapColor.ICE).strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> ASHEN_BLOCK = BLOCKS.registerSimpleBlock("ashen_block", BlockBehaviour.Properties.of().mapColor(MapColor.NETHER).strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> MAGMA_BLOCK = BLOCKS.registerSimpleBlock("magma_block", BlockBehaviour.Properties.of().mapColor(MapColor.FIRE).strength(5.0F, 6.0F).sound(SoundType.METAL));
    public static final DeferredBlock<Block> CRYOLITE_ORE = ore("cryolite_ore", MapColor.ICE, 4.0F);
    public static final DeferredBlock<Block> ASHEN_ORE = ore("ashen_ore", MapColor.NETHER, 4.0F);
    public static final DeferredBlock<Block> DARK_ASH_BLOCK = BLOCKS.registerSimpleBlock("dark_ash_block", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(1.5F, 3.0F).sound(SoundType.NETHERRACK));
    public static final DeferredBlock<Block> ASH_BLOCK = BLOCKS.registerSimpleBlock("ash_block",
            BlockBehaviour.Properties.of().mapColor(MapColor.STONE).strength(1.2F, 3.0F).sound(SoundType.NETHERRACK));
    public static final DeferredBlock<Block> MAGMA_ORE = ore("magma_ore", MapColor.FIRE, 5.0F);
    public static final DeferredBlock<Block> CHAROLITE_ORE = ore("charolite_ore", MapColor.COLOR_PURPLE, 5.0F);

    // Cryolite geode shell and four naturally growing crystal stages.
    public static final DeferredBlock<Block> CRYOLITE_BUD_SMALL = BLOCKS.registerBlock("cryolite_bud_small",
            properties -> new AmethystClusterBlock(3, 4, properties),
            properties -> properties.mapColor(MapColor.ICE).strength(1.5F, 6.0F)
                    .sound(SoundType.AMETHYST_CLUSTER).noOcclusion().lightLevel(state -> 5));
    public static final DeferredBlock<Block> CRYOLITE_BUD_MEDIUM = BLOCKS.registerBlock("cryolite_bud_medium",
            properties -> new AmethystClusterBlock(4, 3, properties),
            properties -> properties.mapColor(MapColor.ICE).strength(1.5F, 6.0F)
                    .sound(SoundType.AMETHYST_CLUSTER).noOcclusion().lightLevel(state -> 5));
    public static final DeferredBlock<Block> CRYOLITE_BUD_LARGE = BLOCKS.registerBlock("cryolite_bud_large",
            properties -> new AmethystClusterBlock(5, 3, properties),
            properties -> properties.mapColor(MapColor.ICE).strength(1.5F, 6.0F)
                    .sound(SoundType.AMETHYST_CLUSTER).noOcclusion().lightLevel(state -> 5));
    public static final DeferredBlock<Block> CRYOLITE_CLUSTER = BLOCKS.registerBlock("cryolite_cluster",
            properties -> new AmethystClusterBlock(7, 3, properties),
            properties -> properties.mapColor(MapColor.ICE).strength(1.5F, 6.0F)
                    .sound(SoundType.AMETHYST_CLUSTER).noOcclusion().lightLevel(state -> 9));
    public static final DeferredBlock<Block> CRYOLITE_GEODE_BLOCK = BLOCKS.registerSimpleBlock("cryolite_geode_block",
            BlockBehaviour.Properties.of().mapColor(MapColor.ICE).strength(3.0F, 9.0F)
                    .requiresCorrectToolForDrops().sound(SoundType.AMETHYST));

    private static DeferredBlock<Block> ore(String name, MapColor color, float hardness) {
        return BLOCKS.registerSimpleBlock(name, BlockBehaviour.Properties.of()
                .mapColor(color).strength(hardness, hardness).requiresCorrectToolForDrops());
    }
    private ModBlocks() {}
}
