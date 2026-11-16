package com.emberandfrost;
import com.mojang.datafixers.util.Pair;
import net.minecraft.core.Registry;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Climate;
import terrablender.api.Region;
import terrablender.api.RegionType;
import java.util.function.Consumer;
public final class EmberOverworldRegion extends Region {
 public EmberOverworldRegion(){super(Identifier.fromNamespaceAndPath(EmberAndFrost.MOD_ID,"overworld"),RegionType.OVERWORLD,5);}
 @Override public void addBiomes(Registry<Biome> registry,Consumer<Pair<Climate.ParameterPoint,ResourceKey<Biome>>> mapper){
  this.addBiome(mapper,Climate.Parameter.span(-0.85F,-0.35F),Climate.Parameter.span(-0.2F,0.8F),Climate.Parameter.span(0.03F,0.55F),Climate.Parameter.span(-0.8F,0.8F),Climate.Parameter.span(-1.0F,1.0F),Climate.Parameter.point(0.0F),0.0F,EmberBiomes.CRYOLITE_CAVERNS);
  this.addBiome(mapper,Climate.Parameter.span(0.55F,1.0F),Climate.Parameter.span(-1.0F,-0.25F),Climate.Parameter.span(0.03F,0.55F),Climate.Parameter.span(-0.8F,0.8F),Climate.Parameter.span(-1.0F,1.0F),Climate.Parameter.point(0.0F),0.0F,EmberBiomes.MAGMA_CRATER);
 }
}
