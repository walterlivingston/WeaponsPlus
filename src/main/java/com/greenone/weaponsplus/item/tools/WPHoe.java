package com.greenone.weaponsplus.item.tools;

import com.greenone.weaponsplus.item.Metal;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

public class WPHoe extends HoeItem implements IMetalItem {
    private Metal metal = null;

    public WPHoe(Metal metalIn){
        this(metalIn.getTier(), -2, -1.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS));
        metal = metalIn;
    }

    public WPHoe(Tier tier, int damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public Metal getMetal() {
        return metal;
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
