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
 *
 * @author Minnakan Seral
 */
public class gem extends DynamicBody {
    public gem(World world){
        super(world);
        Shape gemShape=new PolygonShape(-0.504f,-0.401f, 0.525f,-0.396f, 0.062f,0.582f, -0.036f,0.587f, -0.489f,-0.34f);
        SolidFixture gemFixture = new SolidFixture(this,gemShape,10);
        addImage(new BodyImage("data/gem.png",1.75f));
    }
    
}
