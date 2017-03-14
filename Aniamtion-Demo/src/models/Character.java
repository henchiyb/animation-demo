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


    public Character() {
    }

    public Character(int x, int y) {
        this.x = x;
        this.y = y;
        this.width = CHARACTER_WIDTH;
        this.height = CHARACTER_HEIGHT;
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
