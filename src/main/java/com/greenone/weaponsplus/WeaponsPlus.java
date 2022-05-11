package com.greenone.weaponsplus;

import com.greenone.weaponsplus.data.DataGenerators;
import com.greenone.weaponsplus.common.init.Registration;
import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.slf4j.Logger;

@Mod(WeaponsPlus.MOD_ID)
public class WeaponsPlus
{
    public static final String MOD_ID = "weaponsplus";
    public static final Logger LOGGER = LogUtils.getLogger();

    public WeaponsPlus() {
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();
        Registration.init(eventBus);
        eventBus.addListener(DataGenerators::gatherData);
    }

    private void setup(final FMLCommonSetupEvent event) {

    }
}
