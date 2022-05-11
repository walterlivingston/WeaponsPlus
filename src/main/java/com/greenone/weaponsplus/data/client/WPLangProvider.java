package com.greenone.weaponsplus.data.client;

import com.greenone.weaponsplus.Metal;
import com.greenone.weaponsplus.WeaponsPlus;
import com.greenone.weaponsplus.init.Metals;
import com.greenone.weaponsplus.init.WPItems;
import net.minecraft.data.DataGenerator;
import net.minecraftforge.common.data.LanguageProvider;

public class WPLangProvider extends LanguageProvider {
    private final String locale;

    public WPLangProvider(DataGenerator gen, String locale) {
        super(gen, WeaponsPlus.MOD_ID, locale);
        this.locale=locale;
    }

    @Override
    protected void addTranslations() {
        if(this.locale.equals("en_us")){
            for(Metal m : Metals.METALS.values()){
                if(!m.isVanilla()) {
//                    if(m != Metals.COPPER) addBlock(() -> LHBlocks.storageBlocks.get(m), getFormattedName(m.tagName()+"_block",m));
//                    if(m.hasOre()) { addBlock(() -> LHBlocks.ores.get(m), getFormattedName(m.tagName()+"_ore",m)); }
                    addItem(() -> WPItems.ingots.get(m).get(), getFormattedName(m.tagName() + "_ingot", m));
                }
                if(!m.isVanilla() || m == Metals.COPPER){
                    addItem(() -> WPItems.nuggets.get(m).get(), getFormattedName(m.tagName()+"_nugget",m));
                    addItem(() -> WPItems.swords.get(m).get(), getFormattedName(m.tagName()+"_sword",m));
//                    addItem(() -> WPItems.axes.get(m).get(), getFormattedName(m.tagName()+"_axe",m));
//                    addItem(() -> WPItems.pickaxes.get(m).get(), getFormattedName(m.tagName()+"_pickaxe",m));
//                    addItem(() -> WPItems.shovels.get(m).get(), getFormattedName(m.tagName()+"_shovel",m));
//                    addItem(() -> WPItems.hoes.get(m).get(), getFormattedName(m.tagName()+"_hoe",m));
//                    addItem(() -> WPItems.bows.get(m).get(), getFormattedName(m.tagName()+"_bow",m));
//                    addItem(() -> WPItems.crossbows.get(m).get(), getFormattedName(m.tagName()+"_crossbow",m));
//                    addItem(() -> WPItems.spears.get(m).get(), getFormattedName(m.tagName()+"_spear",m));
//                    addItem(() -> WPItems.shields.get(m).get(), getFormattedName(m.tagName()+"_shield",m));
//                    addItem(() -> WPItems.helmets.get(m).get(), getFormattedName(m.tagName()+"_helmet",m));
//                    addItem(() -> WPItems.chestplates.get(m).get(), getFormattedName(m.tagName()+"_chestplate",m));
//                    addItem(() -> WPItems.leggings.get(m).get(), getFormattedName(m.tagName()+"_leggings",m));
//                    addItem(() -> WPItems.boots.get(m).get(), getFormattedName(m.tagName()+"_boots",m));
                }
            }
        }
    }

    private String getFormattedName(String name, Metal m){
        String ret;
        if(m.hasEffect()) { ret = "\u00A7"+"b" + name.substring(0,1).toUpperCase() + name.substring(1); }else{
            ret = name.substring(0,1).toUpperCase() + name.substring(1);
        }
        while(ret.contains("_")){
            int index = ret.indexOf("_");
            ret = ret.substring(0, index) + " " + ret.substring(index+1,index+2).toUpperCase() + ret.substring(index+2);
        }
        return ret;
    }
}
