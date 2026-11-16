package com.emberandfrost;

import net.neoforged.neoforge.event.enchanting.EnchantmentLevelSetEvent;

public final class CharoliteEnchantingEvents {
    private CharoliteEnchantingEvents() {}

    public static void onEnchantmentLevelSet(EnchantmentLevelSetEvent event) {
        if (!event.getLevel().getBlockState(event.getPos()).is(ModBlocks.CHAROLITE_ENCHANTING_TABLE.get())) {
            return;
        }
        // Charolite raises the effective enchanting tier. The vanilla cap remains 30,
        // but low and mid-tier options become noticeably stronger than at a normal table.
        int boosted = Math.min(30, (int) Math.ceil(event.getOriginalLevel() * 1.5D + 5.0D));
        event.setEnchantLevel(boosted);
    }
}
