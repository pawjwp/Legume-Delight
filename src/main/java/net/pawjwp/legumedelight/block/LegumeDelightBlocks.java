package net.pawjwp.legumedelight.block;

import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.material.MapColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import net.pawjwp.legumedelight.LegumeDelight;
import vectorwing.farmersdelight.common.block.WildCropBlock;

public class LegumeDelightBlocks {
    public static final DeferredRegister<Block> BLOCKS =
            DeferredRegister.create(ForgeRegistries.BLOCKS, LegumeDelight.MOD_ID);


    // Sacks
    public static final RegistryObject<Block> BEAN_SACK = BLOCKS.register("bean_sack",
            () -> new Block(Block.Properties.copy(Blocks.WHITE_WOOL).strength(0.5F).sound(SoundType.WOOL).mapColor(MapColor.COLOR_BROWN)));
    public static final RegistryObject<Block> PEANUT_SACK = BLOCKS.register("peanut_sack",
            () -> new Block(Block.Properties.copy(Blocks.WHITE_WOOL).strength(0.5F).sound(SoundType.WOOL).mapColor(MapColor.COLOR_BROWN)));

    // Wild Crops
    public static final RegistryObject<Block> WILD_BEANS = BLOCKS.register("wild_beans",
            () -> new WildCropBlock(MobEffects.DIG_SPEED, 6, Block.Properties.copy(Blocks.TALL_GRASS)));
    public static final RegistryObject<Block> WILD_PEANUTS = BLOCKS.register("wild_peanuts",
            () -> new WildCropBlock(MobEffects.DAMAGE_BOOST, 6, Block.Properties.copy(Blocks.TALL_GRASS)));

    // Crops
    public static final RegistryObject<Block> BUDDING_BEAN_CROP = BLOCKS.register("budding_beans",
            () -> new BuddingBeanBlock(Block.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> BEAN_CROP = BLOCKS.register("beans",
            () -> new BeanVineBlock(Block.Properties.copy(Blocks.WHEAT)));
    public static final RegistryObject<Block> PEANUT_CROP = BLOCKS.register("peanuts",
            () -> new PeanutBlock(Block.Properties.copy(Blocks.WHEAT)));

    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
