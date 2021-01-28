/*
 * Copyright (c) 2021, Jake Downie, All Rights Reserved
 */

package com.basicrpg.world;

import com.basicrpg.items.Clothing;
import com.basicrpg.items.Item;
import com.basicrpg.items.Weapon;
import com.basicrpg.player.Human;
import com.basicrpg.player.Inventory;

public class Enemy {
    private String name;
    private String description;
    private int health;
    private final int level;
    private Inventory inventory;

    /**
     *
     */
    public Enemy(String newName, String newDescription, int newHealth){
        name = newName;
        description = newDescription;
        health = newHealth;
        inventory = new Inventory();
        level = (health / 100);
    }

    public void handleEquip(Item newItem) {
        int xp = 0;
        if (newItem instanceof Weapon) {
            xp += inventory.EquipWeapon((Weapon) newItem);
        } else if (newItem instanceof Clothing) {
            xp += inventory.equipClothing((Clothing) newItem);
        } else {
            xp += inventory.EquipItem(newItem);
        }
        health += xp;
    }


    /**
     * Handles damage being dealt.
     *
     * @param damage the amount of damage to deal
     * @param type the kind of damage being dealt
     * @param attacker the human that created this damage.
     */
    public void handleDamage(int damage, String type, Human attacker) {
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
        if (health == 0){
            handleDeath(attacker);
        }
    }

    public String getName(){
        return name;
    }

    public String getDescription(){
        return description;
    }

    public void handleDeath(Human slayer){
        int xp = rewardXP();
        slayer.awardXP(xp);
    }

    public void attackHuman(Human target){
        int base_damage = inventory.getWeapon().getDamage();
        int base_condition = inventory.getWeapon().getCondition();
        target.handleDamage(((base_damage*(base_condition/100))*level),convertType(inventory.getWeapon().getType()));
    }

    public String convertType(int type){
        return switch (type) {
            case 1 -> "Bashing";
            case 2 -> "Cutting";
            default -> "None";
        };
    }

    public int rewardXP(){
        return level * 2;
    }

    public int getHealth() {
        return health;
    }
}
