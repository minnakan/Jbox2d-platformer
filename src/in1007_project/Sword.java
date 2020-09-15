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
 *Creates a sword item
 * @author Minnakan Seral
 */
public class Sword extends DynamicBody{
    
    /**
     *
     * @param world
     */
    public Sword(World world)
    {
    super(world);
            Shape swordShape=new PolygonShape(-0.959f,0.642f, 0.922f,0.735f, 1.271f,0.116f, 0.614f,-0.791f,
                    -0.642f,-0.773f, -1.475f,-0.014f, -1.103f,0.54f);
        SolidFixture swordFixture = new SolidFixture(this,swordShape,10);
        addImage(new BodyImage("data/sword.gif",2.25f));
    }
}
