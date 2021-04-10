package enemyobjects;

import drawer.DrawingSurface;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;
import java.util.Timer;

public class BossDragonEnemy {


    BufferedImage image;
    int healthPoints = 100;
    Dimension screenSize;
    ArrayList<FullDragon> dragonBodyList;

    //Dragon Head: Width = 220 , Height = 159
    //Dragon Body: Width = 112,  Height = 104

    int movement;
    boolean flag = true;

    public BossDragonEnemy() throws IOException {
        screenSize = Toolkit.getDefaultToolkit().getScreenSize();

        dragonBodyList = new ArrayList<>();
        dragonBodyList.add(new DragonBody());
        dragonBodyList.add(new DragonBody());
        dragonBodyList.add(new DragonBody());
        dragonBodyList.add(new DragonBody());
        dragonBodyList.add(new DragonBody());
        dragonBodyList.add(new DragonHead());
//        dragonBodyList.add(new DragonHead());

        dragonBodyList.get(0).setX(screenSize.width - dragonBodyList.get(0).getWidth() / 2);
        dragonBodyList.get(0).setY(screenSize.height / 2 - dragonBodyList.get(0).getHeight());

    }

    public void move() {

        if (flag) {
            movement++;
        } else {
            movement--;
        }
        if (movement == 70) {
            flag = false;
        }
        if (movement == -70) {
            flag = true;
        }

        for (int i = 1; i < dragonBodyList.size(); i++) {
            dragonBodyList.get(i).setX((dragonBodyList.get(i - 1).getX()) - dragonBodyList.get(i).getWidth() / 2);
            dragonBodyList.get(i).setY((dragonBodyList.get(i - 1).getY() + dragonBodyList.get(i - 1).getHeight() - (dragonBodyList.get(i).getHeight())) + movement);
        }
    }


    public void draw(DrawingSurface drawingSurface) {
        for (FullDragon bodyPart : dragonBodyList) {
            drawingSurface.drawImage(bodyPart.getImage(), bodyPart.getX(), bodyPart.getY());
        }
    }

    public ArrayList<FullDragon> getDragon() {
        return dragonBodyList;
    }

    public ArrayList<Fireball> shootFireball() throws IOException {
        ArrayList<Fireball> fireBalls = new ArrayList<>();
        Fireball fireball = new Fireball(10,20);
        Fireball fireball2 = new Fireball(30,40);
        Fireball fireball3 = new Fireball(40,50);
        fireBalls.add(fireball);
        fireBalls.add(fireball2);
        fireBalls.add(fireball3);

        return fireBalls;

    }



}
