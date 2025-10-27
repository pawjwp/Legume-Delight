package net.pawjwp.legumedelight.datagen;

import net.pawjwp.legumedelight.LegumeDelight;
import net.minecraft.data.DataGenerator;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

import java.util.concurrent.CompletableFuture;

@Mod.EventBusSubscriber(modid = LegumeDelight.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event) {
        DataGenerator generator = event.getGenerator();
        PackOutput packOutput = generator.getPackOutput();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();
        CompletableFuture<HolderLookup.Provider> lookupProvider = event.getLookupProvider();

        generator.addProvider(event.includeServer(), new LegumeDelightRecipes(packOutput));
        generator.addProvider(event.includeServer(), LegumeDelightLootTables.create(packOutput));

        generator.addProvider(event.includeClient(), new LegumeDelightBlockStates(packOutput, existingFileHelper));
        generator.addProvider(event.includeClient(), new LegumeDelightItemModels(packOutput, existingFileHelper));

        LegumeDelightBlockTags blockTagGenerator = generator.addProvider(event.includeServer(),
                new LegumeDelightBlockTags(packOutput, lookupProvider, existingFileHelper));
        generator.addProvider(event.includeServer(), new LegumeDelightItemTags(packOutput, lookupProvider, blockTagGenerator.contentsGetter(), existingFileHelper));
    }
}
