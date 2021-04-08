package enemyobjects;

import drawer.DrawingSurface;

import java.awt.*;
import java.util.Random;

public class RectEnemy extends EnemyShape {

    private int x;
    private int y = 0;
    private int width;
    private int height;

    private Color color;

    public RectEnemy(int x, int width, int height, Color color) {
        this.x = x;
        this.width = width;
        this.height = height;
        this.color = color;
    }


    public Color getColor() {
        return color;
    }




    @Override
    public void move(DrawingSurface drawingSurface) {
        Random rand = new Random();
        y+=rand.nextInt(5) + 1;

    }

    @Override
    public void draw(DrawingSurface drawingSurface) {
        drawingSurface.drawRect(x,y,width,height, Color.RED);
    }

    @Override
    public int getLowerBound() {
        return y + height;
    }
    @Override
    public int getUpperBound() {
        return y;
    }
    @Override
    public int getLeftBound() {
        return x;
    }
    @Override
    public int getRightBound() {
        return x + width;
    }
}
