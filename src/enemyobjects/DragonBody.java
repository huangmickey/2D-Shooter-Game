package enemyobjects;

import drawer.DrawingSurface;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DragonBody extends FullDragon {

    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage image;



    //Dragon Body: Width = 112,  Height = 104
    public DragonBody() throws IOException {
        this.image = ImageIO.read(new File("DragonSprite/DragonBodyTransparent.png"));
        this.width = image.getWidth();
        this.height = image.getHeight();

    }


    @Override
    public int getUpperBound() {
        return y;
    }
    @Override
    public int getLowerBound() {
        return y + height;
    }
    @Override
    public int getRightBound() {
        return x + width;
    }
    @Override
    public int getLeftBound() {
        return x;
    }
    @Override
    public int getX() {
        return x;
    }
    @Override
    public void setX(int x) {
        this.x = x;
    }
    @Override
    public int getY() {
        return y;
    }
    @Override
    public void setY(int y) {
        this.y = y;
    }
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public int getHeight() {
        return height;
    }
    @Override
    public BufferedImage getImage() {
        return image;
    }
}
