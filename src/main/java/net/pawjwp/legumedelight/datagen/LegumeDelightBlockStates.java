package net.pawjwp.legumedelight.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.pawjwp.legumedelight.LegumeDelight;
import net.pawjwp.legumedelight.block.BuddingBeanBlock;
import net.pawjwp.legumedelight.block.LegumeDelightBlocks;
import net.pawjwp.legumedelight.block.PeanutBlock;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.List;

import static net.minecraft.resources.ResourceLocation.fromNamespaceAndPath;

public class LegumeDelightBlockStates extends BlockStateProvider {

    public LegumeDelightBlockStates(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, LegumeDelight.MOD_ID, exFileHelper);
    }

    private String blockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }

    public ResourceLocation resourceBlock(String path) {
        return fromNamespaceAndPath(LegumeDelight.MOD_ID, "block/" + path);
    }

    @Override
    protected void registerStatesAndModels() {

    }
}
