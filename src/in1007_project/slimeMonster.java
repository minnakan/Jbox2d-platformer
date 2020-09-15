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
 *A slime type enemy monster
 * @author Minnakan Seral
 */
public class slimeMonster extends DynamicBody {
    
    /**
     *
     * @param world
     */
    public slimeMonster(World world){
        super(world);
        Shape slimeMonster= new PolygonShape(0.47f,-0.76f, -1.44f,-0.78f, -1.74f,0.47f, -0.81f,1.2f, 0.85f,1.26f, 1.3f,0.36f);
        SolidFixture slimeFixteure = new SolidFixture(this,slimeMonster , 10);
    }
    
}
