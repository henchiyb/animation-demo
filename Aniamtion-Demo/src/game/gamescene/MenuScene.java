package game.gamescene;

import game.EventType;
import game.GameWindow;
import game.NotificationCenter;
import utils.Utils;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Nhan on 3/15/2017.
 */
public class MenuScene extends GameScene{

    public MenuScene() {
        NotificationCenter.getInstance().register(this);
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
                NotificationCenter.getInstance().onEvent(EventType.CHANGE_SCENE);
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void onEvent(EventType eventType) {
    }
}
