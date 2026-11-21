package com.emberandfrost;

import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

public final class MagmaCraterFeature extends Feature<NoneFeatureConfiguration> {
    private static final BlockState AIR = Blocks.AIR.defaultBlockState();
    private static final BlockState BASALT = Blocks.BASALT.defaultBlockState();
    private static final BlockState BLACKSTONE = Blocks.BLACKSTONE.defaultBlockState();
    private static final BlockState MAGMA = Blocks.MAGMA_BLOCK.defaultBlockState();
    private static final BlockState LAVA = Blocks.LAVA.defaultBlockState();

    public MagmaCraterFeature(Codec<NoneFeatureConfiguration> codec) {
        super(codec);
    }

    @Override
    public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> context) {
        WorldGenLevel level = context.level();
        RandomSource random = context.random();
        BlockPos origin = context.origin();
        int centerX = origin.getX();
        int centerZ = origin.getZ();
        int radius = 16 + random.nextInt(10);
        int seaLevel = level.getSeaLevel();
        int centerSurface = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, centerX, centerZ);

        if (centerSurface <= seaLevel + 5 || centerSurface > 150) return false;

        boolean changed = false;
        BlockPos.MutableBlockPos pos = new BlockPos.MutableBlockPos();
        BlockState magmaOre = ModBlocks.MAGMA_ORE.get().defaultBlockState();

        for (int dx = -radius - 3; dx <= radius + 3; dx++) {
            for (int dz = -radius - 3; dz <= radius + 3; dz++) {
                double distance = Math.sqrt(dx * dx + dz * dz);
                if (distance > radius + 3.0) continue;

                int x = centerX + dx;
                int z = centerZ + dz;
                int surfaceY = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, x, z);
                if (surfaceY <= seaLevel + 3 || Math.abs(surfaceY - centerSurface) > 7) continue;

                if (distance <= radius) {
                    double bowl = 1.0 - distance / radius;
                    int depth = 2 + (int) Math.round(bowl * 5.0);
                    int floorY = surfaceY - depth;

                    for (int y = floorY + 1; y <= surfaceY + 1; y++) {
                        pos.set(x, y, z);
                        BlockState old = level.getBlockState(pos);
                        if (old.isAir() || old.liquid()) continue;
                        level.setBlock(pos, AIR, 2);
                        changed = true;
                    }

                    pos.set(x, floorY, z);
                    if (distance < 5.0) {
                        level.setBlock(pos, LAVA, 2);
                    } else if (random.nextFloat() < 0.38F) {
                        level.setBlock(pos, magmaOre, 2);
                    } else {
                        level.setBlock(pos, MAGMA, 2);
                    }
                    changed = true;

                    if (distance > radius - 3.0 && random.nextFloat() < 0.35F) {
                        pos.set(x, floorY + 1, z);
                        level.setBlock(pos, magmaOre, 2);
                    }
                } else {
                    int rimHeight = 1 + random.nextInt(3);
                    for (int y = surfaceY; y < surfaceY + rimHeight; y++) {
                        pos.set(x, y, z);
                        level.setBlock(pos, random.nextFloat() < 0.65F ? BASALT : BLACKSTONE, 2);
                    }
                    changed = true;
                }
            }
        }

        for (int i = 0; i < 12; i++) {
            int dx = random.nextInt(radius * 2 + 1) - radius;
            int dz = random.nextInt(radius * 2 + 1) - radius;
            if (dx * dx + dz * dz > radius * radius) continue;
            int x = centerX + dx;
            int z = centerZ + dz;
            int y = level.getHeight(Heightmap.Types.WORLD_SURFACE_WG, x, z);
            pos.set(x, y - 1, z);
            if (level.getBlockState(pos).is(Blocks.MAGMA_BLOCK)) {
                level.setBlock(pos, magmaOre, 2);
            }
        }
        return changed;
    }
}
