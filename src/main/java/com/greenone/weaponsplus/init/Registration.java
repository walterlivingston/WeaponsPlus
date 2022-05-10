package com.greenone.weaponsplus.init;

import com.greenone.weaponsplus.item.Metals;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class Registration {
    public static void init(){
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        WPBlocks.init(eventBus);
        WPItems.init(eventBus);
        Metals.register(eventBus);
    }
}
