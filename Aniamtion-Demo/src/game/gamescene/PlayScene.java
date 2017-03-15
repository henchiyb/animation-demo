package game.gamescene;

import controllers.CharacterController;
import game.EventType;
import game.GameWindow;
import game.Subcriber;
import models.Character;
import models.CharacterState;
import utils.Utils;

import javax.sound.sampled.Clip;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

/**
 * Created by Nhan on 3/15/2017.
 */
public class PlayScene extends GameScene{
    private CharacterController characterController;
    private Clip clip;

    public PlayScene() {
        clip = Utils.playSound("res/laser_shoot.wav", true);
        characterController = new CharacterController();
    }

    @Override
    public void run() {
        characterController.run();
    }

    @Override
    public void update(Graphics g) {
        g.drawImage(Utils.loadImage("res/background.png"), 0, 0, GameWindow.SCREEN_WIDTH, GameWindow.SCREEN_HEIGHT, null);
        if (characterController != null){
            characterController.draw(g);
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:
                //TODO
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
//                        clip.start();
//                        clip.loop(-1);
                break;
            case KeyEvent.VK_SPACE:
                clip.stop();
                break;
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        //TODO
        switch (e.getKeyCode()){
            case KeyEvent.VK_UP:

            case KeyEvent.VK_DOWN:

            case KeyEvent.VK_LEFT:

            case KeyEvent.VK_RIGHT:
                characterController.getCharacter().setCharacterState(CharacterState.STANDING);
                break;
        }
    }

    @Override
    public void onEvent(EventType eventType) {

    }
}
