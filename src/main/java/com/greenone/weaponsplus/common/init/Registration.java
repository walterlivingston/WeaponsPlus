package com.greenone.weaponsplus.common.init;

import net.minecraftforge.eventbus.api.IEventBus;

public class Registration {

    public static void init(IEventBus eventBus){
        Metals.init();

        WPBlocks.init(eventBus);
        WPItems.init(eventBus);
    }
}
