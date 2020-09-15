/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

/**
 *A skull item
 * @author Minnakan Seral
 */
public class skull extends DynamicBody {
    
    /**
     *
     * @param world
     */
    public skull(World world){
         super(world);
       Shape skullShape = new PolygonShape(-0.321f,0.51f, 0.321f,0.513f, 0.51f,0.329f,
       0.51f,-0.316f, 0.319f,-0.497f, -0.41f,-0.5f, -0.505f,-0.316f, -0.505f,0.327f);
       SolidFixture skullFixture = new SolidFixture(this,skullShape , 10);
       addImage(new BodyImage("data/skull.png", 1.75f));
    }
}
