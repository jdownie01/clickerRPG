/*
 * Copyright (c) 2021, Jake Downie, All Rights Reserved
 */

package com.basicrpg.world;

import java.util.ArrayList;

public class Encounter {
    private ArrayList<Enemy> enemies;
    private String name;

    public Encounter(String newName, ArrayList<Enemy> newEnemies){
        enemies = newEnemies;
        name = newName;

    }

    public void addEnemy(Enemy enemy){
        enemies.add(enemy);
    }
}
