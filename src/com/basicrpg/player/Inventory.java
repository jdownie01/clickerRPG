package com.basicrpg.player;

import com.basicrpg.items.Clothing;
import com.basicrpg.items.Item;
import com.basicrpg.items.Weapon;

/**
 * Inventory class, handles player inventory and equips.
 *
 * @author Jake Downie
 * @author jwd2488
 * @version 0.1
 * @since 0.1
 */
public class Inventory {

    private Clothing head; // 1
    private Clothing chest; // 2
    private Clothing feet; // 3

    private Item equippedItem; // 4

    private Weapon weapon; // 5

    private int totalWeight;

    /**
     * Constructor for player inventory.
     */
    public Inventory() {
        totalWeight = 0;
    }

    /**
     * Getter for the item on the chest slot.
     *
     * @return the item on the chest
     */
    public Clothing getChest() {
        return chest;
    }

    /**
     * Getter for the item on the feet slot.
     *
     * @return the item on the feet
     */
    public Clothing getFeet() {
        return feet;
    }

    /**
     * Getter for the item on the head slot.
     *
     * @return the item on the head.
     */
    public Clothing getHead() {
        return head;
    }

    /**
     * Getter for the current weapon.
     *
     * @return the current weapon
     */
    public Weapon getWeapon() {
        return weapon;
    }

    /**
     * Getter for the current item.
     *
     * @return the currently equipped item.
     */
    public Item getItem() {
        return equippedItem;
    }

    /**
     * Calculates total weight on the player.
     */
    public void calculateWeight() {
        int cur_total = 0;
        if (head != null & chest != null & feet != null & equippedItem != null & weapon != null) {
            cur_total = (head.getWeight() + chest.getWeight() + feet.getWeight()) / 2;
            cur_total += equippedItem.getWeight();
            cur_total += weapon.getWeight() / 2;
        }
        totalWeight = cur_total;
    }

    /**
     * Equips clothing from handleEquip.
     *
     * @param newItem the item of clothing to equip
     * @return the xp to be gained from the old clothing
     */
    public int equipClothing(Clothing newItem) {
        int xp_to_add = 0;

        switch (newItem.getType()) {
            case 1: {
                if (newItem.getType() == 1) { //TODO: Remove extra line
                    if (head != null) {
                        xp_to_add = head.getCondition() + (int) head.getProtection();
                    }
                    head = newItem;
                }
            }
            case 2: {
                if (newItem.getType() == 2) { //TODO: Remove extra line
                    if (chest != null) {
                        xp_to_add = chest.getCondition() + (int) chest.getProtection();
                    }
                    chest = newItem;
                }
            }
            case 3: {
                if (newItem.getType() == 3) { //TODO: Remove extra line
                    if (feet != null) {
                        xp_to_add = feet.getCondition() + (int) feet.getProtection();
                    }
                    feet = newItem;
                }
            }

        }
        calculateWeight();
        return xp_to_add;
    }

    /**
     * Equips weapons from HandleEquip.
     *
     * @param newItem the weapon to be equipped
     * @return the xp to be gained from the old weapon
     */
    public int EquipWeapon(Weapon newItem) {
        Weapon oldWeapon = weapon;
        int xp_to_add;
        if (oldWeapon != null) {
            xp_to_add = oldWeapon.getCondition() + oldWeapon.getDamage();
        } else {
            xp_to_add = 0;
        }
        weapon = newItem;
        calculateWeight();
        return xp_to_add;
    }

    /**
     * Equips item from HandleEquip
     *
     * @param newItem the item to be equipped
     * @return the xp to be gained from the item.
     */
    public int EquipItem(Item newItem) {
        Item oldItem = equippedItem;
        int xp_to_add;
        if (oldItem != null) {
            xp_to_add = oldItem.getCondition() + oldItem.getWeight();
        } else {
            xp_to_add = 0;
        }
        equippedItem = newItem;
        calculateWeight();
        return xp_to_add;
    }


}
