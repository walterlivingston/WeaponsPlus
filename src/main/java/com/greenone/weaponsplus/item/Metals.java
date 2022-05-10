package com.greenone.weaponsplus.item;

import com.greenone.weaponsplus.init.Registries;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ArmorMaterials;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraftforge.eventbus.api.IEventBus;

public class Metals {

    public static final Metal COPPER = registerMetal("copper", MetalType.VANILLA, WPTiers.COPPER, WPArmorMaterials.COPPER);
    public static final Metal IRON = registerMetal("iron", MetalType.VANILLA, Tiers.IRON, ArmorMaterials.IRON);
    public static final Metal GOLD = registerMetal("gold", MetalType.VANILLA, Tiers.GOLD, ArmorMaterials.GOLD);
    public static final Metal DIAMOND = registerMetal("diamond", MetalType.VANILLA, Tiers.DIAMOND, ArmorMaterials.DIAMOND);
    public static final Metal NETHERITE = registerMetal("netherite", MetalType.VANILLA, Tiers.NETHERITE, ArmorMaterials.NETHERITE);

    public static void register(IEventBus eventBus){
        Registries.METALS.register(eventBus);
    }

    public static Metal registerMetal(String name, MetalType type, Tier tier, ArmorMaterial material){
        Metal ret = new Metal(name, type, tier, material);
        Registries.METALS.register(name, () -> ret);
        return ret;
    }
}
