/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.Body;
import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.SoundClip;
import city.cs.engine.StaticBody;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.Timer;
import org.jbox2d.common.Vec2;

/**
 *Level 3 of the game
 * @author Minnakan Seral
 */
public class Level3 extends BaseLevel implements ActionListener {
    private static final int itemCount = 3;
    private Image background;

    /**
     *
     */
    public enemy3 boss;
    private Timer timer;
    private SoundClip music;
    
    /**
     *
     * @param game
     */
    @Override
    public void populate(IN1007_Project game){
        super.populate(game);
       //base walls
       Shape Wall1Shape = new BoxShape(0.75f,7.5f);
       Body Wall1 = new StaticBody(this, Wall1Shape);
       Wall1.setPosition(new Vec2( -14,-7));
       

       Shape Wall2Shape = new BoxShape(0.75f,7.5f);
       Body Wall2 = new StaticBody(this, Wall2Shape);
       Wall2.setPosition(new Vec2( 14,-7));
       
       float x=-11.5f;
       for(int i=1;i<14;i++){
       StaticBody fire = new Fire(this);
       fire.setPosition(new Vec2(x, -13f));
       fire.addCollisionListener(new FireListener(game));
       x=x+2;
       }
       
      //platforms
      

      Shape platform1Shape = new BoxShape(1.5f,0.2f);
      Body platform11 = new StaticBody(this,platform1Shape);
      platform11.setPosition(new Vec2(-10f,1f));
      
      Shape platform2Shape = new BoxShape(1.5f,0.2f);
      Body platform2 = new StaticBody(this,platform2Shape);
      platform2.setPosition(new Vec2(-5f,1f));
      
      Shape platform3Shape = new BoxShape(0.5f,0.5f);
      Body platform3 = new StaticBody(this,platform3Shape);
      platform3.setPosition(new Vec2(0f,1f));
      
      Shape platform4Shape = new BoxShape(1.5f,0.2f);
      Body platform4 = new StaticBody(this,platform4Shape);
      platform4.setPosition(new Vec2(5f,1f));
      
      Shape platform5Shape = new BoxShape(1.5f,0.2f);
      Body platform5 = new StaticBody(this,platform5Shape);
      platform5.setPosition(new Vec2(10f,1f));
      
      //bottom platforms
      Shape platform6Shape = new BoxShape(1.5f,0.2f);
      Body platform6 = new StaticBody(this,platform6Shape);
      platform6.setPosition(new Vec2(-8f,-10f));
      
      Shape platform7Shape = new BoxShape(0.5f,0.5f);
      Body platform7 = new StaticBody(this,platform7Shape);
      platform7.setPosition(new Vec2(-4f,-6f));
      
      Shape platform8Shape = new BoxShape(1.5f,0.2f);
      Body platform8 = new StaticBody(this,platform8Shape);
      platform8.setPosition(new Vec2(0f,-2f));
      
      Shape platform9Shape = new BoxShape(0.5f,0.5f);
      Body platform9 = new StaticBody(this,platform9Shape);
      platform9.setPosition(new Vec2(4f,-6f));
      
      Shape platform10Shape = new BoxShape(1.5f,0.2f);
      Body platform10 = new StaticBody(this,platform10Shape);
      platform10.setPosition(new Vec2(8f,-10f));
      
      //top platforms
      Shape Tplatform1Shape = new BoxShape(1.5f,0.2f);
      Body Tplatform1 = new StaticBody(this,Tplatform1Shape);
      Tplatform1.setPosition(new Vec2(-8f,10f));
      
      Shape Tplatform2Shape = new BoxShape(0.5f,0.5f);
      Body Tplatform2 = new StaticBody(this,Tplatform2Shape);
      Tplatform2.setPosition(new Vec2(-4f,6f));
      
      Shape Tplatform3Shape = new BoxShape(1.5f,0.2f);
      Body Tplatform3 = new StaticBody(this,Tplatform3Shape);
      Tplatform3.setPosition(new Vec2(0f,4f));
      
      Shape Tplatform4Shape = new BoxShape(0.5f,0.5f);
      Body Tplatform4 = new StaticBody(this,Tplatform4Shape);
      Tplatform4.setPosition(new Vec2(4f,6f));
      
      Shape Tplatform5Shape = new BoxShape(1.5f,0.2f);
      Body Tplatform5 = new StaticBody(this,Tplatform5Shape);
      Tplatform5.setPosition(new Vec2(8f,10f));
      
      //spwaning enemy
      boss = new enemy3(this);
      boss.setPosition(new Vec2(5,2));
      //boss.addImage(new BodyImage("data/boss.gif",4.5f));
      boss.addCollisionListener(new enemyListener(pirate));
    
     //spwaning a sword
       DynamicBody sword = new Sword(this);
       sword.setPosition(new Vec2(-8f, -9f));
       sword.addCollisionListener(new itemCollector(pirate));
       
       //spawning the compass
       DynamicBody compass = new compass(this);
       compass.setPosition(new Vec2(-8f, 11f));
      
      this.setGravity(30f);
      
      timer = new Timer(1000,this);
      timer.setInitialDelay(6000);
      timer.setDelay(3000);
      timer.start();
      

}

    /**
     *
     * @return
     */
    @Override
    public Vec2 startPosition() {
        return new Vec2(-14.5f,2);
    }
    
    /**
     *
     * @return
     */
    @Override
     public Vec2 doorPosition() {
     return new Vec2(8f,11.75f);
     }

    /**
     *
     * @return
     */
    @Override
    public boolean isCompleted() {
    return getPlayer().getItemcount()== itemCount;
}

    /**
     *
     * @return
     */
    @Override
    public Image returnBackground(){
    background = new ImageIcon("data/lvl3.jpg").getImage();
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
     * @return
     */
    @Override
     public SoundClip returnMusic(){
      try {
            music = new SoundClip("data/level3.mp3");
            music.loop();  
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        } 
      return music;
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
     @Override
     public void actionPerformed(ActionEvent ae){
       DynamicBody fireBall = new fireBall(this);
       fireBall.setPosition(new Vec2(2.5f,2f));
       fireBall.setGravityScale(0);
       fireBall.setLinearVelocity(new Vec2 (-10,0));
       fireBall.addCollisionListener(new canonBallCollision(pirate));
       
       
       if(pirate.itemcount>=3){
           fireBall.destroy();
           timer.stop();
           music.stop();
       }
     }
}
