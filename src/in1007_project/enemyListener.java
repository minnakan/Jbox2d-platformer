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
 *Listener to check enemy collisions
 * @author Minnakan Seral
 */
public class enemyListener implements CollisionListener {
    private character_Main pirate;
    IN1007_Project game;
    private SoundClip victory;

    /**
     *
     * @param pirate
     */
    public enemyListener(character_Main pirate){
         this.pirate=pirate;
     }
     
    /**
     *
     * @param e
     */
    @Override
     public void collide(CollisionEvent e) {
        if (e.getOtherBody() == pirate && pirate.itemcount==2 ) {
            e.getReportingBody().destroy();
            System.out.println("Boss killed");
            pirate.setItemValue();
            try {
           victory = new SoundClip("data/victory.mp3");
           victory.setVolume(0.5);
           victory.play();
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException d){
           System.out.println(d);
         } 
            

        }
        else if (e.getOtherBody() == pirate && pirate.itemcount<2 ) {
            System.out.println("Boss killed you");
            game.end();
            
    }    
}
}
