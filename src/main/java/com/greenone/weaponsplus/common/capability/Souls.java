package com.greenone.weaponsplus.common.capability;

import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.Tag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.ICapabilityProvider;
import net.minecraftforge.common.util.INBTSerializable;
import net.minecraftforge.common.util.LazyOptional;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class Souls implements ISouls, INBTSerializable<Tag>,ICapabilityProvider {
    private float souls = 0;

    public static Capability<ISouls> SOULS = null;
    private final LazyOptional<ISouls> instance = LazyOptional.of(() -> this);

    @Override
    public float getSouls() {
        return this.souls;
    }

    @Override
    public void addSouls(float soulsIn) {
        souls += soulsIn;
    }

    @Override
    public void setSouls(float soulsIn) {
        souls = soulsIn;
    }

    @NotNull
    @Override
    public <T> LazyOptional<T> getCapability(@NotNull Capability<T> cap, @Nullable Direction side) {
        if(cap != SOULS){
            return LazyOptional.empty();
        }
        return this.instance.cast();
    }

    @Override
    public Tag serializeNBT() {
        CompoundTag nbt = new CompoundTag();
        nbt.putFloat("souls", this.getSouls());

        return nbt;
    }

    @Override
    public void deserializeNBT(Tag nbt) {
        CompoundTag tag = (CompoundTag) nbt;

        this.setSouls(tag.getFloat("souls"));
    }
}
