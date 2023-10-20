import java.awt.Desktop.Action;
import java.util.Timer;

import processing.core.*;



public class Player {

	double x = 200;
	double y = 350;
	int moveRate = 20;
	int size = 25;
	int lives = 5;
	int score =0;
	
    //hitbox vars
    double pTop;
    double pBot;
    double pLeft;
    double pRight;
	
    public Player() {
    	//this.lives=5;
        

    }
    
    public Player(double x, double y, int lives, int score) {
		this.x = x;
		this.y = y;
		this.lives = lives;
		this.score = score;
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

        return new Player (this.x + this.moveRate, this.y, this.lives, this.score);
    }
	
    //moves player to the left
    public Player moveL() {
        
        return new Player (this.x - this.moveRate, this.y, this.lives,this.score);
    }
    
    //handles collision with enemy
    public boolean collisionE(Enemy e) {
    	
    	return (this.pRight  > e.EL() && this.pLeft < e.ER() 
    			&& this.pBot > e.ET() && this.pTop < e.EB());
    	
    	}
    public boolean collisionC(Collect c) {
    	
    	return (this.pRight  > c.CL() && this.pLeft < c.CR() 
    			&& this.pBot > c.CT() && this.pTop < c.CB());
    	
    	}
    
    public void loseALife() {
    	this.lives -= 1;
    	//System.out.println("LOST A LIFE");
    }
    public void addPoint() {
    	this.score++;
    	System.out.println("Score");
    }
    
	public int returnLives() {
		return this.lives;
	}
	public int returnScore() {
		return this.score;
	}

	
}
