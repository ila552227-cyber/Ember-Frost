package com.emberandfrost;

import net.minecraft.core.Direction;
import net.minecraft.core.Position;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SnowballItem;
import net.minecraft.world.level.Level;

public final class ElementalProjectileItem extends SnowballItem {
    private final ElementalProjectile.Effect effect;

    public ElementalProjectileItem(Properties properties, ElementalProjectile.Effect effect) {
        super(properties);
        this.effect = effect;
    }

    @Override
    public Projectile asProjectile(Level level, Position position, ItemStack stack, Direction direction) {
        return new ElementalProjectile(level, position.x(), position.y(), position.z(), stack, effect);
    }
}
