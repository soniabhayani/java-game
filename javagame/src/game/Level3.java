package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Level 3 of the game
 */
public class Level3 extends GameLevel {

    private static final int NUM_COINS = 11;

    /**
     * Populate the world.
     */
    @Override
    public void populate(Game game) {
        super.populate(game);

        // make the ground
        Shape groundShape = new BoxShape(11, 0.5f);
        Body ground = new StaticBody(this, groundShape);
        ground.setPosition(new Vec2(0, -11.5f));

        // walls
        Shape leftWallShape = new BoxShape(0.5f, 6, new Vec2(-11.5f, 5.5f));
        Fixture leftWall = new SolidFixture(ground, leftWallShape);
        Shape rightWallShape = new BoxShape(0.5f, 6, new Vec2(11.5f, 5.5f));
        Fixture rightWall = new SolidFixture(ground, rightWallShape);


        // make some platforms
        Shape platformShape = new BoxShape(4, 0.5f);
        Body platform1 = new StaticBody(this, platformShape);
        platform1.setPosition(new Vec2(-6, -1.5f));
        Body platform2 = new StaticBody(this, platformShape);
        platform2.setPosition(new Vec2(4, 3f));
        Body platform3 = new StaticBody(this, platformShape);
        platform3.setPosition(new Vec2(0, 7f));


        for (int i = 0; i < NUM_COINS; i++) {
            Body orange = new Coin(this);
            orange.setPosition(new Vec2(i * 2 - 10, 10));
            orange.addCollisionListener(new Pickup(getPlayer()));
        }
    }

    @Override
    public Vec2 startPosition() {
        return new Vec2(8, -10);
    }

    @Override
    public Vec2 doorPosition() {
        return new Vec2(-10.4f, -9.6f);
    }

    @Override
    public Vec2 turtlePosition() {
        return new Vec2(4, -10);
    }

    @Override
    public boolean isCompleted() {
        return getPlayer().getCoinCount() >= NUM_COINS;
    }
}
