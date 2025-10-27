package net.pawjwp.legumedelight.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraftforge.common.crafting.conditions.IConditionBuilder;
import net.pawjwp.legumedelight.datagen.recipe.LegumeDelightCraftingRecipes;
import net.pawjwp.legumedelight.datagen.recipe.LegumeDelightCookingRecipes;
import net.pawjwp.legumedelight.datagen.recipe.LegumeDelightSmeltingRecipes;

import java.util.function.Consumer;

public class LegumeDelightRecipes extends RecipeProvider implements IConditionBuilder {
    public LegumeDelightRecipes(PackOutput pOutput) {
        super(pOutput);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
    }
}
