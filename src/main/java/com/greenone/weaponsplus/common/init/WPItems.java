package com.greenone.weaponsplus.common.init;

import com.greenone.weaponsplus.common.Metal;
import com.greenone.weaponsplus.WeaponsPlus;
import com.greenone.weaponsplus.common.item.ArmorItemPlus;
import com.greenone.weaponsplus.common.item.tools.*;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
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
    public static Map<Metal, RegistryObject<Item>> bows = new HashMap<>();
    public static Map<Metal, RegistryObject<Item>> shields = new HashMap<>();
    public static Map<Metal, RegistryObject<Item>> helmets = new HashMap<>();
    public static Map<Metal, RegistryObject<Item>> chestplates = new HashMap<>();
    public static Map<Metal, RegistryObject<Item>> leggings = new HashMap<>();
    public static Map<Metal, RegistryObject<Item>> boots = new HashMap<>();

    public static void init(IEventBus eventBus){

        for(Metal m : Metals.METALS.values()){
            if(!m.isVanilla() || m.equals(Metals.COPPER)){
                if(!m.equals(Metals.COPPER)) {
                    if(m.getType() == MetalType.PURE) raw.put(m, ITEMS.register("raw_" + m.tagName(), () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS))));
                    ingots.put(m, ITEMS.register(m.tagName() + "_ingot", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS))));
                }else{
                    if(m.getType() == MetalType.PURE) raw.put(m, RegistryObject.create(Items.RAW_COPPER.getRegistryName(), ForgeRegistries.ITEMS));
                    ingots.put(m, RegistryObject.create(Items.COPPER_INGOT.getRegistryName(), ForgeRegistries.ITEMS));
                }
                nuggets.put(m, ITEMS.register(m.tagName() + "_nugget", () -> new Item((new Item.Properties()).tab(CreativeModeTab.TAB_MATERIALS))));

                // Register vanilla weapon types
                swords.put(m, ITEMS.register(m.tagName() + "_sword", () -> new SwordPlus(m)));
                axes.put(m, ITEMS.register(m.tagName() + "_axe", () -> new AxePlus(m)));
                pickaxes.put(m, ITEMS.register(m.tagName() + "_pickaxe", () -> new PickaxePlus(m)));
                shovels.put(m, ITEMS.register(m.tagName() + "_shovel", () -> new ShovelPlus(m)));
                hoes.put(m, ITEMS.register(m.tagName() + "_hoe", () -> new HoePlus(m)));
                helmets.put(m, ITEMS.register(m.tagName()+"_helmet", () -> new ArmorItemPlus(m, EquipmentSlot.HEAD)));
                chestplates.put(m, ITEMS.register(m.tagName()+"_chestplate", () -> new ArmorItemPlus(m, EquipmentSlot.CHEST)));
                leggings.put(m, ITEMS.register(m.tagName()+"_leggings", () -> new ArmorItemPlus(m, EquipmentSlot.LEGS)));
                boots.put(m, ITEMS.register(m.tagName()+"_boots", () -> new ArmorItemPlus(m, EquipmentSlot.FEET)));
            }
            bows.put(m, ITEMS.register(m.tagName() + "_bow", () -> new BowPlus(m)));
            if(m != Metals.IRON) shields.put(m, ITEMS.register(m.tagName()+"_shield", () -> new ShieldPlus(m)));
            else shields.put(m, RegistryObject.create(Items.SHIELD.getRegistryName(), ForgeRegistries.ITEMS));
        }
        ITEMS.register(eventBus);
    }

    private static Item registerItem(String name, Item item){
        ITEMS.register(name, () -> item);
        return item;
    }
}
