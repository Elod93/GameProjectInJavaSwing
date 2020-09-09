package platformer.game.GameObjects;

import java.util.List;

public abstract class Creature extends InteractiveObject {
    int healthPoint;
    double xSpeed;
    double ySpeed;


    public abstract void statusCheck();

    public abstract void getAttacked(Creature creature);
    @Override
    public void interaction(Player player, List<Obstacle> obstacleList) {

    }

}
