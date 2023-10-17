import processing.core.*;



public class Player {

	double x = 200;
	double y = 350;
	int moveRate = 15;
	int size = 15;
	
    //hitbox vars
    double pTop = y - size/2;
    double pBot = y+size/2;
    double pLeft = x - size/2;
    double pRight = x+size/2;
	
    public Player() {
        
    }
    
    public Player(double x, double y) {
		this.x = x;
		this.y = y;
	}

	public PApplet draw(PApplet c) {
        c.fill(255, 0, 0);
        c.circle((int)this.x, (int)this.y, this.size);

        return c;
    }
	
    public Player moveR() {

        return new Player (this.x + this.moveRate, this.y);
    }
	
    public Player moveL() {
        
        return new Player (this.x - this.moveRate, this.y);
    }
    
    public boolean collision(Enemy e) {
    	return (this.pRight  > e.ELeft && this.pLeft < e.ERight 
    			&& this.pBot > e.ETop && this.pTop < e.EBot);
    	
    	}
    
	
	
	
}
