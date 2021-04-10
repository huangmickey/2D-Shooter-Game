package enemyobjects;
import java.awt.image.BufferedImage;

public abstract class FullDragon {

    public abstract int getX();
    public abstract int getY();
    public abstract int getHeight();
    public abstract int getWidth();
    public abstract BufferedImage getImage();
    public abstract void setX(int x);
    public abstract void setY(int y);
    public abstract int getUpperBound();
    public abstract int getLowerBound();
    public abstract int getRightBound();
    public abstract int getLeftBound();
}
