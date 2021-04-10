package enemyobjects;



import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class DragonHead extends FullDragon {

    private int x;
    private int y;
    private int width;
    private int height;
    private BufferedImage image;
    //Dragon Head: Width = 220 , Height = 159

    public DragonHead() throws IOException {
        this.image = ImageIO.read(new File("DragonSprite/DragonHeadTransparent.png"));
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
    public int getY() {
        return y;
    }
    @Override
    public int getHeight() {
        return height;
    }
    @Override
    public int getWidth() {
        return width;
    }
    @Override
    public BufferedImage getImage() {
        return image;
    }
    @Override
    public void setX(int x) {
        this.x = x;
    }
    @Override
    public void setY(int y) {
        this.y = y;
    }
}
