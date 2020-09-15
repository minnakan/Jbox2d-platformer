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
 *Level one of the game
 * @author Minnakan Seral
 */
public class Level1 extends BaseLevel implements ActionListener {
    
    private static final int itemCount = 2;
    private Image background;

    /**
     *
     */
    public MyView view;
    private Timer timer;
    private SoundClip music;
    
    /**
     *
     * @param game
     */
    @Override
    public void populate(IN1007_Project game){
        super.populate(game);
        //centre walls
        Shape centreWallShape = new BoxShape(1f,6);
        Body centreWall = new StaticBody(this, centreWallShape);
        centreWall.setPosition(new Vec2( 0,-3));
        
        Shape centreWall2Shape = new BoxShape(1f,2.5f);
        Body centreWall2 = new StaticBody(this, centreWall2Shape);
        centreWall2.setPosition(new Vec2( 0,7.5f));
        
        Shape centreWall3Shape = new BoxShape(0.25f,2.5f);
        Body centreWall3 = new StaticBody(this, centreWall3Shape);
        centreWall3.setPosition(new Vec2( 0,12.5f));
        
      //left platforms
      Shape left_platform0Shape = new BoxShape(1.25f,0.25f);
      Body leftplatform0 = new StaticBody(this,left_platform0Shape);
      leftplatform0.setPosition(new Vec2(-11,-11));
      
      Shape left_platform1Shape = new BoxShape(1.25f,0.25f);
      Body leftplatform1 = new StaticBody(this,left_platform1Shape);
      leftplatform1.setPosition(new Vec2(-8,-9));
      
      Shape left_platform2Shape = new BoxShape(1.25f,0.25f);
      Body leftplatform2 = new StaticBody(this,left_platform2Shape);
      leftplatform2.setPosition(new Vec2(-5,-7));
      
      Shape left_platform3Shape = new BoxShape(1.25f,0.25f);
      Body leftplatform3 = new StaticBody(this,left_platform3Shape);
      leftplatform3.setPosition(new Vec2(-1.5f,-5));
      
      Shape left_platform3_5Shape = new BoxShape(1.25f,0.25f);
      Body leftplatform3_5 = new StaticBody(this,left_platform3_5Shape);
      leftplatform3_5.setPosition(new Vec2(-14.25f,-5f));
      
      Shape left_platform4Shape = new BoxShape(1.25f,0.25f);
      Body leftplatform4 = new StaticBody(this,left_platform4Shape);
      leftplatform4.setPosition(new Vec2(-5.50f,-3f));
      
      Shape left_platform5Shape = new BoxShape(1.25f,0.25f);
      Body leftplatform5 = new StaticBody(this,left_platform5Shape);
      leftplatform5.setPosition(new Vec2(-8f,-1f));
      
      Shape left_platform6Shape = new BoxShape(1.25f,0.25f);
      Body leftplatform6 = new StaticBody(this,left_platform6Shape);
      leftplatform6.setPosition(new Vec2(-11f,1f));
      
      //upper left bigger platforms
      Shape left_platformUp1Shape = new BoxShape(3f,0.35f);
      Body leftplatformUp1 = new StaticBody(this,left_platformUp1Shape);
      leftplatformUp1.setPosition(new Vec2(-5f,3f));
      

      Shape left_platformUp2Shape = new BoxShape(1.5f,0.25f);
      Body leftplatformUp2 = new StaticBody(this,left_platformUp2Shape);
      leftplatformUp2.setPosition(new Vec2(-10.5f,5.75f));
      
      Shape left_platformUp3Shape = new BoxShape(3f,0.35f);
      Body leftplatformUp3 = new StaticBody(this,left_platformUp3Shape);
      leftplatformUp3.setPosition(new Vec2(-5f,8.5f));
      
      Shape left_platformUp4Shape = new BoxShape(2.5f,0.35f);
      Body leftplatformUp4 = new StaticBody(this,left_platformUp4Shape);
      leftplatformUp4.setPosition(new Vec2(-12.5f,11f));
      
       //spawning objects
       //skull
       DynamicBody skull = new skull(this);
       skull.setPosition(new Vec2(-12.5f, 11.1f));
       skull.addCollisionListener(new itemCollector(pirate));
       
       //spawning  tanks
       StaticBody tank1 = new tank(this,"left");
       tank1.setPosition(new Vec2(14,-14));
       
       StaticBody tank2 = new tank(this,"right");
       tank2.setPosition(new Vec2(0,3.65f));
       
       StaticBody tank3 = new tank(this,"left");
       tank3.setPosition(new Vec2(-3,9.5f));
       
       StaticBody tank4 = new tank(this,"right");
       tank4.setPosition(new Vec2(-14,-4.15f));
       
         
       //spawning a map
       DynamicBody map = new map(this);
       map.setPosition(new Vec2(13f, 0.5f));
       map.addCollisionListener(new itemCollector(pirate));
       
       //right platforms
      Shape right_platform0Shape = new BoxShape(1.25f,0.25f);
      Body rightplatform0 = new StaticBody(this,right_platform0Shape);
      rightplatform0.setPosition(new Vec2(11,-11));
      
      Shape right_platform1Shape = new BoxShape(1.25f,0.25f);
      Body rightplatform1 = new StaticBody(this,right_platform1Shape);
      rightplatform1.setPosition(new Vec2(8,-9));
      
      Shape right_platform2Shape = new BoxShape(3f,0.25f);
      Body rightplatform2 = new StaticBody(this,right_platform2Shape);
      rightplatform2.setPosition(new Vec2(6,2));
      
      Shape right_platform3Shape = new BoxShape(3f,0.25f);
      Body rightplatform3 = new StaticBody(this,right_platform3Shape);
      rightplatform3.setPosition(new Vec2(4,-5));
      
      Shape right_platform4Shape = new BoxShape(1.25f,0.25f);
      Body rightplatform4 = new StaticBody(this,right_platform4Shape);
      rightplatform4.setPosition(new Vec2(10,-3));
      
      Shape right_platform5Shape = new BoxShape(1.25f,0.25f);
      Body rightplatform5 = new StaticBody(this,right_platform5Shape);
      rightplatform5.setPosition(new Vec2(13,0));
      
      Shape right_platform6Shape = new BoxShape(3f,0.25f);
      Body rightplatform6 = new StaticBody(this,right_platform6Shape);
      rightplatform6.setPosition(new Vec2(6,10));
      
      Shape right_platform7Shape = new BoxShape(1.25f,0.25f);
      Body rightplatform7 = new StaticBody(this,right_platform7Shape);
      rightplatform7.setPosition(new Vec2(13,10));
      
      this.setGravity(30f);
      
      timer = new Timer(1000,this);
      //timer.setInitialDelay(1000);
      timer.setDelay(2500);
      timer.start();
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
     return new Vec2(13f, 11.75f);
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
    background = new ImageIcon("data/lvl1.png").getImage();
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
            music = new SoundClip("data/level1.mp3"); 
            music.loop(); 
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        } 
      return music;
     }
     
     @Override
     public void actionPerformed(ActionEvent ae) {
       //spawning  canonballs      
       DynamicBody canonBall2 = new canonBall(this);
       canonBall2.setPosition(new Vec2(13, -13.65f));
       canonBall2.setGravityScale(0);
       canonBall2.setLinearVelocity(new Vec2 (-10,0));
       canonBall2.addCollisionListener(new canonBallCollision(pirate));
       
       DynamicBody canonBall3 = new canonBall(this);
       canonBall3.setPosition(new Vec2(2,4f));
       canonBall3.setGravityScale(0);
       canonBall3.setLinearVelocity(new Vec2 (10,0));
       canonBall3.addCollisionListener(new canonBallCollision(pirate));
       
       DynamicBody canonBall4 = new canonBall(this);
       canonBall4.setPosition(new Vec2(-4.5f,9.5f));
       canonBall4.setGravityScale(0);
       canonBall4.setLinearVelocity(new Vec2 (-10,0));
       canonBall4.addCollisionListener(new canonBallCollision(pirate));
       
       DynamicBody canonBall5 = new canonBall(this);
       canonBall5.setPosition(new Vec2(-12.5f,-4f));
       canonBall5.setGravityScale(0);
       canonBall5.setLinearVelocity(new Vec2 (10,0));
       canonBall5.addCollisionListener(new canonBallCollision(pirate));

    }
     
}

