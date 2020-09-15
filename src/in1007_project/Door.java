/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *The door objective that allows payer to progress levels
 * @author Minnakan Seral
 */
public class Door extends StaticBody {
    public Door(World world){
    super(world,new PolygonShape(-0.782f,-0.864f, -0.777f,0.172f, -0.533f,0.615f, -0.09f,0.848f,
            0.123f,0.845f, 0.571f,0.599f, 0.804f,0.164f, 0.798f,-0.864f));
    addImage(new BodyImage("data/door1.png", 3f));
    
    }
    
}
