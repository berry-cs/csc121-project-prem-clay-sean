import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import processing.event.*;

class SquareEvadeTest {

    SquareEvade cw1 = new SquareEvade();
    Enemy e1 = new Enemy(200,200);
    Enemy e2 = new Enemy(300,300);
    Player p1 = new Player(305,305);
    
    
    @Test
    void tests() {  
    	assertEquals(false,p1.collision(e1));
    	assertEquals(true,p1.collision(e2));

    }

}
