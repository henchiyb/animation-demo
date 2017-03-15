package views;

import models.Character;
import utils.Utils;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Nhan on 3/14/2017.
 */
public class Animation implements View{
    private static final int FRAME_RATE = 2;
    private Vector<BufferedImage> imageVector;
    private BufferedImage image;
    private int countIndex = 0;
    private int countFrameRate = FRAME_RATE;

    public Animation(Vector<BufferedImage> imageVector) {
        this.imageVector = imageVector;
    }

    public Animation(String... imageName){
        imageVector = new Vector<>();
        for (String name: imageName) {
            imageVector.add(Utils.loadImage(name));
        }
    }

    @Override
    public void draw(Graphics g, Character character) {
        image = imageVector.get(countIndex);
        countFrameRate--;
        if (countFrameRate == 0) {
            countFrameRate = FRAME_RATE;
            countIndex++;
        }
        if (countIndex > imageVector.size() - 1){
            countIndex = 0;
        }
        g.drawImage(image,
                character.getX(),
                character.getY(),
                character.getWidth(),
                character.getHeight(),
                null);
    }
}
