package com.hybridavenger.hybridlib.recipe;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.NonNullList;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.Recipe;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.level.Level;

public record FusionChamberRecipe(Ingredient inputItem, ItemStack output) implements Recipe<FusionChamberRecipeInput> {


    @Override
    public NonNullList<Ingredient> getIngredients() {
        NonNullList<Ingredient> list = NonNullList.create();
        list.add(inputItem);
        return list;
    }

    @Override
    public boolean matches(FusionChamberRecipeInput fusionChamberRecipeInput, Level level) {
        if (level.isClientSide()) {
            return false;
        }

        return inputItem.test(fusionChamberRecipeInput.getItem(0));
    }

    @Override
    public ItemStack assemble(FusionChamberRecipeInput fusionChamberRecipeInput, HolderLookup.Provider provider) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(HolderLookup.Provider provider) {
        return output;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipes.FUSION_CHAMBER_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipes.FUSION_CHAMBER_TYPE.get();
    }

    public static class Serializer implements RecipeSerializer<FusionChamberRecipe> {
        public static final MapCodec<FusionChamberRecipe> CODEC = RecordCodecBuilder.mapCodec(inst -> inst.group(
                Ingredient.CODEC_NONEMPTY.fieldOf("ingredient").forGetter(FusionChamberRecipe::inputItem),
                ItemStack.CODEC.fieldOf("result").forGetter(FusionChamberRecipe::output)
        ).apply(inst, FusionChamberRecipe::new));

        public static final StreamCodec<RegistryFriendlyByteBuf, FusionChamberRecipe> STREAM_CODEC =
                StreamCodec.composite(
                        Ingredient.CONTENTS_STREAM_CODEC, FusionChamberRecipe::inputItem,
                        ItemStack.STREAM_CODEC, FusionChamberRecipe::output,
                        FusionChamberRecipe::new);

        @Override
        public MapCodec<FusionChamberRecipe> codec() {
            return CODEC;
        }

        @Override
        public StreamCodec<RegistryFriendlyByteBuf, FusionChamberRecipe> streamCodec() {
            return STREAM_CODEC;
        }
    }
}
