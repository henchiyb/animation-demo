package utils;

import javax.imageio.ImageIO;
import javax.sound.sampled.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Vector;

/**
 * Created by Nhan on 3/14/2017.
 */
public class Utils {
    public static BufferedImage loadImage(String url){
        try {
            return ImageIO.read(new File(url));
        } catch (IOException e) {
            e.printStackTrace();
            return  null;
        }
    }

    public static Vector<BufferedImage> loadVectorImageFromSheet(String sheetUrl, int width,
                                                                 int height, int countSubImage){
        Vector<BufferedImage> imageVector = new Vector<>();
        BufferedImage sheetImage = Utils.loadImage(sheetUrl);
        for (int i = 0; i < countSubImage; i ++){
            int x = i * width;
            int y = 0;
            BufferedImage image = sheetImage.getSubimage(x, y, width, height);
            imageVector.add(image);
        }
        return imageVector;
    }

    public static Clip playSound(String audioUrl, boolean repeat) {
        Clip clip = null;
        File soundFile = new File(audioUrl);
        try {
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);
            clip = AudioSystem.getClip();
            clip.open(audioIn);
//            clip.start();

            if(repeat) {
                clip.loop(Clip.LOOP_CONTINUOUSLY);
            }
            else {
                clip.loop(0);
            }
        } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
            e.printStackTrace();
        }
        return clip;
    }
}
