package platformer.game.Levels;

import platformer.game.GameObjects.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FirstLevel extends Level {
    
    public FirstLevel() {
        super.player = new Player(300, 190);
        super.backGround = new BackGround(748, 3108, new File("").getAbsolutePath().concat("/src/Image_Resources/Lvl1Back.png"));
        super.foreGround = new BackGround(748, 3108, new File("").getAbsolutePath().concat("/src/Image_Resources/Lvl1Front2.png"));
        super.effect = new BackGround(748, 3108, new File("").getAbsolutePath().concat("/src/Image_Resources/effect1.png"));

        super.obstacleList = levelMaker();
        super.gear = new Gear(200, 200);
        super.creatureList = creatureListCreator();
    }

    @Override
    public boolean isFinished() {
        if (super.player.getX() > 3050) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public void set() {
        for (Creature creature : creatureList) {
            creature.interaction(player,  obstacleList);
        }
        player.set(obstacleList, creatureList);

    }

    @Override
    public void draw(Graphics2D gtd) {
        backGround.draw(gtd);
        for (Obstacle obstacle : obstacleList) {
            obstacle.draw(gtd);
        }
        for (Creature creature : creatureList) {
            creature.draw(gtd);
        }
        player.draw(gtd);
       foreGround.draw(gtd);
       effect.draw(gtd);
    }

    private List<Obstacle> levelMaker() {
        List<Obstacle> returnList = new ArrayList<>();
        //FirstRoom
        returnList.add(new Obstacle(50, 0, 50, 620));
        returnList.add(new Obstacle(0, 628, 450, 50));
        returnList.add(new Obstacle(460, 595, 170, 50));
        // plafon
        returnList.add(new Obstacle(460, 343, 170, 50));
        returnList.add(new Obstacle(640, 628, 260, 50));
        returnList.add(new Obstacle(910, 567, 260, 50));
        // plafon2
        returnList.add(new Obstacle(910, 310, 202, 50));
        // fuggoleges
        returnList.add(new Obstacle(1068, 0, 50, 310));
        returnList.add(new Obstacle(900, 565, 260, 50));
        //Stair
        returnList.add(new Obstacle(1165, 552, 15, 15));
        returnList.add(new Obstacle(1178, 535, 15, 15));
        returnList.add(new Obstacle(1193, 517, 17, 17));
        returnList.add(new Obstacle(1210, 500, 17, 17));
        returnList.add(new Obstacle(1227, 483, 17, 17));
        returnList.add(new Obstacle(1242, 463, 120, 30));
        returnList.add(new Obstacle(1365, 446, 15, 15));
        returnList.add(new Obstacle(1380, 430, 15, 15));
        returnList.add(new Obstacle(1395, 415, 15, 15));
        returnList.add(new Obstacle(1412, 397, 15, 15));
        returnList.add(new Obstacle(1432, 375, 20, 20));
        returnList.add(new Obstacle(1450, 358, 15, 15));
        returnList.add(new Obstacle(1465, 343, 15, 15));
        returnList.add(new Obstacle(1480, 325, 15, 15));
        returnList.add(new Obstacle(1490, 305, 15, 15));
        //Upper
        returnList.add(new Obstacle(1510, 293, 10, 30));
        returnList.add(new Obstacle(1520, 293, 460, 50));
        returnList.add(new Obstacle(1990, 325, 55, 30));
        returnList.add(new Obstacle(2355, 293, 750, 50));
        returnList.add(new Obstacle(2290, 325, 60, 30));
        // fal
        returnList.add(new Obstacle(3110, 0, 5, 293));
        //          also szint
        // fal
        returnList.add(new Obstacle(1865, 350, 5, 250));
        // padlo
        returnList.add(new Obstacle(1865, 604, 950, 50));
        returnList.add(new Obstacle(3055, 604, 65, 50));
        // fal
        returnList.add(new Obstacle(3111, 450, 5, 150));
        // verem
        returnList.add(new Obstacle(2810, 654, 5, 100));
        returnList.add(new Obstacle(3055, 654, 5, 100));
        return returnList;
    }


    private List<Creature> creatureListCreator() {
        List<Creature> creatureList = new ArrayList<>();
        creatureList.add(new Troll(1900, 190, 1504, 1920));
        creatureList.add(new Troll(2600, 190, 2330, 3020));
        creatureList.add(new Troll(1900, 500, 1880, 2775));
        return creatureList;
    }
}
