package powerupobjects;

import drawer.DrawingSurface;
import playerobject.Player;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class InvincibleNecklace extends PowerUp {


    int x;
    int y;
    BufferedImage image;
    int height;
    int width;


    public InvincibleNecklace(int x, int y) throws IOException {
        this.x = x;
        this.y = y;
        this.image = ImageIO.read(new File("RPGIconsExtra/icon_23.png"));
        this.height = image.getHeight();
        this.width = image.getWidth();
    }

    @Override
    public void draw(DrawingSurface drawingSurface) {
        drawingSurface.drawImage(image, x, y);
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
    public int getUpperBound() {
        return y;
    }

    @Override
    public int getLowerBound() {
        return y + height;
    }

    @Override
    public void updatePlayer(Player player) {
        player.setInvincibleFlag(true);
    }

}
