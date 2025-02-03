package com.hybridavenger.hybridlib.item;

import com.hybridavenger.hybridlib.HybridLib;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ItemRegistry {

    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(HybridLib.MOD_ID);

    //Ingots and Gems
    public static final DeferredItem<Item> TECH_INGOT = ITEMS.register("tech_ingot",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> EUCLASE_GEM = ITEMS.register("euclase_gem",
            () -> new Item(new Item.Properties()));

    public static final DeferredItem<Item> NETHER_INGOT = ITEMS.register("nether_ingot",
            () -> new Item(new Item.Properties()));


    //Raw
    public static final DeferredItem<Item> RAW_TECH = ITEMS.register("raw_tech",
            () -> new Item(new Item.Properties()));



    //Block2Item





    public static void register(IEventBus eventBus){
        ITEMS.register(eventBus);
    }

}
