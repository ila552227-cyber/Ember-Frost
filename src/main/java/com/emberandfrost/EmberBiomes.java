package com.emberandfrost;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
public final class EmberBiomes {
 public static final ResourceKey<Biome> ASHEN_WASTES=key("ashen_wastes");
 public static final ResourceKey<Biome> CARBON_ABYSS=key("carbon_abyss");
 public static final ResourceKey<Biome> CRYOLITE_CAVERNS=key("cryolite_caverns");
 public static final ResourceKey<Biome> MAGMA_CRATER=key("magma_crater");
 private static ResourceKey<Biome> key(String n){return ResourceKey.create(Registries.BIOME,Identifier.fromNamespaceAndPath(EmberAndFrost.MOD_ID,n));}
 private EmberBiomes(){}
}
