/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 *A listener to check for door collisions
 * @author Minnakan Seral
 */
public class DoorListener implements CollisionListener{
    private IN1007_Project game;
    
    public DoorListener(IN1007_Project game) {
        this.game = game;
    }

    @Override
    public void collide(CollisionEvent e) {
        character_Main player = game.getPlayer();
        if (e.getOtherBody() == player && game.isCurrentLevelCompleted()) {
            System.out.println("Going to next level...");
            game.switchLevel();
        }
    }   
}
