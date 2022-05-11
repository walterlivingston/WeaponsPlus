package com.greenone.weaponsplus;

import com.greenone.weaponsplus.common.item.WPItemModelProperties;
import com.greenone.weaponsplus.common.util.WPEventHandler;
import com.greenone.weaponsplus.data.DataGenerators;
import com.greenone.weaponsplus.common.init.Registration;
import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(WeaponsPlus.MOD_ID)
public class WeaponsPlus
{
    public static final String MOD_ID = "weaponsplus";
    public static final Logger LOGGER = LogUtils.getLogger();

    public WeaponsPlus() {
        MinecraftForge.EVENT_BUS.register(WPEventHandler.instance);

        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        eventBus.addListener(DataGenerators::gatherData);
        eventBus.addListener(this::clientSetup);
        Registration.init(eventBus);
    }

    private void commonSetup(final FMLCommonSetupEvent event) {

    }

    private void clientSetup(final FMLClientSetupEvent event) {
        WPItemModelProperties.registerProperties();
    }
}
