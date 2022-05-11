package com.greenone.weaponsplus.item.tools;

import com.greenone.weaponsplus.Metal;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

public class SwordPlus extends SwordItem implements IMetalItem{
    private Metal metal = null;

    public SwordPlus(Metal metalIn){
        this(metalIn.getTier(), 3, -2.4F, (new Item.Properties().tab(CreativeModeTab.TAB_COMBAT)));
        metal = metalIn;
    }

    public SwordPlus(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
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
        return false;
    }
}
