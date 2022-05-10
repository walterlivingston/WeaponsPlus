package com.greenone.weaponsplus;

import com.mojang.logging.LogUtils;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import org.slf4j.Logger;

@Mod(WeaponsPlus.MOD_ID)
public class WeaponsPlus
{
    public static final String MOD_ID = "weaponsplus";
    public static final Logger LOGGER = LogUtils.getLogger();

    public WeaponsPlus()
    {
        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event)
    {

    }
}
