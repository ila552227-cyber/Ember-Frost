package com.emberandfrost;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.SurfaceRules;

public final class EmberSurfaceRules {
    private static SurfaceRules.RuleSource state(net.minecraft.world.level.block.Block block) {
        return SurfaceRules.state(block.defaultBlockState());
    }

    public static SurfaceRules.RuleSource overworld() {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(EmberBiomes.CRYOLITE_CAVERNS),
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, state(Blocks.PACKED_ICE))),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(EmberBiomes.MAGMA_CRATER),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, state(Blocks.BASALT)),
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, state(Blocks.BASALT)))));
    }

    public static SurfaceRules.RuleSource nether() {
        return SurfaceRules.sequence(
                SurfaceRules.ifTrue(SurfaceRules.isBiome(EmberBiomes.ASHEN_WASTES),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, state(ModBlocks.ASH_BLOCK.get())),
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, state(ModBlocks.ASH_BLOCK.get())))),
                SurfaceRules.ifTrue(SurfaceRules.isBiome(EmberBiomes.CARBON_ABYSS),
                        SurfaceRules.sequence(
                                SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, state(Blocks.BLACKSTONE)),
                                SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, state(Blocks.BLACKSTONE)))));
    }

    private EmberSurfaceRules() {}
}
