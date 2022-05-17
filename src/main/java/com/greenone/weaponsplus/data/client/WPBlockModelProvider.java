package com.greenone.weaponsplus.data.client;

import com.greenone.weaponsplus.common.Metal;
import com.greenone.weaponsplus.WeaponsPlus;
import com.greenone.weaponsplus.common.init.MetalType;
import com.greenone.weaponsplus.common.init.Metals;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockModelProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class WPBlockModelProvider extends BlockModelProvider {
    public WPBlockModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, WeaponsPlus.MOD_ID, existingFileHelper);
    }

    @Override
    public String getName() {
        return "Weapons+ - Block Models";
    }

    @Override
    protected void registerModels() {
        for(Metal m : Metals.METALS.values()){
            if(m.isVanilla()){

            }else {
                if(m.getType() == MetalType.PURE) singleTexture("raw_" + m.tagName() + "_block", modLoc("block/" + "raw_" + m.tagName() + "_block"), modLoc("block/" + "raw_" + m.tagName() + "_block"));
                singleTexture(m.tagName() + "_block", modLoc("block/" + m.tagName() + "_block"), modLoc("block/" + m.tagName() + "_block"));
                if (m.hasOre()) singleTexture(m.tagName() + "_ore", modLoc("block/" + m.tagName() + "_ore"), modLoc("block/" + m.tagName() + "_ore"));
            }
        }
    }

}
