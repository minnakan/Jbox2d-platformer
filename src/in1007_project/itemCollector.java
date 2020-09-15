/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.*;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 *Listener to check for pickup item collisions
 * @author Minnakan Seral
 */
public class itemCollector implements CollisionListener {
    private character_Main pirate;
    private SoundClip itemPickup;

    /**
     *
     * @param pirate
     */
    public itemCollector(character_Main pirate) {
        this.pirate=pirate;
        
    }

    /**
     *
     * @param e
     */
    @Override
    public void collide(CollisionEvent e) {
        if (e.getOtherBody() == pirate) {
            pirate.setItemValue();
            e.getReportingBody().destroy();
            try {
           itemPickup = new SoundClip("data/itemPickup.mp3");
           itemPickup.setVolume(0.5);
           itemPickup.play();
         } catch (UnsupportedAudioFileException|IOException|LineUnavailableException d){
           System.out.println(d);
         }        
    }
        }
        
    }

     

