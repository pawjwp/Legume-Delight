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
        Set<Item> items = ForgeRegistries.ITEMS.getValues().stream().filter(i -> LegumeDelight.MOD_ID.equals(ForgeRegistries.ITEMS.getKey(i).getNamespace()))
                .collect(Collectors.toSet());

        // If needed in the future, exclude specific items here
        // items.remove(LegumeDelightItems.BEANS.get());

        // Blocks with special item sprites, all seeds and feasts go here
        Set<Item> spriteBlockItems = Sets.newHashSet(
                LegumeDelightItems.BEANS.get(),
                LegumeDelightItems.PEANUTS.get()
        );
        takeAll(items, spriteBlockItems.toArray(new Item[0])).forEach(item -> withExistingParent(itemName(item), GENERATED).texture("layer0", resourceItem(itemName(item))));

        // Blocks with flat block textures for their items
        Set<Item> flatBlockItems = Sets.newHashSet(
                LegumeDelightItems.WILD_BEANS.get(),
                LegumeDelightItems.WILD_PEANUTS.get()
        );
        takeAll(items, flatBlockItems.toArray(new Item[0])).forEach(item -> itemGeneratedModel(item, resourceBlock(itemName(item))));

        // Blocks whose items look alike
        takeAll(items, i -> i instanceof BlockItem).forEach(item -> blockBasedModel(item, ""));

        items.forEach(item -> itemGeneratedModel(item, resourceItem(itemName(item))));
    }

    private String itemName(Item item) {
        return ForgeRegistries.ITEMS.getKey(item).getPath();
    }

    public void blockBasedModel(Item item, String suffix) {
        withExistingParent(itemName(item), resourceBlock(itemName(item) + suffix));
    }

    public void itemGeneratedModel(Item item, ResourceLocation texture) {
        withExistingParent(itemName(item), GENERATED).texture("layer0", texture);
    }

    public ResourceLocation resourceBlock(String path) {
        return ResourceLocation.fromNamespaceAndPath(LegumeDelight.MOD_ID, "block/" + path);
    }

    public ResourceLocation resourceItem(String path) {
        return ResourceLocation.fromNamespaceAndPath(LegumeDelight.MOD_ID, "item/" + path);
    }
}
