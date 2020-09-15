/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *A collision Listener to check canon ball collisions
 * @author Minnakan Seral
 */
public class canonBallCollision implements CollisionListener{
        private character_Main pirate;
        private canonBall ball;
        private SoundClip damage;

    /**
     *
     * @param pirate
     */
    public canonBallCollision(character_Main pirate)
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
            e.getReportingBody().destroy();
        try {
           damage = new SoundClip("data/damage.mp3");
           damage.setVolume(0.5);
           damage.play();
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException d){
           System.out.println(d);
         } 
    }
        else{
            e.getReportingBody().destroy();
        }
        }
    }
    
