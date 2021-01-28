/*
 * Copyright (c) 2021, Jake Downie, All Rights Reserved
 */

package com.basicrpg.player;

import com.basicrpg.items.Clothing;
import com.basicrpg.items.Item;
import com.basicrpg.items.Weapon;
import com.basicrpg.world.Enemy;

/**
 * Represents a human (the player).
 *
 * @author Jake Downie
 * @author jwd2488
 * @version 0.1
 * @since 0.1
 */
public class Human {
    private final String name;
    private final Inventory inventory;
    private int blood;
    private int health;
    private boolean dead;
    private int bleeding;
    private int xp;
    private int level;
    private int xp_to_level;

    /**
     * Constructor for the human
     *
     * @param newName The employee’s last name.
     */
    public Human(String newName) {
        blood = 3000;
        dead = false;
        bleeding = 0;
        name = newName;
        health = 100;
        xp = 0;
        level = 0;
        xp_to_level = 100;
        Skill athletics = new Skill("Athletics");
        inventory = new Inventory();
    }

    /**
     * Getter for the humans name.
     *
     * @return the name of the human
     */
    public String GetName() {
        return name;
    }

    /**
     * Getter for the blood level.
     *
     * @return the blood level of the human
     */
    public int GetBlood() {
        return blood;
    }

    /**
     * Getter for the human's level.
     *
     * @return the humans level
     */
    public int getLevel() {
        return level;
    }

    /**
     * Getter for the human's health
     *
     * @return the human's health
     */
    public int GetHealth() {
        return health;
    }

    /**
     * Handles the life tick for the player, this includes blood, health, item effects, and bleeding.
     */
    public void lifeTick() {
        if (!dead) {
            if (inventory.getItem() != null) {
                inventory.getItem().HandleEffect(this);
            }
            if (blood < 3000) {
                blood += 1;
            }
            if (bleeding != 0) {
                blood -= bleeding;
                bleeding -= 1;
            }
            if (health <= 0) {
                dead = true;
                health = 0;
            }
            if (blood < 1000) {
                health -= 2;
            } else if (blood > 2000) {
                if (health < 100) {
                    health += 1;
                }
            }
        }

    }

    /**
     * Handles damage being dealt to the player and preforms calculations in relation to protection.
     *
     * @param damage the damage to be dealt to the player
     * @param type   the type of damage, currently cutting and bashing
     */
    public void handleDamage(int damage, String type) {
        if (type.equals("Bashing")) {
            if (inventory.getChest() != null & inventory.getHead() != null & inventory.getFeet() != null) {
                if (inventory.getChest().getProtection() != 0 & inventory.getHead().getProtection() != 0 & inventory.getFeet().getProtection() != 0) {
                    health -= damage / (
                            inventory.getChest().getProtection() + (inventory.getHead().getProtection()) + (inventory.getFeet().getProtection())
                                    / 2);
                    inventory.getChest().damageClothing(damage);
                    inventory.getHead().damageClothing(damage);
                    inventory.getFeet().damageClothing(damage);
                } else {
                    health -= damage;
                }


            } else {
                health -= damage;
            }
        } else if (type.equals("Cutting")) {
            if (inventory.getChest() != null & inventory.getHead() != null & inventory.getFeet() != null) {
                if (inventory.getChest() != null & inventory.getHead() != null & inventory.getFeet() != null) {
                    health -= damage / (
                            inventory.getChest().getProtection() + (inventory.getHead().getProtection()) + (inventory.getFeet().getProtection())
                    );
                    bleeding += damage / 10;
                    inventory.getChest().setCondition(inventory.getChest().getCondition() - (damage * 2));
                    inventory.getHead().setCondition(inventory.getChest().getCondition() - (damage * 2));
                    inventory.getFeet().setCondition(inventory.getChest().getCondition() - (damage * 2));
                    inventory.getChest().calculateProtection();
                    inventory.getHead().calculateProtection();
                    inventory.getFeet().calculateProtection();
                } else {
                    health -= damage;
                }
            } else {
                health -= damage;
            }
        }
        if (health < 0) {
            health = 0;
        }
    }

    /**
     * Handles XP Being gained.
     */
    public void HandleXpGain() {
        if (xp > xp_to_level) {
            level += 1;
            xp_to_level = xp_to_level * 2;
            xp = 0;
        }
    }

    public void handleAttack(Enemy target, int damage, String type){
        if (target.getHealth() > 0){
            target.handleDamage(damage, type, this);
        }
    }

    public Inventory getInventory() {
        return inventory;
    }

    /**
     * Handles items being equipped, both clothing, weapons, and items.
     *
     * @param newItem the item to be equipped.
     */
    public void handleEquip(Item newItem) {
        if (newItem instanceof Weapon) {
            xp += inventory.EquipWeapon((Weapon) newItem);
        } else if (newItem instanceof Clothing) {
            xp += inventory.equipClothing((Clothing) newItem);
        } else {
            xp += inventory.EquipItem(newItem);
        }
        HandleXpGain();
    }

    /**
     * Setter for player health
     *
     * @param this_health the input health
     */
    public void setHealth(int this_health) {
        health = this_health;
    }

    public void setXP(int i) {
        xp = i;
    }
    public void awardXP(int i){
        xp += i;
        HandleXpGain();
    }
}
