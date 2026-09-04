package net.pawjwp.legumedelight.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class LegumeDelightTags extends vectorwing.farmersdelight.common.tag.CommonTags {

    private static TagKey<Block> commonBlockTag(String path) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }

    private static TagKey<Item> commonItemTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("c", path));
    }

    // Block tags

    public static class Blocks {
        public static final TagKey<Block> STORAGE_BLOCKS_BLOCK_BEAN = commonBlockTag("storage_blocks/bean");
        public static final TagKey<Block> STORAGE_BLOCKS_BLOCK_PEANUT = commonBlockTag("storage_blocks/peanut");
    }



    public static class Items {
        // Misc
        public static final TagKey<Item> FRUITS = commonItemTag("fruits");


        // Crops/*
        public static final TagKey<Item> CROPS_BEAN = commonItemTag("crops/bean");
        public static final TagKey<Item> CROPS_PEANUT = commonItemTag("crops/peanut");

        // Legumes/*
        public static final TagKey<Item> LEGUMES = commonItemTag("legumes");
        public static final TagKey<Item> LEGUMES_BEAN = commonItemTag("legumes/bean");
        public static final TagKey<Item> LEGUMES_PEANUT = commonItemTag("legumes/peanut");

        // Storage_blocks/*
        public static final TagKey<Item> STORAGE_BLOCKS_ITEM_BEAN = commonItemTag("storage_blocks/bean");
        public static final TagKey<Item> STORAGE_BLOCKS_ITEM_PEANUT = commonItemTag("storage_blocks/peanut");


        // Bean tags
        public static final TagKey<Item> BEAN = commonItemTag("bean");
        public static final TagKey<Item> BEANS = commonItemTag("beans");
        public static final TagKey<Item> BEANS_BEAN = commonItemTag("beans/bean");

        public static final TagKey<Item> BEAN_PASTE = commonItemTag("bean_paste");
        public static final TagKey<Item> RED_BEAN_PASTE = commonItemTag("red_bean_paste");
        public static final TagKey<Item> REFRIED_BEANS = commonItemTag("refried_beans");


        // Peanut tags
        public static final TagKey<Item> PEANUT = commonItemTag("peanut");
        public static final TagKey<Item> PEANUTS = commonItemTag("peanuts");
        public static final TagKey<Item> NUTS = commonItemTag("nuts");
        public static final TagKey<Item> NUTS_PEANUT = commonItemTag("nuts/peanut");

        public static final TagKey<Item> NUT_BUTTER = commonItemTag("nut_butter");
        public static final TagKey<Item> PEANUT_BUTTER = commonItemTag("peanut_butter");


        // Diet food group tags
        public static final TagKey<Item> DIET_FRUITS = ItemTags.create(ResourceLocation.fromNamespaceAndPath("diet", "fruits"));
        public static final TagKey<Item> DIET_GRAINS = ItemTags.create(ResourceLocation.fromNamespaceAndPath("diet", "grains"));
        public static final TagKey<Item> DIET_PROTEINS = ItemTags.create(ResourceLocation.fromNamespaceAndPath("diet", "proteins"));
        public static final TagKey<Item> DIET_SUGARS = ItemTags.create(ResourceLocation.fromNamespaceAndPath("diet", "sugars"));
        public static final TagKey<Item> DIET_VEGETABLES = ItemTags.create(ResourceLocation.fromNamespaceAndPath("diet", "vegetables"));
    }
}
