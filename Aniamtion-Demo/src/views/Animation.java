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
    private Vector<BufferedImage> vectorImages;
    private int countImageInVector = 0;
    private int frameRateCount = 0;

    public Animation(Vector<BufferedImage> vectorImages) {
        this.vectorImages = vectorImages;
    }

    public Animation(String... imageUrl) {
        vectorImages = new Vector<>();
        for (String url: imageUrl) {
            vectorImages.add(Utils.loadImage(url));
        }
    }

    public Animation(String sheetUrl) {
        vectorImages = new Vector<>();
        vectorImages = Utils.loadImageVectorFromSheet(sheetUrl, 4, 80, 80);
    }

    public void draw(Graphics g, Character character){
        frameRateCount++;
        BufferedImage image = vectorImages.get(countImageInVector);
        if (frameRateCount == FRAME_RATE) {
            countImageInVector++;
            frameRateCount = 0;
        }

        if (countImageInVector > vectorImages.size() - 1){
            countImageInVector = 0;
        }
        g.drawImage(image,
                character.getX(),
                character.getY(),
                character.getWidth(),
                character.getHeight(),
                null);
    }
}
