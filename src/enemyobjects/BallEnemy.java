package enemyobjects;

import drawer.DrawingSurface;

import java.awt.*;

public class BallEnemy extends EnemyShape {

    int radius;
    int y;
    int x;
    int xVelocity;
    int yVelocity;

    public BallEnemy(int x, int y, int radius, int xVelocity, int yVelocity) {

        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xVelocity = xVelocity;
        this.yVelocity = yVelocity;

    }


    @Override
    public void move(DrawingSurface drawingSurface) {


        x += xVelocity;
        y += yVelocity;
        detectBorderCollision(drawingSurface);




    }

    @Override
    public void draw(DrawingSurface drawingSurface) {
        drawingSurface.drawCircle(x,y,radius, Color.BLUE);
    }

    @Override
    public int getLowerBound() {
        return y + 2*radius;
    }

    @Override
    public int getUpperBound() {
        return y;
    }

    @Override
    public int getRightBound() {
        return x + 2*radius;
    }

    @Override
    public int getLeftBound() {
        return x;
    }

    private void detectBorderCollision(DrawingSurface drawingSurface) {


        if(getRightBound() > drawingSurface.getWidth()) {
            x = drawingSurface.getWidth() - 2*radius;
            xVelocity *= -1;
        }

        if(x <= 0) {
            x = 0;
            xVelocity *= -1;
        }

        if(y < 0 || y + 2*radius > drawingSurface.getHeight()) {
            yVelocity *= -1;
        }

    }

}
