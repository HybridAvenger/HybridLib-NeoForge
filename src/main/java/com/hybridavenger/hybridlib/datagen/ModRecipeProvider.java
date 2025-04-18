package com.hybridavenger.hybridlib.datagen;

import com.hybridavenger.hybridlib.HybridLib;
import com.hybridavenger.hybridlib.block.BlockRegistry;
import com.hybridavenger.hybridlib.item.ItemRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.ItemLike;
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

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.EUCLASE_BLOCK.get())
                .pattern("BBB")
                .pattern("BBB")
                .pattern("BBB")
                .define('B', ItemRegistry.EUCLASE_GEM.get())
                .unlockedBy("has_euclase", has(ItemRegistry.EUCLASE_GEM)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.TECH_INGOT.get(), 9)
                .requires(BlockRegistry.TECH_BLOCK)
                .unlockedBy("has_tech_block", has(BlockRegistry.TECH_BLOCK))
                .save(recipeOutput, "hybridlib:tech_ingot_from_block");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.EUCLASE_GEM.get(), 9)
                .requires(BlockRegistry.EUCLASE_BLOCK)
                .unlockedBy("has_euclase_block", has(BlockRegistry.EUCLASE_BLOCK))
                .save(recipeOutput, "hybridlib:euclase_gem_from_block");

        oreSmelting(recipeOutput, TECH_SMELTABLES, RecipeCategory.MISC, ItemRegistry.TECH_INGOT.get(), 0.25f, 200, "tech");
        oreBlasting(recipeOutput, TECH_SMELTABLES, RecipeCategory.MISC, ItemRegistry.TECH_INGOT.get(), 0.25f, 100, "tech");

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, BlockRegistry.COMPRESSED_OBSIDIAN.get())
                .requires(Blocks.OBSIDIAN)
                .requires(Blocks.OBSIDIAN)
                .unlockedBy("obsidian", has(BlockRegistry.COMPRESSED_OBSIDIAN))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, BlockRegistry.FUSION_CHAMBER.get())
                .pattern("NAN")
                .pattern("AFA")
                .pattern("NAN")
                .define('N', ItemRegistry.NETHER_INGOT.get())
                .define('A', ItemRegistry.AETHERIUM_GEM.get())
                .define('F', Blocks.BLAST_FURNACE)
                .unlockedBy("has_nether", has(ItemRegistry.NETHER_INGOT)).save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.NETHER_INGOT.get())
                .requires(Items.NETHER_STAR)
                .requires(ItemRegistry.DOUBLE_NETHERITE_INGOT)
                .unlockedBy("netherite", has(ItemRegistry.DOUBLE_NETHERITE_INGOT.get()))
                .save(recipeOutput);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.MISC, ItemRegistry.DOUBLE_NETHERITE_INGOT.get())
                .requires(Items.NETHERITE_INGOT, 2)
                .unlockedBy("netherite", has(Items.NETHERITE_INGOT))
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

