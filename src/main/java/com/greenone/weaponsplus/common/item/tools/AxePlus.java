package com.greenone.weaponsplus.common.item.tools;

import com.greenone.weaponsplus.common.Metal;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

public class AxePlus extends AxeItem implements IMetalItem{
    private Metal metal = null;

    public AxePlus(Metal metalIn){
        this(metalIn.getTier(), 6.0F, -3.1F, (new Item.Properties()).tab(CreativeModeTab.TAB_TOOLS));
        metal = metalIn;
    }

    public AxePlus(Tier tier, float damage, float speed, Properties properties) {
        super(tier, damage, speed, properties);
    }

    @Override
    public Metal getMetal() {
        return metal;
    }

    @Override
    public boolean isFoil(@NotNull ItemStack stack) {
        return this.hasEffect() || super.isFoil(stack);
    }

    @Override
    public boolean hasEffect() {
        return metal.hasEffect();
    }
}
