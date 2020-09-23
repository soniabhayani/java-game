package game;

import city.cs.engine.*;

/**
 * Doors in a game. When the actor collides with a door, if
 * the current level is complete the game is advanced to the
 * next level. 
 */
public class Door extends StaticBody {
    
    /**
     * Initialise a new door.
     * @param world The world.
     */
        private static final Shape shape = new PolygonShape(
            -0.578f,0.738f, -0.578f,0.306f, -0.449f,-0.735f, 0.454f,-0.732f, 0.58f,0.306f, 0.58f,0.729f);

        private static final BodyImage image =
                new BodyImage("data/pipe.png", 1.5f);


    public Door(World world) {
            super(world, shape);
            addImage(image);
    }
}
