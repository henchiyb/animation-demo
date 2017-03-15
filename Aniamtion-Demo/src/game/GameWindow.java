package game;

import game.gamescene.GameScene;
import game.gamescene.MenuScene;
import game.gamescene.PlayScene;

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
public class GameWindow extends Frame implements Runnable, ScreenManager {

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
        onChange(SceneType.MENU_SCENE, false);

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

    private void initScene(GameScene scene){
        freeScene(currentScene);
        currentScene = scene;
        addKeyListener(scene);
    }

    private void freeScene(GameScene scene){
        if (scene != null)
            removeKeyListener(scene);
//            NotificationCenter.getInstance().unregister(scene);
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
    public void onChange(SceneType sceneType, boolean addToBackStack) {
        if(addToBackStack && currentScene != null){
            backStack.add(currentScene);
        }
        switch (sceneType){
            case PLAY_SCENE:
                initScene(new PlayScene());
                break;
            case MENU_SCENE:
                initScene(new MenuScene());
                break;
        }
    }

    public void back(){
        if (backStack.size() > 0){
            GameScene newScene = backStack.pop();
            System.out.println("backstack pop: " + backStack.size());
            initScene(newScene);
        }
    }
}
