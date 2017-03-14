package controllers;

import game.GameWindow;
import models.Character;
import utils.Utils;
import views.SingleView;
import views.View;

import java.awt.*;

/**
 * Created by Nhan on 3/14/2017.
 */
public class CharacterController {
    private Character character;
    private View view;

    public CharacterController() {
        this.character = new Character(GameWindow.SCREEN_WIDTH / 2, GameWindow.SCREEN_HEIGHT / 2);
        this.view = new SingleView(Utils.loadImage("res/Boxer21.png"));
    }

    public CharacterController(Character character, View view) {
        this.character = character;
        this.view = view;
    }


    public void draw(Graphics g){
        view.draw(g, character);
    }

    public void run(){

    }
}
