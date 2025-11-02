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
import vectorwing.farmersdelight.common.tag.ForgeTags;
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
        this.tag(ForgeTags.CROPS).add(
                LegumeDelightItems.BEANS.get(),
                LegumeDelightItems.PEANUTS.get()
        );
        this.tag(LegumeDelightTags.CROPS_BEAN).add(LegumeDelightItems.BEANS.get());
        this.tag(LegumeDelightTags.CROPS_PEANUT).add(LegumeDelightItems.PEANUTS.get());

        this.tag(LegumeDelightTags.LEGUMES).add(
                LegumeDelightItems.BEANS.get(),
                LegumeDelightItems.PEANUTS.get()
        );
        this.tag(LegumeDelightTags.LEGUMES_BEAN).add(LegumeDelightItems.BEANS.get());
        this.tag(LegumeDelightTags.LEGUMES_PEANUT).add(LegumeDelightItems.PEANUTS.get());


        this.tag(LegumeDelightTags.BEAN).add(LegumeDelightItems.BEANS.get());
        this.tag(LegumeDelightTags.BEANS).add(LegumeDelightItems.BEANS.get());
        this.tag(LegumeDelightTags.BEANS_BEAN).add(LegumeDelightItems.BEANS.get());

        this.tag(LegumeDelightTags.BEAN_PASTE).add(LegumeDelightItems.BEAN_PASTE.get());
        this.tag(LegumeDelightTags.RED_BEAN_PASTE).add(LegumeDelightItems.BEAN_PASTE.get());
        this.tag(LegumeDelightTags.REFRIED_BEANS).add(LegumeDelightItems.REFRIED_BEANS.get());


        this.tag(LegumeDelightTags.PEANUT).add(LegumeDelightItems.PEANUTS.get());
        this.tag(LegumeDelightTags.PEANUTS).add(LegumeDelightItems.PEANUTS.get());
        this.tag(LegumeDelightTags.NUTS).add(LegumeDelightItems.PEANUTS.get());
        this.tag(LegumeDelightTags.NUTS_PEANUT).add(LegumeDelightItems.PEANUTS.get());

        this.tag(LegumeDelightTags.NUT_BUTTER).add(LegumeDelightItems.PEANUT_BUTTER.get());
        this.tag(LegumeDelightTags.PEANUT_BUTTER).add(LegumeDelightItems.PEANUT_BUTTER.get());

        this.tag(ForgeTags.BERRIES); // establish tag exists before use
        this.tag(LegumeDelightTags.FRUITS).add(
                Items.APPLE,
                Items.MELON_SLICE,
                Items.CHORUS_FRUIT
        ).addTag(
                ForgeTags.BERRIES
        );

        this.tag(LegumeDelightTags.STORAGE_BLOCKS_ITEM_BEAN).add(LegumeDelightItems.BEAN_SACK.get());
        this.tag(LegumeDelightTags.STORAGE_BLOCKS_ITEM_PEANUT).add(LegumeDelightItems.PEANUT_SACK.get());

        // Farmer's Delight Tags
        this.tag(ModTags.MEALS).add(
                LegumeDelightItems.BAKED_BEANS.get(),
                LegumeDelightItems.BEAN_BURGER.get(),
                LegumeDelightItems.BEAN_BURRITO.get(),
                LegumeDelightItems.BEANS_AND_RICE.get(),
                LegumeDelightItems.BEANS_ON_TOAST.get(),
                LegumeDelightItems.CHILI.get(),
                //LegumeDelightItems.NACHOS.get(),
                LegumeDelightItems.PAD_THAI.get(),
                LegumeDelightItems.PASTA_WITH_TOMATO_SAUCE.get(),
                LegumeDelightItems.PEANUT_BUTTER_AND_JAM_SANDWICH.get(),
                LegumeDelightItems.POTATO_TACO.get()
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



        this.tag(LegumeDelightTags.DIET_PROTEINS).add(
                LegumeDelightItems.BEANS.get(),
                LegumeDelightItems.PEANUTS.get()
        ).addOptional(ResourceLocation.parse("culturaldelights:eggplant_parmesian"));;

        this.tag(LegumeDelightTags.DIET_GRAINS)
                .addOptional(ResourceLocation.parse("culturaldelights:corn_cob"))
                .addOptional(ResourceLocation.parse("culturaldelights:corn_kernels"))
                .addOptional(ResourceLocation.parse("culturaldelights:eggplant_parmesian"));

        this.tag(LegumeDelightTags.DIET_VEGETABLES)
                .addOptional(ResourceLocation.parse("culturaldelights:eggplant_parmesian"));

        // This doesn't seem to take effect even though the data generates right. Maybe due to load orders? I'll leave it in just in case.
        this.tag(LegumeDelightTags.DIET_VEGETABLES).remove(
                Items.PUMPKIN_SEEDS,
                Items.SUNFLOWER
        );
    }
}
