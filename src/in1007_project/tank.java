/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *The tank item
 * @author Minnakan Seral
 */
public class tank extends StaticBody{
    
    /**
     *
     * @param world
     * @param direction
     */
    public tank(World world,String direction){
        super(world);
        if(direction.equals("right")){
            Shape tankShape = new PolygonShape(0.473f,-0.395f, 0.63f,0.022f, 0.555f,0.397f, -0.312f,0.4f,
                    -0.575f,0.063f, -0.432f,-0.395f);
        SolidFixture tankFixture = new SolidFixture(this,tankShape,10);
        addImage(new BodyImage("data/tank.png",3f));
        }
        else if(direction.equals("left")){
            Shape tankShape = new PolygonShape(0.473f,-0.395f, 0.63f,0.022f, 0.555f,0.397f, -0.312f,0.4f,
                    -0.575f,0.063f, -0.432f,-0.395f);
        SolidFixture tankFixture = new SolidFixture(this,tankShape,10);
        addImage(new BodyImage("data/tank2.png",3f));
        }
    }
    
}
