package platformer.game.GameObjects;

import java.awt.*;
import java.awt.image.BufferedImage;

public abstract class GameObject {
     int x;
     int y;
     int width;
     int height;
     BufferedImage tempDisplayImage;                 // The current image drawn by: draw() method, in each "turn"

    public GameObject() {
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public abstract void draw(Graphics2D gtd);
}
