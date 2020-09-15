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
 *A key item
 * @author Minnakan Seral
 */
public class key extends DynamicBody {

    /**
     *
     * @param world
     */
    public key(World world){
        super(world);
        Shape keyShape=new PolygonShape(-0.205f,0.868f, 0.068f,0.865f, 0.253f,0.52f, 0.335f,-0.14f, 0.273f,-0.858f,
                -0.154f,-0.858f, -0.332f,-0.212f, -0.352f,0.537f);
        SolidFixture keyFixture = new SolidFixture(this,keyShape,10);
        addImage(new BodyImage("data/key.gif",1.75f));
    }
    
}
