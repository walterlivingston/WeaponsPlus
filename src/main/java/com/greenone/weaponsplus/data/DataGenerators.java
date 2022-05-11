package com.greenone.weaponsplus.data;

import com.greenone.weaponsplus.WeaponsPlus;
import com.greenone.weaponsplus.data.client.WPBlockModelProvider;
import com.greenone.weaponsplus.data.client.WPBlockStateProvider;
import com.greenone.weaponsplus.data.client.WPItemModelProvider;
import com.greenone.weaponsplus.data.client.WPLangProvider;
import com.greenone.weaponsplus.data.loot.WPLootTableProvider;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.forge.event.lifecycle.GatherDataEvent;

@Mod.EventBusSubscriber(modid = WeaponsPlus.MOD_ID, bus = Mod.EventBusSubscriber.Bus.MOD)
public class DataGenerators {
    @SubscribeEvent
    public static void gatherData(GatherDataEvent event){
        DataGenerator gen = event.getGenerator();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        gen.addProvider(new WPBlockModelProvider(gen, existingFileHelper));
        gen.addProvider(new WPBlockStateProvider(gen, existingFileHelper));
        gen.addProvider(new WPItemModelProvider(gen, existingFileHelper));
//
        gen.addProvider(new WPLootTableProvider(gen));
//
//        LHBlockTagsProvider blockTags = new LHBlockTagsProvider(gen, existingFileHelper);
//        //gen.addProvider(blockTags);
//        //gen.addProvider(new LHItemTagsProvider(gen, blockTags, existingFileHelper));
//
        gen.addProvider(new WPRecipeProvider(gen));
        gen.addProvider(new WPLangProvider(gen, "en_us"));
    }
}
