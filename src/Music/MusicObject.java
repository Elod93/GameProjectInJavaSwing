package Music;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.*;
import java.io.File;

public class MusicObject {

    public void playMusic(String fileLocation) {
        try {
            File filePath = new File(fileLocation);
            if(filePath.exists()){
                AudioInputStream audioInput = AudioSystem.getAudioInputStream(filePath);
                Clip clip = AudioSystem.getClip();
                clip.start();
                clip.open(audioInput);
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }else{
                System.out.println("Missing File");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
