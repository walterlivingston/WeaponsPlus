package com.greenone.weaponsplus.common.item.tools;

import com.greenone.weaponsplus.client.render.properties.ShieldRenderProperties;
import com.greenone.weaponsplus.common.Metal;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShieldItem;
import org.jetbrains.annotations.NotNull;

public class ShieldPlus extends ShieldItem implements IMetalItem {
    private Metal metal = null;

    public ShieldPlus(Metal metalIn){
        this((new Item.Properties()).durability(metalIn.getTier().getUses() + 336).tab(CreativeModeTab.TAB_COMBAT));
        this.metal = metalIn;
    }

    public ShieldPlus(Properties p_43089_) {
        super(p_43089_);
    }

    public int getUseDuration(ItemStack stack) {
        return (int) (72000 - (getMetal().getTier().getSpeed()*20));
    }

    @Override
    public Metal getMetal() {
        return this.metal;
    }

    @Override
    public boolean isFoil(@NotNull ItemStack stack) {
        return this.hasEffect() || super.isFoil(stack);
    }

    @Override
    public boolean hasEffect() {
        return this.metal.hasEffect();
    }

    @Override
    public @NotNull Object getRenderPropertiesInternal() {
        return new ShieldRenderProperties();
    }
}
