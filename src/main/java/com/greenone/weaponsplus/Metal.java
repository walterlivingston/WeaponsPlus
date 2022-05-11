package com.greenone.weaponsplus;

import com.greenone.weaponsplus.init.MetalType;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class Metal implements IMetal{
    private final String name;
    private final MetalType type;
    private final Tier tier;
    private final ArmorMaterial armorMaterial;
    private final Material material;
    private final MaterialColor materialColor;
    private final float destroyTime;
    private final float explosionResistance;
    private final boolean hasDeepslate;

    public Metal(String nameIn, MetalType typeIn, Tier tierIn, ArmorMaterial armorMatIn) {
        this(nameIn, typeIn, tierIn, armorMatIn, Material.METAL, MaterialColor.METAL, 5.0F, 6.0F, true);
    }

    Metal(String nameIn, MetalType typeIn, Tier tierIn, ArmorMaterial armorMatIn, Material matIn, MaterialColor matColorIn, float destroyTimeIn, float explosionResistanceIn, boolean hasDeepslateIn){
        name = nameIn;
        type = typeIn;
        tier = tierIn;
        armorMaterial = armorMatIn;
        material = matIn;
        materialColor = matColorIn;
        destroyTime = destroyTimeIn;
        explosionResistance = explosionResistanceIn;
        hasDeepslate = hasDeepslateIn;
    }

    @Override
    public String tagName() {
        return name;
    }

    @Override
    public MetalType getType() {
        return type;
    }

    @Override
    public Tier getTier() {
        return tier;
    }

    @Override
    public ArmorMaterial getArmorMaterial() {
        return armorMaterial;
    }

    @Override
    public Material getMaterial() {
        return material;
    }

    @Override
    public MaterialColor getColor() {
        return materialColor;
    }

    @Override
    public float getDestroyTime() {
        return destroyTime;
    }

    @Override
    public float getExplosionResistance() {
        return explosionResistance;
    }

    @Override
    public boolean hasOre() {
        return !type.isVanilla();
    }

    @Override
    public boolean hasDeepslate() {
        return hasDeepslate;
    }

    @Override
    public boolean isVanilla() {
        return type.isVanilla();
    }

    @Override
    public boolean hasEffect() {
        return type.hasEffect();
    }
}
