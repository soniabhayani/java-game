package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * A world with some bodies.
 */
public class GameWorld extends World {
    private Mario mario;
    private Turtle turtle;
    private Plant plant;
    
    public GameWorld() {
        super();

        // make a character
        mario = new Mario(this);
        mario.setPosition(new Vec2(8, -10));

        // make a character
        turtle = new Turtle(this);
        turtle.setPosition(new Vec2(4, -10));
        turtle.addCollisionListener(new Pickup(mario));

        // make a character
        plant = new Plant(this);
        plant.setPosition(new Vec2(5, -10));
        plant.addCollisionListener(new Pickup(mario));


        for (int i = 0; i < 11; i++) {
            Body coin = new Coin(this);
            coin.setPosition(new Vec2(i*2-10, 10));
            coin.addCollisionListener(new Pickup(mario));
        }
    }
    
    public Mario getPlayer() {
        return mario;
    }
}
