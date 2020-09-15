
package in1007_project;

/**
 *
 * @author Minnakan Seral
 */
import city.cs.engine.*;
import java.awt.Graphics2D;
import java.awt.Image;
import org.jbox2d.common.Vec2;

/**
 *Abstract class that builds the basic components in the world
 * @author Minnakan Seral
 */
public abstract class BaseLevel extends World{

    /**
     *
     */
    public character_Main pirate;
    
    /**
     *
     * @return
     */
    public character_Main getPlayer(){
        return pirate;
    }

    /**
     *Creates the base structure of the game world.
     * @param game
     */
    public void  populate(IN1007_Project game){
   
        //making the ground        
        Shape groundShape = new BoxShape(16, 1.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -16f));
        SolidFixture fixture = new SolidFixture(ground,groundShape);
        fixture.setFriction(1f);
        
        
        //making the roof
        Shape roofShape = new BoxShape(16, 0.5f);
        Body roof = new StaticBody(this, roofShape);
        roof.setPosition(new Vec2(0, 16f));
       
        
        
        //making the walls
        Shape leftWallShape = new BoxShape(0.25f,15);
        Body leftwall = new StaticBody(this, leftWallShape);
        leftwall.setPosition(new Vec2( -15f,0));
        
        Shape rightWallShape = new BoxShape(0.25f,15);
        Body rightwall = new StaticBody(this, rightWallShape);
        rightwall.setPosition(new Vec2( 15f,0));
        
        //spawning the playable character
        pirate = new character_Main(this);
        pirate.setPosition(startPosition());
        pirate.addImage(new BodyImage("data/pirate_1.png",2f));
        
        //spawning the door
        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));
        
     
    }

    /**
     *The start position of the controllable character
     * @return
     */
    public abstract Vec2 startPosition();
    
    /**
     *Specifies door position for each level that extends this abstract class.
     * @return
     */
    public abstract Vec2 doorPosition();
    
    /**
     *Method to check weather the level is completed.
     * @return
     */
    public abstract boolean isCompleted();
    
    /**
     *Method to return a background image for each level.
     * @return
     */
    public abstract Image returnBackground();
    
    /**
     *
     * @return
     */
    public abstract character_Main getCharacter();
    
    /**
     *
     * @return
     */
    public abstract int getHealth();
    
    /**
     *
     * @param health
     */
    public abstract void setHealth(int health);
    
    /**
     *
     * @param pause
     */
    public abstract void pauseTimer(Boolean pause);
    
    /**
     *Method to return a background music for each level.
     * @return
     */
    public abstract SoundClip returnMusic();
    
}
    
 
  
    
        

