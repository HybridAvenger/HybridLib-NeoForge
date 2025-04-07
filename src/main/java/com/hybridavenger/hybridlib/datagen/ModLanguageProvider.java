package com.hybridavenger.hybridlib.datagen;

import com.hybridavenger.hybridlib.HybridLib;
import com.hybridavenger.hybridlib.block.BlockRegistry;
import com.hybridavenger.hybridlib.item.ItemRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.common.data.LanguageProvider;

public class ModLanguageProvider extends LanguageProvider
{
    public ModLanguageProvider(PackOutput output, String modid, String locale) {
        super(output, modid, locale);

    }




    @Override
    protected void addTranslations() {
        //Items
        add(ItemRegistry.AETHERIUM_GEM.get(), "Aetherium Gem");
        add(ItemRegistry.RAW_TECH.get(), "Raw Tech");
        add(ItemRegistry.TECH_INGOT.get(), "Tech Ingot");
        add(ItemRegistry.EUCLASE_GEM.get(), "Euclase Gem");
        add(ItemRegistry.AETHERIUM_GEM_FRAGMENT.get(), "Fragment of Aetherium Gem");
        add(ItemRegistry.DOUBLE_NETHERITE_INGOT.get(), "Double Netherite Ingot");
        add(ItemRegistry.NETHER_INGOT.get(), "Nether Ingot");

        //Blocks
        add(BlockRegistry.AETHERIUM_ORE.get(), "Aetherium Ore");
        add(BlockRegistry.TECH_BLOCK.get(), "Block of Tech");
        add(BlockRegistry.COMPRESSED_OBSIDIAN.get(), "Compressed Obsidian");
        add(BlockRegistry.DEEPSLATE_TECH_ORE.get(), "Deepslate Tech Ore");
        add(BlockRegistry.DEEPSLATE_EUCLASE_ORE.get(), "Deepslate Euclase Ore");
        add(BlockRegistry.TECH_ORE.get(), "Tech Ore");
        add(BlockRegistry.EUCLASE_ORE.get(), "Euclase Ore");
        add(BlockRegistry.FUSION_CHAMBER.get(), "Fusion Chamber");

        add("creativetab.hybridlib.hybridtab", "Hybrid Library Mod");
    }
}
