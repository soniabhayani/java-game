package game;

import city.cs.engine.*;

import java.awt.*;
import java.util.List;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JFrame;
import org.jbox2d.common.Vec2;

/**
 * The computer game.
 */
public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel world;

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;
    private int level;
    private Controller controller;
    private SoundClip gameMusic;


    /** Initialise a new Game. */
    public Game() {
        try {
            gameMusic = new SoundClip("data/background.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continous playback (looping)
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }

        // make the world
        level = 1;
        world = new Level1();
        world.populate(this);
        world.addStepListener(new TurtleStep(world.getTurtle()));
        view = new MyView(world, world.getPlayer(), 500, 500);

        // make a view
        // uncomment this to draw a 1-metre grid over the view
        // view.setGridResolution(1);

        // display the view in a frame
        final JFrame frame = new JFrame("Event handling");

        ControlPanel buttons = new ControlPanel(this);
        frame.add(buttons.getMainPanel(), BorderLayout.WEST);

        // quit the application when the game window is closed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // display the world in the window
        frame.add(view);
        // don't let the game window be resized
        frame.setResizable(false);
        // size the game window to fit the world view
        frame.pack();
        // make the window visible
        frame.setVisible(true);
        // get keyboard focus
        frame.requestFocus();
        // give keyboard focus to the frame whenever the mouse enters the view
        view.addMouseListener(new GiveFocus(frame));


        controller = new Controller(world.getPlayer());
        frame.addKeyListener(controller);
        
        // uncomment to make the view track Mario
        //world.addStepListener(new Tracker(view, world.getPlayer()));

        // uncomment this to make a debugging view
        //JFrame debugView = new DebugViewer(world, 500, 500);

        // start!
        world.start();
    }
    /** The player in the current level. */
    public Mario getPlayer() {
        return world.getPlayer();
    }

    public void pause(){
        world.stop();
    }
    public void resume(){ world.start();}

    /** Is the current level of the game finished? */
    public boolean isCurrentLevelCompleted() {
        return world.isCompleted();
    }

    /** Advance to the next level of the game. */
    public void goNextLevel() {
        world.stop();
        if (level == 3) {
            System.exit(0);
        }
        else if (level ==0){
            level++;
            // get a new world
            world = new Level1();

            // fill it with bodies
            world.populate(this);
            world.addStepListener(new TurtleStep(world.getTurtle()));
            view.updateMario(world.getPlayer());
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.start();
        } else if (level ==1){
            level++;
            // get a new world
            world = new Level2();
            // fill it with bodies
            world.populate(this);
            world.addStepListener(new TurtleStep(world.getTurtle()));
            view.updateMario(world.getPlayer());
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.start();
        }
        else if (level ==2){
            level++;
            // get a new world
            world = new Level3();
            // fill it with bodies
            world.populate(this);
            world.addStepListener(new TurtleStep(world.getTurtle()));
            view.updateMario(world.getPlayer());
            // switch the keyboard control to the new player
            controller.setBody(world.getPlayer());
            // show the new world in the view
            view.setWorld(world);
            world.start();
        }
    }

    public void setLevel(int level) {this.level = level;}
    public int getLevel() {return level;}


    /** Run the game. */
    public static void main(String[] args) {
        new Game();
     
        
    }
}
