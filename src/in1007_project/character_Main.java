/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 *The playable character (walker)
 * @author Minnakan Seral
 */
public class character_Main extends Walker  {
    private float friction = 0.5f;
    private static Shape characterMain = new PolygonShape(-0.658f,0.363f, -0.356f,0.972f, 0.351f,0.966f, 0.705f,0.623f,
            0.668f,-0.36f, 0.465f,-0.992f, -0.397f,-0.974f, -0.637f,-0.425f);
    
    /**
     *
     */
    public boolean skullFound;

    /**
     *
     */
    public int itemcount;

    /**
     *
     */
    public int health = 100;

    /**
     *
     */
    public IN1007_Project game;
    
    /**
     *Constructor for the class
     * 
     * @param world
     */
    public character_Main(World world){
        super(world,characterMain);
    }

    /**
     *Increments each time a character picks up an item.
     * <p>
     * main property of the controllable player. Set number of items must be picked up before progressing on to the next level
     */
    public void setItemValue() {
        //System.out.println("You have found an item");
        itemcount++;
        System.out.println("Item Count ="+itemcount);

        
    }

    /**
     *Called whenever a payer takes damage.
     * <p>
     * All projectiles and enemies do -25 damage on each hit. Game ends when health reaches zero. The player has 100 health to start with.
     */
    public void decrementHealthValue(){
        if(health>0){
        health = health -25;
        System.out.println("You took damage");
        System.out.println("Health = "+health);
        }
        
        if(health<=0){
            System.out.println("Game Over");
         game.restart();
        }
    }
    
    /**
     *
     * @return
     */
    public int getItemcount() {
        return itemcount;
    }

    /**
     *
     * @return
     */
    public int getHealth() {
        return health;
    }
    
    /**
     *
     * @param health
     * @return
     */
    public int setHealth(int health){
        this.health=health;
        return health;
    }
}
