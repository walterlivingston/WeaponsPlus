package com.greenone.weaponsplus.init;

import com.greenone.weaponsplus.IMetalType;

public enum MetalType implements IMetalType {
    VANILLA,
    PURE,
    ALLOY,
    BLESSED;

    @Override
    public boolean isVanilla() {
        return this==VANILLA;
    }

    @Override
    public boolean hasEffect() {
        return this==BLESSED;
    }
}
