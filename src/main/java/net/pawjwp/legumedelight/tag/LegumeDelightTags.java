package net.pawjwp.legumedelight.tag;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class LegumeDelightTags extends vectorwing.farmersdelight.common.tag.ForgeTags {
    // Block tags
    public static final TagKey<Block> STORAGE_BLOCKS_BLOCK_BEAN = forgeBlockTag("storage_blocks/bean");
    public static final TagKey<Block> STORAGE_BLOCKS_BLOCK_PEANUT = forgeBlockTag("storage_blocks/peanut");



    // Misc
    public static final TagKey<Item> FRUITS = forgeItemTag("fruits");


    // Crops/*
    public static final TagKey<Item> CROPS_BEAN = forgeItemTag("crops/bean");
    public static final TagKey<Item> CROPS_PEANUT = forgeItemTag("crops/peanut");

    // Legumes/*
    public static final TagKey<Item> LEGUMES = forgeItemTag("legumes");
    public static final TagKey<Item> LEGUMES_BEAN = forgeItemTag("legumes/bean");
    public static final TagKey<Item> LEGUMES_PEANUT = forgeItemTag("legumes/peanut");

    // Storage_blocks/*
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_BEAN = forgeItemTag("storage_blocks/bean");
    public static final TagKey<Item> STORAGE_BLOCKS_ITEM_PEANUT = forgeItemTag("storage_blocks/peanut");


    // Bean tags
    public static final TagKey<Item> BEAN = forgeItemTag("bean");
    public static final TagKey<Item> BEANS = forgeItemTag("beans");
    public static final TagKey<Item> BEANS_BEAN = forgeItemTag("beans/bean");

    public static final TagKey<Item> BEAN_PASTE = forgeItemTag("bean_paste");
    public static final TagKey<Item> RED_BEAN_PASTE = forgeItemTag("red_bean_paste");
    public static final TagKey<Item> REFRIED_BEANS = forgeItemTag("refried_beans");


    // Peanut tags
    public static final TagKey<Item> PEANUT = forgeItemTag("peanut");
    public static final TagKey<Item> PEANUTS = forgeItemTag("peanuts");
    public static final TagKey<Item> NUTS = forgeItemTag("nuts");
    public static final TagKey<Item> NUTS_PEANUT = forgeItemTag("nuts/peanut");

    public static final TagKey<Item> NUT_BUTTER = forgeItemTag("nut_butter");
    public static final TagKey<Item> PEANUT_BUTTER = forgeItemTag("peanut_butter");


    // Diet food group tags
    public static final TagKey<Item> DIET_FRUITS = ItemTags.create(ResourceLocation.fromNamespaceAndPath("diet", "fruits"));
    public static final TagKey<Item> DIET_GRAINS = ItemTags.create(ResourceLocation.fromNamespaceAndPath("diet", "grains"));
    public static final TagKey<Item> DIET_PROTEINS = ItemTags.create(ResourceLocation.fromNamespaceAndPath("diet", "proteins"));
    public static final TagKey<Item> DIET_SUGARS = ItemTags.create(ResourceLocation.fromNamespaceAndPath("diet", "sugars"));
    public static final TagKey<Item> DIET_VEGETABLES = ItemTags.create(ResourceLocation.fromNamespaceAndPath("diet", "vegetables"));

    private static TagKey<Block> forgeBlockTag(String path) {
        return BlockTags.create(ResourceLocation.fromNamespaceAndPath("forge", path));
    }

    private static TagKey<Item> forgeItemTag(String path) {
        return ItemTags.create(ResourceLocation.fromNamespaceAndPath("forge", path));
    }
}
