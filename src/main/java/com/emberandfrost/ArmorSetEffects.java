package com.emberandfrost;

import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.tick.PlayerTickEvent;

@EventBusSubscriber(modid = EmberAndFrost.MOD_ID)
public final class ArmorSetEffects {
    private ArmorSetEffects() {}

    @SubscribeEvent
    public static void onPlayerTick(PlayerTickEvent.Post event) {
        Player player = event.getEntity();
        if (player.level().isClientSide() || player.tickCount % 20 != 0) return;

        if (wearingFullSet(player, "cinder")) {
            apply(player, MobEffects.FIRE_RESISTANCE, 0);
            apply(player, MobEffects.SLOWNESS, 0);
        } else if (wearingFullSet(player, "cryolite")) {
            apply(player, MobEffects.SPEED, 0);
            apply(player, MobEffects.WEAKNESS, 0);
        } else if (wearingFullSet(player, "ashen")) {
            apply(player, MobEffects.STRENGTH, 0);
            apply(player, MobEffects.HUNGER, 0);
        } else if (wearingFullSet(player, "magma")) {
            apply(player, MobEffects.FIRE_RESISTANCE, 0);
            apply(player, MobEffects.DAMAGE_BOOST, 0);
            apply(player, MobEffects.MINING_FATIGUE, 0);
        }
    }

    private static void apply(Player player, net.minecraft.core.Holder<net.minecraft.world.effect.MobEffect> effect, int amplifier) {
        player.addEffect(new MobEffectInstance(effect, 45, amplifier, true, false, true));
    }

    private static boolean wearingFullSet(Player player, String material) {
        return isPiece(player.getItemBySlot(EquipmentSlot.HEAD), material, "helmet")
                && isPiece(player.getItemBySlot(EquipmentSlot.CHEST), material, "chestplate")
                && isPiece(player.getItemBySlot(EquipmentSlot.LEGS), material, "leggings")
                && isPiece(player.getItemBySlot(EquipmentSlot.FEET), material, "boots");
    }

    private static boolean isPiece(ItemStack stack, String material, String piece) {
        return BuiltInRegistries.ITEM.getKey(stack.getItem()).getPath().equals(material + "_" + piece);
    }
}
