import drawer.DrawingSurface;
import enemyobjects.BallEnemy;
import enemyobjects.RectEnemy;
import enemyobjects.EnemyShape;
import playerobject.Player;
import weapons.Weapon;
import powerupobjects.PowerUp;
import powerupobjects.InvincibleNecklace;
import userinput.UserInput;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;
public class Game {

    int rectEnemyCounter;
    boolean isDead = false;
    private List<PowerUp> powerUpList;
    private List<EnemyShape> enemyList;
    private List<Weapon> weaponList;
    private Player player;
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Random rand = new Random();
    int weaponCount;
    int enemiesKilled;
    int ballEnemyCounter;
    boolean bossBattle = false;
    int powerUpCount;
    int invincibleCounter;

    //100counts == 1second
    public Game() {
        enemyList = new ArrayList<>();
        weaponList = new ArrayList<>();
        powerUpList = new ArrayList<>();
        player = new Player(screenSize.width, screenSize.height);

    }

    public void update(DrawingSurface drawingSurface, UserInput userInput) throws IOException {


        //
        if(!isDead) {

            if(bossBattle) {

            }



            powerUpCount++;
            if(powerUpCount == 1000) {
                powerUpList.add(new InvincibleNecklace(rand.nextInt(screenSize.width), rand.nextInt(screenSize.height)));
            }



            //weapon cool-down counter - 250ms
            if (weaponCount > 0) {
                weaponCount--;
            }


            //enemy spawning counter - every 150ms
            rectEnemyCounter++;
            ballEnemyCounter++;

            if (rectEnemyCounter == 15) {
                enemyList.add(new RectEnemy(rand.nextInt(screenSize.width), rand.nextInt(20) + 10, rand.nextInt(20) + 10, Color.RED));
                rectEnemyCounter = 0;
            }
            if (ballEnemyCounter == 300) {

                enemyList.add(new BallEnemy(rand.nextInt(screenSize.width), rand.nextInt(10), rand.nextInt(20) + 10, 5,5));
                ballEnemyCounter = 0;

            }




            //Updating the x and y of all objects
            for (Weapon weapon : weaponList) {
                weapon.move();
            }
            for (EnemyShape enemyShape : enemyList) {
                enemyShape.move(drawingSurface);
            }


            //key presses
            keyPresses(userInput);



            //collision detection
            detectBorderCollision();
            detectWeaponCollision();
            detectPowerUpCollision();

            if(player.isInvincibleFlag()) {
                invincibleCounter++;
            } else {
                isDead = isEnemyCollision();
            }

            if(invincibleCounter == 1000) {
                player.setInvincibleFlag(false);
                invincibleCounter = 0;
            }

            //stops canvas from drawing if deadFlag == true
            if(isDead) {
                userInput.clear();
                Object[] choices = {"Restart", "Quit"};
                Object defaultChoice = choices[1];
                int result = JOptionPane.showOptionDialog(null,"You lost","Game Over", JOptionPane.YES_NO_OPTION,JOptionPane.QUESTION_MESSAGE,null,choices,defaultChoice);

                if(result == 1) {
                    System.exit(0);

                } else {
                    //Resets the whole game
                    restartGame();
                }
            }
        }
        //drawing
        drawAll(drawingSurface);
    }

    public void detectWeaponCollision() {

        for(int i = 0; i < weaponList.size(); i++) {
            for(int j = 0; j < enemyList.size(); j++) {
                if(weaponList.get(i).getLowerBound() >= enemyList.get(j).getUpperBound() &&
                   weaponList.get(i).getUpperBound() <= enemyList.get(j).getLowerBound() &&
                   weaponList.get(i).getLeftBound() <= enemyList.get(j).getRightBound() &&
                   weaponList.get(i).getRightBound() >= enemyList.get(j).getLeftBound()) {
                    weaponList.remove(weaponList.get(i));
                    enemyList.remove(enemyList.get(j));
                    enemiesKilled++;
                }
            }
        }
    }

    public void detectBorderCollision() {
        enemyList.removeIf(enemy -> enemy instanceof RectEnemy && enemy.getLowerBound() >= screenSize.height);
        weaponList.removeIf(weapon -> weapon.getUpperBound() <= 0);
        if(player.getLowerBound() > screenSize.height - 100) {
            player.setY(screenSize.height - 100 - player.getHeight());
        }
        if(player.getLeftBound() < 0) {
            player.setX(0);
        }
        if(player.getRightBound() > screenSize.width) {
            player.setX(screenSize.width - player.getWidth());
        }

    }

    public void detectPowerUpCollision() {
        for(PowerUp powerUp : powerUpList) {

            if(player.getLeftBound() <= powerUp.getRightBound() &&
               player.getRightBound() >= powerUp.getLeftBound() &&
               player.getLowerBound() >= powerUp.getUpperBound() &&
               player.getUpperBound() <= powerUp.getLowerBound()) {

                powerUp.updatePlayer(player);
                powerUpList.remove(powerUp);
            }
        }
    }

    public boolean isEnemyCollision() {
        //Detect the collision of enemy and player


        for(EnemyShape enemy : enemyList) {
            if (((enemy.getLowerBound() > player.getUpperBound() && enemy.getLowerBound() < player.getLowerBound())  ||
                 (enemy.getUpperBound() < player.getLowerBound() && enemy.getUpperBound() > player.getUpperBound())) &&
                    ((enemy.getRightBound() > player.getLeftBound()  && enemy.getRightBound() < player.getRightBound()) ||
                    (enemy.getLeftBound() < player.getRightBound() && enemy.getLeftBound() > player.getLeftBound()))) {

                return true;
            }
        }
        return false;
    }

    private void restartGame() {
        enemiesKilled = 0;
        rectEnemyCounter = 0;
        weaponCount = 0;
        enemyList.clear();
        weaponList.clear();
        player = new Player(screenSize.width, screenSize.height);
        isDead = false;

    }

    private void keyPresses(UserInput userInput) {
        if (userInput.isUpPressed()) {

            player.moveUp();
        }

        if (userInput.isDownPressed()) {
            player.moveDown();
        }

        if (userInput.isRightPressed()) {
            player.moveRight();
        }

        if (userInput.isLeftPressed()) {
            player.moveLeft();
        }

        if (userInput.isSpacePressed()) {
            if (weaponCount <= 0) {
                weaponList.add(player.shoot());
                weaponCount = 25;
            }
        }

        if (userInput.isEscPressed()) {
            System.exit(0);
        }
    }

    private void drawAll(DrawingSurface drawingSurface) {

        drawingSurface.drawString("Kill Counter: " + enemiesKilled, screenSize.width/2, screenSize.height/20);
        player.drawPlayer(drawingSurface);
        for(PowerUp powerUp : powerUpList) {
            powerUp.draw(drawingSurface);
        }
        for(Weapon weapon : weaponList) {
            weapon.draw(drawingSurface);
        }
        for(EnemyShape enemyShape : enemyList) {
            enemyShape.draw(drawingSurface);
        }

    }



}
