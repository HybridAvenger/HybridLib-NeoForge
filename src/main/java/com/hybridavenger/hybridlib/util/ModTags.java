package com.hybridavenger.hybridlib.util;

import com.hybridavenger.hybridlib.HybridLib;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {

        public static final TagKey<Block> NEEDS_TECH_TOOL = createTag("needs_tech_tool");
        public static final TagKey<Block> INCORRECT_FOR_TECH_TOOL = createTag("incorrect_for_tech_tool");


        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(HybridLib.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> TRANSFORMABLE_ITEMS = createTag("transformable_items");

        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(HybridLib.MOD_ID, name));
        }
    }
}
