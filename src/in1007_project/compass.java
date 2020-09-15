
package in1007_project;

import city.cs.engine.BodyImage;
import city.cs.engine.DynamicBody;
import city.cs.engine.PolygonShape;
import city.cs.engine.World;

/**
 *A compass item
 * @author Minnakan Seral
 */
public class compass extends DynamicBody {

    /**
     *
     * @param world
     */
    public compass(World world){
        super(world,new PolygonShape(-0.183f,0.736f, 0.266f,0.741f, 0.626f,0.071f,
                0.345f,-0.723f, -0.269f,-0.73f, -0.611f,0.053f));
        addImage(new BodyImage("data/compass.png", 2f));
        
    }
    
}
