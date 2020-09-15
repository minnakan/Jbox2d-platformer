/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.SoundClip;
import java.awt.Image;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 *End level of the game
 * @author Minnakan Seral
 */
public class LevelEnd extends BaseLevel{
    int health=100;
    private Image background;

    /**
     *
     */
    public MyView view;
    private Timer timer;
    private SoundClip music;

    /**
     *
     */
    public character_Main pirate;

    /**
     *
     */
    public LevelEnd(){
        
    }

    /**
     *
     * @return
     */
    @Override
    public Vec2 startPosition() {
    return new Vec2(-14, -15);
    }
    
    /**
     *
     * @return
     */
    @Override
     public Vec2 doorPosition() {
     return new Vec2(130f, 11.750f);
     }
    
    /**
     *
     * @return
     */
    @Override
    public boolean isCompleted() {
    return getPlayer().getItemcount()== 0;
    }
    
    /**
     *
     * @return
     */
    @Override
    public Image returnBackground(){
    background = new ImageIcon("data/end.jpg").getImage();
    return background;
    }
    
    /**
     *
     * @return
     */
    @Override
     public character_Main getCharacter(){
      return pirate;
    }
     
    /**
     *
     * @return
     */
    @Override
     public int getHealth(){
         return pirate.getHealth();
     }
     
    /**
     *
     * @param health
     */
    @Override
     public void setHealth(int health){
         pirate.setHealth(health);
     }
     
    /**
     *
     * @param pause
     */
    @Override
     public void pauseTimer(Boolean pause){
         if(pause == false){
         timer.stop();
         }
         else{
             timer.start();
         }
     }
     
    /**
     *
     * @return
     */
    @Override
     public SoundClip returnMusic(){
      try {
            music = new SoundClip("data/end.mp3"); 
            music.loop(); 
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        } 
      return music;
     }
}
