package com.greenone.weaponsplus.common.init;

import com.greenone.weaponsplus.common.Metal;
import com.greenone.weaponsplus.common.item.WPArmorMaterials;
import com.greenone.weaponsplus.common.item.WPTiers;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Tiers;

import java.util.HashMap;
import java.util.Map;

public class Metals {
    public static Map<String, Metal> METALS = new HashMap();

    // Vanilla Metals
    public static final Metal COPPER = register(new Metal("copper", MetalType.VANILLA, WPTiers.COPPER, WPArmorMaterials.COPPER));
    public static final Metal IRON = register(new Metal("iron", MetalType.VANILLA, Tiers.IRON, ArmorMaterials.IRON));
    public static final Metal GOLD = register(new Metal("gold", MetalType.VANILLA, Tiers.GOLD, ArmorMaterials.GOLD));
    public static final Metal DIAMOND = register(new Metal("diamond", MetalType.VANILLA, Tiers.DIAMOND, ArmorMaterials.DIAMOND));
    public static final Metal NETHERITE = register(new Metal("netherite", MetalType.VANILLA, Tiers.NETHERITE, ArmorMaterials.NETHERITE));

    public static final Metal TIN = register(new Metal("tin", MetalType.PURE, WPTiers.TIN, WPArmorMaterials.TIN));

    public static void init(){  }

    public static Metal register(Metal metal){
        METALS.put(metal.tagName(), metal);
        return metal;
    }
}
