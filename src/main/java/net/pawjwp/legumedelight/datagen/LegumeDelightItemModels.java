package net.pawjwp.legumedelight.datagen;

import com.google.common.collect.Sets;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.pawjwp.legumedelight.LegumeDelight;
import net.pawjwp.legumedelight.item.LegumeDelightItems;

import java.util.Set;
import java.util.stream.Collectors;

import static vectorwing.farmersdelight.data.ItemModels.takeAll;

public class LegumeDelightItemModels extends ItemModelProvider {
    public static final String GENERATED = "item/generated";

    public LegumeDelightItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, LegumeDelight.MOD_ID, existingFileHelper);
    }

    @Override
    protected void registerModels() {

    }
}
