package com.greenone.weaponsplus.data.client;

import com.greenone.weaponsplus.common.Metal;
import com.greenone.weaponsplus.WeaponsPlus;
import com.greenone.weaponsplus.common.init.Metals;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.common.data.ExistingFileHelper;

import javax.annotation.Nonnull;

public class WPItemModelProvider extends ItemModelProvider {
    public WPItemModelProvider(DataGenerator generator, ExistingFileHelper existingFileHelper) {
        super(generator, WeaponsPlus.MOD_ID, existingFileHelper);
    }

    @Nonnull
    @Override
    public String getName() {
        return "Weapons+ - Item Models";
    }

    @Override
    protected void registerModels() {
        ModelFile itemGenerated = getExistingFile(new ResourceLocation("item/generated"));
        ModelFile handheld = getExistingFile(new ResourceLocation("item/handheld"));

        for(Metal m : Metals.METALS.values()) {
            if (!m.isVanilla()) {
                if (m.hasOre()) withExistingParent(m.tagName() + "_ore", modLoc("block/" + m.tagName() + "_ore"));
                withExistingParent(m.tagName() + "_block", modLoc("block/" + m.tagName() + "_block"));
                builder(itemGenerated, m.tagName() + "_ingot");
            }
            if(!m.isVanilla() || m == Metals.COPPER) {
                builder(itemGenerated, m.tagName() + "_nugget");
                builder(handheld, m.tagName() + "_sword");
                builder(handheld, m.tagName() + "_pickaxe");
                builder(handheld, m.tagName() + "_axe");
                builder(handheld, m.tagName() + "_shovel");
                builder(handheld, m.tagName() + "_hoe");
                builder(itemGenerated, m.tagName() + "_spear");
                builder(itemGenerated, m.tagName() + "_helmet");
                builder(itemGenerated, m.tagName() + "_chestplate");
                builder(itemGenerated, m.tagName() + "_leggings");
                builder(itemGenerated, m.tagName() + "_boots");
            }
        }
    }

    private ItemModelBuilder builder(ModelFile itemGenerated, String name) {
        return getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }
}
