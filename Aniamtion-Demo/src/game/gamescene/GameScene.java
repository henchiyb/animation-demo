package game.gamescene;

import java.awt.*;
import java.awt.event.KeyListener;

/**
 * Created by Nhan on 3/19/2017.
 */
public interface GameScene extends KeyListener{
    void run();
    void update(Graphics g);
}
