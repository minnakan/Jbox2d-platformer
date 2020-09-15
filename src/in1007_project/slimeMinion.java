/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.World;

/**
 *A slime type enemy
 * @author Minnakan Seral
 */
public class slimeMinion extends DynamicBody {
   
    private IN1007_Project game;
    
    /**
     *
     * @param world
     */
    public slimeMinion(World world){
    super(world);
        Shape slimeMinionShape = new PolygonShape(0.52f,0.76f, -0.46f,0.77f, -0.84f,0.35f, -0.81f,
                -0.46f, 0.33f,-0.46f, 0.76f,0.21f);
        SolidFixture slimeFixture = new SolidFixture(this,slimeMinionShape , 10);

}
}
