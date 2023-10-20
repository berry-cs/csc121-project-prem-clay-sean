import processing.core.PApplet;

public class Collect {
    
    double x;
    double y;
    double fallRate = 5;
    int size = 20;
    
    //hitbox vars
    double CTop;
    double CBot;
    double CLeft;
    double CRight;
    
    public Collect() {
        this (Math.random()*(375)+1,  Math.random()*(-500));
    }
    
    public Collect(double x, double y) {
        this.x = x;
        this.y = y;
        
        CTop = y;
        CBot = y+size;
        CLeft= x;
        CRight = x+size;
    }

    public PApplet draw(PApplet s) {
        s.fill(255, 0, 0);
        s.square((int)this.x, (int)this.y, size);

        return s;
    }
    
    /** makes the Collect reappear at a random x along the top */
    public Collect respawn() {
        return new Collect((Math.random()*400+1), 0);
    }
    
    /** moves the Collect down or respawns when it hits the bottom */
    public Collect fallDown() {
        if (this.y < 400) {
            return new Collect(this.x, this.y + this.fallRate);
        } else {
            return this.respawn();
        }
    }
    
    public double CL() {
    	return this.CLeft;
    }
    
    public double CT() {
    	return this.CTop;
    }
    
    public double CB() {
    	return this.CBot;
    }
    
    public double CR() {
    	return this.CRight;
    }
}