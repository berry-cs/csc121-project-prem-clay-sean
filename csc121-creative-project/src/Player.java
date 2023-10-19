import java.awt.Desktop.Action;
import java.util.Timer;

import processing.core.*;



public class Player {

	double x = 200;
	double y = 350;
	int moveRate = 15;
	int size = 15;
	int lives = 5;
	
    //hitbox vars
    double pTop;
    double pBot;
    double pLeft;
    double pRight;
	
    public Player() {
    	//this.lives=5;
    }
    
    public Player(double x, double y, int lives) {
		this.x = x;
		this.y = y;
		this.lives = lives;
		 pTop = y - size/2;
		 pBot = y+size/2;
		 pLeft = x - size/2;
		 pRight = x+size/2;
	}

	public PApplet draw(PApplet c) {
        c.fill(255, 0, 0);
        c.circle((int)this.x, (int)this.y, this.size);

        return c;
    }
	
	//moves player to the right
    public Player moveR() {

        return new Player (this.x + this.moveRate, this.y, this.lives);
    }
	
    //moves player to the left
    public Player moveL() {
        
        return new Player (this.x - this.moveRate, this.y, this.lives);
    }
    
    //handles collision with enemy
    public boolean collision(Enemy e) {
    	
    	return (this.pRight  > e.EL() && this.pLeft < e.ER() 
    			&& this.pBot > e.ET() && this.pTop < e.EB());
    	
    	}
    
    public void loseALife() {
    	this.lives -= 1;
    	System.out.println("LOST A LIFE");
    }
    
	public int returnLives() {
		return this.lives;
	}

	
}
