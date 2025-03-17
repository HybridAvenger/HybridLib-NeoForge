package com.hybridavenger.hybridlib.tiers;

import com.hybridavenger.hybridlib.item.ItemRegistry;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.SimpleTier;

public class ModdedToolTiers {

    public static final Tier TECH = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL,
            700, 2f, 3f, 15, () -> Ingredient.of(ItemRegistry.TECH_INGOT));
}
