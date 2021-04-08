package powerupobjects;

import drawer.DrawingSurface;
import playerobject.Player;

public abstract class PowerUp {

    public abstract void draw(DrawingSurface drawingSurface);
    public abstract int getRightBound();
    public abstract int getLeftBound();
    public abstract int getUpperBound();
    public abstract int getLowerBound();
    public abstract void updatePlayer(Player player);

}
