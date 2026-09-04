package net.pawjwp.legumedelight.datagen.recipe;

import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.crafting.CompoundIngredient;
import net.pawjwp.legumedelight.LegumeDelight;
import net.pawjwp.legumedelight.item.LegumeDelightItems;
import net.pawjwp.legumedelight.tag.LegumeDelightTags;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

public class LegumeDelightCookingRecipes {
    public static final int FAST_COOKING = 100;      // 5 seconds
    public static final int NORMAL_COOKING = 200;    // 10 seconds
    public static final int SLOW_COOKING = 400;      // 20 seconds, for feasts

    public static final float SMALL_EXP = 0.35F; // for simple dishes/ingredients
    public static final float MEDIUM_EXP = 1.0F; // standard
    public static final float LARGE_EXP = 2.0F; // for feasts

    public static void register(RecipeOutput output) {
        cookMiscellaneous(output);
        cookMeals(output);
    }

    private static void cookMiscellaneous(RecipeOutput output) {
        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.BEAN_PASTE.get(), 1, NORMAL_COOKING, SMALL_EXP)
                .addIngredient(LegumeDelightTags.Items.CROPS_BEAN)
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_beans", LegumeDelightItems.BEANS.get())
                .setNamespace(LegumeDelight.MOD_ID)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .save(output);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.BEAN_PATTY.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(LegumeDelightTags.Items.CROPS_BEAN)
                .addIngredient(LegumeDelightTags.Items.CROPS_BEAN)
                .addIngredient(Items.WHEAT)
                .unlockedByItems("has_beans", LegumeDelightItems.BEANS.get())
                .setNamespace(LegumeDelight.MOD_ID)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .save(output);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.CANDIED_PEANUTS.get(), 1, NORMAL_COOKING, SMALL_EXP)
                .addIngredient(CompoundIngredient.of(Ingredient.of(LegumeDelightTags.Items.NUTS_PEANUT), Ingredient.of(LegumeDelightItems.ROASTED_PEANUTS.get())))
                .addIngredient(Ingredient.of(Items.SUGAR, Items.HONEY_BOTTLE))
                .unlockedByItems("has_peanuts", LegumeDelightItems.PEANUTS.get())
                .setNamespace(LegumeDelight.MOD_ID)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .save(output);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.REFRIED_BEANS.get(), 1, NORMAL_COOKING, SMALL_EXP)
                .addIngredient(LegumeDelightTags.Items.CROPS_BEAN)
                .unlockedByItems("hsa_beans", LegumeDelightItems.BEANS.get())
                .setNamespace(LegumeDelight.MOD_ID)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .save(output);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.PEANUT_BUTTER.get(), 1, NORMAL_COOKING, SMALL_EXP)
                .addIngredient(CompoundIngredient.of(Ingredient.of(LegumeDelightTags.Items.NUTS_PEANUT), Ingredient.of(LegumeDelightItems.ROASTED_PEANUTS.get())))
                .unlockedByItems("has_peanuts", LegumeDelightItems.PEANUTS.get())
                .setNamespace(LegumeDelight.MOD_ID)
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .save(output);
    }

    private static void cookMeals(RecipeOutput output) {
        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.BAKED_BEANS.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(LegumeDelightTags.Items.CROPS_BEAN)
                .addIngredient(LegumeDelightTags.Items.CROPS_BEAN)
                .addIngredient(ModItems.TOMATO_SAUCE.get())
                .addIngredient(Ingredient.of(Items.SUGAR, Items.HONEY_BOTTLE))
                .unlockedByAnyIngredient(LegumeDelightItems.BEANS.get(), ModItems.TOMATO_SAUCE.get())
                .setNamespace(LegumeDelight.MOD_ID)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(output);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.BEANS_AND_RICE.get(), 1, FAST_COOKING, SMALL_EXP)
                .addIngredient(LegumeDelightTags.Items.CROPS_BEAN)
                .addIngredient(ModItems.RICE.get())
                .unlockedByAnyIngredient(LegumeDelightItems.BEANS.get(), ModItems.RICE.get())
                .setNamespace(LegumeDelight.MOD_ID)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(output);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.CHILI.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(LegumeDelightTags.Items.CROPS_BEAN)
                .addIngredient(LegumeDelightTags.Items.CROPS_BEAN)
                .addIngredient(LegumeDelightTags.Items.CROPS_BEAN)
                .addIngredient(CommonTags.Items.CROPS_ONION)
                .addIngredient(ModItems.TOMATO_SAUCE.get())
                .addIngredient(CommonTags.Items.CROPS_TOMATO)
                .unlockedByAnyIngredient(LegumeDelightItems.BEANS.get(), ModItems.TOMATO_SAUCE.get(), ModItems.TOMATO.get(), ModItems.ONION.get())
                .setNamespace(LegumeDelight.MOD_ID)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(output);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.PAD_THAI.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(CommonTags.Items.FOODS_PASTA)
                .addIngredient(Tags.Items.EGGS)
                .addIngredient(LegumeDelightTags.Items.PEANUT_BUTTER)
                .addIngredient(Items.DRIED_KELP)
                .unlockedByAnyIngredient(ModItems.RAW_PASTA.get(), LegumeDelightItems.PEANUT_BUTTER.get(), Items.DRIED_KELP)
                .setNamespace(LegumeDelight.MOD_ID)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(output);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.PASTA_WITH_TOMATO_SAUCE.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(CommonTags.Items.FOODS_PASTA)
                .addIngredient(ModItems.TOMATO_SAUCE.get())
                .unlockedByAnyIngredient(ModItems.RAW_PASTA.get(), ModItems.TOMATO_SAUCE.get())
                .setNamespace(LegumeDelight.MOD_ID)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .save(output);
    }
}
