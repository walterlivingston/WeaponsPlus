package com.greenone.weaponsplus.init;

import com.greenone.weaponsplus.Metal;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Metals {
    public static Map<String, Metal> METALS = new HashMap();

    // Vanilla Metals
    public static final Metal COPPER = register(new Metal("copper", MetalType.VANILLA, Tiers.IRON, ArmorMaterials.IRON));
    public static final Metal IRON = register(new Metal("iron", MetalType.VANILLA, Tiers.IRON, ArmorMaterials.IRON));
    public static final Metal GOLD = register(new Metal("gold", MetalType.VANILLA, Tiers.GOLD, ArmorMaterials.GOLD));
    public static final Metal DIAMOND = register(new Metal("diamond", MetalType.VANILLA, Tiers.DIAMOND, ArmorMaterials.DIAMOND));
    public static final Metal NETHERITE = register(new Metal("netherite", MetalType.VANILLA, Tiers.NETHERITE, ArmorMaterials.NETHERITE));

    public static final Metal TIN = register(new Metal("tin", MetalType.PURE, Tiers.IRON, ArmorMaterials.IRON));

    public static void init(){  }

    public static Metal register(Metal metal){
        METALS.put(metal.tagName(), metal);
        return metal;
    }
}
