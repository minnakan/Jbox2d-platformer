/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

/**
 *A listener to check for spike collisions
 * @author Minnakan Seral
 */
    public class spikeCollision implements CollisionListener{
        private character_Main pirate;

    /**
     *
     * @param pirate
     */
    public spikeCollision(character_Main pirate)
         {
             this.pirate = pirate;
         }
         
    /**
     *
     * @param e
     */
    @Override
       public void collide(CollisionEvent e) {
        if (e.getOtherBody() == pirate) {
            pirate.decrementHealthValue();
        }
    }
    
}

