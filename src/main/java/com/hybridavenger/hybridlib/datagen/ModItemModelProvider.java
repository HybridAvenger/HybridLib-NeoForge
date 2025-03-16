package com.hybridavenger.hybridlib.datagen;

import com.hybridavenger.hybridlib.HybridLib;
import com.hybridavenger.hybridlib.item.ItemRegistry;
import net.minecraft.data.PackOutput;

import net.neoforged.neoforge.client.model.generators.ItemModelProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;

public class ModItemModelProvider extends ItemModelProvider {
    public ModItemModelProvider(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, HybridLib.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        basicItem(ItemRegistry.EUCLASE_GEM.get());
        basicItem(ItemRegistry.RAW_TECH.get());
        basicItem(ItemRegistry.AETHERIUM_GEM_FRAGMENT.get());
        basicItem(ItemRegistry.DOUBLE_NETHERITE_INGOT.get());
        basicItem(ItemRegistry.AETHERIUM_GEM.get());
        basicItem(ItemRegistry.NETHER_INGOT.get());
        basicItem(ItemRegistry.TECH_INGOT.get());
    }
}
