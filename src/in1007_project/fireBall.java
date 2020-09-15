/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.BodyImage;
import city.cs.engine.CircleShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

/**
 *A fireball projectile
 * @author Minnakan Seral
 */
public class fireBall extends DynamicBody {

    /**
     *
     * @param world
     */
    public fireBall(World world)
    {
       super(world);
       float fireBallRadius = 0.25f;
       Shape fireBallShape = new CircleShape(fireBallRadius);
       SolidFixture fireBallFixture = new SolidFixture(this,fireBallShape , 10);
       addImage(new BodyImage("data/fireBall.gif", 4*fireBallRadius));
    }  
   
}
