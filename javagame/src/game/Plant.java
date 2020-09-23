package game;

import city.cs.engine.*;

public class Plant extends StaticBody {

    private static final Shape shape = new PolygonShape(
            0.84f,-1.62f, 1.0f,-0.22f, 0.75f,1.39f, -0.71f,1.56f, -1.08f,-0.57f);

    private static final BodyImage image =
            new BodyImage("data/piranha.gif", 3.5f);


    public Plant(World world) {
        super(world, shape);
        addImage(image);
    }
}
