import processing.core.*;
import processing.event.*;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class CircleApp extends PApplet {
    CircleWorld w;
    CircleWorld w2;
    CircleWorld w3;
    
    public void settings() {
        this.size(400, 400);
    }
    
    public void setup() {
        w = new CircleWorld(200, 0);
        w2 = new CircleWorld(300,0);
        w3 = new CircleWorld(100,0);
        
    }
    
    public void draw() {
        w = w.update();
        w.draw(this);
        
        w2 = w2.update();
        w2.draw(this);
        
        w3 = w3.update();
        w3.draw(this);
        
        
    }
    
    public void mousePressed(MouseEvent mev) {
        w = w.mousePressed(mev);

    }
    
    public void keyPressed(KeyEvent kev) {
        // w = w.keyPressed(kev);
    }

    public static void main(String[] args) {
        PApplet.runSketch(new String[] { "CircleApp" }, new CircleApp());
    }
}
