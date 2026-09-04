package net.pawjwp.legumedelight.block;

import net.minecraft.core.registries.Registries;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.pawjwp.legumedelight.LegumeDelight;
import vectorwing.farmersdelight.common.block.WildCropBlock;

import java.util.function.Supplier;

public class LegumeDelightBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(Registries.BLOCK, LegumeDelight.MOD_ID);


    // Sacks
    public static final Supplier<Block> BEAN_SACK = BLOCKS.register("bean_sack",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.5F).sound(SoundType.WOOL).mapColor(MapColor.COLOR_BROWN)));
    public static final Supplier<Block> PEANUT_SACK = BLOCKS.register("peanut_sack",
            () -> new Block(Block.Properties.ofFullCopy(Blocks.WHITE_WOOL).strength(0.5F).sound(SoundType.WOOL).mapColor(MapColor.COLOR_BROWN)));

    // Wild Crops
    public static final Supplier<Block> WILD_BEANS = BLOCKS.register("wild_beans",
            () -> new WildCropBlock(MobEffects.DIG_SPEED, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));
    public static final Supplier<Block> WILD_PEANUTS = BLOCKS.register("wild_peanuts",
            () -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, Block.Properties.ofFullCopy(Blocks.TALL_GRASS)));

    // Crops
    public static final Supplier<Block> BUDDING_BEAN_CROP = BLOCKS.register("budding_beans",
            () -> new BuddingBeanBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final Supplier<Block> BEAN_CROP = BLOCKS.register("beans",
            () -> new BeanVineBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));
    public static final Supplier<Block> BEAN_CROP_ON_ROPE = BLOCKS.register("beans_on_rope",
            () -> new HangingBeanBlock(Block.Properties.ofFullCopy(BEAN_CROP.get()).pushReaction(PushReaction.NORMAL)));
    public static final Supplier<Block> PEANUT_CROP = BLOCKS.register("peanuts",
            () -> new PeanutBlock(Block.Properties.ofFullCopy(Blocks.WHEAT)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
