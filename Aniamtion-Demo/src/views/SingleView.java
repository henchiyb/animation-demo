package views;

import models.Character;

import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * Created by Nhan on 3/14/2017.
 */
public class SingleView implements View{
    private BufferedImage image;

    public SingleView(BufferedImage image) {
        this.image = image;
    }

    public void draw(Graphics g, Character character){
        g.drawImage(image,
                character.getX(),
                character.getY(),
                character.getWidth(),
                character.getHeight(),
                null);
    }
}
