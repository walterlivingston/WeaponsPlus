package com.greenone.weaponsplus.common.item;

import com.greenone.weaponsplus.WeaponsPlus;
import com.greenone.weaponsplus.common.init.Metals;
import com.greenone.weaponsplus.common.init.WPItems;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import org.jetbrains.annotations.NotNull;

import java.util.function.Supplier;

public enum WPArmorMaterials implements ArmorMaterial {
    COPPER("copper", 13, new int[]{1, 4, 5, 2}, 11, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F,
            () -> Ingredient.of(Items.COPPER_INGOT)),
    TIN("tin", 13, new int[]{1, 4, 5, 2}, 11, SoundEvents.ARMOR_EQUIP_IRON, 0.0F, 0.0F,
            () -> Ingredient.of(WPItems.ingots.get(Metals.TIN).get())),
    LEAD("lead", 18, new int[]{3, 6, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_IRON, 1.0F, 0.1F,
            () -> Ingredient.of(WPItems.ingots.get(Metals.LEAD).get())),
    SILVER("silver", 16, new int[]{2, 5, 6, 2}, 25, SoundEvents.ARMOR_EQUIP_IRON, 0.2F, 0.0F,
            () -> Ingredient.of(WPItems.ingots.get(Metals.SILVER).get()))
//    GOLD("gold", 7, new int[]{1, 3, 5, 2}, 25, SoundEvents.ARMOR_EQUIP_GOLD, 0.0F, 0.0F, () -> {
//        return Ingredient.of(Items.GOLD_INGOT);
//    }),
//    DIAMOND("diamond", 33, new int[]{3, 6, 8, 3}, 10, SoundEvents.ARMOR_EQUIP_DIAMOND, 2.0F, 0.0F, () -> {
//        return Ingredient.of(Items.DIAMOND);
//    }),
//    TURTLE("turtle", 25, new int[]{2, 5, 6, 2}, 9, SoundEvents.ARMOR_EQUIP_TURTLE, 0.0F, 0.0F, () -> {
//        return Ingredient.of(Items.SCUTE);
//    }),
//    NETHERITE("netherite", 37, new int[]{3, 6, 8, 3}, 15, SoundEvents.ARMOR_EQUIP_NETHERITE, 3.0F, 0.1F, () -> {
//        return Ingredient.of(Items.NETHERITE_INGOT);
//    });
    ;
    private static final int[] HEALTH_PER_SLOT = new int[]{13, 15, 16, 11};
    private final String name;
    private final int durabilityMultiplier;
    private final int[] slotProtections;
    private final int enchantmentValue;
    private final SoundEvent sound;
    private final float toughness;
    private final float knockbackResistance;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    WPArmorMaterials(String nameIn, int durabilityMultIn, int[] slotProtectionsIn, int enchantmentValueIn, SoundEvent soundIn, float toughnessIn, float knockbackResistanceIn, Supplier<Ingredient> repairIngredientIn) {
        this.name = nameIn;
        this.durabilityMultiplier = durabilityMultIn;
        this.slotProtections = slotProtectionsIn;
        this.enchantmentValue = enchantmentValueIn;
        this.sound = soundIn;
        this.toughness = toughnessIn;
        this.knockbackResistance = knockbackResistanceIn;
        this.repairIngredient = new LazyLoadedValue<>(repairIngredientIn);
    }

    @Override
    public int getDurabilityForSlot(EquipmentSlot slot) {
        return HEALTH_PER_SLOT[slot.getIndex()] * this.durabilityMultiplier;
    }

    @Override
    public int getDefenseForSlot(EquipmentSlot slot) {
        return this.slotProtections[slot.getIndex()];
    }

    @Override
    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    @Override
    public @NotNull SoundEvent getEquipSound() {
        return this.sound;
    }

    @Override
    public @NotNull Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }

    @Override
    public @NotNull String getName() {
        return WeaponsPlus.MOD_ID + ":" + this.name;
    }

    @Override
    public float getToughness() {
        return this.toughness;
    }

    @Override
    public float getKnockbackResistance() {
        return this.knockbackResistance;
    }
}
