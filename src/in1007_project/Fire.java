/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in1007_project;

import city.cs.engine.BodyImage;
import city.cs.engine.PolygonShape;
import city.cs.engine.Shape;
import city.cs.engine.SolidFixture;
import city.cs.engine.StaticBody;
import city.cs.engine.World;

/**
 *The fire obstacle
 * @author Minnakan Seral
 */
public class Fire extends StaticBody {
    
    public Fire(World world){
            super(world);
            Shape fireShape = new PolygonShape(-0.52f,-0.661f, 0.257f,-0.654f, 0.328f,-0.064f,
                    0.155f,0.567f, -0.412f,0.57f, -0.649f,0.018f);
        SolidFixture fireFixture = new SolidFixture(this,fireShape,10);
        addImage(new BodyImage("data/fire.gif",5f));
    }
    
}
