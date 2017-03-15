package game.gamescene;

import game.GameWindow;
import game.NotificationCenter;
import game.SceneType;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;

/**
 * Created by Nhan on 3/15/2017.
 */
public class MenuScene extends GameScene{

    public MenuScene() {
        this.sceneType = SceneType.MENU_SCENE;
    }

    @Override
    public void run() {
    }

    @Override
    public void update(Graphics g) {
            g.drawImage(Utils.loadImage("res/rpg_menu.jpg"), 0, 0, GameWindow.SCREEN_WIDTH, GameWindow.SCREEN_HEIGHT, null);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_A){
                //TODO: change to scene Play
                System.out.println("change scene");
                NotificationCenter.getInstance().onEvent(SceneType.PLAY_SCENE, true);
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
