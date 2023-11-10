import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.event.*;

class SquareEvadeTest {

    SquareEvade cw1 = new SquareEvade();
    Enemy e1 = new Enemy(200,200,5);
    Enemy e2 = new Enemy(300,300,5);
    Player p1 = new Player(305,305,5,0);
    
    
    @Test
    void tests() {  
    	assertEquals(false,p1.collisionE(e1));
    	assertEquals(5,p1.returnLives());
    	assertEquals(true,p1.collisionE(e2));
    	p1.loseALife();
    	assertEquals(4,p1.returnLives());
    	assertEquals(0,p1.returnScore());
    	p1.addPoint();
    	assertEquals(1,p1.returnScore());
    	p1.addPoint();
    	p1.addPoint();
    	p1.addPoint();
    	assertEquals(4,p1.returnScore());
    	

    }

}
