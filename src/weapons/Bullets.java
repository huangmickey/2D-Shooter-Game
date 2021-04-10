package weapons;

import drawer.DrawingSurface;

import java.awt.*;

public class Bullets extends Weapon {

    private int x;
    private int y;
    private int radius = 5;

    public Bullets(int x, int y) {
        this.x = x;
        this.y = y;

    }

    @Override
    public void move(String weaponOrientation) {
        if(weaponOrientation.equals("Up")) {
            y -= 10;
        } else {
            x += 10;
        }
    }

    @Override
    public void draw(DrawingSurface drawingSurface) {
        drawingSurface.drawBullet(x, y, radius, Color.GREEN);
    }

    @Override
    public int getUpperBound() {
        return y;
    }

    @Override
    public int getLowerBound() {
        return y + 2*radius;
    }

    @Override
    public int getRightBound() {
        return x + 2*radius;
    }

    @Override
    public int getLeftBound() {
        return x;
    }


}
