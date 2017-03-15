package game;

import models.Character;

/**
 * Created by Nhan on 3/14/2017.
 */
public class Program {
    public static void main(String[] args){
        GameWindow gameWindow = new GameWindow();
        Thread thread = new Thread(gameWindow);
        thread.run();
    }
}
