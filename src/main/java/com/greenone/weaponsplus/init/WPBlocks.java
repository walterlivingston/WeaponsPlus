package com.greenone.weaponsplus.init;

import com.greenone.weaponsplus.WeaponsPlus;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class WPBlocks {
    public static DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, WeaponsPlus.MOD_ID);

    public static void init(IEventBus eventBus){
        //BLOCKS.register("test", () -> new Block(BlockBehaviour.Properties.of(Material.STONE)));

        BLOCKS.register(eventBus);
    }
}
