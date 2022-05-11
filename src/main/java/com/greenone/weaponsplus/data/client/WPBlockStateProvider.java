package com.greenone.weaponsplus.data.client;

import com.greenone.weaponsplus.Metal;
import com.greenone.weaponsplus.WeaponsPlus;
import com.greenone.weaponsplus.init.Metals;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;

public class WPBlockStateProvider extends BlockStateProvider {
    private final WPBlockModelProvider blockModels;

    public WPBlockStateProvider(DataGenerator gen, ExistingFileHelper exFileHelper) {
        super(gen, WeaponsPlus.MOD_ID, exFileHelper);
        this.blockModels = new WPBlockModelProvider(gen, exFileHelper) {
            @Override protected void registerModels() {}
        };
    }

    @Override
    public String getName() {
        return "Weapons+ - Block States/Models";
    }

    @Override
    protected void registerStatesAndModels() {
        for(Metal m : Metals.METALS.values()){
            if(m.isVanilla()){

            }else {
//                simpleBlock(LHBlocks.storageBlocks.get(m));
//                if (m.hasOre()) {
//                    simpleBlock(LHBlocks.ores.get(m));
//                }
            }
        }
    }
}
