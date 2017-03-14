package controllers;

import game.GameWindow;
import models.Character;
import utils.Utils;
import views.Animation;
import views.SingleView;
import views.View;

import java.awt.*;

/**
 * Created by Nhan on 3/14/2017.
 */
public class CharacterController {
    private Character character = Character.getInstance();
    private View view;
    private View animationUp = new Animation("res/Boxer30.png", "res/Boxer31.png", "res/Boxer32.png");
    private View animationDown = new Animation("res/Boxer00.png", "res/Boxer01.png", "res/Boxer02.png");
    private View animationLeft = new Animation("res/Boxer10.png", "res/Boxer11.png", "res/Boxer12.png");
    private View animationRight = new Animation("res/davis_walking.png");

    public CharacterController() {
    }

    public void draw(Graphics g){
        switch (character.getCharacterState()){
            case UP:
                view = animationUp;
                break;
            case DOWN:
                view = animationDown;
                break;
            case LEFT:
                view = animationLeft;
                break;
            case RIGHT:
                view = animationRight;
                break;
            case STANDING:
                view = new SingleView(Utils.loadImage("res/Boxer00.png"));
//                view = new Animation(character, "res/Boxer20.png", "res/Boxer21.png", "res/Boxer22.png");
        }
            view.draw(g, character);
    }

    public void run(){
        switch (character.getCharacterState()){
            case UP:
                character.moveUp();
                break;
            case DOWN:
                character.moveDown();
                break;
            case LEFT:
                character.moveLeft();
                break;
            case RIGHT:
                character.moveRight();
                break;
            case STANDING:
                break;
        }
    }
}
