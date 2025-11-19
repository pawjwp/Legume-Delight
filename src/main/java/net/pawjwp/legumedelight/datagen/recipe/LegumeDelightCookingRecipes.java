package net.pawjwp.legumedelight.datagen.recipe;

import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.pawjwp.legumedelight.item.LegumeDelightItems;
import net.pawjwp.legumedelight.tag.LegumeDelightTags;
import vectorwing.farmersdelight.client.recipebook.CookingPotRecipeBookTab;
import vectorwing.farmersdelight.common.registry.ModItems;
import vectorwing.farmersdelight.common.tag.ForgeTags;
import vectorwing.farmersdelight.data.builder.CookingPotRecipeBuilder;

import java.util.function.Consumer;
import java.util.stream.Stream;

public class LegumeDelightCookingRecipes {
    public static final int FAST_COOKING = 100;      // 5 seconds
    public static final int NORMAL_COOKING = 200;    // 10 seconds
    public static final int SLOW_COOKING = 400;      // 20 seconds, for feasts

    public static final float SMALL_EXP = 0.35F; // for simple dishes/ingredients
    public static final float MEDIUM_EXP = 1.0F; // standard
    public static final float LARGE_EXP = 2.0F; // for feasts

    public static void register(Consumer<FinishedRecipe> consumer) {
        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.BAKED_BEANS.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(LegumeDelightTags.CROPS_BEAN)
                .addIngredient(LegumeDelightTags.CROPS_BEAN)
                .addIngredient(ModItems.TOMATO_SAUCE.get())
                .addIngredient(Ingredient.fromValues(Stream.of( // sweeteners
                        new Ingredient.ItemValue(new ItemStack(Items.SUGAR)),
                        new Ingredient.ItemValue(new ItemStack(Items.HONEY_BOTTLE))
                )))
                .unlockedByAnyIngredient(LegumeDelightItems.BEANS.get(), ModItems.TOMATO_SAUCE.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.BEAN_PASTE.get(), 1, NORMAL_COOKING, SMALL_EXP)
                .addIngredient(LegumeDelightTags.CROPS_BEAN)
                .addIngredient(Items.SUGAR)
                .unlockedByItems("has_beans", LegumeDelightItems.BEANS.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.BEAN_PATTY.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(LegumeDelightTags.CROPS_BEAN)
                .addIngredient(LegumeDelightTags.CROPS_BEAN)
                .addIngredient(Items.WHEAT)
                .unlockedByItems("has_beans", LegumeDelightItems.BEANS.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.BEANS_AND_RICE.get(), 1, FAST_COOKING, SMALL_EXP)
                .addIngredient(LegumeDelightTags.CROPS_BEAN)
                .addIngredient(ModItems.RICE.get())
                .unlockedByAnyIngredient(LegumeDelightItems.BEANS.get(), ModItems.RICE.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.CANDIED_PEANUTS.get(), 1, NORMAL_COOKING, SMALL_EXP)
                .addIngredient(Ingredient.fromValues(Stream.of(
                        new Ingredient.TagValue(LegumeDelightTags.NUTS_PEANUT),
                        new Ingredient.ItemValue(new ItemStack(LegumeDelightItems.ROASTED_PEANUTS.get()))
                )))
                .addIngredient(Ingredient.fromValues(Stream.of( // sweeteners
                        new Ingredient.ItemValue(new ItemStack(Items.SUGAR)),
                        new Ingredient.ItemValue(new ItemStack(Items.HONEY_BOTTLE))
                )))
                .unlockedByItems("has_peanuts", LegumeDelightItems.PEANUTS.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.CHILI.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(LegumeDelightTags.CROPS_BEAN)
                .addIngredient(LegumeDelightTags.CROPS_BEAN)
                .addIngredient(LegumeDelightTags.CROPS_BEAN)
                .addIngredient(ForgeTags.CROPS_ONION)
                .addIngredient(ModItems.TOMATO_SAUCE.get())
                .addIngredient(ForgeTags.CROPS_TOMATO)
                .unlockedByAnyIngredient(LegumeDelightItems.BEANS.get(), ModItems.TOMATO_SAUCE.get(), ModItems.TOMATO.get(), ModItems.ONION.get())
                .build(consumer);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.PAD_THAI.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(ForgeTags.PASTA)
                .addIngredient(ForgeTags.EGGS)
                .addIngredient(LegumeDelightTags.PEANUT_BUTTER)
                .addIngredient(Items.DRIED_KELP)
                .unlockedByAnyIngredient(ModItems.RAW_PASTA.get(), LegumeDelightItems.PEANUT_BUTTER.get(), Items.DRIED_KELP)
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.PASTA_WITH_TOMATO_SAUCE.get(), 1, NORMAL_COOKING, MEDIUM_EXP)
                .addIngredient(ForgeTags.PASTA)
                .addIngredient(ModItems.TOMATO_SAUCE.get())
                .unlockedByAnyIngredient(ModItems.RAW_PASTA.get(), ModItems.TOMATO_SAUCE.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MEALS)
                .build(consumer);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.REFRIED_BEANS.get(), 1, NORMAL_COOKING, SMALL_EXP)
                .addIngredient(LegumeDelightTags.CROPS_BEAN)
                .unlockedByItems("hsa_beans", LegumeDelightItems.BEANS.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer);

        CookingPotRecipeBuilder.cookingPotRecipe(LegumeDelightItems.PEANUT_BUTTER.get(), 1, NORMAL_COOKING, SMALL_EXP)
                .addIngredient(Ingredient.fromValues(Stream.of(
                    new Ingredient.TagValue(LegumeDelightTags.NUTS_PEANUT),
                    new Ingredient.ItemValue(new ItemStack(LegumeDelightItems.ROASTED_PEANUTS.get()))
                )))
                .unlockedByItems("has_peanuts", LegumeDelightItems.PEANUTS.get())
                .setRecipeBookTab(CookingPotRecipeBookTab.MISC)
                .build(consumer);
    }
}
