package com.hybridavenger.hybridlib.block;

import com.hybridavenger.hybridlib.HybridLib;
import com.hybridavenger.hybridlib.item.ItemRegistry;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.DropExperienceBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockRegistry {

    public static final DeferredRegister.Blocks BLOCKS = DeferredRegister.createBlocks(HybridLib.MOD_ID);


    //Ores



    //Blocks
    public static final DeferredBlock<Block> TECH_BLOCK = registerBlock("tech_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));





   private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block){
       DeferredBlock<T> toReturn = BLOCKS.register(name, block);
       registerBlockItem(name, toReturn);
       return toReturn;
   }

   public static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block){
       ItemRegistry.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties()));
   }

    public static void register(IEventBus eventBus){
        BLOCKS.register(eventBus);
    }
}
