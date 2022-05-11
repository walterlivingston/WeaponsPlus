package com.greenone.weaponsplus.common.util;

import com.greenone.weaponsplus.WeaponsPlus;
import com.greenone.weaponsplus.common.capability.ISouls;
import com.greenone.weaponsplus.common.capability.Souls;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(modid = WeaponsPlus.MOD_ID)
public class WPEventHandler {
    public static final WPEventHandler instance = new WPEventHandler();

    @SubscribeEvent
    public void registerCapabilities(final RegisterCapabilitiesEvent event){
        event.register(ISouls.class);
    }

    @SubscribeEvent
    public void attachCapabilities(final AttachCapabilitiesEvent event) {
        if (!((event.getObject()) instanceof Player)) return;
        event.addCapability(new ResourceLocation(WeaponsPlus.MOD_ID, "souls"), new Souls());
    }
}
