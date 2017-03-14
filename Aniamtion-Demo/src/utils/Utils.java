package utils;

import javax.imageio.ImageIO;
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
}
