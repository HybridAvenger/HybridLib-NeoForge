package com.hybridavenger.hybridlib.datagen;

import com.hybridavenger.hybridlib.HybridLib;
import com.hybridavenger.hybridlib.block.BlockRegistry;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.neoforged.neoforge.common.data.BlockTagsProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagProvider extends BlockTagsProvider {
    public ModBlockTagProvider(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, HybridLib.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        tag(BlockTags.MINEABLE_WITH_PICKAXE)
                .add(BlockRegistry.AETHERIUM_ORE.get())
                .add(BlockRegistry.EUCLASE_ORE.get())
                .add(BlockRegistry.TECH_BLOCK.get())
                .add(BlockRegistry.TECH_ORE.get())
                .add(BlockRegistry.DEEPSLATE_EUCLASE_ORE.get())
                .add(BlockRegistry.DEEPSLATE_TECH_ORE.get());


    }
}
