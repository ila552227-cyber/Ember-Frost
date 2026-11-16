package com.emberandfrost;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.MapColor;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModBlocks {
    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(EmberAndFrost.MOD_ID);
    public static final DeferredBlock<Block> ASH_BLOCK = BLOCKS.registerSimpleBlock("ash_block", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(0.8F, 2.0F));
    public static final DeferredBlock<Block> CINDER_BLOCK = BLOCKS.registerSimpleBlock("cinder_block", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_GRAY).strength(5.0F, 6.0F));
    public static final DeferredBlock<Block> CHAROLITE_ENCHANTING_TABLE = BLOCKS.registerSimpleBlock("charolite_enchanting_table", BlockBehaviour.Properties.of().mapColor(MapColor.COLOR_PURPLE).strength(5.0F, 1200.0F));
    public static final DeferredBlock<Block> CINDER_ORE = ore("cinder_ore", MapColor.STONE, 3.0F);
    public static final DeferredBlock<Block> CRYOLITE_ORE = ore("cryolite_ore", MapColor.ICE, 4.0F);
    public static final DeferredBlock<Block> ASHEN_ORE = ore("ashen_ore", MapColor.NETHER, 4.0F);
    public static final DeferredBlock<Block> MAGMA_ORE = ore("magma_ore", MapColor.FIRE, 5.0F);
    public static final DeferredBlock<Block> CHAROLITE_ORE = ore("charolite_ore", MapColor.COLOR_PURPLE, 5.0F);

    private static DeferredBlock<Block> ore(String name, MapColor color, float hardness) {
        return BLOCKS.registerSimpleBlock(name, BlockBehaviour.Properties.of()
                .mapColor(color).strength(hardness, hardness).requiresCorrectToolForDrops());
    }
    private ModBlocks() {}
}
