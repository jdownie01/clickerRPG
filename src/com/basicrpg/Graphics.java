/*
 * Copyright (c) 2021, Jake Downie, All Rights Reserved
 */

package com.basicrpg;

import com.basicrpg.player.Human;
import com.basicrpg.world.Enemy;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.text.Text;
import javafx.stage.Stage;

/**
 * Graphics class, handles all visuals.
 *
 * @author Jake Downie
 * @author jwd2488
 * @version 0.1
 * @since 0.1
 */
public class Graphics extends Application {

    static Human this_human;
    static Enemy this_enemy;

    public static void main(Human player, Enemy enemy) {
        this_human = player;
        this_enemy = enemy;
        launch();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Game Window");

        Button btn = new Button();
        btn.setText("Next Turn");
        btn.setLayoutX(145);
        btn.setLayoutY(100);

        Text player_info = new Text();
        player_info.setText("Current Health: " + this_human.GetHealth());
        player_info.setY(50);
        player_info.setX(50);

        Text player_equipment = new Text();
        player_equipment.setText("Equipped Clothing:\n  " +
                this_human.getInventory().getChest() + "\n  " +
                this_human.getInventory().getHead() + "\n   " +
                this_human.getInventory().getFeet());
        player_equipment.setY(75);
        player_equipment.setX(50);

        Text player_blood = new Text();
        player_blood.setText("Blood: " + this_human.GetBlood());
        player_blood.setY(125);
        player_blood.setX(50);

        Text enemy_health = new Text();
        enemy_health.setText("Enemy health: " + this_enemy.getHealth());
        enemy_health.setY(205);
        enemy_health.setX(50);

        btn.setOnAction(event -> {
            System.out.println("Hello World!");
            Main.gameTick(this_human, this_enemy);
            player_info.setText("Current Health: " + this_human.GetHealth());
            player_equipment.setText("Equipped Clothing -> " +
                    this_human.getInventory().getChest() + "\n" +
                    this_human.getInventory().getHead() + "\n" +
                    this_human.getInventory().getFeet());
            player_blood.setText("Blood: " + this_human.GetBlood());
            enemy_health.setText("Enemy health: " + this_enemy.getHealth());
        });

        Group root = new Group(player_info, player_blood, player_equipment, enemy_health, btn);
        primaryStage.setScene(new Scene(root, 600, 300));
        primaryStage.show();
    }
}