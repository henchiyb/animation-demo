package game.gamescene;

import game.GameWindow;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Nhan on 3/19/2017.
 */
public class MeneScene implements GameScene {

    @Override
    public void run() {


    }

    @Override
    public void update(Graphics g) {
        g.drawImage(Utils.loadImage("res/rpg_menu.jpg"),
                0,
                0,
                GameWindow.SCREEN_WIDTH,
                GameWindow.SCREEN_HEIGHT, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
