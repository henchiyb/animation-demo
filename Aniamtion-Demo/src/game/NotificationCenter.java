package game;

import java.util.Vector;

/**
 * Created by Nhan on 3/15/2017.
 */
public class NotificationCenter {
    private Vector<Subcriber> subcriberVector;

    private NotificationCenter() {
        this.subcriberVector = new Vector<>();
    }

    private static NotificationCenter instance;

    public static NotificationCenter getInstance() {
        if (instance == null)
            instance = new NotificationCenter();
        return instance;
    }

    public void onEvent(EventType eventType){
        for (Subcriber sub: subcriberVector) {
            sub.onEvent(eventType);
        }
    }

    public void register(Subcriber sub){
        subcriberVector.add(sub);
    }

    public void unregister(Subcriber sub){
        subcriberVector.remove(sub);
    }
}
