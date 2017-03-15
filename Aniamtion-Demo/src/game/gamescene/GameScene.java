package game.gamescene;

import game.SceneType;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by Nhan on 3/15/2017.
 */
public abstract class GameScene implements KeyListener {
    public SceneType sceneType;
    public boolean isAttach;
    public abstract void run();
    public abstract void update(Graphics g);
}
