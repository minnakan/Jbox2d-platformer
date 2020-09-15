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
 *A Listener to check chest collisions 
 * @author Minnakan Seral
 */
public class chestListener implements CollisionListener {
    private character_Main pirate;

    /**
     *
     */
    public SoundClip itemPickup;

    /**
     *
     * @param pirate
     */
    public chestListener(character_Main pirate){
         this.pirate=pirate;
     }
     
    /**
     *
     * @param e
     */
    @Override
     public void collide(CollisionEvent e) {
        if (e.getOtherBody() == pirate && pirate.itemcount==1 ) {
            pirate.setItemValue();
            e.getReportingBody().destroy();
            System.out.println("Chest opened");
            try {
           itemPickup = new SoundClip("data/itemPickup.mp3");
           itemPickup.setVolume(0.5);
           itemPickup.play();
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException d){
           System.out.println(d);
         }        
        }
        else{
            System.out.println("Key required to open chest");
        }
    }   
    
}
