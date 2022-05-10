package com.greenone.weaponsplus.item;

public enum MetalType {
    PURE,
    ALLOY,
    VANILLA,
    BLESSED;

    public boolean hasOre(){
        return this == PURE;
    }

    public boolean isVanilla(){
        return this == VANILLA;
    }
}
