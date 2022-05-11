package com.greenone.weaponsplus.init;

import com.greenone.weaponsplus.Metal;
import com.greenone.weaponsplus.WeaponsPlus;
import com.greenone.weaponsplus.item.tools.SwordPlus;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class WPItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WeaponsPlus.MOD_ID);

    public static Map<Metal, RegistryObject<Item>> ingots = new HashMap<>();
    public static Map<Metal, RegistryObject<Item>> raw = new HashMap<>();
    public static Map<Metal, RegistryObject<Item>> nuggets = new HashMap<>();
    public static Map<Metal, RegistryObject<Item>> swords = new HashMap<>();
    public static Map<Metal, RegistryObject<Item>> axes = new HashMap<>();
    public static Map<Metal, RegistryObject<Item>> pickaxes = new HashMap<>();
    public static Map<Metal, RegistryObject<Item>> shovels = new HashMap<>();
    public static Map<Metal, RegistryObject<Item>> hoes = new HashMap<>();
    public static Map<Metal, RegistryObject<Item>> helmets = new HashMap<>();
    public static Map<Metal, RegistryObject<Item>> chestplates = new HashMap<>();
    public static Map<Metal, RegistryObject<Item>> leggings = new HashMap<>();
    public static Map<Metal, RegistryObject<Item>> boots = new HashMap<>();

    public static void init(IEventBus eventBus){

        for(Metal m : Metals.METALS.values()){
            if(!m.isVanilla() || m.equals(Metals.COPPER)){
                if(!m.equals(Metals.COPPER)) {
                    raw.put(m, ITEMS.register("raw_" + m.tagName(), () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS))));
                    ingots.put(m, ITEMS.register(m.tagName() + "_ingot", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS))));
                }
                nuggets.put(m, ITEMS.register(m.tagName() + "_nugget", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS))));

                // Register vanilla weapon types
                swords.put(m, ITEMS.register(m.tagName() + "_sword", () -> new SwordPlus(m)));
//                axes.put(m, registerItem(m.tagName() + "_axe", new WPAxe(m)));
//                pickaxes.put(m, registerItem(m.tagName() + "_pickaxe", new WPPickaxe(m)));
//                shovels.put(m, registerItem(m.tagName() + "_shovel", new WPShovel(m)));
//                hoes.put(m, registerItem(m.tagName() + "_hoe", new WPHoe(m)));
            }
        }
        ITEMS.register(eventBus);
    }

    private static Item registerItem(String name, Item item){
        ITEMS.register(name, () -> item);
        return item;
    }
}
