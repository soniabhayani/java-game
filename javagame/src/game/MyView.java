package game;

import java.awt.Graphics2D;
import java.awt.Image;
import javax.swing.ImageIcon;
import city.cs.engine.*;

/**
 * extended view
 */
public class MyView extends UserView {
    Mario mario;
    private Game game;

    private Image background;

    public MyView(World world, Mario mario, int width, int height) {
        super(world, width, height);
        this.mario = mario;
        this.game = game;
        this.background = new ImageIcon("data/game-background.jpg").getImage();
    }
    public  void updateMario(Mario mario){
        this.mario = mario;
    }
    @Override
    protected void paintBackground(Graphics2D g) {
             g.drawImage(background, 0, 0, this);
        //if (game.getLevel() == 1) {
        //    g.drawImage(background, 0, 0, this);
       // }

       // if (game.getLevel() == 2) {
       //     this.background = new ImageIcon("data/game-background.png").getImage(); //change background
       //     g.drawImage(background, 0, 0, this);

      //  }
      //  if (game.getLevel() == 3) {
      //      this.background = new ImageIcon("data/background3.png").getImage(); //change background
      //      g.drawImage(background, 0, 0, this);
      //  }
    }
    @Override
    protected void paintForeground(Graphics2D g) {
        g.drawString( "Score:" + mario.getCoinCount(),100,100);
        g.drawString("Lives:" + mario.getLifeCount(), 450, 50);
    }


}
