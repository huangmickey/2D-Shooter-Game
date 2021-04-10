package enemyobjects;

import drawer.DrawingSurface;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class Fireball extends EnemyShape{

    int x;
    int y;
    int width;
    int height;
    BufferedImage image;

    public Fireball(int x, int y) throws IOException {

        image = ImageIO.read(new File("DragonSprite/fireball.png"));
        width = image.getWidth();
        height = image.getHeight();
        this.x = x;
        this.y = y;
    }

    @Override
    public void move() {
        x -= 10;
    }

    @Override
    public void draw(DrawingSurface drawingSurface) {

        drawingSurface.drawImage(image, x, y);

    }

    @Override
    public int getLowerBound() {
        return 0;
    }

    @Override
    public int getUpperBound() {
        return 0;
    }

    @Override
    public int getRightBound() {
        return 0;
    }

    @Override
    public int getLeftBound() {
        return 0;
    }
}
