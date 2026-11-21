package com.emberandfrost;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;

public final class ModBiomes {
    public static final ResourceKey<Biome> ASHEN_WASTES =
            ResourceKey.create(Registries.BIOME, Identifier.fromNamespaceAndPath(EmberAndFrost.MOD_ID, "ashen_wastes"));

    private ModBiomes() {}
}
