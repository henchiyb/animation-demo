package game;

import controllers.CharacterController;
import models.Character;
import models.CharacterState;
import utils.Utils;

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

    private CharacterController characterController;
    private BufferedImage backBuffer;
    private Graphics graphics;

    public GameWindow(){
        setVisible(true);
        setSize(SCREEN_WIDTH, SCREEN_HEIGHT);

        characterController = new CharacterController();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                switch (e.getKeyCode()){
                    case KeyEvent.VK_UP:
                        if (Character.getInstance().getCharacterState() != CharacterState.UP)
                            Character.getInstance().setCharacterState(CharacterState.UP);
                        break;
                    case KeyEvent.VK_DOWN:
                        Character.getInstance().setCharacterState(CharacterState.DOWN);
                        break;
                    case KeyEvent.VK_LEFT:
                        Character.getInstance().setCharacterState(CharacterState.LEFT);
                        break;
                    case KeyEvent.VK_RIGHT:
                        Character.getInstance().setCharacterState(CharacterState.RIGHT);
                        break;
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {
//                switch (e.getKeyCode()){
//                    case KeyEvent.VK_UP:
//                    case KeyEvent.VK_DOWN:
//                    case KeyEvent.VK_LEFT:
//                    case KeyEvent.VK_RIGHT:
//                        characterController.getCharacter().setCharacterState(CharacterState.STANDING);
//                        break;
                if (Character.getInstance().getCharacterState() != CharacterState.STANDING){
                    Character.getInstance().setCharacterState(CharacterState.STANDING);
                }
            }
        });
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
            characterController.run();
        }
    }

    @Override
    public void update(Graphics g) {
        graphics.drawImage(Utils.loadImage("res/background.png"), 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, null);
        if (characterController != null){
            characterController.draw(graphics);
        }
        g.drawImage(backBuffer, 0, 0, SCREEN_WIDTH, SCREEN_HEIGHT, null);
    }
}