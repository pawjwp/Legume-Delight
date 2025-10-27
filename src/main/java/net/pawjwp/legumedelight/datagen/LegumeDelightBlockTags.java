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

        // Mineability Tags
        this.tag(net.minecraft.tags.BlockTags.MINEABLE_WITH_HOE).add(
                LegumeDelightBlocks.BEAN_SACK.get(),
                LegumeDelightBlocks.PEANUT_SACK.get()
        );

        // Minecraft Tags
        this.tag(net.minecraft.tags.BlockTags.CLIMBABLE).add(
                LegumeDelightBlocks.BEAN_CROP.get()
        );
        this.tag(net.minecraft.tags.BlockTags.CROPS).add(
                LegumeDelightBlocks.BUDDING_BEAN_CROP.get(),
                LegumeDelightBlocks.BEAN_CROP.get(),
                LegumeDelightBlocks.PEANUT_CROP.get()
        );
        this.tag(net.minecraft.tags.BlockTags.SMALL_FLOWERS).add(
                LegumeDelightBlocks.WILD_BEANS.get(),
                LegumeDelightBlocks.WILD_PEANUTS.get()
        );
        this.tag(net.minecraft.tags.BlockTags.MAINTAINS_FARMLAND).add(
                LegumeDelightBlocks.BUDDING_BEAN_CROP.get(),
                LegumeDelightBlocks.BEAN_CROP.get(),
                LegumeDelightBlocks.PEANUT_CROP.get()
        );

        // Forge Tags
        this.tag(LegumeDelightTags.STORAGE_BLOCKS_BLOCK_BEAN).add(LegumeDelightBlocks.BEAN_SACK.get());
        this.tag(LegumeDelightTags.STORAGE_BLOCKS_BLOCK_PEANUT).add(LegumeDelightBlocks.PEANUT_SACK.get());

        // Farmer's Delight Tags
        this.tag(ModTags.WILD_CROPS).add(
                LegumeDelightBlocks.WILD_BEANS.get(),
                LegumeDelightBlocks.WILD_PEANUTS.get()
        );

        // Compatibility Tags
        this.tag(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS_BLOCK).add(
                LegumeDelightBlocks.BUDDING_BEAN_CROP.get(),
                LegumeDelightBlocks.BEAN_CROP.get(),
                LegumeDelightBlocks.PEANUT_CROP.get()
        );
        this.tag(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS_BLOCK).add(
                LegumeDelightBlocks.BUDDING_BEAN_CROP.get(),
                LegumeDelightBlocks.BEAN_CROP.get(),
                LegumeDelightBlocks.PEANUT_CROP.get()
        );
    }
}
