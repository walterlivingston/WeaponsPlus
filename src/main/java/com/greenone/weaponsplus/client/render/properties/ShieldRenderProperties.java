package com.greenone.weaponsplus.client.render.properties;

import com.greenone.weaponsplus.client.render.ShieldRenderer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockEntityWithoutLevelRenderer;
import net.minecraftforge.client.IItemRenderProperties;

public class ShieldRenderProperties implements IItemRenderProperties {
    @Override
    public BlockEntityWithoutLevelRenderer getItemStackRenderer() {
        return new ShieldRenderer(Minecraft.getInstance().getBlockEntityRenderDispatcher(), Minecraft.getInstance().getEntityModels());
    }
}
