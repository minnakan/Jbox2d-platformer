/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import org.jbox2d.common.Vec2;

/**
 *Listener to check slimeBall collisions
 * @author Minnakan Seral
 */
public class slimeCollision implements CollisionListener {
    private character_Main pirate ;

    /**
     *
     */
    public Level2 game = new Level2();
    
    /**
     *
     * @param pirate
     */
    public slimeCollision(character_Main pirate){
        this.pirate=pirate;
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
        else{
            e.getReportingBody().destroy();
        }
    
}
}
