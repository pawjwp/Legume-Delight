package net.pawjwp.legumedelight;

import org.slf4j.Logger;

import com.mojang.logging.LogUtils;

import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.ModContainer;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;

import net.pawjwp.legumedelight.block.LegumeDelightBlocks;
import net.pawjwp.legumedelight.item.LegumeDelightItems;

import vectorwing.farmersdelight.common.registry.ModCreativeTabs;

// The value here should match an entry in the META-INF/neoforge.mods.toml file
@Mod(LegumeDelight.MOD_ID)
public class LegumeDelight {
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "legumedelight";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public LegumeDelight(IEventBus modEventBus, ModContainer modContainer)
    {
        LegumeDelightItems.register(modEventBus);
        LegumeDelightBlocks.register(modEventBus);

        // Register the commonSetup method for modloading
        modEventBus.addListener(this::commonSetup);

        // Register the item to a creative tab
        modEventBus.addListener(this::addCreative);
    }

    private void commonSetup(final FMLCommonSetupEvent event)
    {
        LOGGER.info("Legume Delight loaded");
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event)
    {
        if(event.getTab() == ModCreativeTabs.TAB_FARMERS_DELIGHT.get()) {
            LegumeDelightItems.CREATIVE_TAB_ITEMS.forEach(item -> event.accept(item.get()));
        }
    }
}
