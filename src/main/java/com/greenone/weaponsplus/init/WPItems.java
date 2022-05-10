package com.greenone.weaponsplus.init;

import com.greenone.weaponsplus.WeaponsPlus;
import com.greenone.weaponsplus.item.Metal;
import com.greenone.weaponsplus.item.Metals;
import com.greenone.weaponsplus.item.tools.*;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class WPItems {
    public static DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, WeaponsPlus.MOD_ID);

    public static Map<Metal, Item> ingots = new HashMap<>();
    public static Map<Metal, Item> raw = new HashMap<>();
    public static Map<Metal, Item> nuggets = new HashMap<>();
    public static Map<Metal, Item> swords = new HashMap<>();
    public static Map<Metal, Item> axes = new HashMap<>();
    public static Map<Metal, Item> pickaxes = new HashMap<>();
    public static Map<Metal, Item> shovels = new HashMap<>();
    public static Map<Metal, Item> hoes = new HashMap<>();
    public static Map<Metal, Item> helmets = new HashMap<>();
    public static Map<Metal, Item> chestplates = new HashMap<>();
    public static Map<Metal, Item> leggings = new HashMap<>();
    public static Map<Metal, Item> boots = new HashMap<>();

    public static void init(IEventBus eventBus){
        for(RegistryObject<? extends Metal> ro : Registries.METALS.getEntries()){
            Metal m = ro.get();
            if(!m.isVanilla() || m.equals(Metals.COPPER)){
                if(!m.equals(Metals.COPPER)) {
                    raw.put(m, registerItem("raw_" + m.getName(), new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS))));
                    ingots.put(m, registerItem(m.getName() + "_ingot", new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS))));
                }
                nuggets.put(m, registerItem(m.getName() + "_nugget", new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS))));

                // Register vanilla weapon types
                swords.put(m, registerItem(m.getName() + "_sword", new WPSword(m)));
                axes.put(m, registerItem(m.getName() + "_axe", new WPAxe(m)));
                pickaxes.put(m, registerItem(m.getName() + "_pickaxe", new WPPickaxe(m)));
                shovels.put(m, registerItem(m.getName() + "_shovel", new WPShovel(m)));
                hoes.put(m, registerItem(m.getName() + "_hoe", new WPHoe(m)));
            }
        }
        ITEMS.register(eventBus);
    }

    private static Item registerItem(String name, Item item){
        ITEMS.register(name, () -> item);
        return item;
    }
}
