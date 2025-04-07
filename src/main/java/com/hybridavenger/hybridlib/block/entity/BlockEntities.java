package com.hybridavenger.hybridlib.block.entity;

import com.hybridavenger.hybridlib.HybridLib;
import com.hybridavenger.hybridlib.block.BlockRegistry;
import com.hybridavenger.hybridlib.screen.custom.FusionChamberMenu;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class BlockEntities  {
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES =
            DeferredRegister.create(BuiltInRegistries.BLOCK_ENTITY_TYPE, HybridLib.MOD_ID);

    public static final Supplier<BlockEntityType<FusionChamberBlockEntity>> FUSION_CHAMBER_BE =
            BLOCK_ENTITIES.register("fusion_chamber_be", () -> BlockEntityType.Builder.of(
                    FusionChamberBlockEntity::new, BlockRegistry.FUSION_CHAMBER.get()).build(null));

    public static void register(IEventBus eventBus) {
        BLOCK_ENTITIES.register(eventBus);
    }
}