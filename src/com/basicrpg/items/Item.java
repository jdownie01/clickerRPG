/*
 * Copyright (c) 2021, Jake Downie, All Rights Reserved
 */

package com.basicrpg.items;

import com.basicrpg.player.Human;

import java.util.function.Consumer;

/**
 * Item class, parent for both weapons and clothing. Handles Effects, conditions, and details.
 *
 * @author Jake Downie
 * @author jwd2488
 * @version 0.1
 * @since 0.1
 */
public class Item {
    private String name;
    private String description;
    private int weight;
    private int condition;
    private Consumer<Human> effect;

    /**
     * Constructor for the Item class.
     * @param newName the name for the item being created
     * @param newDescription the description for the item being created
     * @param newWeight the weight for the item being created
     * @param newEffect the effect of the item being created, can be any function or the NothingEffect for no effect
     */
    public Item(String newName, String newDescription, int newWeight, Consumer<Human> newEffect) {
        condition = 100;    
        weight = newWeight;
        name = newName;
        description = newDescription;
        effect = newEffect;
    }

    /**
     * Second constructor for the item class, used in cases where there is no effect (like weapons and clothing).
     * @param newName the name for the item being created
     * @param newDescription the description for the item being created
     * @param newWeight the weight for the item being created
     */
    public Item(String newName, String newDescription, int newWeight) {
        condition = 100;
        weight = newWeight;
        name = newName;
        description = newDescription;
        effect = Item::NothingEffect;
    }

    /**
     * This effect does nothing, used for items that do nothing.
     * @param target_human the target for the effect
     */
    public static void NothingEffect(Human target_human) {
        //Nothing!
    }


    /**
     * This effect gives a human + 1 health as long as they are under 100 health.
     * @param target_human the target for the effect
     */
    public static void AppleEffect(Human target_human) {
        if (target_human.GetHealth() < 100) {
            target_human.setHealth(target_human.GetHealth() + 1);
        }
    }

    /**
     * Getter for the item's weight
     * @return returns the weight of the item
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Getter for the condition of the item.
     * @return the item's condition.
     */
    public int getCondition() {
        return condition;
    }

    /**
     * Setter for the condition of the item
     * @param condition the condition to set the item to.
     */
    public void setCondition(int condition) {
        this.condition = condition;
    }

    /**
     * Getter for the item's description.
     * @return the description of the item
     */
    public String getDescription() {
        return description;
    }

    /**
     * Getter for the item's name.
     * @return the item's name
     */
    public String getName() {
        return name;
    }

    /**
     * Function to handle the effect of an item
     * @param target_human the human the effect targets
     */
    public void HandleEffect(Human target_human) {
        effect.accept(target_human);
    }

}
