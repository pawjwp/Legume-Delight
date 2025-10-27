package net.pawjwp.legumedelight.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.RegistryObject;
import net.pawjwp.legumedelight.block.LegumeDelightBlocks;
import net.pawjwp.legumedelight.block.PeanutBlock;
import net.pawjwp.legumedelight.item.LegumeDelightItems;

import java.util.Set;

public class LegumeDelightBlockLootTables extends BlockLootSubProvider {
    public LegumeDelightBlockLootTables() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(LegumeDelightBlocks.BEAN_SACK.get());
        this.dropSelf(LegumeDelightBlocks.PEANUT_SACK.get());

        this.dropOther(LegumeDelightBlocks.BUDDING_BEAN_CROP.get(), LegumeDelightItems.BEANS.get());

        LootItemCondition.Builder beansLootable = LootItemBlockStatePropertyCondition.hasBlockStateProperties(LegumeDelightBlocks.BEAN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PeanutBlock.AGE, 7));
        this.add(LegumeDelightBlocks.BEAN_CROP.get(), this.applyExplosionDecay(LegumeDelightBlocks.BEAN_CROP.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(LegumeDelightItems.BEANS.get()))
                        )
                        .withPool(LootPool.lootPool()
                                .when(beansLootable)
                                .add(LootItem.lootTableItem(LegumeDelightItems.BEANS.get())
                                        .apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))
                                )
                        )
        ));

        LootItemCondition.Builder peanutsLootable = LootItemBlockStatePropertyCondition.hasBlockStateProperties(LegumeDelightBlocks.PEANUT_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(PeanutBlock.AGE, 7));
        this.add(LegumeDelightBlocks.PEANUT_CROP.get(), this.applyExplosionDecay(LegumeDelightBlocks.PEANUT_CROP.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(LegumeDelightItems.PEANUTS.get()))
                        )
                        .withPool(LootPool.lootPool()
                                .when(peanutsLootable)
                                .add(LootItem.lootTableItem(LegumeDelightItems.PEANUTS.get())
                                        .apply(ApplyBonusCount.addBonusBinomialDistributionCount(Enchantments.BLOCK_FORTUNE, 0.5714286F, 3))
                                )
                        )
        ));

        this.add(LegumeDelightBlocks.WILD_BEANS.get(),
                createShearsDispatchTable(LegumeDelightBlocks.WILD_BEANS.get(),this.applyExplosionDecay(LegumeDelightBlocks.WILD_BEANS.get(),
                        LootItem.lootTableItem(LegumeDelightItems.BEANS.get())
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2))
                ))
        );

        this.add(LegumeDelightBlocks.WILD_PEANUTS.get(),
                createShearsDispatchTable(LegumeDelightBlocks.WILD_PEANUTS.get(),this.applyExplosionDecay(LegumeDelightBlocks.WILD_PEANUTS.get(),
                        LootItem.lootTableItem(LegumeDelightItems.PEANUTS.get())
                                .apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE, 2))
                ))
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return LegumeDelightBlocks.BLOCKS.getEntries().stream().map(RegistryObject::get)::iterator;
    }
}