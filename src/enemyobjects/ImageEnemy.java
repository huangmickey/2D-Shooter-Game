package enemyobjects;

import drawer.DrawingSurface;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Random;

public class ImageEnemy extends EnemyShape{

    private int x;
    private int y;
    private BufferedImage image;

    public ImageEnemy(String filePath, int x, int y) throws IOException {
        Random rand = new Random();
        image =  ImageIO.read(new File(filePath));

    }
    @Override
    public void move(DrawingSurface drawingSurface) {
        x++;
        y++;
    }

    @Override
    public void draw(DrawingSurface drawingSurface) {
        drawingSurface.drawImage(image,x,y);
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
