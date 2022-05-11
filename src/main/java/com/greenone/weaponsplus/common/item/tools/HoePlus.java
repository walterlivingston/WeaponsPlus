package com.greenone.weaponsplus.common.item.tools;

import com.greenone.weaponsplus.common.Metal;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

public class HoePlus extends HoeItem implements IMetalItem {
    private Metal metal = null;

    public HoePlus(Metal metalIn){
        this(metalIn.getTier(), -2, -1.0F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS));
        metal = metalIn;
    }

    public HoePlus(Tier tier, int damage, float speed, Properties properties) {
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
        return this.metal.hasEffect();
    }
}
