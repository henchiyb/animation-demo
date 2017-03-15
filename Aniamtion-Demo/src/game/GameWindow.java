package game;

import controllers.CharacterController;
import game.gamescene.GameScene;
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
import java.util.Stack;

/**
 * Created by Nhan on 3/14/2017.
 */
public class GameWindow extends Frame implements Runnable, Subcriber {

    public static final int SCREEN_WIDTH = 800;
    public static final int SCREEN_HEIGHT = 600;

    private GameScene currentScene;
    private BufferedImage backBuffer;
    private Graphics graphics;
    private Stack<GameScene> backStack;

    public GameWindow(){
        setVisible(true);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        backStack = new Stack<>();
        NotificationCenter.getInstance().register(this);
        initScene(new MenuScene(), true);

        this.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    back();
                    System.out.println("onBack");
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {

            }
        });
        backBuffer = new BufferedImage(SCREEN_WIDTH, SCREEN_HEIGHT, BufferedImage.TYPE_INT_BGR);
        graphics = backBuffer.getGraphics();
    }

    private void initScene(GameScene scene, boolean addToBackStack){
        freeScene(currentScene);
        currentScene = scene;
        addKeyListener(scene);
        if(addToBackStack)
            backStack.add(scene);
    }

    private void freeScene(GameScene scene){
        if (scene != null)
            removeKeyListener(scene);
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
            currentScene.run();
        }
    }

    @Override
    public void update(Graphics g) {
        currentScene.update(graphics);
        g.drawImage(backBuffer, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, null);
    }

    @Override
    public void onEvent(EventType eventType) {
        if(eventType == EventType.CHANGE_SCENE){
            initScene(new PlayScene(), true);
        }
    }

    public void back(){
        if (backStack.size() > 0){
            GameScene newScene = backStack.pop();
            initScene(newScene, false);
        }
    }
}
