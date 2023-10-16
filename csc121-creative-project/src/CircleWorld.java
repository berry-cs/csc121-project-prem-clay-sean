import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

/**
 * Represents an interactive application where a drop of
 * water falls down from the top of the window. If the 
 * user clicks the mouse, the drop is moved over to the
 * location of the click;
 */
public class CircleWorld {
    
    //Enemy[] eList = {e1,e2,e3};
    int numEnemies;
    Player p;
    Enemy eList[];
    int score;
    int lives;

    public CircleWorld() {
        numEnemies = 5;
        p = new Player();
        eList = new Enemy[numEnemies];
        score = 0;
        lives = 5;
        
        for (int i = 0; i < numEnemies; i++) {
            eList[i] = new Enemy();
        }
    }
    
    public CircleWorld(int numEnemies, Player p, Enemy eList[]) {
    	this.numEnemies = numEnemies;
        this.p = p;
        this.eList=eList;
        
    }

    /**
     * Renders a picture of the drop on the window
     */
    public PApplet draw(PApplet c) {
        c.background(42);
        c.textSize(25);
        c.text("Score: " + this.score, 20, 40);
        c.text("Lives: " + this.lives, 300, 40);

        

        
       for(int i = 0; i< eList.length; i++) {
        	this.eList[i].draw(c);
        	        }
        p.draw(c);
        return c;
    }

    /**
     * Produces an updated world where the drop moves
     * down a little bit, if it hasn't hit the bottom
     * of the screen yet.
     */
    public CircleWorld update() {
        for(int i = 0; i < numEnemies; i++) {
        	if(p.collision(this.eList[i])) {
        		//this.eList[i];
        	}
        	
 
        }
        Enemy updatedEnemies[] = new Enemy[numEnemies];
        for(int i = 0; i < numEnemies; i++) {
            updatedEnemies[i] = this.eList[i].fallDown();
        }
        
        
        return new CircleWorld(numEnemies, p, updatedEnemies);
   
   
    }
    
    /**
     * Produces an updated world with the position of the
     * drop updated to the location of the mouse press.
     */
    public CircleWorld mousePressed(MouseEvent mev) {
        //return new CircleWorld(e1.fallDown(), e2.fallDown(), e3.fallDown(), p.move());
    return this;
    }
    
    
    public CircleWorld keyPressed(KeyEvent kev) {
    	if(kev.getKeyCode() == PApplet.RIGHT) {
            Enemy updatedEnemies[] = new Enemy[numEnemies];
            for(int i = 0; i < numEnemies; i++) {
                updatedEnemies[i] = this.eList[i].fallDown();
            }
            return new CircleWorld(numEnemies, p.moveR(), updatedEnemies);
    	}
  
    	else if(kev.getKeyCode() == PApplet.LEFT) {
            Enemy updatedEnemies[] = new Enemy[numEnemies];
            for(int i = 0; i < numEnemies; i++) {
                updatedEnemies[i] = this.eList[i].fallDown();
            }
            return new CircleWorld(numEnemies, p.moveL(), updatedEnemies);
    	}
    	else{
    		return this;
    	}
        //return new CircleWorld(e1.fallDown(), e2.fallDown(), e3.fallDown(), p.move());
    }
    
}
