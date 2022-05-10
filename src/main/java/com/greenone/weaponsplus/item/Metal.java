package com.greenone.weaponsplus.item;

import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;

public class Metal {
    private final String name;
    private final MetalType type;
    private final Tier tier;
    private final ArmorMaterial armorMat;
    private final Material mat;
    private final MaterialColor matColor;
    private final float destroyTime;
    private final float explosionResistance;
    private final boolean hasDeepslate;

    Metal(String nameIn, MetalType typeIn, Tier tierIn, ArmorMaterial armorMatIn) {
        this(nameIn, typeIn, tierIn, armorMatIn, Material.METAL, MaterialColor.METAL, 5.0F, 6.0F, true);
    }

    Metal(String nameIn, MetalType typeIn, Tier tierIn, ArmorMaterial armorMatIn, Material matIn, MaterialColor matColorIn, float destroyTimeIn, float explosionResistanceIn, boolean hasDeepslateIn){
        name = nameIn;
        type = typeIn;
        tier = tierIn;
        armorMat = armorMatIn;
        mat = matIn;
        matColor = matColorIn;
        destroyTime = destroyTimeIn;
        explosionResistance = explosionResistanceIn;
        hasDeepslate = hasDeepslateIn;
    }

    public String getName() {
        return this.name;
    }

    public MetalType getType() {
        return this.type;
    }

    public Tier getTier() {
        return this.tier;
    }

    public ArmorMaterial getArmorMaterial() {
        return this.armorMat;
    }

    public Material getMaterial() {
        return this.mat;
    }

    public MaterialColor getColor() {
        return this.matColor;
    }

    public float getDestroyTime() {
        return this.destroyTime;
    }

    public float getExplosionResistance() {
        return this.explosionResistance;
    }

    public boolean hasOre(){
        return this.type.hasOre();
    }

    public boolean hasDeepslate(){
        return this.hasOre() && this.hasDeepslate;
    }

    public boolean isVanilla(){
        return this.type.isVanilla();
    }

    public boolean hasEffect() { return this.type == MetalType.BLESSED; }
}
