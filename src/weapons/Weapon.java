package weapons;

import drawer.DrawingSurface;

public abstract class Weapon {

    public abstract void move();
    public abstract void draw(DrawingSurface drawingSurface);
    public abstract int getUpperBound();
    public abstract int getLowerBound();
    public abstract int getRightBound();
    public abstract int getLeftBound();

}
