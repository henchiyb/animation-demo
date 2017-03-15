package game;

import java.util.Vector;

/**
 * Created by Nhan on 3/15/2017.
 */
public class NotificationCenter {
    private Vector<ScreenManager> screenManagerVector;

    private NotificationCenter() {
        this.screenManagerVector = new Vector<>();
    }

    private static NotificationCenter instance;

    public static NotificationCenter getInstance() {
        if (instance == null)
            instance = new NotificationCenter();
        return instance;
    }

    public void onEvent(SceneType sceneType, boolean addToBackStack){
            for (ScreenManager sub : screenManagerVector) {
                sub.onChange(sceneType, addToBackStack);
            }
    }

    public void register(ScreenManager sub){
        screenManagerVector.add(sub);
    }

    public void unregister(ScreenManager sub){
        screenManagerVector.remove(sub);
    }
}
