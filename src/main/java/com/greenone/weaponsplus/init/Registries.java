package com.greenone.weaponsplus.init;

import com.greenone.weaponsplus.WeaponsPlus;
import com.greenone.weaponsplus.item.Metal;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.registries.DeferredRegister;

public class Registries {
    public static final DeferredRegister<Metal> METALS = DeferredRegister.create(new ResourceLocation(WeaponsPlus.MOD_ID, "metals"), WeaponsPlus.MOD_ID);

}
