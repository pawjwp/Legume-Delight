package net.pawjwp.legumedelight.datagen.recipe;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.data.recipes.ShapelessRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import net.neoforged.neoforge.common.conditions.NotCondition;
import net.neoforged.neoforge.common.crafting.CompoundIngredient;
import net.pawjwp.legumedelight.LegumeDelight;
import net.pawjwp.legumedelight.item.LegumeDelightItems;
import net.pawjwp.legumedelight.tag.LegumeDelightTags;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class LegumeDelightCraftingRecipes {
    public static void register(RecipeOutput output) {
        recipesCraftedMeals(output);
        recipesBlocks(output);
        recipesMaterials(output);
    }

    private static void recipesBlocks(RecipeOutput output) {
        // Sacks
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, LegumeDelightItems.BEAN_SACK.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', LegumeDelightItems.BEANS.get())
                .unlockedBy("has_beans", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.BEANS.get()))
                .save(output);
        ShapedRecipeBuilder.shaped(RecipeCategory.BUILDING_BLOCKS, LegumeDelightItems.PEANUT_SACK.get(), 1)
                .pattern("###")
                .pattern("###")
                .pattern("###")
                .define('#', LegumeDelightItems.PEANUTS.get())
                .unlockedBy("has_peanuts", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.PEANUTS.get()))
                .save(output);
    }

    private static void recipesCraftedMeals(RecipeOutput output) {
        // Meals
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.BEAN_BURGER.get())
                .requires(Tags.Items.FOODS_BREAD)
                .requires(LegumeDelightItems.BEAN_PATTY.get())
                .requires(CommonTags.Items.FOODS_LEAFY_GREEN)
                .requires(CommonTags.Items.CROPS_TOMATO)
                .requires(CommonTags.Items.CROPS_ONION)
                .unlockedBy("has_bean_patty", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.BEAN_PATTY.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.BEAN_BURRITO.get())
                .requires(Items.BREAD)
                .requires(LegumeDelightItems.REFRIED_BEANS.get(), 2)
                .requires(ModItems.COOKED_RICE.get())
                .requires(CommonTags.Items.CROPS_ONION)
                .requires(CommonTags.Items.CROPS_TOMATO)
                .unlockedBy("has_beans", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.BEANS.get()))
                .save(output.withConditions(new NotCondition(new ModLoadedCondition("culturaldelights"))),
                        ResourceLocation.fromNamespaceAndPath(LegumeDelight.MOD_ID, "bean_burrito"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.BEAN_BURRITO.get())
                .requires(Ingredient.of(BuiltInRegistries.ITEM.get(ResourceLocation.parse("culturaldelights:tortilla"))))
                .requires(LegumeDelightItems.REFRIED_BEANS.get())
                .requires(LegumeDelightItems.BEANS.get())
                .requires(ModItems.COOKED_RICE.get())
                .requires(CommonTags.Items.CROPS_ONION)
                .requires(CommonTags.Items.CROPS_TOMATO)
                .unlockedBy("has_beans", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.BEANS.get()))
                .save(output.withConditions(new ModLoadedCondition("culturaldelights")),
                        ResourceLocation.fromNamespaceAndPath(LegumeDelight.MOD_ID, "bean_burrito_culturaldelights"));

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.BEANS_ON_TOAST.get(), 4)
                .requires(Tags.Items.FOODS_BREAD)
                .requires(LegumeDelightItems.BAKED_BEANS.get())
                .unlockedBy("has_baked_beans", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.BAKED_BEANS.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.MOONCAKE.get(), 4)
                .requires(LegumeDelightTags.Items.BEAN_PASTE)
                .requires(LegumeDelightTags.Items.BEAN_PASTE)
                .requires(Tags.Items.EGGS)
                .requires(ModItems.PIE_CRUST.get())
                .unlockedBy("has_bean_paste", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.BEAN_PASTE.get()))
                .save(output);

        /*ConditionalRecipe.builder()
                .addCondition(new ModLoadedCondition("culturaldelights"))
                .addRecipe(c -> ShapelessRecipeBuilder
                        .shapeless(RecipeCategory.FOOD, LegumeDelightItems.NACHOS.get(), 2)
                        .requires(Ingredient.of(ForgeRegistries.ITEMS.getValue(ResourceLocation.parse("culturaldelights:tortilla_chips"))), 2)
                        .requires(ModItems.TOMATO_SAUCE.get())
                        .requires(LegumeDelightTags.Items.REFRIED_BEANS)
                        .unlockedBy("has_tortilla_chips", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.REFRIED_BEANS.get()))
                        .save(c))
                .build(consumer, (ResourceLocation.fromNamespaceAndPath(LegumeDelight.MOD_ID, "nachos")));*/

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.PEANUT_BAR.get(), 2)
                .requires(Ingredient.of(LegumeDelightItems.PEANUTS.get(), LegumeDelightItems.ROASTED_PEANUTS.get()))
                .requires(Items.COCOA_BEANS)
                .requires(Ingredient.of(Items.SUGAR, Items.HONEY_BOTTLE))
                .unlockedBy("has_peanuts", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.PEANUTS.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.PEANUT_BUTTER_AND_JAM_SANDWICH.get())
                .requires(Tags.Items.FOODS_BREAD)
                .requires(LegumeDelightTags.Items.PEANUT_BUTTER)
                .requires(LegumeDelightTags.Items.FRUITS)
                .unlockedBy("has_peanut_butter", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.PEANUT_BUTTER.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.PEANUT_BUTTER_COOKIE.get(), 8)
                .requires(LegumeDelightItems.PEANUT_BUTTER.get())
                .requires(Items.WHEAT)
                .requires(Items.WHEAT)
                .unlockedBy("has_peanut_butter", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.PEANUT_BUTTER.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.PEANUT_BUTTER_CUP.get(), 4)
                .requires(LegumeDelightItems.PEANUT_BUTTER.get())
                .requires(Items.COCOA_BEANS)
                .requires(Items.SUGAR)
                .unlockedBy("has_peanut_butter", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.PEANUT_BUTTER.get()))
                .save(output);

        /*ConditionalRecipe.builder()
                .addCondition(new NotCondition(new ModLoadedCondition("culturaldelights")))
                .addRecipe(c -> ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.POTATO_TACO.get())
                        .requires(Items.BREAD)
                        .requires(Items.BAKED_POTATO)
                        .requires(CommonTags.Items.FOODS_LEAFY_GREEN)
                        .requires(CommonTags.Items.CROPS_TOMATO)
                        .requires(CommonTags.Items.CROPS_ONION)
                        .unlockedBy("has_potatoes", InventoryChangeTrigger.TriggerInstance.hasItems(Items.POTATO))
                        .save(c))
                .addCondition(new ModLoadedCondition("culturaldelights"))
                .addRecipe(c -> ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.POTATO_TACO.get())
                        .requires(Ingredient.of(ForgeRegistries.ITEMS.getValue(ResourceLocation.parse("culturaldelights:tortilla"))))
                        .requires(Items.BAKED_POTATO)
                        .requires(CommonTags.Items.FOODS_LEAFY_GREEN)
                        .requires(CommonTags.Items.CROPS_TOMATO)
                        .requires(CommonTags.Items.CROPS_ONION)
                        .unlockedBy("has_potatoes", InventoryChangeTrigger.TriggerInstance.hasItems(Items.POTATO))
                        .save(c))
                .build(consumer, (ResourceLocation.fromNamespaceAndPath(LegumeDelight.MOD_ID, "potato_taco")));*/

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.RICE_CAKE.get(), 2)
                .requires(ModItems.COOKED_RICE.get())
                .requires(LegumeDelightTags.Items.BEAN_PASTE)
                .unlockedBy("has_bean_paste", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.BEAN_PASTE.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.TRAIL_MIX.get(), 2)
                .requires(CompoundIngredient.of(Ingredient.of(LegumeDelightTags.Items.NUTS), Ingredient.of(LegumeDelightItems.ROASTED_PEANUTS.get(), LegumeDelightItems.CANDIED_PEANUTS.get())), 2)
                .requires(Tags.Items.FOODS_BERRY)
                .requires(CompoundIngredient.of(Ingredient.of(ItemTags.create(ResourceLocation.parse("c:seeds/pumpkin"))), Ingredient.of(Items.SUNFLOWER, Items.COCOA_BEANS)))
                .unlockedBy("has_peanuts", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.PEANUTS.get()))
                .save(output);
    }

    private static void recipesMaterials(RecipeOutput output) {
        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.BEANS.get(), 9)
                .requires(LegumeDelightItems.BEAN_SACK.get())
                .unlockedBy("has_bean_sack", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.BEAN_SACK.get()))
                .save(output);

        ShapelessRecipeBuilder.shapeless(RecipeCategory.FOOD, LegumeDelightItems.PEANUTS.get(), 9)
                .requires(LegumeDelightItems.PEANUT_SACK.get())
                .unlockedBy("has_peanut_sack", InventoryChangeTrigger.TriggerInstance.hasItems(LegumeDelightItems.PEANUT_SACK.get()))
                .save(output);
    }
}
