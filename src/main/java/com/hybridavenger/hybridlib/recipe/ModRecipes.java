package com.hybridavenger.hybridlib.recipe;

import com.hybridavenger.hybridlib.HybridLib;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModRecipes {
    public static final DeferredRegister<RecipeSerializer<?>> SERIALIZERS =
            DeferredRegister.create(Registries.RECIPE_SERIALIZER, HybridLib.MOD_ID);
    public static final DeferredRegister<RecipeType<?>> TYPES =
            DeferredRegister.create(Registries.RECIPE_TYPE, HybridLib.MOD_ID);

    public static final DeferredHolder<RecipeSerializer<?>, FusionChamberRecipe.Serializer> FUSION_CHAMBER_SERIALIZER =
            SERIALIZERS.register("fusion_chamber", FusionChamberRecipe.Serializer::new);
    public static final DeferredHolder<RecipeType<?>, RecipeType<FusionChamberRecipe>> FUSION_CHAMBER_TYPE =
            TYPES.register("fusion_chamber", () -> new RecipeType<FusionChamberRecipe>() {
                @Override
                public String toString() {
                    return "fusion_chamber";
                }
            });


    public static void register(IEventBus eventBus) {
        SERIALIZERS.register(eventBus);
        TYPES.register(eventBus);
    }
}