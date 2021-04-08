package userinput;

import java.awt.event.KeyEvent;
import java.util.HashSet;
import java.util.Set;

public class UserInput {
    //asd
    private final Set<Integer> pressedKeys;

    public UserInput() {
        this.pressedKeys = new HashSet<>();
    }

    public boolean isKeyPressed(int keyCode) {
        return pressedKeys.contains(keyCode);
    }

    public boolean isUpPressed() {
        return isKeyPressed(KeyEvent.VK_UP);
    }

    public boolean isDownPressed() {
        return isKeyPressed(KeyEvent.VK_DOWN);
    }

    public boolean isRightPressed() {
        return isKeyPressed(KeyEvent.VK_RIGHT);
    }

    public boolean isLeftPressed() {
        return isKeyPressed(KeyEvent.VK_LEFT);
    }

    public boolean isSpacePressed() {return isKeyPressed(KeyEvent.VK_SPACE);}

    public boolean isEscPressed() {return isKeyPressed(KeyEvent.VK_ESCAPE);}

    public void updatePressed(int keyCode) {
        pressedKeys.add(keyCode);
    }

    public void updateReleased(int keyCode) {
        pressedKeys.remove(keyCode);
    }

    public void clear() {
        pressedKeys.clear();
    }
}
