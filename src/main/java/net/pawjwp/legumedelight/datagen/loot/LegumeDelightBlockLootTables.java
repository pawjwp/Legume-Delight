package net.pawjwp.legumedelight.datagen.loot;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.pawjwp.legumedelight.block.BeanVineBlock;
import net.pawjwp.legumedelight.block.LegumeDelightBlocks;
import net.pawjwp.legumedelight.block.PeanutBlock;
import net.pawjwp.legumedelight.item.LegumeDelightItems;

import java.util.Set;
import java.util.stream.Collectors;

public class LegumeDelightBlockLootTables extends BlockLootSubProvider {
    public LegumeDelightBlockLootTables(HolderLookup.Provider registries) {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags(), registries);
    }

    @Override
    protected void generate() {
        HolderLookup.RegistryLookup<Enchantment> registryLookup = this.registries.lookupOrThrow(Registries.ENCHANTMENT);

        this.dropSelf(LegumeDelightBlocks.BEAN_SACK.get());
        this.dropSelf(LegumeDelightBlocks.PEANUT_SACK.get());

        this.dropOther(LegumeDelightBlocks.BUDDING_BEAN_CROP.get(), LegumeDelightItems.BEANS.get());

        LootItemCondition.Builder beansLootable = LootItemBlockStatePropertyCondition.hasBlockStateProperties(LegumeDelightBlocks.BEAN_CROP.get())
                .setProperties(StatePropertiesPredicate.Builder.properties()
                        .hasProperty(BeanVineBlock.VINE_AGE, 3)
                        .hasProperty(BeanVineBlock.ROPELOGGED, false));
        this.add(LegumeDelightBlocks.BEAN_CROP.get(), this.applyExplosionDecay(LegumeDelightBlocks.BEAN_CROP.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(LegumeDelightItems.BEANS.get()))
                        )
                        .withPool(LootPool.lootPool()
                                .when(beansLootable)
                                .add(LootItem.lootTableItem(LegumeDelightItems.BEANS.get())
                                        .apply(ApplyBonusCount.addBonusBinomialDistributionCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3))
                                )
                        )
        ));

        LootItemCondition.Builder beansOnRopeLootable = LootItemBlockStatePropertyCondition.hasBlockStateProperties(LegumeDelightBlocks.BEAN_CROP_ON_ROPE.get())
                .setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(BeanVineBlock.VINE_AGE, 3));
        this.add(LegumeDelightBlocks.BEAN_CROP_ON_ROPE.get(), this.applyExplosionDecay(LegumeDelightBlocks.BEAN_CROP_ON_ROPE.get(),
                LootTable.lootTable()
                        .withPool(LootPool.lootPool()
                                .add(LootItem.lootTableItem(LegumeDelightItems.BEANS.get()))
                        )
                        .withPool(LootPool.lootPool()
                                .when(beansOnRopeLootable)
                                .add(LootItem.lootTableItem(LegumeDelightItems.BEANS.get())
                                        .apply(ApplyBonusCount.addBonusBinomialDistributionCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3))
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
                                        .apply(ApplyBonusCount.addBonusBinomialDistributionCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 0.5714286F, 3))
                                )
                        )
        ));

        this.add(LegumeDelightBlocks.WILD_BEANS.get(),
                createShearsDispatchTable(LegumeDelightBlocks.WILD_BEANS.get(),this.applyExplosionDecay(LegumeDelightBlocks.WILD_BEANS.get(),
                        LootItem.lootTableItem(LegumeDelightItems.BEANS.get())
                                .apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 2))
                ))
        );

        this.add(LegumeDelightBlocks.WILD_PEANUTS.get(),
                createShearsDispatchTable(LegumeDelightBlocks.WILD_PEANUTS.get(),this.applyExplosionDecay(LegumeDelightBlocks.WILD_PEANUTS.get(),
                        LootItem.lootTableItem(LegumeDelightItems.PEANUTS.get())
                                .apply(ApplyBonusCount.addUniformBonusCount(registryLookup.getOrThrow(Enchantments.FORTUNE), 2))
                ))
        );
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return LegumeDelightBlocks.BLOCKS.getEntries().stream().map(DeferredHolder::value).collect(Collectors.toList());
    }
}