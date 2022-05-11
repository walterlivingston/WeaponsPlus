package com.greenone.weaponsplus.common.item;

import com.greenone.weaponsplus.common.init.Metals;
import com.greenone.weaponsplus.common.init.WPItems;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;

import java.util.function.Supplier;

public enum WPTiers implements Tier {
    COPPER(2, 200, 7.0F, 1.5F, 14, () -> Ingredient.of(Items.COPPER_INGOT)),
    TIN(2, 200, 7.0F, 1.5F, 14, () -> Ingredient.of(WPItems.ingots.get(Metals.TIN).get()))
//    DIAMOND(3, 1561, 8.0F, 3.0F, 10, () -> {
//        return Ingredient.of(Items.DIAMOND);
//    }),
//    GOLD(0, 32, 12.0F, 0.0F, 22, () -> {
//        return Ingredient.of(Items.GOLD_INGOT);
//    }),
//    NETHERITE(4, 2031, 9.0F, 4.0F, 15, () -> {
//        return Ingredient.of(Items.NETHERITE_INGOT);
//    });
        ;

    private final int level;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    WPTiers(int levelIn, int usesIn, float speedIn, float damageIn, int enchantmentValue, Supplier<Ingredient> repairIngredient) {
        this.level = levelIn;
        this.uses = usesIn;
        this.speed = speedIn;
        this.damage = damageIn;
        this.enchantmentValue = enchantmentValue;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredient);
    }

    @Override
    public int getUses() {
        return this.uses;
    }

    @Override
    public float getSpeed() {
        return this.speed;
    }

    @Override
    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public int getLevel() {
        return this.level;
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
