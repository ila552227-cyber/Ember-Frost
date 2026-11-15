package com.emberandfrost;

import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public final class ElementalProjectileItem extends Item {
    private final ElementalProjectile.Effect effect;

    public ElementalProjectileItem(Properties properties, ElementalProjectile.Effect effect) {
        super(properties);
        this.effect = effect;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level level, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);
        if (!level.isClientSide() && level instanceof ServerLevel serverLevel) {
            ElementalProjectile projectile = new ElementalProjectile(serverLevel, player, stack.copyWithCount(1), effect);
            projectile.shootFromRotation(player, player.getXRot(), player.getYRot(), 0.0F, 1.5F, 1.0F);
            serverLevel.addFreshEntity(projectile);
        }
        if (!player.getAbilities().instabuild) stack.shrink(1);
        player.getCooldowns().addCooldown(this, 12);
        return InteractionResultHolder.sidedSuccess(stack, level.isClientSide());
    }
}
