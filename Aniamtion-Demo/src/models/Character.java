package models;

import game.GameWindow;

/**
 * Created by Nhan on 3/14/2017.
 */
public class Character {
    private static final int SPEED = 2;
    private static final int CHARACTER_WIDTH = 40;
    private static final int CHARACTER_HEIGHT = 40;
    protected int x;
    protected int y;
    protected int width;
    protected int height;

    private static Character instance = null;

    public static Character getInstance() {
        if (instance == null)
            instance = new Character(GameWindow.SCREEN_WIDTH / 3, GameWindow.SCREEN_HEIGHT / 3);
        return instance;
    }

    private CharacterState characterState;

    public CharacterState getCharacterState() {
        return characterState;
    }

    public void setCharacterState(CharacterState characterState) {
        this.characterState = characterState;
    }

    public Character() {
    }

    public Character(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = CHARACTER_WIDTH;
        this.height = CHARACTER_HEIGHT;
        this.characterState = CharacterState.STANDING;
    }

    public Character(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void moveLeft(){
        x -= SPEED;
    }

    public void moveRight(){
        x += SPEED;
    }

    public void moveUp(){
        y -= SPEED;
    }

    public void moveDown(){
        y += SPEED;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
