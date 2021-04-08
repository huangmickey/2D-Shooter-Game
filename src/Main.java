import javax.swing.*;
import java.awt.*;

public class Main {

    public static void main(String[] args) {
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();


        Game program = new Game();
        Canvas canvas = new Canvas(program);


        JFrame frame = new JFrame();
        frame.addKeyListener(canvas);
        frame.setSize(screenSize.width, screenSize.height);
        frame.setUndecorated(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(canvas);
        frame.setVisible(true);



    }
}
