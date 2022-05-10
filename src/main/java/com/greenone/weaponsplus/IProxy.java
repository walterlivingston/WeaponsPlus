package com.greenone.weaponsplus;

import net.minecraft.server.MinecraftServer;
import net.minecraft.world.entity.player.Player;

import javax.annotation.Nullable;

public interface IProxy {
    @Nullable
    Player getClientPlayer();

    @Nullable
    MinecraftServer getServer();
}
