package com.emberandfrost.block;

import com.emberandfrost.menu.CharoliteEnchantmentMenu;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.SimpleMenuProvider;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CharoliteEnchantingTableBlock extends Block {
    private static final Component TITLE = Component.translatable("container.emberandfrost.charolite_enchanting");

    public CharoliteEnchantingTableBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected InteractionResult useWithoutItem(BlockState state, Level level, BlockPos pos, Player player, BlockHitResult hit) {
        if (level.isClientSide()) return InteractionResult.SUCCESS;
        MenuProvider provider = new SimpleMenuProvider(
                (containerId, inventory, user) -> new CharoliteEnchantmentMenu(containerId, inventory, level, pos),
                TITLE
        );
        player.openMenu(provider);
        return InteractionResult.CONSUME;
    }
}
