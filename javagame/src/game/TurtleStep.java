package game;
import city.cs.engine.BodyImage;
import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;

public class TurtleStep implements StepListener {
    private Turtle turtle;

    public TurtleStep(Turtle turtle) {this.turtle = turtle;}

    @Override
    public void preStep(StepEvent e) {
    }
    /**
     *Causes the tiger to change direction once it reaches a certain x-direction.
     */
    @Override
    public void postStep(StepEvent e) {
        if (turtle.getxPos() > turtle.getStartXPos() +5){
            turtle.setEnemyDirection(-1);
        }
        if(turtle.getxPos() < turtle.getStartXPos()-3){
            turtle.setEnemyDirection(1);
        }
        turtle.getxPos();
        turtle.startWalking(3*turtle.getEnemyDirection());
    }
}