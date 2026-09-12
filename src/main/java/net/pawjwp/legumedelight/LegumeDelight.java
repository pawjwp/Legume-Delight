package net.pawjwp.legumedelight;

import com.mojang.logging.LogUtils;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.pawjwp.legumedelight.item.LegumeDelightItems;
import net.pawjwp.legumedelight.block.LegumeDelightBlocks;
import org.slf4j.Logger;
import vectorwing.farmersdelight.common.registry.ModCreativeTabs;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(LegumeDelight.MOD_ID)
public class LegumeDelight
{
    // Define mod id in a common place for everything to reference
    public static final String MOD_ID = "legumedelight";
    // Directly reference a slf4j logger
    private static final Logger LOGGER = LogUtils.getLogger();

    public LegumeDelight(FMLJavaModLoadingContext context)
    {
        IEventBus modEventBus = context.getModEventBus();

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
        if(event.getTabKey() == ModCreativeTabs.TAB_FARMERS_DELIGHT.getKey()) {
            LegumeDelightItems.CREATIVE_TAB_ITEMS.forEach(event::accept);
        }
    }
}
