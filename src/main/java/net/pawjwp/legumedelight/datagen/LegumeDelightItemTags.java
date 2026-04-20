package net.pawjwp.legumedelight.datagen;

import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.ItemTagsProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.pawjwp.legumedelight.LegumeDelight;
import net.pawjwp.legumedelight.item.LegumeDelightItems;
import net.pawjwp.legumedelight.tag.LegumeDelightTags;
import org.jetbrains.annotations.Nullable;
import vectorwing.farmersdelight.common.tag.CompatibilityTags;
import vectorwing.farmersdelight.common.tag.CommonTags;
import vectorwing.farmersdelight.common.tag.ModTags;

import java.util.concurrent.CompletableFuture;

public class LegumeDelightItemTags extends ItemTagsProvider {
    public LegumeDelightItemTags(PackOutput p_275343_, CompletableFuture<HolderLookup.Provider> p_275729_, CompletableFuture<TagLookup<Block>> p_275322_, @Nullable ExistingFileHelper existingFileHelper) {
        super(p_275343_, p_275729_, p_275322_, LegumeDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {

        // Minecraft Tags
        this.tag(ItemTags.VILLAGER_PLANTABLE_SEEDS).add(
                LegumeDelightItems.BEANS.get(),
                LegumeDelightItems.PEANUTS.get()
        );

        // Forge Tags
        this.tag(CommonTags.Items.CROPS).add(
                LegumeDelightItems.BEANS.get(),
                LegumeDelightItems.PEANUTS.get()
        );
        this.tag(LegumeDelightTags.Items.CROPS_BEAN).add(LegumeDelightItems.BEANS.get());
        this.tag(LegumeDelightTags.Items.CROPS_PEANUT).add(LegumeDelightItems.PEANUTS.get());

        this.tag(LegumeDelightTags.Items.LEGUMES).add(
                LegumeDelightItems.BEANS.get(),
                LegumeDelightItems.PEANUTS.get()
        );
        this.tag(LegumeDelightTags.Items.LEGUMES_BEAN).add(LegumeDelightItems.BEANS.get());
        this.tag(LegumeDelightTags.Items.LEGUMES_PEANUT).add(LegumeDelightItems.PEANUTS.get());


        this.tag(LegumeDelightTags.Items.BEAN).add(LegumeDelightItems.BEANS.get());
        this.tag(LegumeDelightTags.Items.BEANS).add(LegumeDelightItems.BEANS.get());
        this.tag(LegumeDelightTags.Items.BEANS_BEAN).add(LegumeDelightItems.BEANS.get());

        this.tag(LegumeDelightTags.Items.BEAN_PASTE).add(LegumeDelightItems.BEAN_PASTE.get());
        this.tag(LegumeDelightTags.Items.RED_BEAN_PASTE).add(LegumeDelightItems.BEAN_PASTE.get());
        this.tag(LegumeDelightTags.Items.REFRIED_BEANS).add(LegumeDelightItems.REFRIED_BEANS.get());


        this.tag(LegumeDelightTags.Items.PEANUT).add(LegumeDelightItems.PEANUTS.get());
        this.tag(LegumeDelightTags.Items.PEANUTS).add(LegumeDelightItems.PEANUTS.get());
        this.tag(LegumeDelightTags.Items.NUTS).add(LegumeDelightItems.PEANUTS.get());
        this.tag(LegumeDelightTags.Items.NUTS_PEANUT).add(LegumeDelightItems.PEANUTS.get());

        this.tag(LegumeDelightTags.Items.NUT_BUTTER).add(LegumeDelightItems.PEANUT_BUTTER.get());
        this.tag(LegumeDelightTags.Items.PEANUT_BUTTER).add(LegumeDelightItems.PEANUT_BUTTER.get());

        this.tag(CommonTags.Items.BERRIES); // establish tag exists before use
        this.tag(LegumeDelightTags.Items.FRUITS).add(
                Items.APPLE,
                Items.MELON_SLICE,
                Items.CHORUS_FRUIT
        ).addTag(
                CommonTags.Items.BERRIES
        );

        this.tag(LegumeDelightTags.Items.STORAGE_BLOCKS_ITEM_BEAN).add(LegumeDelightItems.BEAN_SACK.get());
        this.tag(LegumeDelightTags.Items.STORAGE_BLOCKS_ITEM_PEANUT).add(LegumeDelightItems.PEANUT_SACK.get());

        // Farmer's Delight Tags
        this.tag(ModTags.Items.MEALS).add(
                LegumeDelightItems.BAKED_BEANS.get(),
                LegumeDelightItems.BEAN_BURGER.get(),
                LegumeDelightItems.BEAN_BURRITO.get(),
                LegumeDelightItems.BEANS_AND_RICE.get(),
                LegumeDelightItems.BEANS_ON_TOAST.get(),
                LegumeDelightItems.CHILI.get(),
                //LegumeDelightItems.NACHOS.get(),
                LegumeDelightItems.PAD_THAI.get(),
                LegumeDelightItems.PASTA_WITH_TOMATO_SAUCE.get(),
                LegumeDelightItems.PEANUT_BUTTER_AND_JAM_SANDWICH.get()
                //LegumeDelightItems.POTATO_TACO.get()
        );

        this.tag(ModTags.Items.SWEETS).add(
                LegumeDelightItems.CANDIED_PEANUTS.get(),
                LegumeDelightItems.MOONCAKE.get(),
                LegumeDelightItems.PEANUT_BAR.get(),
                LegumeDelightItems.PEANUT_BUTTER_COOKIE.get(),
                LegumeDelightItems.PEANUT_BUTTER_CUP.get(),
                LegumeDelightItems.RICE_CAKE.get(),
                LegumeDelightItems.TRAIL_MIX.get()
        );

        // Compatibility Tags
        this.tag(CompatibilityTags.CREATE_UPRIGHT_ON_BELT).add(
                LegumeDelightItems.BEAN_PASTE.get(),
                LegumeDelightItems.PEANUT_BUTTER.get(),
                LegumeDelightItems.REFRIED_BEANS.get(),
                LegumeDelightItems.MOONCAKE.get()
        );
        this.tag(CompatibilityTags.SERENE_SEASONS_SPRING_CROPS).add(
                LegumeDelightItems.BEANS.get(),
                LegumeDelightItems.PEANUTS.get()
        );
        this.tag(CompatibilityTags.SERENE_SEASONS_SUMMER_CROPS).add(
                LegumeDelightItems.BEANS.get(),
                LegumeDelightItems.PEANUTS.get()
        );
        this.tag(CompatibilityTags.TINKERS_CONSTRUCT_SEEDS).add(
                LegumeDelightItems.BEANS.get(),
                LegumeDelightItems.PEANUTS.get()
        );



        this.tag(LegumeDelightTags.Items.DIET_PROTEINS).add(
                LegumeDelightItems.BEANS.get(),
                LegumeDelightItems.PEANUTS.get()
        ).addOptional(ResourceLocation.parse("culturaldelights:eggplant_parmesian"));

        this.tag(LegumeDelightTags.Items.DIET_GRAINS)
                .addOptional(ResourceLocation.parse("culturaldelights:corn_cob"))
                .addOptional(ResourceLocation.parse("culturaldelights:corn_kernels"))
                .addOptional(ResourceLocation.parse("culturaldelights:eggplant_parmesian"));

        this.tag(LegumeDelightTags.Items.DIET_VEGETABLES)
                .addOptional(ResourceLocation.parse("culturaldelights:eggplant_parmesian"));

        // This doesn't seem to take effect even though the data generates right. Maybe due to load orders? I'll leave it in just in case.
        this.tag(LegumeDelightTags.Items.DIET_VEGETABLES).remove(
                Items.PUMPKIN_SEEDS,
                Items.SUNFLOWER
        );
    }
}
