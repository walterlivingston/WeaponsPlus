package com.greenone.weaponsplus.init;

import com.greenone.weaponsplus.WeaponsPlus;
import com.greenone.weaponsplus.item.Metal;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.OreBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraft.world.level.material.MaterialColor;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

import java.util.HashMap;
import java.util.Map;

public class WPBlocks {
    static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WeaponsPlus.MOD_ID);

    public static Map<Metal, Block> ores = new HashMap<>();
    public static Map<Metal, Block> deepslate_ores = new HashMap<>();
    public static Map<Metal, Block> storage_blocks = new HashMap<>();

    public static void init(IEventBus eventBus){
        for(RegistryObject<? extends Metal> ro : Registries.METALS.getEntries()){
            Metal m = ro.get();
            if(!m.isVanilla()){
                // Register vanilla block types
                if(m.hasOre()) ores.put(m, registerBlockAndItem(m.getName()+"_ore", new OreBlock(BlockBehaviour.Properties.of(Material.STONE).requiresCorrectToolForDrops().strength(m.getDestroyTime(), m.getExplosionResistance()))));
                if(m.hasDeepslate()) deepslate_ores.put(m, registerBlockAndItem(m.getName()+"_deepslate_ore", new OreBlock(BlockBehaviour.Properties.copy(ores.get(m)).color(MaterialColor.DEEPSLATE).strength(m.getDestroyTime() + 1.5F, m.getExplosionResistance()).sound(SoundType.DEEPSLATE))));
                storage_blocks.put(m, registerBlockAndItem(m.getName()+"_block", new Block(BlockBehaviour.Properties.of(m.getMaterial(), m.getColor()).requiresCorrectToolForDrops().strength(m.getDestroyTime(), m.getExplosionResistance()).sound(SoundType.METAL))));
            }
        }
        BLOCKS.register(eventBus);
    }

    private static Block registerBlockAndItem(String name, Block block){
        BLOCKS.register(name, () -> block);
        WPItems.ITEMS.register(name, block::asItem);
        return block;
    }
}
