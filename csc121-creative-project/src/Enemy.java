import processing.core.*;

public class Enemy {
    
   private double x;
   private double y;
   private double fallRate = 5;
   private int size = 20;
    
    //hitbox vars
   private double ETop;
   private double EBot;
   private double ELeft;
   private double ERight;
    
    public Enemy() {
        this (Math.random()*(375)+1,  Math.random()*(-500),5);
    }
    
    public Enemy(double x, double y, double fallRate) {
        this.x = x;
        this.y = y;
        this.fallRate = fallRate;
        
        ETop = y;
        EBot = y+size;
        ELeft= x;
        ERight = x+size;
        
    }

    public PApplet draw(PApplet s) {
        s.fill(69, 69, 69);
        s.square((int)this.x, (int)this.y, size);

        return s;
    }
    
    /** makes the enemy reappear at a random x along the top */
    public Enemy respawn() {
        return new Enemy((Math.random()*400+1), Math.random()*(-300), this.fallRate);
    }
    
    /** moves the enemy down or respawns when it hits the bottom */
    public Enemy fallDown() {
        if (this.y < 400) {
            return new Enemy(this.x, this.y + this.fallRate, this.fallRate);
        } else {
            return this.respawn();
        }
    }
    
    public void speedUp() {
    	this.fallRate+= .5;
    }
    
    public void resetSpeed() {
    	this.fallRate = 5;
    }
    
    public double EL() {
    	return this.ELeft;
    }
    
    public double ET() {
    	return this.ETop;
    }
    
    public double EB() {
    	return this.EBot;
    }
    
    public double ER() {
    	return this.ERight;
    }
}
