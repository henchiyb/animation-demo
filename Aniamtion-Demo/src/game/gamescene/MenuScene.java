package game.gamescene;

import game.GameWindow;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Nhan on 3/15/2017.
 */
public class MenuScene implements GameScene, KeyListener {

    private PlayScene playScene;
    @Override
    public void run() {
        if (playScene != null)
            playScene.run();
    }

    @Override
    public void update(Graphics g) {
        if (playScene == null)
            g.drawImage(Utils.loadImage("res/rpg_menu.jpg"), 0, 0, GameWindow.SCREEN_WIDTH, GameWindow.SCREEN_HEIGHT, null);
        else
            playScene.update(g);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (playScene == null)
            if (e.getKeyCode() == KeyEvent.VK_A){
                //TODO: change to scene Play
                System.out.println("change scene");
                playScene = PlayScene.instance;
            }
        else
            playScene.keyPressed(e);

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
