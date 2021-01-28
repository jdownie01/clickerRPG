/*
 * Copyright (c) 2021, Jake Downie, All Rights Reserved
 */

package com.basicrpg.items;

/**
 * Clothing class, handles clothing and protection.
 *
 * @author Jake Downie
 * @author jwd2488
 * @version 0.1
 * @since 0.1
 */
public class Clothing extends Item {

    private final int type;
    private float protection;

    public Clothing(String newName, String newDescription, int newProtection, int newWeight, int newType) {
        super(newName, newDescription, newWeight);
        protection = newProtection;
        type = newType;
    }

    public float getProtection() {
        return protection;
    }

    public int getType() {
        return type;
    }

    public void calculateProtection() {
        protection = protection * ((float) getCondition() / 100);
    }

    public void damageClothing(int damage) {
        setCondition(getCondition() - damage);
        if (getCondition() < 0) {
            setCondition(0);
        }
        calculateProtection();
    }

    public String toString() {
        return "Name: " + getName() + " Description: " + getDescription() + " Protection: " + protection + " Weight: " + getWeight() + " Condition: " + getCondition();
    }
}
