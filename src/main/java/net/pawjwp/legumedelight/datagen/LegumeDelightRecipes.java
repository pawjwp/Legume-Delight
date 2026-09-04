package net.pawjwp.legumedelight.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.neoforged.neoforge.common.conditions.IConditionBuilder;
import net.pawjwp.legumedelight.datagen.recipe.LegumeDelightCraftingRecipes;
import net.pawjwp.legumedelight.datagen.recipe.LegumeDelightCookingRecipes;
import net.pawjwp.legumedelight.datagen.recipe.LegumeDelightSmeltingRecipes;

import java.util.concurrent.CompletableFuture;

public class LegumeDelightRecipes extends RecipeProvider implements IConditionBuilder {
    public LegumeDelightRecipes(PackOutput pOutput, CompletableFuture<HolderLookup.Provider> registries) {
        super(pOutput, registries);
    }

    @Override
    protected void buildRecipes(RecipeOutput output) {
        LegumeDelightCraftingRecipes.register(output);
        LegumeDelightCookingRecipes.register(output);
        LegumeDelightSmeltingRecipes.register(output);
    }
}