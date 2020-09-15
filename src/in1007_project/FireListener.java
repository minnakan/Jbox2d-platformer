/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 *A listener to check for fire collisions
 * @author Minnakan Seral
 */
public class FireListener implements CollisionListener {
        private IN1007_Project game;
        
        public FireListener(IN1007_Project game){
            this.game=game;
        }
            @Override
    public void collide(CollisionEvent e) {
        character_Main player = game.getPlayer();
            if (e.getOtherBody() == player) {
            System.out.println("fell into fire");
            player.decrementHealthValue();
        }
            else{
                e.getOtherBody().destroy();
                player.setItemValue();
            }
}
}
