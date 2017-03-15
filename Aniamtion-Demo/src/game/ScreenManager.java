package game;

import game.gamescene.GameScene;

/**
 * Created by Nhan on 3/15/2017.
 */
public interface ScreenManager {
    void onChange(SceneType sceneType, boolean addToBackStack);
}
