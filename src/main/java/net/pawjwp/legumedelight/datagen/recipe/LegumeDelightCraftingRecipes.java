package net.pawjwp.legumedelight.datagen.recipe;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.crafting.ConditionalRecipe;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.common.crafting.conditions.NotCondition;
import net.minecraftforge.registries.ForgeRegistries;
import net.pawjwp.legumedelight.LegumeDelight;
import net.pawjwp.legumedelight.item.LegumeDelightItems;
import net.pawjwp.legumedelight.tag.LegumeDelightTags;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class LegumeDelightCraftingRecipes {
    public static void register(Consumer<FinishedRecipe> consumer) {
        // Sacks
                ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, LegumeDelightItems.BEAN_SACK.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', LegumeDelightItems.BEANS.get())
                .unlockedBy("has_beans", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.BEANS.get()))
                .save(consumer);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, LegumeDelightItems.PEANUT_SACK.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', LegumeDelightItems.PEANUTS.get())
                .unlockedBy("has_peanuts", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.PEANUTS.get()))
                .save(consumer);



        // Meals
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.BEAN_BURGER.get())
                .requires(ForgeTags.BREAD)
                .requires(LegumeDelightItems.BEAN_PATTY.get())
                .requires(ForgeTags.SALAD_INGREDIENTS)
                .requires(ForgeTags.CROPS_TOMATO)
                .requires(ForgeTags.CROPS_ONION)
                .unlockedBy("has_bean_patty", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.BEAN_PATTY.get()))
                .save(consumer);

        ConditionalRecipe.builder()
                .addCondition(new NotCondition(new ModLoadedCondition("culturaldelights")))
                .addRecipe(c -> ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.BEAN_BURRITO.get())
                        .requires(Items.BREAD)
                        .requires(LegumeDelightItems.REFRIED_BEANS.get(), 2)
                        .requires(ModItems.COOKED_RICE.get())
                        .requires(ForgeTags.CROPS_ONION)
                        .requires(ForgeTags.CROPS_TOMATO)
                        .unlockedBy("has_beans", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.BEANS.get()))
                        .save(c))
                .addCondition(new ModLoadedCondition("culturaldelights"))
                .addRecipe(c -> ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.BEAN_BURRITO.get())
                        .requires(Ingredient.of(ForgeRegistries.ITEMS.getValue(ResourceLocation.parse("culturaldelights:tortilla"))))
                        .requires(LegumeDelightItems.REFRIED_BEANS.get(), 2)
                        .requires(ModItems.COOKED_RICE.get())
                        .requires(ForgeTags.CROPS_ONION)
                        .requires(ForgeTags.CROPS_TOMATO)
                        .unlockedBy("has_beans", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.BEANS.get()))
                        .save(c))
                .build(consumer, (ResourceLocation.fromNamespaceAndPath(LegumeDelight.MOD_ID, "bean_burrito")));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.BEANS_ON_TOAST.get(), 4)
                .requires(ForgeTags.BREAD)
                .requires(LegumeDelightItems.BAKED_BEANS.get())
                .unlockedBy("has_baked_beans", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.BAKED_BEANS.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.MOONCAKE.get(), 4)
                .requires(LegumeDelightTags.BEAN_PASTE)
                .requires(LegumeDelightTags.BEAN_PASTE)
                .requires(ForgeTags.EGGS)
                .requires(ModItems.PIE_CRUST.get())
                .unlockedBy("has_bean_paste", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.BEAN_PASTE.get()))
                .save(consumer);

        /*ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition("culturaldelights"))
                .addRecipe(c -> ShapelessRecipeBuilder
                        .shapeless(RecipeCategory.FOOD, LegumeDelightItems.NACHOS.get(), 2)
                        .requires(Ingredient.of(ForgeRegistries.ITEMS.getValue(ResourceLocation.parse("culturaldelights:tortilla_chips"))), 2)
                        .requires(ModItems.TOMATO_SAUCE.get())
                        .requires(LegumeDelightTags.REFRIED_BEANS)
                        .unlockedBy("has_tortilla_chips", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.REFRIED_BEANS.get()))
                        .save(c))
                .build(consumer, (ResourceLocation.fromNamespaceAndPath(LegumeDelight.MOD_ID, "nachos")));*/

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.PEANUT_BAR.get(), 2)
                .requires(Ingredient.fromValues(Stream.of(
                        new Ingredient.ItemValue(new ItemStack(LegumeDelightItems.PEANUTS.get())),
                        new Ingredient.ItemValue(new ItemStack(LegumeDelightItems.ROASTED_PEANUTS.get()))
                )))
                .requires(Items.COCOA_BEANS)
                .requires(Ingredient.fromValues(Stream.of( // sweeteners
                        new Ingredient.ItemValue(new ItemStack(Items.SUGAR)),
                        new Ingredient.ItemValue(new ItemStack(Items.HONEY_BOTTLE))
                )))
                .unlockedBy("has_peanuts", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.PEANUTS.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.PEANUT_BUTTER_AND_JAM_SANDWICH.get())
                .requires(ForgeTags.BREAD)
                .requires(LegumeDelightTags.PEANUT_BUTTER)
                .requires(LegumeDelightTags.FRUITS)
                .unlockedBy("has_peanut_butter", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.PEANUT_BUTTER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.PEANUT_BUTTER_COOKIE.get(), 8)
                .requires(LegumeDelightItems.PEANUT_BUTTER.get())
                .requires(Items.WHEAT)
                .requires(Items.WHEAT)
                .unlockedBy("has_peanut_butter", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.PEANUT_BUTTER.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.PEANUT_BUTTER_CUP.get(), 4)
                .requires(LegumeDelightItems.PEANUT_BUTTER.get())
                .requires(Items.COCOA_BEANS)
                .requires(Items.SUGAR)
                .unlockedBy("has_peanut_butter", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.PEANUT_BUTTER.get()))
                .save(consumer);

        ConditionalRecipe.builder()
                .addCondition(new NotCondition(new ModLoadedCondition("culturaldelights")))
                .addRecipe(c -> ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.POTATO_TACO.get())
                        .requires(Items.BREAD)
                        .requires(Items.BAKED_POTATO)
                        .requires(ForgeTags.SALAD_INGREDIENTS)
                        .requires(ForgeTags.CROPS_TOMATO)
                        .requires(ForgeTags.CROPS_ONION)
                        .unlockedBy("has_potatoes", InventoryChangeTrigger.TriggerInstance.hasItems(Items.POTATO))
                        .save(c))
                .addCondition(new ModLoadedCondition("culturaldelights"))
                .addRecipe(c -> ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.POTATO_TACO.get())
                        .requires(Ingredient.of(ForgeRegistries.ITEMS.getValue(ResourceLocation.parse("culturaldelights:tortilla"))))
                        .requires(Items.BAKED_POTATO)
                        .requires(ForgeTags.SALAD_INGREDIENTS)
                        .requires(ForgeTags.CROPS_TOMATO)
                        .requires(ForgeTags.CROPS_ONION)
                        .unlockedBy("has_potatoes", InventoryChangeTrigger.TriggerInstance.hasItems(Items.POTATO))
                        .save(c))
                .build(consumer, (ResourceLocation.fromNamespaceAndPath(LegumeDelight.MOD_ID, "potato_taco")));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.RICE_CAKE.get(), 2)
                .requires(ModItems.COOKED_RICE.get())
                .requires(LegumeDelightTags.BEAN_PASTE)
                .unlockedBy("has_bean_paste", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.BEAN_PASTE.get()))
                .save(consumer);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.TRAIL_MIX.get(), 2)
                .requires(Ingredient.fromValues(Stream.of(
                        new Ingredient.TagValue(LegumeDelightTags.NUTS),
                        new Ingredient.ItemValue(new ItemStack(LegumeDelightItems.ROASTED_PEANUTS.get())),
                        new Ingredient.ItemValue(new ItemStack(LegumeDelightItems.CANDIED_PEANUTS.get()))
                )), 2)
                .requires(ForgeTags.BERRIES)
                .requires(Ingredient.fromValues(Stream.of(
                        new Ingredient.TagValue(ItemTags.create(ResourceLocation.parse("forge:seeds/pumpkin"))),
                        new Ingredient.ItemValue(new ItemStack(Items.SUNFLOWER)),
                        new Ingredient.ItemValue(new ItemStack(Items.COCOA_BEANS))
                )))
                .unlockedBy("has_peanuts", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.PEANUTS.get()))
                .save(consumer);

    }
}
