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
 *A slimeBall projectile
 * @author Minnakan Seral
 */
public class slimeBall extends DynamicBody {

    /**
     *
     * @param world
     */
    public slimeBall(World world)
    {
       super(world);
       float slimeBallRadius = 0.25f;
       Shape slimeBallShape = new CircleShape(slimeBallRadius);
       SolidFixture canonBallFixture = new SolidFixture(this,slimeBallShape , 10);
       addImage(new BodyImage("data/slimeBall.png", 4*slimeBallRadius));
    }  
   
}