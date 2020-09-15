package in1007_project;
import city.cs.engine.*;
import java.awt.BorderLayout;
import java.awt.Container;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;

/**
 *Main class that constructs the game
 * @author Minnakan Seral
 */
public class IN1007_Project {

    /**
     *
     */
    public BaseLevel world;
    private MyView view;
    private int lvl;
    private Controller controller;
    private boolean pause = false;  

    /**
     *
     */
    public character_Main pirate;
    int health;

    /**
     *
     */
    public SoundClip music;

    /**
     *
     */
    public double musicVol =0.25;

    /**
     *
     */
    public IN1007_Project(){
        lvl = 1;
        world = new Level1();
        world.populate(this);
        view = new MyView(world,world.getPlayer(),600,600);
        view.setbackground(world.returnBackground());
        //view.setGridResolution(1);
        final JFrame frame = new JFrame("Project");
        //JFrame debugView = new DebugViewer(world, 600, 600);
        Container buttons = new controlPannel(this);
        frame.add(buttons, BorderLayout.NORTH);

        
 
        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.add(view);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);
        
        frame.requestFocus();
        view.addMouseListener(new GiveFocus(frame));
        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);
        
        world.start();
        music = world.returnMusic();
        music.play();
        music.setVolume(musicVol);
   
        }  
        
    /**
     *
     * @return
     */
    public character_Main getPlayer(){
        return world.getPlayer();
       }
       
    /**
     *checks completion of level
     * @return
     */
    public boolean isCurrentLevelCompleted() {
      return world.isCompleted();
    }

    /**
     *switches level if the level is completed
     */
    public void switchLevel() {
           health=world.getHealth();
           world.stop();
           music.stop();
        if (lvl == 3) {
            world = new LevelEnd();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setbackground(world.returnBackground());
            view.updatePirate(world.pirate);
            view.setWorld(world);
            world.start();
            music = world.returnMusic();
            music.play();
            music.setVolume(0.25);
        } else if(lvl ==1) {
            lvl++;
            world = new Level2();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setbackground(world.returnBackground());
            view.updatePirate(world.pirate);
            view.setWorld(world);
            world.start();
            world.setHealth(health);
            music = world.returnMusic();
            music.play();
            music.setVolume(0.25);
        }
        else if(lvl ==2) {
            lvl++;
            world = new Level3();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            view.setbackground(world.returnBackground());
            view.updatePirate(world.pirate);
            world.start();
            world.setHealth(health);
            music = world.returnMusic();
            music.play();
            music.setVolume(0.25);
        }
    } 
          
    /**
     *Method to end game
     */
    public void end(){
           world.stop();
          }
          
    /**
     *Method to pause game
     */
    public void pause(){
              if(!pause){
              world.stop();
              world.pauseTimer(pause);
              music.pause();
              pause = true;
              }
              else if(pause == true){
              world.start();
              world.pauseTimer(pause);
              music.play();
              music.loop();
              pause =false;
               }
          }

    /**
     *Method to restart current level
     */
    public void restart(){
            if(lvl==1){
            world.stop();
            world = new Level1();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            view.updatePirate(world.pirate);
            world.start();
            }
            if(lvl==2){
            world.stop();
            world = new Level2();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            view.updatePirate(world.pirate);
            world.start();
            }
            
            if(lvl==3){
            world.stop();
            world = new Level3();
            world.populate(this);
            controller.setBody(world.getPlayer());
            view.setWorld(world);
            view.updatePirate(world.pirate);
            world.start();
            }
          }

    /**
     *
     */
    public void increaseVolume(){
              musicVol=musicVol+0.05;
              music.setVolume(musicVol);
              System.out.println("volume="+musicVol);
          }
          
    /**
     *
     */
    public void decreaseVolume(){
              musicVol=musicVol-0.05;
              if (musicVol<=0.05){
                  musicVol=musicVol+0.05;
              }
              music.setVolume(musicVol);
              System.out.println("volume="+musicVol);
          }

    /**
     *
     * @param args
     */
    public static void main(String[] args) {
        new IN1007_Project();
        
    }
    
}
