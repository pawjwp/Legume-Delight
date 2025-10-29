package net.pawjwp.legumedelight.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.pawjwp.legumedelight.LegumeDelight;
import net.pawjwp.legumedelight.block.BeanVineBlock;
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
        this.sackBlock(LegumeDelightBlocks.BEAN_SACK.get(), "bean");
        this.sackBlock(LegumeDelightBlocks.PEANUT_SACK.get(), "peanut");

        this.wildCropBlock(LegumeDelightBlocks.WILD_BEANS.get());
        this.wildCropBlock(LegumeDelightBlocks.WILD_PEANUTS.get());

        this.customStageBlock(
                LegumeDelightBlocks.BUDDING_BEAN_CROP.get(),
                ResourceLocation.parse("block/cross"),
                "cross",
                BuddingBeanBlock.AGE,
                Arrays.asList(0, 1, 2, 3, 3)
        );
        this.ropeLoggedVineBlock(
                LegumeDelightBlocks.BEAN_CROP.get(),
                "beans",
                BeanVineBlock.VINE_AGE,
                BeanVineBlock.ROPELOGGED,
                Arrays.asList(0, 1, 2, 3),
                resourceBlock("beans_coiled_rope"),
                ResourceLocation.parse("farmersdelight:block/rope_top")
        );
        this.customStageBlock(
                LegumeDelightBlocks.PEANUT_CROP.get(),
                ResourceLocation.parse("block/cross"),
                "cross",
                PeanutBlock.AGE,
                Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7)
        );
    }

    // Adapted from https://github.com/vectorwing/FarmersDelight/blob/1.20/src/main/java/vectorwing/farmersdelight/data/BlockStates.java
    public void sackBlock(Block block, String cropName) {
        this.simpleBlock(block,
                models().cubeBottomTop(
                        blockName(block),
                        resourceBlock(cropName + "_sack_side"),
                        resourceBlock(cropName + "_sack_bottom"),
                        resourceBlock(cropName + "_sack_top")
                )
        );
    }

    public void wildCropBlock(Block block) {
        this.simpleBlock(block,
                models().cross(
                        blockName(block),
                        resourceBlock(blockName(block))).renderType("cutout"));
    }

    public void customStageBlock(
            Block block,
            @Nullable ResourceLocation parent,
            String textureKey,
            IntegerProperty ageProperty,
            List<Integer> suffixes,
            Property<?>... ignored
    ) {
        getVariantBuilder(block)
                .forAllStatesExcept(state -> {
                    int ageSuffix = state.getValue(ageProperty);
                    String stageName = blockName(block) + "_stage";
                    stageName += suffixes.isEmpty() ? ageSuffix : suffixes.get(Math.min(suffixes.size(), ageSuffix));
                    if (parent == null) {
                        return ConfiguredModel.builder()
                                .modelFile(models().cross(stageName, resourceBlock(stageName)).renderType("cutout")).build();
                    }
                    return ConfiguredModel.builder()
                            .modelFile(models().singleTexture(stageName, parent, textureKey, resourceBlock(stageName)).renderType("cutout")).build();
                }, ignored);
    }

    public void ropeLoggedVineBlock(
            Block block,
            String baseName,
            IntegerProperty ageProperty,
            BooleanProperty ropeProperty,
            List<Integer> suffixes,
            ResourceLocation ropeSideTexture,
            ResourceLocation ropeTopTexture,
            Property<?>... ignored
    ) {
        getVariantBuilder(block)
                .forAllStatesExcept(state -> {
                    int ageSuffix = state.getValue(ageProperty);
                    int suffix = suffixes.isEmpty() ? ageSuffix : suffixes.get(Math.min(suffixes.size() - 1, ageSuffix));
                    boolean rope = state.getValue(ropeProperty);

                    String modelName = baseName + (rope ? "_vine_stage" : "_stage") + suffix;

                    if (rope) {
                        return ConfiguredModel.builder()
                                .modelFile(models()
                                        .withExistingParent(modelName, ResourceLocation.parse("farmersdelight:block/crop_with_rope"))
                                        .texture("crop", resourceBlock(modelName))
                                        .texture("rope_side", ropeSideTexture)
                                        .texture("rope_top",  ropeTopTexture)
                                        .renderType("cutout"))
                                .build();
                    } else {
                        return ConfiguredModel.builder()
                                .modelFile(models()
                                        .singleTexture(modelName, ResourceLocation.parse("block/cross"), "cross", resourceBlock(modelName))
                                        .renderType("cutout"))
                                .build();
                    }
                }, ignored);
    }
}
