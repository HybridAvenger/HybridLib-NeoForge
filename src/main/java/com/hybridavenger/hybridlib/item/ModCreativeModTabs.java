package com.hybridavenger.hybridlib.item;

import com.hybridavenger.hybridlib.HybridLib;
import com.hybridavenger.hybridlib.block.BlockRegistry;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModTabs {

    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, HybridLib.MOD_ID);

    public static final Supplier<CreativeModeTab> HYBRID_TAB = CREATIVE_MODE_TAB.register("hybrid_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ItemRegistry.NETHER_INGOT.get()))
                    .title(Component.translatable("creativetab.hybridlib.hybridtab"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ItemRegistry.RAW_TECH);
                        output.accept(ItemRegistry.NETHER_INGOT);
                        output.accept(ItemRegistry.EUCLASE_GEM);
                        output.accept(ItemRegistry.TECH_INGOT);
                        output.accept(ItemRegistry.DOUBLE_NETHERITE_INGOT);
                        output.accept(ItemRegistry.AETHERIUM_GEM);
                        output.accept(ItemRegistry.AETHERIUM_GEM_FRAGMENT);

                        output.accept(BlockRegistry.AETHERIUM_ORE);
                        output.accept(BlockRegistry.TECH_ORE);
                        output.accept(BlockRegistry.TECH_BLOCK);
                        output.accept(BlockRegistry.EUCLASE_BLOCK);
                        output.accept(BlockRegistry.EUCLASE_ORE);
                        output.accept(BlockRegistry.DEEPSLATE_EUCLASE_ORE);
                        output.accept(BlockRegistry.DEEPSLATE_TECH_ORE);
                        output.accept(BlockRegistry.COMPRESSED_OBSIDIAN);
                        output.accept(BlockRegistry.FUSION_CHAMBER);



                    }).build());

    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }

}
