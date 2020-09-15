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
 *The canon ball projectile
 * @author Minnakan Seral
 */
public class canonBall extends DynamicBody {

    /**
     *
     * @param world
     */
    public canonBall(World world)
    {
       super(world);
       float canonBallRadius = 0.35f;
       Shape canonBallShape = new CircleShape(canonBallRadius);
       SolidFixture canonBallFixture = new SolidFixture(this,canonBallShape , 10);
       addImage(new BodyImage("data/canonBall.png", 4*canonBallRadius));
    }  
   
}
