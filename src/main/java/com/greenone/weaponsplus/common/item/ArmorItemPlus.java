package com.greenone.weaponsplus.common.item;

import com.greenone.weaponsplus.common.Metal;
import com.greenone.weaponsplus.common.item.tools.IMetalItem;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.*;
import org.jetbrains.annotations.NotNull;

public class ArmorItemPlus extends ArmorItem implements IMetalItem {
    private Metal metal = null;

    public ArmorItemPlus(Metal metalIn, EquipmentSlot slot){
        this(metalIn.getArmorMaterial(), slot, (new Item.Properties()).tab(CreativeModeTab.TAB_COMBAT));
        this.metal = metalIn;
    }

    public ArmorItemPlus(ArmorMaterial armorMaterial, EquipmentSlot slot, Properties properties) {
        super(armorMaterial, slot, properties);
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
