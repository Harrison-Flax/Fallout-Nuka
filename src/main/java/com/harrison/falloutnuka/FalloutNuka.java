package com.harrison.falloutnuka;

import net.minecraft.world.item.Item;
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import com.mrcrayfish.guns.item.GunItem;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(FalloutNuka.MODID)
public class FalloutNuka
{
    // Define mod id in a common place for everything to reference
    public static final String MODID = "falloutnuka";

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<GunItem> FALLOUT_10MM = ITEMS.register("fallout_1_10mm",
            () -> new GunItem(new Item.Properties().stacksTo(1)));

    public FalloutNuka(FMLJavaModLoadingContext context) {
        IEventBus modEventBus = context.getModEventBus();
        ITEMS.register(modEventBus);
        modEventBus.addListener(this::addCreative);
    }

    private void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey().location().toString().equals("nukacraft:weapons")) {
            event.accept(FALLOUT_10MM);
        }
    }
}