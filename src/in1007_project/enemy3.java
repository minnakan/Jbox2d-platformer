/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.Walker;
import city.cs.engine.World;

/**
 *Enemy walker for level 3
 * @author Minnakan Seral
 */
public class enemy3 extends Walker {
    
    private static Shape enemy3= new PolygonShape(-0.46f,0.74f, 0.64f,0.73f, 1.29f,0.1f, 0.87f,-0.91f,
            0.48f,-1.26f, -0.55f,-1.25f, -1.21f,-0.16f);

    /**
     *
     * @param world
     */
    public enemy3(World world){
    super(world,enemy3);
       addImage(new BodyImage("data/boss.gif",3.5f));
    }
}
