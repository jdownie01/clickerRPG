/*
 * Copyright (c) 2021, Jake Downie, All Rights Reserved
 */

package com.basicrpg.items;

/**
 * Weapon class, handles weapons and damage.
 *
 * @author Jake Downie
 * @author jwd2488
 * @version 0.1
 * @since 0.1
 */
public class Weapon extends Item {
    int damage;
    int type;

    /**
     * Constructor for the weapon
     *
     * @param newDamage      the weapons damage
     * @param newType        the type of damage
     * @param newName        the name of the weapon
     * @param newDescription the description of the weapon
     * @param newWeight      the weight of the weapon
     */
    public Weapon(int newDamage, int newType, String newName, String newDescription, int newWeight) {
        super(newName, newDescription, newWeight);
        damage = newDamage;
        type = newType;
    }

    /**
     * Getter for weapon damage.
     *
     * @return the damage of the weapon
     */
    public int getDamage() {
        return damage;
    }

    /**
     * Override method for the string representation of the weapon
     *
     * @return lots of information in string format
     */
    public String toString() {
        return "Name: " + getName() + " Description: " + getDescription() + " Damage: " + damage + " Weight: " + getWeight();
    }

    public int getType() {
        return type;
    }
}
