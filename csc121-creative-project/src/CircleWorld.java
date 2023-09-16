import processing.core.PApplet;
import processing.event.MouseEvent;

/**
 * Represents an interactive application where a drop of
 * water falls down from the top of the window. If the 
 * user clicks the mouse, the drop is moved over to the
 * location of the click;
 */
public class CircleWorld {
    
    Enemy e1;
    Enemy e2;
    Enemy e3;
    
    Player p;

    public CircleWorld() {
        e1 = new Enemy();
        e2 = new Enemy();
        e3 = new Enemy();
        
        p = new Player();
    }
    
    public CircleWorld(Enemy e1, Enemy e2, Enemy e3, Player p) {
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
        this.p = p;
    }

    /**
     * Renders a picture of the drop on the window
     */
    public PApplet draw(PApplet c) {
        c.background(255);
        c.text("Hello!", 20, 20);
        e1.draw(c);
        e2.draw(c);
        e3.draw(c);
        p.draw(c);
        return c;
    }

    /**
     * Produces an updated world where the drop moves
     * down a little bit, if it hasn't hit the bottom
     * of the screen yet.
     */
    public CircleWorld update() {
        return new CircleWorld(e1.fallDown(), e2.fallDown(), e3.fallDown(), p);
    }
    
    /**
     * Produces an updated world with the position of the
     * drop updated to the location of the mouse press.
     */
    public CircleWorld mousePressed(MouseEvent mev) {
        return this;
    }
    
}
