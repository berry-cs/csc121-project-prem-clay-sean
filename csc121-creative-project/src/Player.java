import processing.core.*;



public class Player {

	double x = 200;
	double y = 350;
	int moveRate = 5;
	
	
    public Player() {
        
    }
    
    public Player(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public PApplet draw(PApplet c) {
        c.fill(255, 0, 0);
        c.circle((int)this.x, (int)this.y, 15);

        return c;
    }
	
	
	
	
}
