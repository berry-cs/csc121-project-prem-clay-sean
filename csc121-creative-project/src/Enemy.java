import processing.core.*;

public class Enemy {
    
    double x;
    double y;
    double fallRate = 5;
    
    public Enemy() {
        this.x = (Math.random()*400+1);
        this.y = Math.random()*(-500);
    }
    
    public Enemy(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public PApplet draw(PApplet s) {
        s.fill(0, 0, 255);
        s.square((int)this.x, (int)this.y, 15);

        return s;
    }
    
    /** makes the enemy reappear at a random x along the top */
    public Enemy respawn() {
        return new Enemy((Math.random()*400+1), 0);
    }
    
    /** moves the enemy down or respawns when it hits the bottom */
    public Enemy fallDown() {
        if (this.y < 400) {
            return new Enemy(this.x, this.y + this.fallRate);
        } else {
            return this.respawn();
        }
    }
}
