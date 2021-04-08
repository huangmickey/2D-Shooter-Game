package drawer;

import java.awt.*;
import java.util.Random;

public class DrawingSurface {

    private final Graphics2D graphics;

    public DrawingSurface(Graphics2D graphics) {
        this.graphics = graphics;
    }

    public DrawingSurface(Graphics graphics) {
        if (!(graphics instanceof Graphics2D)) {
            throw new IllegalArgumentException("expected Graphics2D");
        }
        this.graphics = (Graphics2D) graphics;
    }

    public Graphics2D getGraphics() {
        return graphics;
    }

    public int getWidth() {
        return graphics.getClipBounds().width;
    }

    public int getHeight() {
        return graphics.getClipBounds().height;
    }

    public void drawRect(int x, int y, int width, int height) {

        graphics.setPaint(Color.BLACK);
        graphics.drawRect(x, y, width, height);
    }

    public void drawRect(int x, int y, int width, int height, Color color) {
        graphics.setPaint(color);
        graphics.drawRect(x, y, width, height);
    }

    public void drawCircle(int x, int y, int radius) {
        graphics.setPaint(Color.BLACK);
        drawOval(x, y, radius * 2, radius * 2);
    }

    public void drawBullet(int x, int y, int radius, Color color) {
        graphics.setPaint(color);
        graphics.fillOval(x, y, radius * 2, radius * 2);
    }

    public void drawCircle(int x, int y, int radius, Color color) {
        graphics.setPaint(color);
        drawOval(x, y, radius * 2, radius * 2);
    }

    public void drawRect(int x, int y, int width, int height, double rotationDegrees) {
        graphics.rotate(Math.toRadians(rotationDegrees));
        graphics.drawRect(x, y, width, height);
        graphics.rotate(0);
    }

    public void drawLine(int xStart, int yStart, int xEnd, int yEnd) {
        graphics.drawLine(xStart, yStart, xEnd, yEnd);
    }

    public void drawOval(int x, int y, int width, int height) {
        graphics.drawOval(x, y, width, height);
    }

    public void drawImage(Image image, int x, int y) {
        graphics.drawImage(image, x, y, null);
    }

    public void drawImage(Image image, int x, int y, double rotationDegrees) {
        graphics.rotate(Math.toRadians(rotationDegrees));
        drawImage(image, x, y);
        graphics.rotate(0);
    }

    public void clear() {
        graphics.clearRect(0, 0, getWidth(), getHeight());
    }

    public Color createRandomColor() {
        Random rand = new Random();
        int r = rand.nextInt(256);
        int g = rand.nextInt(256);
        int b = rand.nextInt(256);
        return new Color(r,g,b);
    }

    public void drawString(String str, int x, int y) {
        graphics.setFont(new Font("TimesRoman", Font.BOLD, 20));
        graphics.drawString(str, x, y);

    }



    public void drawPlayer(int x, int y, int width, int height, Color color) {
        graphics.setPaint(color);
        graphics.fillRect(x,y,width,height);
        graphics.setPaint(Color.BLACK);
    }
}
