package com.greenone.weaponsplus.common.item;

import com.greenone.weaponsplus.WeaponsPlus;
import com.greenone.weaponsplus.common.init.WPItems;
import net.minecraft.client.renderer.item.ItemProperties;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.registries.RegistryObject;

public class WPItemModelProperties {
    public static void registerProperties(){
        for(RegistryObject<Item> bow : WPItems.bows.values()){
            ItemProperties.register(bow.get(), new ResourceLocation(WeaponsPlus.MOD_ID, "pull"), (stack, p_239429_1_, entity, p_174623_) -> {
                if (entity == null) {
                    return 0.0F;
                } else {
                    return entity.getUseItem() != stack ? 0.0F : (float)(stack.getUseDuration() - entity.getUseItemRemainingTicks()) / 20.0F;
                }
            });
            ItemProperties.register(bow.get(), new ResourceLocation(WeaponsPlus.MOD_ID, "pulling"), (p_239428_0_, p_239428_1_, p_239428_2_, p_174623_) -> p_239428_2_ != null && p_239428_2_.isUsingItem() && p_239428_2_.getUseItem() == p_239428_0_ ? 1.0F : 0.0F);
        }
        for(RegistryObject<Item> shield : WPItems.shields.values()){
            ItemProperties.register(shield.get(), new ResourceLocation(WeaponsPlus.MOD_ID,"blocking"), (p_239421_0_, p_239421_1_, p_239421_2_, p_174623_) -> p_239421_2_ != null && p_239421_2_.isUsingItem() && p_239421_2_.getUseItem() == p_239421_0_ ? 1.0F : 0.0F);
        }
    }
}
