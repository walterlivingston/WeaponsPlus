package com.greenone.weaponsplus.common.init;

import com.greenone.weaponsplus.common.Metal;
import com.greenone.weaponsplus.WeaponsPlus;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class WPBlocks {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WeaponsPlus.MOD_ID);

    public static Map<Metal, RegistryObject<Block>> ores = new HashMap<>();
    public static Map<Metal, RegistryObject<Block>> raw_blocks = new HashMap<>();
    public static Map<Metal, RegistryObject<Block>> storage_blocks = new HashMap<>();

    public static void init(IEventBus eventBus){
        for(Metal m : Metals.METALS.values()){
            if(!m.isVanilla()){
                if(m.hasOre()) ores.put(m, BLOCKS.register(m.tagName()+"_ore", () -> registerBlock(m.tagName()+"_ore",new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(3.0F, 3.0F)))));
                if(m.getType() == MetalType.PURE) raw_blocks.put(m, BLOCKS.register("raw_" + m.tagName()+"_block", () -> registerBlock("raw_" + m.tagName()+"_block", new Block(BlockBehaviour.Properties.of(m.getMaterial(), m.getColor()).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)))));
                storage_blocks.put(m, BLOCKS.register(m.tagName()+"_block", () -> registerBlock(m.tagName()+"_block", new Block(BlockBehaviour.Properties.of(m.getMaterial(), m.getColor()).requiresCorrectToolForDrops().strength(5.0F, 6.0F).sound(SoundType.METAL)))));
            }
        }
        BLOCKS.register(eventBus);
    }

    private static Block registerBlock(String name, Block block){
        WPItems.ITEMS.register(name, () -> new BlockItem(block, new Item.Properties().tab(CreativeModeTab.TAB_BUILDING_BLOCKS)));
        return block;
    }
}
