package com.hybridavenger.hybridlib.tiers;

import com.hybridavenger.hybridlib.block.BlockRegistry;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.common.SimpleTier;

import java.util.function.Supplier;

public class VanillaToolTier {


    public static final Tier WOOD = new SimpleTier(BlockTags.INCORRECT_FOR_WOODEN_TOOL,
            750, 2.0F, 1.0F, 15, () -> Ingredient.of(ItemTags.PLANKS));

    public static final Tier STONE = new SimpleTier(BlockTags.INCORRECT_FOR_STONE_TOOL,
            1250, 4.0F, 1.0F, 5, () -> Ingredient.of(ItemTags.STONE_TOOL_MATERIALS));

    public static final Tier COPPER = new SimpleTier(BlockTags.INCORRECT_FOR_STONE_TOOL,
            1500, 4.5F, 1.5F, 15, () -> Ingredient.of(ItemTags.STONE_TOOL_MATERIALS));

    public static final Tier IRON = new SimpleTier(BlockTags.INCORRECT_FOR_IRON_TOOL,
            2500, 6.0F, 2.0F, 14, () -> Ingredient.of(Items.IRON_INGOT));

    public static final Tier GOLD = new SimpleTier(BlockTags.INCORRECT_FOR_GOLD_TOOL,
            750, 15.0F, 0.0F, 22, () -> Ingredient.of(Items.GOLD_INGOT));

    public static final Tier DIAMOND = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            5000, 8.0F, 3.0F, 10, () -> Ingredient.of(Items.IRON_INGOT));

    public static final Tier EMERALD = new SimpleTier(BlockTags.INCORRECT_FOR_DIAMOND_TOOL,
            6000, 6.0F, 5.0F, 14, () -> Ingredient.of(Items.EMERALD));

    public static final Tier OBSIDIAN = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            8000, 7.0F, 5.0F, 14, () -> Ingredient.of(BlockRegistry.COMPRESSED_OBSIDIAN));

    public static final Tier NETHERITE = new SimpleTier(BlockTags.INCORRECT_FOR_NETHERITE_TOOL,
            10000, 9.0F, 5.0F, 14, () -> Ingredient.of(Items.EMERALD));






}
