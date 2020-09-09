package platformer.game.GameObjects;

import platformer.game.ImageContainingClass.TrollDisplay;
import platformer.game.MainGameLoop;

import java.awt.*;
import java.util.List;


public class Troll extends Creature {
    private boolean isChasePlayer;
    private TrollDisplay td;
    boolean movingLeft;
    boolean movingRight;
    private int pointA;
    private int pointB;
    private int display = 0;
    private int attackDisplay = 0;
    private boolean attackStance;
    private long attackTime;
    private int spriteDisplayFrequency;
    private int speedGear = 5;
    private boolean sideFlag;
    private boolean direction;


    public Troll(int x, int y, int spX1, int spX2) {
        this.td = new TrollDisplay();
        this.isChasePlayer = false;
        super.x = x;
        super.y = y;
        super.height = 60;
        super.width = 40;
        super.isActive = true;
        healthPoint = 3;
        pointA = spX1;
        pointB = spX2;
        super.hitBox = new Rectangle(x, y, width, height);
        super.tempDisplayImage = td.movementLeft.get(0);

    }

    public void draw(Graphics2D graphics2D) {

        if (isActive) {
            graphics2D.drawImage(tempDisplayImage, x - 10, y - 47, 82, 104, null);
            if (!attackStance) {
                if (movingLeft && !movingRight) {
                    trollMoveLeft();
                }
                if (movingRight && !movingLeft) {
                    trollMoveRight();
                }
            } else if (!direction) {
                attackAnimationRight();

            } else {
                attackAnimationLeft();

            }
        }
    }

    public void trollMoveRight() {
        if (spriteDisplayFrequency % speedGear == 0) {
            tempDisplayImage = td.movementRight.get(display);
            display++;
            if (display == 7) {
                display = 0;
            }
        }
        spriteDisplayFrequency++;
    }


    public void trollMoveLeft() {

        if (spriteDisplayFrequency % speedGear == 0) {
            tempDisplayImage = td.movementLeft.get(display);
            display++;
            if (display == 7) {
                display = 0;
            }
        }
        spriteDisplayFrequency++;
    }

    public void interaction(Player player, List<Obstacle> obstacleList) {
        if (isActive) {
            playerStatusCheck(player);
            if (isChasePlayer) {
                chasePlayer(player);
            } else {
                patrol();
            }

            ySpeed += 0.3;
            horizontalCollision(obstacleList);
            verticalCollision(obstacleList);
            x = x + (int) xSpeed;
            y = y + (int) ySpeed;
            hitBox.x = x;
            hitBox.y = y;
            //statusCheck();
            if(player.getHealthPoint()<0){
                player.setActive(false);
            }
        }
    }

    private void playerStatusCheck(Player player) {
        if ((player.getX() < this.x - 300) || (player.getX() - 300 > this.x)) {
            isChasePlayer = false;
        } else {
            isChasePlayer = true;
        }
    }

    private void chasePlayer(Player player) {

        if (player.getX() > this.x + 80 && !attackStance) {
            xSpeed = 2;
            movingLeft = false;
            movingRight = true;
            direction = true;
        } else if (player.getX() < this.x - 40 && !attackStance) {
            xSpeed = -2;
            movingLeft = true;
            movingRight = false;
            direction = false;
        } else {
            attack(player);
        }

    }

    private void attack(Player player) {
        if (this.hitBox.intersects(player.hitBox)) {
            xSpeed = 0;
            attackTime = MainGameLoop.roundCounter;
            attackStance = true;
            player.getAttacked(this);
        }
    }

    private void patrol() {

        if (this.x > pointA && this.x < pointB && !direction) {
            xSpeed = -1;
            movingLeft = true;
            movingRight = false;
        }
        if (this.x <= pointA) {
            direction = true;
            movingLeft = false;
            movingRight = true;
            xSpeed = 1;
        }
        if (this.x > pointA && this.x < pointB && direction) {
            xSpeed = 1;
            movingLeft = false;
            movingRight = true;
        }
        if (this.x >= pointB) {
            direction = false;
            movingLeft = true;
            movingRight = false;
            xSpeed = -1;
        }
    }

    @Override
    public void statusCheck() {
        if (attackStance) {
            xSpeed = 0;
        }
        if (healthPoint <= 0) {
            isActive = false;
        }
    }

    @Override
    public void getAttacked(Creature creature) {

        xSpeed = 0;
        if (creature.getX() > this.x) {
            this.x -= 50;
        } else {
            this.x += 50;
        }
        healthPoint--;
    }

    /**
     * Check horizontal collision
     **/
    private void horizontalCollision(List<Obstacle> obstacleList) {
        this.hitBox.x += xSpeed;
        for (Obstacle obstacle : obstacleList) {
            if (this.hitBox.intersects(obstacle.hitBox)) {
                this.hitBox.x -= xSpeed;
                while (!obstacle.hitBox.intersects(hitBox)) {
                    this.hitBox.x += Math.signum(xSpeed);
                    x += xSpeed;
                }
                hitBox.x -= Math.signum(xSpeed);
                xSpeed = 0;
                x = hitBox.x;
                jumpPhysics(obstacleList);
            }
        }
    }


    /**
     * Check vertical collision
     **/
    private void verticalCollision(List<Obstacle> obstacleList) {

        this.hitBox.y += ySpeed;
        for (Obstacle obstacle : obstacleList) {
            if (this.hitBox.intersects(obstacle.hitBox)) {
                this.hitBox.y -= ySpeed;
                while (!obstacle.hitBox.intersects(hitBox)) {
                    this.hitBox.y += Math.signum(ySpeed);
                }
                this.hitBox.y -= Math.signum(ySpeed);
                ySpeed = 0;
                y = hitBox.y;
            }
        }
    }

    /**
     * Jump
     **/
    private void jumpPhysics(List<Obstacle> obstacleList) {

        hitBox.y++;
        for (Obstacle obstacle : obstacleList) {
            if (obstacle.hitBox.intersects(this.hitBox)) {
                ySpeed = -7.5;
            }
        }
        hitBox.y--;


    }

    public void attackAnimationLeft() {
        if (attackTime != 0) {
            if (MainGameLoop.roundCounter == attackTime) {
                tempDisplayImage = td.rightAttack.get(0);
            } else if (MainGameLoop.roundCounter == attackTime + 10) {
                tempDisplayImage = td.rightAttack.get(1);
            } else if (MainGameLoop.roundCounter == attackTime + 20) {
                tempDisplayImage = td.rightAttack.get(2);
            } else if (MainGameLoop.roundCounter == attackTime + 30) {
                tempDisplayImage = td.rightAttack.get(3);
            } else if (MainGameLoop.roundCounter == attackTime + 40) {
                tempDisplayImage = td.rightAttack.get(4);
                attackStance = false;
            }
        }
    }

    public void attackAnimationRight() {
        if (attackTime != 0) {
            if (MainGameLoop.roundCounter == attackTime) {
                tempDisplayImage = td.leftAttack.get(0);
            } else if (MainGameLoop.roundCounter == attackTime + 10) {
                tempDisplayImage = td.leftAttack.get(1);
            } else if (MainGameLoop.roundCounter == attackTime + 20) {
                tempDisplayImage = td.leftAttack.get(2);
            } else if (MainGameLoop.roundCounter == attackTime + 30) {
                tempDisplayImage = td.leftAttack.get(3);
            } else if (MainGameLoop.roundCounter == attackTime + 40) {
                tempDisplayImage = td.leftAttack.get(4);
                attackStance = false;
            }
        }
    }
}


