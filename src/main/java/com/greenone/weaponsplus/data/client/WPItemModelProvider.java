package com.greenone.weaponsplus.data.client;

import com.greenone.weaponsplus.common.Metal;
import com.greenone.weaponsplus.WeaponsPlus;
import com.greenone.weaponsplus.common.init.Metals;
import net.minecraft.client.renderer.block.model.BlockModel;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelBuilder;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelBuilder;
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
                if (m.hasOre()){
                    withExistingParent(m.tagName() + "_ore", modLoc("block/" + m.tagName() + "_ore"));
                    withExistingParent("raw_" + m.tagName() + "_block", modLoc("block/" + "raw_" + m.tagName() + "_block"));
                }
                withExistingParent(m.tagName() + "_block", modLoc("block/" + m.tagName() + "_block"));
                builder(itemGenerated, "raw_" + m.tagName());
                builder(itemGenerated, m.tagName() + "_ingot");
            }
            if(!m.isVanilla() || m == Metals.COPPER) {
                builder(itemGenerated, m.tagName() + "_nugget");
                builder(handheld, m.tagName() + "_sword");
                builder(handheld, m.tagName() + "_pickaxe");
                builder(handheld, m.tagName() + "_axe");
                builder(handheld, m.tagName() + "_shovel");
                builder(handheld, m.tagName() + "_hoe");
                builder(itemGenerated, m.tagName() + "_helmet");
                builder(itemGenerated, m.tagName() + "_chestplate");
                builder(itemGenerated, m.tagName() + "_leggings");
                builder(itemGenerated, m.tagName() + "_boots");
            }
            if(m != Metals.IRON) shieldBuilder(WeaponsPlus.MOD_ID, m.tagName() + "_shield");
        }
    }

    private void builder(ModelFile itemGenerated, String name) {
        getBuilder(name).parent(itemGenerated).texture("layer0", "item/" + name);
    }

    private void shieldBuilder(String MOD_ID, String name) {
        getBuilder(name + "_blocking").parent(new ModelFile.UncheckedModelFile("builtin/entity"))
                .guiLight(BlockModel.GuiLight.FRONT)
                .texture("particle", new ResourceLocation(MOD_ID, "entity/shield/" + name))
                .transforms()
                    .transform(ModelBuilder.Perspective.THIRDPERSON_RIGHT)
                        .rotation(45,135,0)
                        .translation(3.51F, 11, -2)
                        .scale(1,1,1)
                    .end()
                    .transform(ModelBuilder.Perspective.THIRDPERSON_LEFT)
                        .rotation(45,135,0)
                        .translation(13.51F, 3, 5)
                        .scale(1,1,1)
                    .end()
                    .transform(ModelBuilder.Perspective.FIRSTPERSON_RIGHT)
                        .rotation(0,180,-5)
                        .translation(-15, 5, -11)
                        .scale(1.25F,1.25F,1.25F)
                    .end()
                    .transform(ModelBuilder.Perspective.FIRSTPERSON_LEFT)
                        .rotation(0,180,-5)
                        .translation(5, 5, -11)
                        .scale(1.25F,1.25F,1.25F)
                    .end()
                    .transform(ModelBuilder.Perspective.GUI)
                        .rotation(15,-25,-5)
                        .translation(2, 3, 0)
                        .scale(0.65F,0.65F,0.65F)
                    .end()
                .end()
                .override()
                    .predicate(new ResourceLocation(WeaponsPlus.MOD_ID, "blocking"), 1)
                        .model(getExistingFile(new ResourceLocation(MOD_ID, "item/" + name + "_blocking")))
                .end();
        getBuilder(name).parent(new ModelFile.UncheckedModelFile("builtin/entity"))
            .guiLight(BlockModel.GuiLight.FRONT)
            .texture("particle", new ResourceLocation(MOD_ID, "entity/shield/" + name))
            .transforms()
                .transform(ModelBuilder.Perspective.THIRDPERSON_RIGHT)
                    .rotation(0,90,0)
                    .translation(10, 6, -4)
                    .scale(1,1,1)
                .end()
                .transform(ModelBuilder.Perspective.THIRDPERSON_LEFT)
                    .rotation(0,90,0)
                    .translation(10, 6, 12)
                    .scale(1,1,1)
                .end()
                .transform(ModelBuilder.Perspective.FIRSTPERSON_RIGHT)
                    .rotation(0,180,5)
                    .translation(-10, 2, -10)
                    .scale(1.25F,1.25F,1.25F)
                .end()
                .transform(ModelBuilder.Perspective.FIRSTPERSON_LEFT)
                    .rotation(0,180,5)
                    .translation(10, 0, -10)
                    .scale(1.25F,1.25F,1.25F)
                .end()
                .transform(ModelBuilder.Perspective.GUI)
                    .rotation(15,-25,-5)
                    .translation(2, 3, 0)
                    .scale(0.65F,0.65F,0.65F)
                .end()
                .transform(ModelBuilder.Perspective.FIXED)
                    .rotation(0,180,0)
                    .translation(-2, 4, -5)
                    .scale(0.5F,0.5F,0.5F)
                .end()
                .transform(ModelBuilder.Perspective.GROUND)
                    .rotation(0,0,0)
                    .translation(4, 4, 2)
                    .scale(0.25F,0.25F,0.25F)
                .end()
            .end()
            .override()
                .predicate(new ResourceLocation(WeaponsPlus.MOD_ID, "blocking"), 1)
                    .model(getExistingFile(new ResourceLocation(MOD_ID, "item/" + name + "_blocking")))
            .end();
    }
}
