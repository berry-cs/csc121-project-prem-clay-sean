import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

/**
 * produces an animation of severeal enemy squares falling from the top of the scre
 * and the player must move the circle to avoid contact with 

 */
public class SquareEvade {
    
    //Enemy[] eList = {e1,e2,e3};
    int numEnemies;
    Player p;
    Enemy eList[];
    int score;
    int lives;

    public SquareEvade() {
        numEnemies = 5;
        p = new Player();
        eList = new Enemy[numEnemies];
        score = 0;
        lives = 5;
        
        for (int i = 0; i < numEnemies; i++) {
            eList[i] = new Enemy();
        }
    }
    
    public SquareEvade(int numEnemies, Player p, Enemy eList[]) {
    	this.numEnemies = numEnemies;
        this.p = p;
        this.eList=eList;
        this.score = 0;
        this.lives = 5;
    }

    /**
     * Renders a picture of an array of square, circle player, and the score/lives
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
     * Produces an updated scene where the squares are further down on the 
     * screen and if prompted by the user the player to the left or right
     */
    public SquareEvade update() {
    	

        Enemy updatedEnemies[] = new Enemy[numEnemies];
        for(int i = 0; i < numEnemies; i++) {
            updatedEnemies[i] = this.eList[i].fallDown();
        }
        
//        for(int i = 0; i < numEnemies; i++) {
//        	if(p.collision(updatedEnemies[i])) {
//        		this.lives -=1;
//        	}
//        	
//        }
        return new SquareEvade(numEnemies, p, updatedEnemies);
   
   
    }
    
    /**
     *does nothing
     */
    public SquareEvade mousePressed(MouseEvent mev) {
        //return new SquareEvade(e1.fallDown(), e2.fallDown(), e3.fallDown(), p.move());
    return this;
    }
    
    
    /**
     *controls the movement of the player using arrow keys
     */
    public SquareEvade keyPressed(KeyEvent kev) {
    	if(kev.getKeyCode() == PApplet.RIGHT) {
            Enemy updatedEnemies[] = new Enemy[numEnemies];
            for(int i = 0; i < numEnemies; i++) {
                updatedEnemies[i] = this.eList[i].fallDown();
            }
            return new SquareEvade(numEnemies, p.moveR(), updatedEnemies);
    	}
  
    	else if(kev.getKeyCode() == PApplet.LEFT) {
            Enemy updatedEnemies[] = new Enemy[numEnemies];
            for(int i = 0; i < numEnemies; i++) {
                updatedEnemies[i] = this.eList[i].fallDown();
            }
            return new SquareEvade(numEnemies, p.moveL(), updatedEnemies);
    	}
    	else{
    		return this;
    	}
        //return new SquareEvade(e1.fallDown(), e2.fallDown(), e3.fallDown(), p.move());
    }
    
}
