import drawer.DrawingSurface;
import userinput.UserInput;

import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.IOException;

public class Canvas extends JPanel implements KeyListener {

    private static final int UPDATE_DELAY = 1;

    private final Game program;
    private final UserInput userInput;

    public Canvas(Game program) {

        this.program = program;
        userInput = new UserInput();
        Timer timer = new Timer(UPDATE_DELAY, (event)-> {
            repaint();
        });
        timer.start();

    }

    @Override
    protected void paintComponent(Graphics g){

        super.paintComponent(g);
        DrawingSurface drawingSurface = new DrawingSurface(g);
        drawingSurface.clear();
        try {
            program.update(drawingSurface, userInput);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        userInput.updatePressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        userInput.updateReleased(e.getKeyCode());
    }


}
