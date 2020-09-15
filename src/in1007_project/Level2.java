/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
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
 *Level 2 of the game
 * @author Minnakan Seral
 */
public class Level2 extends BaseLevel implements ActionListener {
    private static final int itemCount = 2;
    private Image background;
    DynamicBody slime = new slimeMonster(this);
    DynamicBody slimeMinion1= new slimeMinion(this);
    DynamicBody slimeMinion2 = new slimeMinion(this);
    private Timer timer;
    Vec2 slimeVel = new Vec2(9,0);
    int steps;
    private SoundClip music;

    /**
     *
     * @param game
     */
    @Override
    public void populate(IN1007_Project game){
        super.populate(game);
       //right and left walls
       Shape leftWallShape = new BoxShape(0.75f,10);
       Body leftWall = new StaticBody(this, leftWallShape);
       leftWall.setPosition(new Vec2( -10,0));
        
       Shape rightWallShape = new BoxShape(0.75f,10);
       Body rightWall = new StaticBody(this, rightWallShape);
       rightWall.setPosition(new Vec2( 10,0));
        
       //platforms inbetween the walls
       Shape platform1Shape = new BoxShape(2f,0.25f);
       Body platform1 = new StaticBody(this,platform1Shape);
       platform1.setPosition(new Vec2(0,-11));
        
      Shape platform2Shape = new BoxShape(2.25f,0.25f);
      Body platform2 = new StaticBody(this,platform2Shape);
      platform2.setPosition(new Vec2(-7f,-7f));
      
      Shape platform3Shape = new BoxShape(2.25f,0.25f);
      Body platform3 = new StaticBody(this,platform3Shape);
      platform3.setPosition(new Vec2(7f,-7f));
      
      Shape platform4Shape = new BoxShape(2f,0.25f);
      Body platform4 = new StaticBody(this,platform4Shape);
      platform4.setPosition(new Vec2(0f,-2.5f));
      
      Shape platform5Shape = new BoxShape(2f,0.25f);
      Body platform5 = new StaticBody(this,platform5Shape);
      platform5.setPosition(new Vec2(-5f,1));
      
      Shape platform6Shape = new BoxShape(2f,0.25f);
      Body platform6 = new StaticBody(this,platform6Shape);
      platform6.setPosition(new Vec2(0f,5));
      
      Shape platform7Shape = new BoxShape(2f,0.25f);
      Body platform7 = new StaticBody(this,platform7Shape);
      platform7.setPosition(new Vec2(7f,8));
      
      Shape platform8Shape = new BoxShape(2f,0.25f);
      Body platform8 = new StaticBody(this,platform8Shape);
      platform8.setPosition(new Vec2(7f,0));
      
      Shape platform9Shape = new BoxShape(2f,0.25f);
      Body platform9 = new StaticBody(this,platform9Shape);
      platform9.setPosition(new Vec2(-7f,10));
      
      
      //other platforms
      Shape platform10Shape = new BoxShape(0.275f,2.25f);
      Body platform10 = new StaticBody(this,platform10Shape);
      platform10.setPosition(new Vec2(-10f,12.25f));
      
      Shape platform11Shape = new BoxShape(2f,0.25f);
      Body platform11 = new StaticBody(this,platform11Shape);
      platform11.setPosition(new Vec2(12.75f,0f));
      
      Shape platform12Shape = new BoxShape(1f,0.25f);
      Body platform12 = new StaticBody(this,platform12Shape);
      platform12.setPosition(new Vec2(-11.75f,0f));
      
      Shape platform13Shape = new BoxShape(1f,0.25f);
      Body platform13 = new StaticBody(this,platform13Shape);
      platform13.setPosition(new Vec2(-13f,12f));
      
      Shape platform14Shape = new BoxShape(1f,0.25f);
      Body platform14 = new StaticBody(this,platform14Shape);
      platform14.setPosition(new Vec2(-14f,-11f));
      
      Shape platform15Shape = new BoxShape(1f,0.25f);
      Body platform15 = new StaticBody(this,platform14Shape);
      platform15.setPosition(new Vec2(-11.75f,-7f));
      
      Shape platform16Shape = new BoxShape(1f,0.25f);
      Body platform16 = new StaticBody(this,platform14Shape);
      platform16.setPosition(new Vec2(-14f,-3f));
      
      Shape platform17Shape = new BoxShape(1f,0.25f);
      Body platform17 = new StaticBody(this,platform14Shape);
      platform17.setPosition(new Vec2(-14f,4f));
      
      //spawning in the key
       DynamicBody key = new key(this);
       key.setPosition(new Vec2(-13f, 13f));
       key.addCollisionListener(new itemCollector(pirate));
       
       //spawning the chest
       DynamicBody chest = new chest(this);
       chest.setPosition(new Vec2(-7f, 13f));
       chest.addCollisionListener(new chestListener(pirate));
       
       //adding slimes
       slime.setPosition(new Vec2(0,-13.75f));
       slime.addImage(new BodyImage("data/slimeRight.gif",5));
       
       slimeMinion1.setPosition(new Vec2(9f,-6f));
       slimeMinion1.addImage(new BodyImage("data/slimeleft.gif",3));
       
       
       slimeMinion2.setPosition(new Vec2(-6f,1.75f));
       slimeMinion2.addImage(new BodyImage("data/slimeRight.gif",3));

       
       
       


       
       for(int i =7;i<10;i++){
       StaticBody spike= new spikes(this,"right");
       spike.setPosition(new Vec2(-15f,i));
       spike.addCollisionListener(new spikeCollision(pirate));
       }
       
       for(int i =5;i<8;i++){
       StaticBody spike= new spikes(this,"right");
       spike.setPosition(new Vec2(11f,i));
       spike.addCollisionListener(new spikeCollision(pirate));
       }
       
      timer = new Timer(1000,this);
      timer.setDelay(2500);
      timer.start();
      
      this.setGravity(30f);
   
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
     return new Vec2(12.75f,1.75f);
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
    background = new ImageIcon("data/back_cave.png").getImage();
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
            music = new SoundClip("data/level2.mp3");   
            music.loop(); 
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        } 
      return music;
     }
     
     @Override
     public void actionPerformed(ActionEvent ae){
         if(steps==4){
             slimeVel.x=slimeVel.x*-1;
             if(slimeVel.x<0){
                 slime.removeAllImages();
                 slime.addImage(new BodyImage("data/slimeLeft.gif",5));
             }
             if(slimeVel.x>0){
                 slime.removeAllImages();
                 slime.addImage(new BodyImage("data/slimeRight.gif",5));
             }
             steps=0;
         }
          steps++;
          
         slime.setLinearVelocity(slimeVel);
         slime.addCollisionListener(new slimeCollision(pirate));
         
         //slimeballs
       DynamicBody slimeBall = new slimeBall(this);
       slimeBall.setPosition(new Vec2(7, -6f));
       //canonBall2.setGravityScale(0);
       slimeBall.setLinearVelocity(new Vec2 (-14,0));
       slimeBall.addCollisionListener(new canonBallCollision(pirate));
       
       DynamicBody slimeBall2 = new slimeBall(this);
       slimeBall2.setPosition(new Vec2(-4.5f, 2f));
       //canonBall2.setGravityScale(0);
       slimeBall2.setLinearVelocity(new Vec2 (10,0));
       slimeBall2.addCollisionListener(new canonBallCollision(pirate));
     }
}
