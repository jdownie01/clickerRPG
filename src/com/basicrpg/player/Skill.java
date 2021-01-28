/*
 * Copyright (c) 2021, Jake Downie, All Rights Reserved
 */

package com.basicrpg.player;

/**
 * Skill class to handle skill trees and level ups
 *
 * @author Jake Downie
 * @author jwd2488
 * @version 0.1
 * @since 0.1
 */
public class Skill {
    int xp;
    int nextLevel;
    int level;
    String name;

    /**
     * Constructor for skills
     *
     * @param newName the name of the skill
     */
    public Skill(String newName) {
        name = newName;
        xp = 0;
        level = 0;
    }

    /**
     * Adds experience and then passes to handleLevelUp to level up.
     *
     * @param additionalXP the new amount of XP to be added
     */
    public void addExperience(int additionalXP) {
        xp += additionalXP;
        if (xp > nextLevel) {
            handleLevelUp();
        }
    }

    /**
     * Handles leveling up.
     */
    private void handleLevelUp() {
        level += 1;
        xp = 0;
        nextLevel = nextLevel * 2;
    }

}
