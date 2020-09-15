/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.World;

/**
 *The chest item
 * @author Minnakan Seral
 */
public class chest extends DynamicBody {

    /**
     *
     * @param world
     */
    public chest(World world){
        super(world,new PolygonShape(-0.558f,-0.54f, -0.68f,0.193f, -0.477f,0.567f, 0.47f,0.573f,
                0.663f,0.177f, 0.512f,-0.553f));
        addImage(new BodyImage("data/chest.png", 2f));
        
    }
    
}
