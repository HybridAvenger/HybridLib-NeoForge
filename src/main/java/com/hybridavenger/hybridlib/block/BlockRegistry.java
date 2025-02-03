package com.hybridavenger.hybridlib.block;

import com.hybridavenger.hybridlib.HybridLib;
import com.hybridavenger.hybridlib.item.ItemRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

public class BlockRegistry {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(HybridLib.MOD_ID);


    //Ores



    //Blocks







   public static <T extends Block> void RegisterBlockItem(String name, DeferredBlock<T> block){
       ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
   }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
