package net.pawjwp.legumedelight.datagen;

import net.minecraft.data.PackOutput;
import net.minecraft.data.loot.LootTableProvider;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.pawjwp.legumedelight.datagen.loot.LegumeDelightBlockLootTables;

import java.util.List;
import java.util.Set;

public class LegumeDelightLootTables {
    public static LootTableProvider create(PackOutput output) {
        return new LootTableProvider(output, Set.of(), List.of(
                new LootTableProvider.SubProviderEntry(LegumeDelightBlockLootTables::new, LootContextParamSets.BLOCK)
        ));
    }
}