package game;

import city.cs.engine.*;

public class Turtle extends Walker {
    private float startXPos = 4;
    private float xPos;
    private int enemyDirection = 1;
    // Remember:  using the keyword static below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            0.845f,-0.931f, 1.001f,-0.133f, 0.372f,0.942f, -0.791f,0.611f, -1.008f,0.368f, -0.866f,-0.924f);

    private static final BodyImage image =
            new BodyImage("data/turtle.png", 2.25f);


    public Turtle(World world) {
        super(world, shape);
        addImage(image);
    }
    public float getxPos() {
        xPos = getPosition().x;
        return xPos;
    }

    public float getStartXPos() {
        return startXPos; }


    public int getEnemyDirection() { return enemyDirection;}
    public void setEnemyDirection(int enemyDirection) {
        this.enemyDirection = enemyDirection;
    }
}

