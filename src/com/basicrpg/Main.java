/*
 * Copyright (c) 2021, Jake Downie, All Rights Reserved
 */

package com.basicrpg;

import com.basicrpg.items.WorldItems;
import com.basicrpg.player.Human;
import com.basicrpg.world.Enemy;

/**
 * Main class, handles game ticks and
 *
 * @author Jake Downie
 * @author jwd2488
 * @version 0.1
 * @since 0.1
 */
public class Main {

    /**
     * Our main function.
     *
     * @param args any input args to handle
     */
    public static void main(String[] args) {
        Human player = setup();
        Enemy troll = setupEnemy();
        Graphics.main(player, troll);

    }

    /**
     * This method handles the game ticks, and ends the game when the player's health is 0.
     *
     * @param jake the input human for the game tick
     */
    public static void gameTick(Human jake,Enemy troll) {
        if (jake.GetHealth() > 0) {
            jake.lifeTick();
            if (troll.getHealth() > 1){
                troll.attackHuman(jake);
            }
            jake.handleAttack(troll,jake.getInventory().getWeapon().getDamage(),convertType(jake.getInventory().getWeapon().getType()));
        }
    }

    public static String convertType(int type){
        switch (type){
            case 1:
                return "Bashing";
            case 2:
                return "Cutting";
        }
        return "Cutting";
    }


    /**
     * Sets up the player character for the game.
     *
     * @return the newly created human
     */
    public static Human setup() {
        Human jake = new Human("Jake");
        jake.handleDamage(10, "Cutting");
        System.out.println(jake.GetHealth());
        jake.handleEquip(WorldItems.apple);
        jake.handleEquip(WorldItems.apple);
        jake.handleEquip(WorldItems.rusty_chainmail);
        jake.handleEquip(WorldItems.rusty_sword);
        jake.handleEquip(WorldItems.boring_boots);
        jake.handleEquip(WorldItems.ugly_helm);
        System.out.println("Equipped Clothing -> " + jake.getInventory().getChest().getName() + ", " + jake.getInventory().getHead().getName() + " and " + jake.getInventory().getFeet().getName());
        System.out.println("Equipped Weapon ->x  " + jake.getInventory().getWeapon());
        return jake;
    }
    public static Enemy setupEnemy() {
        Enemy troll = new Enemy("Troll","A big ugly troll.",400);
        troll.handleEquip(WorldItems.apple);
        troll.handleEquip(WorldItems.apple);
        troll.handleEquip(WorldItems.rusty_chainmail);
        troll.handleEquip(WorldItems.rusty_sword);
        troll.handleEquip(WorldItems.boring_boots);
        troll.handleEquip(WorldItems.ugly_helm);
        return troll;
    }
}
