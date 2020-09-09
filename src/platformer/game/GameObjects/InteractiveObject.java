package platformer.game.GameObjects;

import java.util.List;
import java.awt.*;

public abstract class InteractiveObject extends GameObject {
    boolean isActive;
    Rectangle hitBox;

    public InteractiveObject() {
        this.hitBox = new Rectangle(super.x, super.y, super.width, super.height);
    }

    public abstract void interaction(Player player,List<Obstacle> obstacleList);
}
