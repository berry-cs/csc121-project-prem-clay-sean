import java.awt.Desktop.Action;
import java.awt.event.KeyEvent;
import java.util.Timer;
import processing.core.PApplet;
import processing.core.*;



public class Player {

	private double x = 200;
	private double y = 350;
	private int moveRate = 5;
	private int size = 25;
	private int lives = 5;
	private int score =0;
	
    //hitbox vars
	private double pTop;
	private double pBot;
	private double pLeft;
	private double pRight;
	private boolean movingLeft;
	private boolean movingRight;
	
    public Player() {
    	//this.lives=5;
    	this.x = 200;
    	this.y = 350;
    	this.moveRate = 5;
    	this.size = 25;
    	this.lives = 5;
    	this.score =0;

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
    

    public Player keyHandle(processing.event.KeyEvent kev) {

	
	if (kev.getKeyCode() == PApplet.RIGHT) {
		this.movingRight = true;
		this.movingLeft = false;
		
	}

	if(kev.getKeyCode() == PApplet.LEFT) {
		this.movingRight = false;
		this.movingLeft = true;
	}
	//System.out.println(this.movingRight);
	return this;
    }
    
	public Player keyRelease(processing.event.KeyEvent kev) {
		if(kev.getKeyCode() == PApplet.LEFT) {
			this.movingLeft = false;
		}
		if(kev.getKeyCode() == PApplet.RIGHT) {
			this.movingRight = false;
		}
		return this;

	}

    public Player updateP() {
    	
    	

	if(this.movingLeft == true) {
		this.x-=moveRate;
	}
	
	if(this.movingRight == true) {
		this.x+=moveRate;
	}
	return this;
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
    	System.out.println("LOST A LIFE");
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
