package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.swing.*;
import java.awt.Color;
import java.io.IOException;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;

/**
 * A coin.
 */
public class Coin extends DynamicBody {
    private static final Shape shape = new PolygonShape(
            -0.153f,0.347f, 0.141f,0.347f, 0.344f,0.148f, 0.344f,-0.251f, 0.225f,-0.344f, -0.22f,-0.349f, -0.346f,-0.252f, -0.349f,0.148f);
    private static SoundClip coinSound;

    static {
        try {
            coinSound = new SoundClip("data/coinsound.wav");
            System.out.println("Loading coin sound");
        } catch (UnsupportedAudioFileException|IOException|LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage("data/coin.gif", 0.7f);
    
    public Coin(World world) {
        super(world, shape);
        addImage(image);
    }
    @Override
    public void destroy()
    {
        coinSound.play();
        super.destroy();
    }
}
