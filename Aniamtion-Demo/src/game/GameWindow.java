package game;

import controllers.CharacterController;
import game.gamescene.MenuScene;
import game.gamescene.PlayScene;
import models.Character;
import models.CharacterState;
import utils.Utils;

import javax.rmi.CORBA.Util;
import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.image.BufferedImage;

/**
 * Created by Nhan on 3/14/2017.
 */
public class GameWindow extends Frame implements Runnable {

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;

    private PlayScene playScene;
    private MenuScene menuScene;
    private BufferedImage backBuffer;
    private Graphics graphics;

    public GameWindow(){
        setVisible(true);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
//        playScene = new PlayScene();
//        this.addKeyListener(playScene);

        menuScene = new MenuScene();
        this.addKeyListener(menuScene);

        backBuffer = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_BGR);
        graphics = backBuffer.getGraphics();
    }

    @Override
    public void run() {
        while (true){
            repaint();
            try {
                Thread.sleep(17);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            playScene.run();
            menuScene.run();
        }
    }

    @Override
    public void update(Graphics g) {
//        playScene.update(graphics);
        menuScene.update(graphics);
        g.drawImage(backBuffer, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, null);
    }
}
