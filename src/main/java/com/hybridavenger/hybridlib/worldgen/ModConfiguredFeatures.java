package com.hybridavenger.hybridlib.worldgen;

import com.hybridavenger.hybridlib.HybridLib;
import com.hybridavenger.hybridlib.block.BlockRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_TECH_ORE_KEY = registerKey("tech_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OVERWORLD_EUCLASE_ORE_KEY = registerKey("euclase_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> END_AETHERIUM_ORE_KEY = registerKey("aetherium_ore");


    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        List<OreConfiguration.TargetBlockState> overworldTechOres = List.of(
                OreConfiguration.target(stoneReplaceables, BlockRegistry.TECH_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlockRegistry.DEEPSLATE_TECH_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> overworldEuclaseOres = List.of(
                OreConfiguration.target(stoneReplaceables, BlockRegistry.EUCLASE_ORE.get().defaultBlockState()),
                OreConfiguration.target(deepslateReplaceables, BlockRegistry.DEEPSLATE_EUCLASE_ORE.get().defaultBlockState()));

        List<OreConfiguration.TargetBlockState> endAetheriumOre = List.of(
                OreConfiguration.target(endReplaceables, BlockRegistry.AETHERIUM_ORE.get().defaultBlockState()));

        register(context, OVERWORLD_TECH_ORE_KEY, Feature.ORE, new OreConfiguration(overworldTechOres, 5));
        register(context, OVERWORLD_EUCLASE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldEuclaseOres, 3));
        register(context, END_AETHERIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables,
                BlockRegistry.AETHERIUM_ORE.get().defaultBlockState(), 4));
    }

    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(HybridLib.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
