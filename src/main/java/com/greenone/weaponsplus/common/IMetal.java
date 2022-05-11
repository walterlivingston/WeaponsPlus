package com.greenone.weaponsplus.common;

import com.greenone.weaponsplus.common.init.MetalType;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public interface IMetal {
    String tagName();
    MetalType getType();
    Tier getTier();
    ArmorMaterial getArmorMaterial();
    Material getMaterial();
    MaterialColor getColor();
    float getDestroyTime();
    float getExplosionResistance();
    boolean hasOre();
    boolean hasDeepslate();
    boolean isVanilla();
    boolean hasEffect();
}
