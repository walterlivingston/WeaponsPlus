package com.greenone.weaponsplus;

import com.greenone.weaponsplus.init.Registration;
import net.minecraft.client.Minecraft;
import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.event.server.ServerStartedEvent;
import net.minecraftforge.event.server.ServerStartingEvent;
import net.minecraftforge.event.server.ServerStoppingEvent;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLDedicatedServerSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.jetbrains.annotations.Nullable;

public class SideProxy implements IProxy{
    private static MinecraftServer server;

    SideProxy(){
        FMLJavaModLoadingContext.get().getModEventBus().addListener(SideProxy::commonSetup);
    }

    private static void commonSetup(final FMLCommonSetupEvent event) {
        Registration.init();
    }

    private static void serverStarted(ServerStartedEvent event) {
        WeaponsPlus.LOGGER.info("Server Started");
        server = event.getServer();
    }

    private static void serverStarting(ServerStartingEvent event) {
    }

    private static void serverStopping(ServerStoppingEvent event) {
        WeaponsPlus.LOGGER.info("Server Stopped");
        server = null;
    }

    @Nullable
    @Override
    public Player getClientPlayer() {
        return Minecraft.getInstance().player;
    }

    @Nullable
    @Override
    public MinecraftServer getServer() {
        return server;
    }

    public static class Client extends SideProxy{
        public Client(){
            FMLJavaModLoadingContext.get().getModEventBus().addListener(Client::clientSetup);
        }

        private static void clientSetup(FMLClientSetupEvent event){

        }

        @Nullable
        @Override
        public Player getClientPlayer() {
            return Minecraft.getInstance().player;
        }
    }

    public static class Server extends SideProxy{
        public Server() {
            FMLJavaModLoadingContext.get().getModEventBus().addListener(this::serverSetup);
        }

        private void serverSetup(FMLDedicatedServerSetupEvent event) {

        }
    }
}
