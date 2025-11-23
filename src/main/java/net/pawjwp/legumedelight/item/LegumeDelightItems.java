package net.pawjwp.legumedelight.item;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemNameBlockItem;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pawjwp.legumedelight.LegumeDelight;
import net.pawjwp.legumedelight.block.LegumeDelightBlocks;
import vectorwing.farmersdelight.common.FoodValues;
import vectorwing.farmersdelight.common.item.ConsumableItem;

import java.util.LinkedHashSet;
import java.util.function.Supplier;

import static vectorwing.farmersdelight.common.registry.ModItems.*;

public class LegumeDelightItems {
    public static LinkedHashSet<RegistryObject<Item>> CREATIVE_TAB_ITEMS = new LinkedHashSet<>();;

    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, LegumeDelight.MOD_ID);

    public static RegistryObject<Item> registerWithTab(String name, Supplier<Item> supplier) {
        RegistryObject<Item> block = ITEMS.register(name, supplier);
        CREATIVE_TAB_ITEMS.add(block);
        return block;
    }

    // Wild Crops
    public static final RegistryObject<Item> WILD_BEANS = registerWithTab("wild_beans",
            () -> new BlockItem(LegumeDelightBlocks.WILD_BEANS.get(), basicItem()));
    public static final RegistryObject<Item> WILD_PEANUTS = registerWithTab("wild_peanuts",
            () -> new BlockItem(LegumeDelightBlocks.WILD_PEANUTS.get(), basicItem()));

    // Basic Crops
    public static final RegistryObject<Item> BEANS = registerWithTab("beans",
			() -> new ItemNameBlockItem(LegumeDelightBlocks.BUDDING_BEAN_CROP.get(), foodItem(LegumeDelightFoodValues.BEANS)));
    public static final RegistryObject<Item> PEANUTS = registerWithTab("peanuts",
            () -> new ItemNameBlockItem(LegumeDelightBlocks.PEANUT_CROP.get(), foodItem(LegumeDelightFoodValues.PEANUTS)));;

    // Crop Sacks
    public static final RegistryObject<Item> BEAN_SACK = registerWithTab("bean_sack",
            () -> new BlockItem(LegumeDelightBlocks.BEAN_SACK.get(), basicItem()));
    public static final RegistryObject<Item> PEANUT_SACK = registerWithTab("peanut_sack",
            () -> new BlockItem(LegumeDelightBlocks.PEANUT_SACK.get(), basicItem()));

    // Basic Foods
    public static final RegistryObject<Item> BEAN_PASTE = registerWithTab("bean_paste",
            () -> new ConsumableItem(foodItem(LegumeDelightFoodValues.BEAN_PASTE).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
    public static final RegistryObject<Item> BEAN_PATTY = registerWithTab("bean_patty",
            () -> new Item(foodItem(LegumeDelightFoodValues.BEAN_PATTY)));
    public static final RegistryObject<Item> PEANUT_BUTTER = registerWithTab("peanut_butter",
            () -> new ConsumableItem(foodItem(LegumeDelightFoodValues.PEANUT_BUTTER).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16)));
    public static final RegistryObject<Item> REFRIED_BEANS = registerWithTab("refried_beans",
            () -> new ConsumableItem(bowlFoodItem(LegumeDelightFoodValues.REFRIED_BEANS)));
    public static final RegistryObject<Item> ROASTED_PEANUTS = registerWithTab("roasted_peanuts",
            () -> new Item(foodItem(LegumeDelightFoodValues.ROASTED_PEANUTS)));

    // Sweets
    public static final RegistryObject<Item> CANDIED_PEANUTS = registerWithTab("candied_peanuts",
            () -> new Item(foodItem(LegumeDelightFoodValues.CANDIED_PEANUTS)));
    public static final RegistryObject<Item> MOONCAKE = registerWithTab("mooncake",
            () -> new Item(foodItem(FoodValues.PIE_SLICE)));
    public static final RegistryObject<Item> PEANUT_BAR = registerWithTab("peanut_bar",
            () -> new Item(foodItem(LegumeDelightFoodValues.PEANUT_BAR)));
    public static final RegistryObject<Item> PEANUT_BUTTER_COOKIE = registerWithTab("peanut_butter_cookie",
            () -> new Item(foodItem(FoodValues.COOKIES)));
    public static final RegistryObject<Item> PEANUT_BUTTER_CUP = registerWithTab("peanut_butter_cup",
            () -> new Item(foodItem(FoodValues.COOKIES)));
    public static final RegistryObject<Item> RICE_CAKE = registerWithTab("rice_cake",
            () -> new Item(foodItem(FoodValues.PIE_SLICE)));
    public static final RegistryObject<Item> TRAIL_MIX = registerWithTab("trail_mix",
            () -> new Item(foodItem(LegumeDelightFoodValues.TRAIL_MIX)));

    // Handheld Foods
    public static final RegistryObject<Item> BEAN_BURGER = registerWithTab("bean_burger",
            () -> new Item(foodItem(LegumeDelightFoodValues.BEAN_BURGER)));
    public static final RegistryObject<Item> BEAN_BURRITO = registerWithTab("bean_burrito",
            () -> new Item(foodItem(LegumeDelightFoodValues.BEAN_BURRITO)));
    public static final RegistryObject<Item> BEANS_ON_TOAST = registerWithTab("beans_on_toast",
            () -> new Item(foodItem(LegumeDelightFoodValues.BEANS_ON_TOAST)));
    /*public static final RegistryObject<Item> NACHOS = registerWithTab("nachos",
            () -> new Item(foodItem(LegumeDelightFoodValues.NACHOS)));*/
    public static final RegistryObject<Item> PEANUT_BUTTER_AND_JAM_SANDWICH = registerWithTab("peanut_butter_and_jam_sandwich",
            () -> new Item(foodItem(LegumeDelightFoodValues.PEANUT_BUTTER_AND_JAM_SANDWICH)));
    /*public static final RegistryObject<Item> POTATO_TACO = registerWithTab("potato_taco",
            () -> new Item(foodItem(LegumeDelightFoodValues.POTATO_TACO)));*/

    // Bowl Foods
    public static final RegistryObject<Item> BAKED_BEANS = registerWithTab("baked_beans",
            () -> new ConsumableItem(bowlFoodItem(LegumeDelightFoodValues.BAKED_BEANS), true));
    public static final RegistryObject<Item> BEANS_AND_RICE = registerWithTab("beans_and_rice",
            () -> new ConsumableItem(bowlFoodItem(LegumeDelightFoodValues.BEANS_AND_RICE), true));
    public static final RegistryObject<Item> CHILI = registerWithTab("chili",
            () -> new ConsumableItem(bowlFoodItem(LegumeDelightFoodValues.CHILI), true));
    public static final RegistryObject<Item> PAD_THAI = registerWithTab("pad_thai",
            () -> new ConsumableItem(bowlFoodItem(LegumeDelightFoodValues.PAD_THAI), true));

    // Plated Foods
    public static final RegistryObject<Item> PASTA_WITH_TOMATO_SAUCE = registerWithTab("pasta_with_tomato_sauce",
            () -> new ConsumableItem(bowlFoodItem(LegumeDelightFoodValues.PASTA_WITH_TOMATO_SAUCE), true));


    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
