package com.hybridavenger.hybridlib.datagen;

import com.hybridavenger.hybridlib.HybridLib;
import com.hybridavenger.hybridlib.block.BlockRegistry;
import com.hybridavenger.hybridlib.item.ItemRegistry;
import com.hybridavenger.hybridlib.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;

import java.util.List;
import java.util.concurrent.CompletableFuture;

public class ModRecipeProvider extends RecipeProvider implements IConditionBuilder {
    public ModRecipeProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> registries) {
        super(output, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput recipeOutput) {
        List<ItemLike> TECH_SMELTABLES = List.of(ItemRegistry.RAW_TECH,
                BlockRegistry.TECH_ORE, BlockRegistry.DEEPSLATE_TECH_ORE);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.TECH_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ItemRegistry.TECH_INGOT.get())
                .unlockedBy("has_tech", has(ItemRegistry.TECH_INGOT)).save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, ItemRegistry.AETHERIUM_GEM.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ItemRegistry.AETHERIUM_GEM_FRAGMENT.get())
                .unlockedBy("has_aetherium", has(ItemRegistry.AETHERIUM_GEM)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.TECH_INGOT.get(), 9)
                .requires(BlockRegistry.TECH_BLOCK)
                .unlockedBy("has_tech_block", has(BlockRegistry.TECH_BLOCK))
                .save(recipeOutput, "hybridlib:tech_ingot_from_block");

        oreSmelting(recipeOutput, TECH_SMELTABLES, RecipeCategory.MISC, ItemRegistry.TECH_INGOT.get(), 0.25f, 200, "bismuth");
        oreBlasting(recipeOutput, TECH_SMELTABLES, RecipeCategory.MISC, ItemRegistry.TECH_INGOT.get(), 0.25f, 100, "bismuth");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BlockRegistry.COMPRESSED_OBSIDIAN.get())
                .requires(Blocks.OBSIDIAN)
                .requires(Blocks.OBSIDIAN)
                .unlockedBy("obsidian", has(BlockRegistry.COMPRESSED_OBSIDIAN))
                .save(recipeOutput);
    }

    protected static void oreSmelting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTIme, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.SMELTING_RECIPE, SmeltingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTIme, pGroup, "_from_smelting");
    }

    protected static void oreBlasting(RecipeOutput recipeOutput, List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult,
                                      float pExperience, int pCookingTime, String pGroup) {
        oreCooking(recipeOutput, RecipeSerializer.BLASTING_RECIPE, BlastingRecipe::new, pIngredients, pCategory, pResult,
                pExperience, pCookingTime, pGroup, "_from_blasting");
    }

    protected static <T extends AbstractCookingRecipe> void oreCooking(RecipeOutput recipeOutput, RecipeSerializer<T> pCookingSerializer, AbstractCookingRecipe.Factory<T> factory,
                                                                       List<ItemLike> pIngredients, RecipeCategory pCategory, ItemLike pResult, float pExperience, int pCookingTime, String pGroup, String pRecipeName) {
        for (ItemLike itemlike : pIngredients) {
            SimpleCookingRecipeBuilder.generic(Ingredient.of(itemlike), pCategory, pResult, pExperience, pCookingTime, pCookingSerializer, factory).group(pGroup).unlockedBy(getHasName(itemlike), has(itemlike))
                    .save(recipeOutput, HybridLib.MOD_ID + ":" + getItemName(pResult) + pRecipeName + "_" + getItemName(itemlike));
        }


    }

}

