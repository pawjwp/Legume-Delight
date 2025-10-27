package net.pawjwp.legumedelight.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.pawjwp.legumedelight.LegumeDelight;
import net.pawjwp.legumedelight.tag.LegumeDelightTags;
import org.jetbrains.annotations.Nullable;
import net.pawjwp.legumedelight.block.LegumeDelightBlocks;
import vectorwing.farmersdelight.common.tag.CompatibilityTags;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class LegumeDelightBlockTags extends BlockTagsProvider {

    public LegumeDelightBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, LegumeDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

    }
}
