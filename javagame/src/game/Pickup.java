package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

/**
 * Collision listener that allows the bird to collect things.
 */
public class Pickup implements CollisionListener {
    private Mario mario;

    public Pickup(Mario mario) {
        this.mario = mario;
    }

    @Override
    public void collide(CollisionEvent e) {
        if (e.getReportingBody() instanceof Turtle && e.getOtherBody() == mario) {
            mario.decrementLifeCount();

        } else if (e.getReportingBody() instanceof Plant && e.getOtherBody() == mario) {
            mario.decrementLifeCount();
        }

        if (e.getReportingBody() instanceof Coin && e.getOtherBody() == mario) {
            mario.incrementCoinCount();
            e.getReportingBody().destroy();
        }

    }
}

