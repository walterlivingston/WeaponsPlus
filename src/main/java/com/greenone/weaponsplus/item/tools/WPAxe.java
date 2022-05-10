package com.greenone.weaponsplus.item.tools;

import com.greenone.weaponsplus.item.Metal;
import net.minecraft.world.item.*;

public class WPAxe extends AxeItem implements IMetalItem {
    private Metal metal = null;

    public WPAxe(Metal metalIn){
        this(metalIn.getTier(), 6.0F, -3.1F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS));
        metal = metalIn;
    }

    public WPAxe(Tier tier, float damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public Metal getMetal() {
        return metal;
    }

    @Override
    public boolean isFoil(ItemStack p_41453_) {
        return this.hasEffect() || super.isFoil(p_41453_);
    }

    @Override
    public boolean hasEffect() {
        return metal.hasEffect();
    }
}
