package com.emberandfrost;

import net.minecraft.world.level.levelgen.SurfaceRules;

public final class AshenWastesSurfaceRules {
    private static final SurfaceRules.RuleSource ASH = SurfaceRules.state(ModBlocks.ASH_BLOCK.get().defaultBlockState());

    public static SurfaceRules.RuleSource makeRules() {
        return SurfaceRules.ifTrue(SurfaceRules.isBiome(ModBiomes.ASHEN_WASTES),
                SurfaceRules.sequence(
                        SurfaceRules.ifTrue(SurfaceRules.ON_FLOOR, ASH),
                        SurfaceRules.ifTrue(SurfaceRules.UNDER_FLOOR, ASH),
                        SurfaceRules.ifTrue(SurfaceRules.ON_CEILING, ASH),
                        SurfaceRules.ifTrue(SurfaceRules.UNDER_CEILING, ASH)
                ));
    }

    private AshenWastesSurfaceRules() {}
}
