import processing.core.*;



public class Player {

	double x = 200;
	double y = 350;
	int moveRate = 15;
	int size = 15;
	
    //hitbox vars
    double pTop;
    double pBot;
    double pLeft;
    double pRight;
	
    public Player() {
        
    }
    
    public Player(double x, double y) {
		this.x = x;
		this.y = y;
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

        return new Player (this.x + this.moveRate, this.y);
    }
	
    //moves player to the left
    public Player moveL() {
        
        return new Player (this.x - this.moveRate, this.y);
    }
    
    //handles collision with enemy
    public boolean collision(Enemy e) {
    	return (this.pRight  > e.EL() && this.pLeft < e.ER() 
    			&& this.pBot > e.ET() && this.pTop < e.EB());
    	
    	}
    
	
	
	
}
