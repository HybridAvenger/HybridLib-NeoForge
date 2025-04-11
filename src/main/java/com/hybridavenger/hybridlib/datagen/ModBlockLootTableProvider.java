package com.hybridavenger.hybridlib.datagen;

import com.hybridavenger.hybridlib.block.BlockRegistry;
import com.hybridavenger.hybridlib.item.ItemRegistry;
import net.minecraft.core.Holder;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;

import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;


import java.util.Iterator;
import java.util.Set;

public class ModBlockLootTableProvider extends BlockLootSubProvider {
    protected ModBlockLootTableProvider(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        dropSelf(BlockRegistry.TECH_BLOCK.get());
        dropSelf(BlockRegistry.COMPRESSED_OBSIDIAN.get());
        dropSelf(BlockRegistry.FUSION_CHAMBER.get());
        dropSelf(BlockRegistry.EUCLASE_BLOCK.get());


        add(BlockRegistry.AETHERIUM_ORE.get(),
                block -> createMultipleOreDrops(BlockRegistry.AETHERIUM_ORE.get(), ItemRegistry.AETHERIUM_GEM_FRAGMENT.get(), 1, 2));

        add(BlockRegistry.TECH_ORE.get(),
                block -> createMultipleOreDrops(BlockRegistry.TECH_ORE.get(), ItemRegistry.RAW_TECH.get(), 2, 5));

        add(BlockRegistry.DEEPSLATE_TECH_ORE.get(),
                block -> createMultipleOreDrops(BlockRegistry.DEEPSLATE_TECH_ORE.get(), ItemRegistry.RAW_TECH.get(), 2, 5));

        add(BlockRegistry.EUCLASE_ORE.get(),
                block -> createMultipleOreDrops(BlockRegistry.EUCLASE_ORE.get(), ItemRegistry.EUCLASE_GEM.get(), 1, 3));

        add(BlockRegistry.DEEPSLATE_EUCLASE_ORE.get(),
                block -> createMultipleOreDrops(BlockRegistry.DEEPSLATE_EUCLASE_ORE.get(), ItemRegistry.EUCLASE_GEM.get(), 1, 3));


    }

    protected LootTable.Builder createMultipleOreDrops(Block pBlock, Item item, float minDrops, float maxDrops) {
        HolderLookup.RegistryLookup<Enchantment> registrylookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);
        return this.createSilkTouchDispatchTable(pBlock,
                this.applyExplosionDecay(pBlock, LootItem.lootTableItem(item)
                        .apply(SetItemCountFunction.setCount(UniformGenerator.between(minDrops, maxDrops)))
                        .apply(ApplyBonusCount.addOreBonusCount(registrylookup.getOrThrow(Enchantments.FORTUNE)))));
    }

  @Override
    protected Iterable<Block> getKnownBlocks(){
        return BlockRegistry.BLOCKS.getEntries().stream().map(Holder::value)::iterator;
  }

}
