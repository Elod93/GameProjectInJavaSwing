package platformer.game.GameObjects;

import platformer.game.ImageContainingClass.SliderDisplay;

import java.awt.*;
import java.util.List;

public class Slider extends Creature {

    private SliderDisplay sliderDisplay;
    public Slider(int x, int y) {
        this.isActive = true;
        this.sliderDisplay = new SliderDisplay();
        super.x = x;
        super.y = y;
        super.height = 117;
        super.width = 106;
        super.hitBox = new Rectangle(x, y, width, height);
        super.tempDisplayImage = sliderDisplay.getRightMovement().get(0);
        this.healthPoint = 10;
    }

    public void draw(Graphics2D gtd) {
        if (isActive) {
            gtd.drawImage(tempDisplayImage, x, y, sliderDisplay.getDisplayWidth(), sliderDisplay.getDisplayHeight(), null);
        }
    }


    @Override
    public void interaction(Player player, List<Obstacle> obstacleList) {
        if (player.getX() + 200 > x && player.getX() - 200 < x) {
            if (isActive && player.isControlAble()) {
                movementAgainstPlayer(player);
            }
            statusCheck();
        }
    }

    private void movementAgainstPlayer(Player player) {

        if (player.getX() > (this.x + 100)) {
            //ha a hatótávolságon kívül ér +x irányban akkor követi xSpeed++
            MonsterActionRight(player);

        } else if (player.getX() <= (this.x + 100) && player.getX() >= (this.x - 40)) {
            //ha hatótávolságon belül ér elkezdi ütni, míg ki nem ér belőle a
            attackPlayer(player);

        } else if (player.getX() < (this.x - 40)) {
            //ha a hatótávolságon kívül ér -x irányban akkor követi xSpeed--
            MonsterActionLeft(player);
        }

        frictionHandling();
        setMaxXSpeed();
        x += xSpeed;
        hitBox.x = x;
    }

    private void MonsterActionRight(Player player) {
        if (player.getxSpeed() < 0) { //  <- erre megy)
            //bevárja egy helyben
            xSpeed = 0;
            this.tempDisplayImage = sliderDisplay.getRightStop();

        } else if (player.getxSpeed() >= 0) {
            xSpeed++;
            this.tempDisplayImage = sliderDisplay.getRightMovement().get(0);

        }
    }

    private void attackPlayer(Player player) {
        xSpeed = 0;
        attackAnimation(player);
        if (player.getHitBox().intersects(this.hitBox)) {
            if (player.isControlAble()) {
                player.getAttacked(this);
            }
        }
    }

    private void MonsterActionLeft(Player player) {
        if (player.getxSpeed() == 0) {   //<-
            //bevárja egy helyben
            xSpeed = 0;
            this.tempDisplayImage = sliderDisplay.getLeftStop();
        } else if (player.getxSpeed() > 0) {
//            xSpeed = 0;
//            this.tempDisplayImage = sliderDisplay.getLeftStop();
            xSpeed--;
            this.tempDisplayImage = sliderDisplay.getLeftMovement().get(0);
        } else if (player.getxSpeed() < 0) {    //->
            xSpeed--;
            this.tempDisplayImage = sliderDisplay.getLeftMovement().get(0);
        }
    }

    private void setMaxXSpeed() {
        int maxHrzSpeed = 6;
        if (xSpeed > maxHrzSpeed) {
            xSpeed = maxHrzSpeed;
        } else if (xSpeed < -maxHrzSpeed) {
            xSpeed = -maxHrzSpeed;
        }
    }

    private void frictionHandling() {
        if (xSpeed > 0 && xSpeed < 0.2) {
            xSpeed = 0;
        } else if (xSpeed < 0 && xSpeed > -0.2) {
            xSpeed = 0;
        }
    }

    private void attackAnimation(Player player) {
        if (player.getX() > x) {
            this.tempDisplayImage = sliderDisplay.getRightAttackMovement().get(0);
        } else {
            this.tempDisplayImage = sliderDisplay.getLeftAttackMovement().get(0);
        }
    }


    @Override
    public void statusCheck() {
        if (healthPoint <= 0) {
            isActive = false;
        }
    }

    @Override
    public void getAttacked(Creature creature) {
        xSpeed=0;
        if(creature.getX()>this.x){
            this.x -=50;
            tempDisplayImage=sliderDisplay.getRightStop();
        }else{
            this.x +=50;
            tempDisplayImage=sliderDisplay.getLeftStop();
        }
        healthPoint--;
    }
}
