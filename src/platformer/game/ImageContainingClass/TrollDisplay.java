package platformer.game.ImageContainingClass;

import platformer.game.MainGameLoop;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class TrollDisplay {
    public  ArrayList<BufferedImage> movementRight;
    public ArrayList<BufferedImage> movementLeft;
    public ArrayList<BufferedImage> leftAttack;
    public ArrayList<BufferedImage> rightAttack;
    private final String projectFolder = new File("").getAbsolutePath();

    public TrollDisplay() {
        this.movementRight = rightMovementMaker();
        this.movementLeft = leftMovementMaker();
        this.leftAttack = leftAttackMaker();
        this.rightAttack = rightAttackMaker();
    }
    public ArrayList<BufferedImage> getMovementRight() {
        return movementRight;
    }

    public ArrayList<BufferedImage> getMovementLeft() {
        return movementLeft;
    }

    public ArrayList<BufferedImage> getLeftAttack() {
        return leftAttack;
    }

    public ArrayList<BufferedImage> leftMovementMaker() {
        ArrayList<BufferedImage> leftMovementList = new ArrayList<>();

        try {
            leftMovementList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TWL1.png"))));
            leftMovementList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TWL2.png"))));
            leftMovementList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TWL3.png"))));
            leftMovementList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TWL4.png"))));
            leftMovementList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TWL5.png"))));
            leftMovementList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TWL4.png"))));
            leftMovementList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TWL3.png"))));
            leftMovementList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TWL2.png"))));



        } catch (IOException e) {
            e.printStackTrace();
        }
        return leftMovementList;
    }

    public ArrayList<BufferedImage> rightMovementMaker() {
        ArrayList<BufferedImage> rightMovementList = new ArrayList<>();
        try {
            rightMovementList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TWR1.png"))));
            rightMovementList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TWR2.png"))));
            rightMovementList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TWR3.png"))));
            rightMovementList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TWR4.png"))));
            rightMovementList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TWR5.png"))));
            rightMovementList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TWR4.png"))));
            rightMovementList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TWR3.png"))));
            rightMovementList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TWR2.png"))));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return rightMovementList;
    }

    public ArrayList<BufferedImage> leftAttackMaker(){
        ArrayList<BufferedImage> leftAttackList = new ArrayList<>();
        try{
            leftAttackList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TAL1.png"))));
            leftAttackList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TAL2.png"))));
            leftAttackList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TAL3.png"))));
            leftAttackList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TAL4.png"))));
            leftAttackList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TAL5.png"))));

        }    catch (IOException e) {
        e.printStackTrace();
    }
        return leftAttackList;
    }

    public ArrayList<BufferedImage> rightAttackMaker(){
        ArrayList<BufferedImage> rightAttackList = new ArrayList<>();
        try{
            rightAttackList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TAR1.png"))));
            rightAttackList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TAR2.png"))));
            rightAttackList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TAR3.png"))));
            rightAttackList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TAR4.png"))));
            rightAttackList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/TAR5.png"))));

        }    catch (IOException e) {
            e.printStackTrace();
        }
        return rightAttackList;
    }


}
