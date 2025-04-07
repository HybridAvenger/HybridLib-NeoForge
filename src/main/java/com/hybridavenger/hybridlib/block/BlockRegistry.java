package com.hybridavenger.hybridlib.block;

import com.hybridavenger.hybridlib.HybridLib;
import com.hybridavenger.hybridlib.block.custom.FusionChamberBlock;
import com.hybridavenger.hybridlib.item.ItemRegistry;
import net.minecraft.util.valueproviders.UniformInt;
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

    public static final DeferredBlock<Block> AETHERIUM_ORE = registerBlock("aetherium_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> TECH_ORE = registerBlock("tech_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DEEPSLATE_TECH_ORE = registerBlock("deepslate_tech_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> EUCLASE_ORE = registerBlock("euclase_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> DEEPSLATE_EUCLASE_ORE = registerBlock("deepslate_euclase_ore",
            () -> new DropExperienceBlock(UniformInt.of(2, 4),
                    BlockBehaviour.Properties.of().strength(3f).requiresCorrectToolForDrops().sound(SoundType.STONE)));





    //Blocks
    public static final DeferredBlock<Block> TECH_BLOCK = registerBlock("tech_block",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(4f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    public static final DeferredBlock<Block> COMPRESSED_OBSIDIAN = registerBlock("compressed_obsidian",
            () -> new Block(BlockBehaviour.Properties.of()
                    .strength(5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));

    //Other
    public static final DeferredBlock<FusionChamberBlock> FUSION_CHAMBER = registerBlock("fusion_chamber",
            () -> new FusionChamberBlock(BlockBehaviour.Properties.of()));





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
