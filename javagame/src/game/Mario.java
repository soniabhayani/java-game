package game;

import city.cs.engine.*;

public class Mario extends Walker  {
    // Remember:  using the keyword s tatic below means the fields shape and image belong to the class, rather than any instance.
    // That means there is a single shape and image for all instances of the class.
    private static final Shape shape = new PolygonShape(
            -0.437f,-1.111f, 0.391f,-1.111f, 0.706f,-0.378f, 0.373f,0.819f, 0.004f,1.139f, -0.378f,0.828f, -0.72f,-0.36f);

    private static final BodyImage image =
            new BodyImage("data/mario.png", 2.25f);

    private int coinCount;
    private int lifeCount;

    public Mario(World world) {
        super(world, shape);
        addImage(image);
        coinCount = 0;
        lifeCount = 3;
    }
    public void setCoinCount(int coinCount) {
        this.coinCount = coinCount;
    }
    public int getCoinCount() {
        return coinCount;
    }

    public void incrementCoinCount() {
        coinCount++;
        System.out.println("Yahoo!!  Coin count = " + coinCount);
    }
    public void setLifeCount(int lifeCount) {
        this.lifeCount = lifeCount;
    }
    public int getLifeCount() {

        return lifeCount;
    }

    public void decrementLifeCount() {
        lifeCount--;
        System.out.println("Ohhhh. Mamma Mia! Lives = " + lifeCount);
        if (lifeCount == 0) {
            System.exit(0);
        }
    }

}

