import processing.core.*;
import processing.event.*;
import javax.swing.JOptionPane;
import java.io.*;
import java.util.Scanner;

/**
 * Provides the scaffolding to launch a Processing application
 */
public class CircleApp extends PApplet {
	static SquareEvade w;

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
        name = JOptionPane.showInputDialog("Please enter your username"); 

        UserInfo rec = new UserInfo();
        
        try {
        	
        	Scanner sc = new Scanner(new File("userData.txt"));
        	
        	while (sc.hasNext()) {
        		String un = sc.next();
        		int score = sc.nextInt();
        		
        		rec.addInfo(un, score);
        	}
        	
    		int theirIndex = rec.getUserIndex(name);
        	
        	if (theirIndex == -1) {
        		rec.addInfo(name, w.getPlayer().returnHighScore());
        	} else {
        		int playerHS = rec.getScore(theirIndex);
        	}
        	
        	PrintWriter pw = new PrintWriter(new File("userData.txt"));
        	
        	int i = 0;
        	String output = "";
        	
        	while (i < rec.size()) {
        		String un = rec.getUsername(i);
        		int score = rec.getScore(i);
        		output = output + un + " " + str(score) + "\n";
        		i = i + 1;
        	}
        	
        	pw.println(output);
        	
        	sc.close();
        	pw.close();
        	
        } catch (FileNotFoundException e) {
        	e.printStackTrace();
        }
        
        String msg = "Hello Player " + name + "!"; 
        JOptionPane.showMessageDialog(null, msg);
    }

}
