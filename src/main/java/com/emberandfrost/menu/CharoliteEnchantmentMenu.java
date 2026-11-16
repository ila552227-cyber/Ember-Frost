package com.emberandfrost.menu;

import com.emberandfrost.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerLevelAccess;
import net.minecraft.world.inventory.EnchantmentMenu;
import net.minecraft.world.level.Level;

public class CharoliteEnchantmentMenu extends EnchantmentMenu {
    private final Level level;
    private final BlockPos pos;

    public CharoliteEnchantmentMenu(int containerId, Inventory inventory, Level level, BlockPos pos) {
        super(containerId, inventory, ContainerLevelAccess.create(level, pos));
        this.level = level;
        this.pos = pos.immutable();
    }

    @Override
    public boolean stillValid(Player player) {
        return level.getBlockState(pos).is(ModBlocks.CHAROLITE_ENCHANTING_TABLE.get())
                && player.distanceToSqr(pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5) <= 64.0;
    }
}
