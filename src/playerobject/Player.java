package playerobject;

import drawer.DrawingSurface;
import weapons.Bullets;

import java.awt.*;


public class Player {

    private int x;
    private int y;
    private int width = 20;
    private int height = 20;
    private int ySpeed;
    private int xSpeed;
    private boolean invincibleFlag;

    private Color color;

    public Player(int screenWidth, int screenHeight) {
        this.x = screenWidth / 2;
        this.y = screenHeight / 2;
        xSpeed = 5;
        ySpeed = 5;
        invincibleFlag = false;
        color = Color.BLACK;
    }

    public void moveUp() {
        y -= ySpeed;
    }

    public void moveDown() {
        y += ySpeed;
    }

    public void moveRight() {
        x += xSpeed;
    }

    public void moveLeft() {
        x -= xSpeed;
    }

    public void drawPlayer(DrawingSurface drawingSurface) {
        drawingSurface.drawPlayer(x,y,width,height,color);
    }

    public Bullets shoot() {
        return new Bullets((x + (width / 4)), y);
    }

    public int getLowerBound() {
        return y + height;
    }

    public int getUpperBound() {
        return y;
    }

    public int getLeftBound() {
        return x;
    }

    public int getRightBound() {
        return x + width;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getHeight() {
        return height;
    }

    public int getySpeed() {
        return ySpeed;
    }

    public void setySpeed(int ySpeed) {
        this.ySpeed = ySpeed;
    }

    public int getxSpeed() {
        return xSpeed;
    }

    public void setxSpeed(int xSpeed) {
        this.xSpeed = xSpeed;
    }

    public boolean isInvincibleFlag() {
        return invincibleFlag;
    }

    public void setInvincibleFlag(boolean invincibleFlag) {
        this.invincibleFlag = invincibleFlag;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }



}
