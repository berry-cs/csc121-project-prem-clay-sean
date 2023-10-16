import processing.core.*;



public class Player {

	double x = 200;
	double y = 350;
	int moveRate = 15;
	
	
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
	
    public Player moveR() {

        return new Player (this.x + this.moveRate, this.y);
    }
	
    public Player moveL() {
        
        return new Player (this.x - this.moveRate, this.y);
    }
    
    public boolean collision(Enemy aEnemy) {
    	(this.x > aEnemy.ELeft && this.x < aEnemy.ERight
    			&& this.y > aEnemy.ETop && this.y < aEnemy.EBot);
    }
	
	
	
}
