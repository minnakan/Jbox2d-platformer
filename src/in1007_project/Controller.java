package in1007_project;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * Key handler to control an Walker.
 */
public class Controller extends KeyAdapter {
    private static float JUMPING_SPEED = 16;
    private static float WALKING_SPEED;
    
    private Walker body;
    
    public Controller(Walker body) {
        this.body = body;
    }
    
    /**
     * Handle key press events for walking and jumping.
     * @param e description of the key event
     */
    @Override
    public void keyPressed(KeyEvent e) {
        int code = e.getKeyCode();
            if (code == KeyEvent.VK_W) { // W = jump
            Vec2 v = body.getLinearVelocity();
            // only jump if body is not already jumping
            if (Math.abs(v.y) < 0.01f) {
                body.jump(JUMPING_SPEED);
            }
        } else if (code == KeyEvent.VK_A) {
            WALKING_SPEED = 5;
            body.startWalking(-WALKING_SPEED); // A = walk left
            body.removeAllImages();
            body.addImage(new BodyImage("data/left1.png",2f));
        } else if (code == KeyEvent.VK_D) {
            WALKING_SPEED = 5;
            body.startWalking(WALKING_SPEED); // d = walk right
            body.removeAllImages();
            body.addImage(new BodyImage("data/pirate_1.png",2f));
            
           
        }
    }
    
    /**
     * Handle key release events (stop walking).
     * @param e description of the key event
     */
    @Override
    public void keyReleased(KeyEvent e) {
        int code = e.getKeyCode();
        if (code == KeyEvent.VK_A) {
            body.stopWalking();
            
        } else if (code == KeyEvent.VK_D) {
            body.stopWalking();
        }
    }
        public void setBody(Walker body) {
        this.body = body;
    }
}

