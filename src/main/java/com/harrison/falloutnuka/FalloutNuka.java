package com.harrison.falloutnuka;

import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FalloutNuka.MODID)
public class FalloutNuka
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "falloutnuka";

    // Holding the item
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    // Registering the pistol name
    public static final RegistryObject<Item> FALLOUT_10MM = ITEMS.register("fallout_1_10mm",
            () -> new Item(new Item.Properties()));

    // Constructor for defining the item in the game
    public FalloutNuka(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();

        ITEMS.register(modEventBus);

        // Adds to creative mode menu
        modEventBus.addListener(this::addCreative);
    }

    // Pistol will be in combat tab
    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == CreativeModeTabs.COMBAT) {
            event.accept(FALLOUT_10MM);
        }
    }
}
