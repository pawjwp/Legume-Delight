package net.pawjwp.legumedelight.datagen.recipe;

import net.minecraft.advancements.critereon.InventoryChangeTrigger;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.pawjwp.legumedelight.LegumeDelight;
import net.pawjwp.legumedelight.item.LegumeDelightItems;

public class LegumeDelightSmeltingRecipes {
    public static void register(RecipeOutput output) {
        foodSmeltingRecipes("roasted_peanuts", LegumeDelightItems.PEANUTS.get(), LegumeDelightItems.ROASTED_PEANUTS.get(), 0.35F, output);
    }

    private static void foodSmeltingRecipes(String name, ItemLike ingredient, ItemLike result, float experience, RecipeOutput output) {
        String namePrefix = ResourceLocation.fromNamespaceAndPath(LegumeDelight.MOD_ID, name).toString();
        SimpleCookingRecipeBuilder.smelting(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 200)
                .unlockedBy(name, InventoryChangeTrigger.TriggerInstance.hasItems(ingredient))
                .save(output);
        SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 600)
                .unlockedBy(name, InventoryChangeTrigger.TriggerInstance.hasItems(ingredient))
                .save(output, namePrefix + "_from_campfire_cooking");
        SimpleCookingRecipeBuilder.smoking(Ingredient.of(ingredient), RecipeCategory.FOOD, result, experience, 100)
                .unlockedBy(name, InventoryChangeTrigger.TriggerInstance.hasItems(ingredient))
                .save(output, namePrefix + "_from_smoking");
    }
}
