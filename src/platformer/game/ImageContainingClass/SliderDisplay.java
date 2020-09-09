package platformer.game.ImageContainingClass;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SliderDisplay {
    BufferedImage leftStop;
    BufferedImage rightStop;
    List<BufferedImage> leftMovement ;
    List<BufferedImage> rightMovement;
    List<BufferedImage> leftAttackMovement;
    List<BufferedImage> rightAttackMovement;
    private final String projectFolder = new File("").getAbsolutePath();
    private final int displayHeight = 106;
    private final int displayWidth = 117;

    public SliderDisplay() {
        this.leftStop = leftStop();
        this.rightStop = rightStop();
        this.leftMovement = leftMovementMaker();
        this.rightMovement = rightMovementMaker();
        this.leftAttackMovement=leftAttackMovementMaker();
        this.rightAttackMovement=rightAttackMovementMaker();
    }
    public BufferedImage getLeftStop() {
        return leftStop;
    }

    public BufferedImage getRightStop() {
        return rightStop;
    }

    public List<BufferedImage> getLeftMovement() {
        return leftMovement;
    }

    public List<BufferedImage> getRightMovement() {
        return rightMovement;
    }

    public List<BufferedImage> getLeftAttackMovement() {
        return leftAttackMovement;
    }

    public List<BufferedImage> getRightAttackMovement() {
        return rightAttackMovement;
    }

    public int getDisplayHeight() {
        return displayHeight;
    }

    public int getDisplayWidth() {
        return displayWidth;
    }

    private List<BufferedImage> leftAttackMovementMaker(){
        List<BufferedImage> returnList = new ArrayList<>();
        try {
            returnList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/SAL.png"))));
            returnList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/SSL.png"))));


        } catch (IOException e) {
            System.out.println("PNG not found");
        }
        return returnList;
    }



    private List<BufferedImage> rightAttackMovementMaker(){
        List<BufferedImage> returnList = new ArrayList<>();
        try {
            returnList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/SAR.png"))));
            returnList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/SSR.png"))));



        } catch (IOException e) {
            System.out.println("PNG not found");
        }
        return returnList;

    }

    private List<BufferedImage> leftMovementMaker() {
        List<BufferedImage> returnList = new ArrayList<>();
        try {
            returnList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/SML.png"))));
            returnList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/SSL.png"))));

        } catch (IOException e) {
            System.out.println("PNG not found");
        }
        return returnList;

    }
    private List<BufferedImage> rightMovementMaker() {
        List<BufferedImage> returnList = new ArrayList<>();
        try {
            returnList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/SMR.png"))));
            returnList.add(ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/SSR.png"))));
        } catch (IOException e) {
            System.out.println("PNG not found");
        }
        return returnList;
    }
    private BufferedImage leftStop() {
        try {
            return ImageIO.read(new File(projectFolder.concat("/src/Image_Resources//SSL.png")));
        } catch (IOException e) {
            System.out.println("PNG not found");
        }
        return null;
    }

    private BufferedImage rightStop() {
        try {
            return ImageIO.read(new File(projectFolder.concat("/src/Image_Resources/SSR.png")));
        } catch (IOException e) {
            System.out.println("PNG not found");
        }
        return null;
    }
}
