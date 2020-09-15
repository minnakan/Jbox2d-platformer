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
 *The spike obstacle
 * @author Minnakan Seral
 */
public class spikes extends StaticBody {
    
    /**
     *
     * @param world
     * @param direction
     */
    public spikes(World world,String direction){
        super(world);
        if(direction.equals("up")){
        Shape spikeShape = new PolygonShape(-0.302f,-0.747f, 0.369f,-0.735f, 0.052f,0.804f);
        SolidFixture spikeFixture = new SolidFixture(this,spikeShape,10);
        addImage(new BodyImage("data/spike1.png",2f));
        }
        else if(direction.equals("right")){
        Shape spikeShape = new PolygonShape(-1.284f,-0.613f, -1.297f,0.508f, 1.354f,-0.064f);
        SolidFixture spikeFixture = new SolidFixture(this,spikeShape,10);
        addImage(new BodyImage("data/rightSpike.png",2f));
        }
        else if(direction.equals("left")){
        Shape spikeShape = new PolygonShape(1.264f,-0.468f, 1.268f,0.662f, -1.413f,0.121f);
        SolidFixture spikeFixture = new SolidFixture(this,spikeShape,10);
        addImage(new BodyImage("data/leftSpike.png",2f));
        }
        else if(direction.equals("down")){
        Shape spikeShape = new PolygonShape(-0.375f,0.737f, 0.277f,0.74f, -0.06f,-0.81f);
        SolidFixture spikeFixture = new SolidFixture(this,spikeShape,10);
        addImage(new BodyImage("data/downSpike.png",2f));
        }
        
    }
}
