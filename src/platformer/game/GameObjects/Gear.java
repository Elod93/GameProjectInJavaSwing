package platformer.game.GameObjects;

import platformer.game.ImageContainingClass.GearDisplay;

import java.awt.*;
import java.util.List;

public class Gear extends InteractiveObject {

    private GearDisplay gearDisplay;

    public Gear(int x, int y) {
        this.gearDisplay = new GearDisplay();
        super.isActive = true;
        super.x = x;
        super.y = y;
        super.width = 50;
        super.height = 50;
        super.hitBox = new Rectangle(x, y, width, height);
        super.tempDisplayImage = gearDisplay.getImageList().get(0);
    }

    @Override
    public void draw(Graphics2D gtd) {
        if (isActive) {
            gtd.drawImage(tempDisplayImage, x, y, width, height, null);
        }
    }


    @Override
    public void interaction(Player player, List<Obstacle> obstacleList) {
        if (player.getHitBox().intersects(this.hitBox)) {
            isActive = false;
        }
    }
}
