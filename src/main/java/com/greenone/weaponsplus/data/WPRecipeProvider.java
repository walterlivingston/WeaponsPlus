package com.greenone.weaponsplus.data;

import com.greenone.weaponsplus.Metal;
import com.greenone.weaponsplus.WeaponsPlus;
import com.greenone.weaponsplus.init.Metals;
import com.greenone.weaponsplus.init.WPBlocks;
import com.greenone.weaponsplus.init.WPItems;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Consumer;

public class WPRecipeProvider extends RecipeProvider {
    public WPRecipeProvider(DataGenerator generatorIn) {
        super(generatorIn);
    }

    @Override
    public String getName() {
        return "WeaponsPlus - Recipes";
    }

    @Override
    protected void buildCraftingRecipes(Consumer<FinishedRecipe> consumer) {
        for(Metal m : Metals.METALS.values()){
            if(m.isVanilla()){

            }else {
                if(m.hasOre())
//                    SimpleCookingRecipeBuilder.smelting(Ingredient.of(WPBlocks.ores.get(m).get().asItem()), WPItems.ingots.get(m).get(), 0.7F, 200).unlockedBy("has_"+m.tagName()+"_ore", has(WPBlocks.ores.get(m).get().asItem())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName() + "_ore"));
//                ShapedRecipeBuilder.shaped(WPBlocks.storageBlocks.get(m).get()).define('#', WPItems.ingots.get(m).get()).pattern("###").pattern("###").pattern("###").unlockedBy("has_" + m.tagName()+"_ingot", has(WPItems.ingots.get(m).get())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName() + "_block"));
//                ShapedRecipeBuilder.shaped(WPItems.ingots.get(m).get()).define('#', LHTags.Items.NUGGETS.get(m).get()).pattern("###").pattern("###").pattern("###").group("iron_ingot").unlockedBy("has_" + m.tagName() + "_nugget", has(LHTags.Items.NUGGETS.get(m).get())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName() + "_ingot_from_nuggets"));
//                ShapelessRecipeBuilder.shapeless(WPItems.nuggets.get(m).get(), 9).requires(WPItems.ingots.get(m).get()).unlockedBy("has_" + m.tagName() + "_ingot", has(WPItems.ingots.get(m).get())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName() + "_nugget"));

                ShapedRecipeBuilder.shaped(WPItems.swords.get(m).get()).define('#', Items.STICK).define('X', WPItems.ingots.get(m).get()).pattern("X").pattern("X").pattern("#").unlockedBy("has_" + m.tagName()+"_ingot", has(WPItems.ingots.get(m).get())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName() + "_sword"));
                //ShapelessRecipeBuilder.shapeless(WPItems.ingots.get(m).get(), 9).requires(LHTags.Items.STORAGE_BLOCKS.get(m).get()).unlockedBy("has_" + m.tagName() + "_block", has(WPBlocks.storageBlocks.get(m).get())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName()+"_ingot_from_block"));
//                ShapedRecipeBuilder.shaped(WPItems.axes.get(m).get()).define('#', Items.STICK).define('X', WPItems.ingots.get(m).get()).pattern("XX").pattern("X#").pattern(" #").unlockedBy("has_" + m.tagName()+"_ingot", has(WPItems.ingots.get(m).get())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName() + "_axe"));
//                ShapedRecipeBuilder.shaped(WPItems.helmets.get(m).get()).define('X', WPItems.ingots.get(m).get()).pattern("XXX").pattern("X X").unlockedBy("has_"+m.tagName(), has(WPItems.ingots.get(m).get())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName() + "_helmet"));
//                ShapedRecipeBuilder.shaped(WPItems.chestplates.get(m).get()).define('X', WPItems.ingots.get(m).get()).pattern("X X").pattern("XXX").pattern("XXX").unlockedBy("has_"+m.tagName(), has(WPItems.ingots.get(m).get())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName() + "_chestplate"));
//                ShapedRecipeBuilder.shaped(WPItems.leggings.get(m).get()).define('X', WPItems.ingots.get(m).get()).pattern("XXX").pattern("X X").pattern("X X").unlockedBy("has_"+m.tagName(), has(WPItems.ingots.get(m).get())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName() + "_leggings"));
//                ShapedRecipeBuilder.shaped(WPItems.boots.get(m).get()).define('X', WPItems.ingots.get(m).get()).pattern("X X").pattern("X X").unlockedBy("has_"+m.tagName(), has(WPItems.ingots.get(m).get())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName() + "_boots"));
//                ShapedRecipeBuilder.shaped(WPItems.hoes.get(m).get()).define('#', Items.STICK).define('X', WPItems.ingots.get(m).get()).pattern("XX").pattern(" #").pattern(" #").unlockedBy("has_" + m.tagName()+"_ingot", has(WPItems.ingots.get(m).get())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName() + "_hoe"));
//                ShapedRecipeBuilder.shaped(WPItems.pickaxes.get(m).get()).define('#', Items.STICK).define('X', WPItems.ingots.get(m).get()).pattern("XXX").pattern(" # ").pattern(" # ").unlockedBy("has_" + m.tagName()+"_ingot", has(WPItems.ingots.get(m).get())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName() + "_pickaxe"));
//                ShapedRecipeBuilder.shaped(WPItems.shovels.get(m).get()).define('#', Items.STICK).define('X', WPItems.ingots.get(m).get()).pattern("X").pattern("#").pattern("#").unlockedBy("has_" + m.tagName()+"_ingot", has(WPItems.ingots.get(m).get())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName() + "_shovel"));
//                ShapedRecipeBuilder.shaped(WPItems.bows.get(m).get()).define('#', WPItems.ingots.get(m).get()).define('X', Items.STRING).pattern(" #X").pattern("# X").pattern(" #X").unlockedBy("has_string", has(Items.STRING)).unlockedBy("has_" + m.tagName()+"_ingot", has(WPItems.ingots.get(m).get())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName() + "_bow"));
//                ShapedRecipeBuilder.shaped(WPItems.shields.get(m).get()).define('W', WPItems.ingots.get(m).get()).define('o', Items.IRON_INGOT).pattern("WoW").pattern("WWW").pattern(" W ").unlockedBy("has_iron_ingot", has(Items.IRON_INGOT)).unlockedBy("has_" + m.tagName()+"_ingot", has(WPItems.ingots.get(m).get())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName() + "_shield"));
//                ShapedRecipeBuilder.shaped(WPItems.spears.get(m).get()).define('#', Items.STICK).define('X', WPItems.ingots.get(m).get()).pattern("  X").pattern(" # ").pattern("#  ").unlockedBy("has_" + m.tagName()+"_ingot", has(WPItems.ingots.get(m).get())).save(consumer, new ResourceLocation(WeaponsPlus.MOD_ID, m.tagName() + "_spear"));
            }
        }
    }
}
