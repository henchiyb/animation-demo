package controllers;

import game.GameWindow;
import models.Character;
import utils.Utils;
import views.Animation;
import views.SingleView;
import views.View;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Vector;

/**
 * Created by Nhan on 3/14/2017.
 */
public class CharacterController {
    private Character character;
    private View view;

    private Animation animationLeft = new Animation(
            "res/Boxer10.png",
            "res/Boxer11.png",
            "res/Boxer12.png");
//    private Animation animationRight = new Animation(
//            "res/Boxer20.png",
//            "res/Boxer21.png",
//            "res/Boxer22.png");
    private Animation animationRight = new Animation(Utils.loadVectorImageFromSheet("res/davis_walking.png",
        80,
        80,
        4));
    private Animation animationUp = new Animation(
            "res/Boxer30.png",
            "res/Boxer31.png",
            "res/Boxer32.png");
    private Animation animationDown = new Animation(
            "res/Boxer00.png",
            "res/Boxer01.png",
            "res/Boxer02.png");

    public CharacterController() {

    }

    public CharacterController(Character character, View view) {
        this.character = character;
        this.view = view;
    }


    public void draw(Graphics g){
        switch (character.getCharacterState()){
            case UP:
                this.view = animationUp;
                break;
            case DOWN:
                this.view = animationDown;
            case LEFT:
                this.view = animationLeft;
                break;
            case RIGHT:
                this.view = animationRight;
                break;
            case STANDING:
                this.view = new SingleView(Utils.loadImage("res/Boxer01.png"));
                break;
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
        }
    }
    public Character getCharacter() {
        return character;
    }
}
