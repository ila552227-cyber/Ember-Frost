package com.emberandfrost;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;
import net.neoforged.neoforge.registries.DeferredRegister;

public final class ModFeatures {
    public static final DeferredRegister<Feature<?>> FEATURES =
            DeferredRegister.create(Registries.FEATURE, EmberAndFrost.MOD_ID);

    public static final net.neoforged.neoforge.registries.DeferredHolder<Feature<?>, Feature<NoneFeatureConfiguration>> MAGMA_CRATER =
            FEATURES.register("magma_crater", () -> new MagmaCraterFeature(NoneFeatureConfiguration.CODEC));

    private ModFeatures() {}
}
