package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import java.lang.management.PlatformLoggingMXBean;

/**
 * A level of the game.
 */
public abstract class GameLevel extends World {
    private Mario mario;
    private Turtle turtle;
    private Plant plant;
    
    public Mario getPlayer() {
        return mario;
    }
    public Turtle getTurtle() { return turtle;}
    
    /**
     * Populate the world of this level.
     * Child classes should this method with additional bodies.
     */
    public void populate(Game game) {

        // make a character
        mario = new Mario(this);
        mario.setPosition(startPosition());

        turtle = new Turtle(this);
        turtle.setPosition(turtlePosition());
        turtle.addCollisionListener(new Pickup(getPlayer()));

        plant = new Plant(this);
        plant.setPosition(new Vec2(-4, -9.2f));
        plant.addCollisionListener(new Pickup(mario));

        Door door = new Door(this);
        door.setPosition(doorPosition());
        door.addCollisionListener(new DoorListener(game));
    }
    
    /** The initial position of the player. */
    public abstract Vec2 startPosition();
    
    /** The position of the exit door. */
    public abstract Vec2 doorPosition();

    /** The position of the turtle. */
    public abstract Vec2 turtlePosition();
    
    /** Is this level complete? */
    public abstract boolean isCompleted();
}
