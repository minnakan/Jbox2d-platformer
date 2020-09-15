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
 *A map item
 * @author Minnakan Seral
 */
public class map extends DynamicBody{
        
    /**
     *
     * @param world
     */
    public map(World world){
         super(world);
       Shape skullShape = new PolygonShape(-0.7f,0.085f, -0.597f,0.383f, 0.698f,0.392f,
               0.868f,0.0f, 0.772f,-0.308f, -0.521f,-0.306f, -0.707f,-0.063f);
       SolidFixture canonBallFixture = new SolidFixture(this,skullShape , 10);
       addImage(new BodyImage("data/map.gif", 1.75f));
    }
    
}
