package com.emberandfrost;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;
import java.util.function.Consumer;
public final class EmberNetherRegion extends Region {
 public EmberNetherRegion(){super(Identifier.fromNamespaceAndPath(EmberAndFrost.MOD_ID,"nether"),RegionType.NETHER,5);}
 @Override public void addBiomes(Registry<Biome> registry,Consumer<Pair<Climate.ParameterPoint,ResourceKey<Biome>>> mapper){
  this.addBiome(mapper,Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),0.0F,EmberBiomes.ASHEN_WASTES);
  this.addBiome(mapper,Climate.Parameter.point(0.0F),Climate.Parameter.point(-0.5F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),0.0F,EmberBiomes.CARBON_ABYSS);
  this.addBiome(mapper,Climate.Parameter.point(0.4F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),0.0F,Biomes.CRIMSON_FOREST);
  this.addBiome(mapper,Climate.Parameter.point(0.0F),Climate.Parameter.point(0.5F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),0.375F,Biomes.WARPED_FOREST);
  this.addBiome(mapper,Climate.Parameter.point(-0.5F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),Climate.Parameter.point(0.0F),0.175F,Biomes.BASALT_DELTAS);
 }
}
