package com.hybridavenger.hybridlib.datagen;

import com.hybridavenger.hybridlib.HybridLib;
import com.hybridavenger.hybridlib.block.BlockRegistry;
import net.minecraft.data.PackOutput;
import net.neoforged.neoforge.client.model.generators.BlockStateProvider;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredBlock;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, HybridLib.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        blockWithItem(BlockRegistry.TECH_BLOCK);
        blockWithItem(BlockRegistry.EUCLASE_ORE);
        blockWithItem(BlockRegistry.AETHERIUM_ORE);
        blockWithItem(BlockRegistry.TECH_ORE);
        blockWithItem(BlockRegistry.DEEPSLATE_EUCLASE_ORE);
        blockWithItem(BlockRegistry.DEEPSLATE_TECH_ORE);

    }

    private void blockWithItem(DeferredBlock<?> deferredBlock){
        simpleBlockWithItem(deferredBlock.get(), cubeAll(deferredBlock.get()));
    }
}
