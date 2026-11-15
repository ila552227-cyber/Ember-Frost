package com.emberandfrost;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.Snowball;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.level.Level;

public final class ElementalProjectile extends Snowball {
    public enum Effect { FIRE, SLOW, KNOCKBACK, POISON }

    private final Effect effect;

    public ElementalProjectile(ServerLevel level, LivingEntity owner, ItemStack stack, Effect effect) {
        super(EntityType.SNOWBALL, level);
        setOwner(owner);
        setItem(stack);
        this.effect = effect;
    }

    @Override
    protected void onHitEntity(EntityHitResult hit) {
        super.onHitEntity(hit);
        if (!(hit.getEntity() instanceof LivingEntity target) || level().isClientSide()) return;
        switch (effect) {
            case FIRE -> target.igniteForSeconds(5.0F);
            case SLOW -> target.addEffect(new MobEffectInstance(MobEffects.SLOWNESS, 100, 1));
            case KNOCKBACK -> {
                var direction = target.position().subtract(position()).normalize();
                target.push(direction.x * 1.8D, 0.45D, direction.z * 1.8D);
                target.hurtMarked = true;
            }
            case POISON -> target.addEffect(new MobEffectInstance(MobEffects.POISON, 100, 0));
        }
    }

    @Override
    public void tick() {
        super.tick();
        if (level() instanceof ServerLevel server && tickCount % 2 == 0) {
            server.sendParticles(ParticleTypes.FLAME, getX(), getY(), getZ(), 1, 0.02, 0.02, 0.02, 0.0);
        }
    }
}
