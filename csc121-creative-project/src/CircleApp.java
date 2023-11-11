import processing.core.*;
import processing.event.*;
import javax.swing.JOptionPane;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class CircleApp extends PApplet {
    SquareEvade w;
    
    public void settings() {
        this.size(400, 400);
    }
    
    public void setup() {
        w = new SquareEvade();        
    }
    
    public void draw() {
        w = w.update();
        w.draw(this);        
    }
    
    public void mousePressed(MouseEvent mev) {
        w = w.mousePressed(mev);

    }
    
    public void keyPressed(KeyEvent kev) {
         w = w.keyPressed(kev);
    }
    
    public void keyReleased(KeyEvent kev) {
        w = w.keyReleased(kev);
   }
   

    public static void main(String[] args) {
    	
        PApplet.runSketch(new String[] { "CircleApp" }, new CircleApp());
        
        String name; 
        name = JOptionPane.showInputDialog("Please enter your name"); 
        
        String msg = "Hello " + name + "!"; 
        JOptionPane.showMessageDialog(null, msg);
    }
    

}
