package com.greenone.weaponsplus.common.item.tools;

import com.greenone.weaponsplus.common.Metal;
import net.minecraft.world.item.*;

public class ShovelPlus extends ShovelItem implements IMetalItem {
    private Metal metal = null;

    public ShovelPlus(Metal metalIn){
        this(metalIn.getTier(), 1.5F, -3.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS));
        metal = metalIn;
    }

    public ShovelPlus(Tier tier, float damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public Metal getMetal() {
        return this.metal;
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return this.hasEffect() || super.isFoil(p_41453_);
    }

    @Override
    public boolean hasEffect() {
        return this.metal.hasEffect();
    }
}
