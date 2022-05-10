package com.greenone.weaponsplus.item.tools;

import com.greenone.weaponsplus.item.Metal;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

public class WPSword extends SwordItem implements IMetalItem{
    private Metal metal = null;

    public WPSword(Metal metalIn){
        this(metalIn.getTier(), 3, -2.4F, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT));
        this.metal = metalIn;
    }

    public WPSword(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public Metal getMetal() {
        return this.metal;
    }

    @Override
    public boolean isFoil(@NotNull ItemStack p_41453_) {
        return this.hasEffect() || super.isFoil(p_41453_);
    }

    @Override
    public boolean hasEffect() {
        return metal.hasEffect();
    }
}
