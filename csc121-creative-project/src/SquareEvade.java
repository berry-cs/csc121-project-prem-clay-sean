import processing.core.PApplet;
import processing.event.KeyEvent;
import processing.event.MouseEvent;

/**
 * produces an animation of severeal enemy squares falling from the top of the
 * scre and the player must move the circle to avoid contact with
 * 
 */
public class SquareEvade {

	private int numC;
	private int numEnemies;
	private Player p;
	private Enemy eList[];
	private Collect cList[];
	private int state;
	private boolean upgradeReady = true;
	private boolean upgradeReady2 = true;



	public SquareEvade() {
		numEnemies = 3;
		numC = 2;
		p = new Player();
		eList = new Enemy[numEnemies];
		cList = new Collect[numC];

		state = 0;
		// lives = p.returnLives();

		for (int i = 0; i < numEnemies; i++) {
			eList[i] = new Enemy();
		}

		for (int i = 0; i < numC; i++) {
			cList[i] = new Collect();
		}

	}

	public SquareEvade(int numEnemies, Player p, Enemy eList[], int numC, Collect cList[]) {
		this.numEnemies = numEnemies;
		this.p = p;
		this.eList = eList;
		this.numC= numC;
		this.cList = cList;

		

		// this.lives = 5;
	}

	/**
	 * Renders a picture of an array of square, circle player, and the score/lives
	 */
	public PApplet draw(PApplet c) {
		
		switch(state) {
		case 0:
			
			c.background(10);
			c.textSize(50);
			c.fill(255,0,0);
			c.text("Square Evade", 60, 80);
			c.textSize(25);
			c.text("Avoid the grey squares!", 50, 130);
	        c.fill(69, 69, 69);
	        c.square(300,105,25);
	        
	        c.fill(92,200,128);
			c.textSize(25);
	        c.fill(255,0,0);
			c.text("Collect the colored squares!", 20, 200);
	        c.fill(92,200,128);
	        c.square(355,175,25);
	        c.fill(255,0,0);
	        c.square(315,175,25);

			
			break;
		case 1:
			c.background(10);
			c.textSize(25);
			c.text("Score: " + this.p.returnScore(), 20, 40);
			c.text("Lives: " + this.p.returnLives(), 300, 40);
			for (int i = 0; i < eList.length; i++) {
				this.eList[i].draw(c);
			}
			for (int i = 0; i < cList.length; i++) {
				this.cList[i].draw(c);
			}
			
			
			p.getColor(this.cList[0]);

			if(this.p.returnScore()%5 == 0 && this.p.returnScore()>0) {
				
				for (int i = 0; i < cList.length; i++) {
					this.cList[i].changeColor();
				}
				p.getColor(this.cList[0]);
				//this.p.addPoint();
			}
			

			if(this.p.returnScore()%5 == 0 && this.p.returnScore()>0 && upgradeReady) {
				
				for (int i = 0; i < cList.length; i++) {
					this.cList[i].speedUp();
				}
				
				for (int i = 0; i < eList.length; i++) {
					this.eList[i].speedUp();
				}
				upgradeReady = false;

			}
			
			if(this.p.returnScore()%6 == 0 && this.p.returnScore()>0 && upgradeReady == false) {
				upgradeReady = true;
			}
			
			if(this.p.returnScore()%10 == 0 && this.p.returnScore()>0 && upgradeReady2) {
				this.p.gainALife();
				upgradeReady2 = false;
				
			}
			
			if(this.p.returnScore()%11 == 0 && this.p.returnScore()>0 && upgradeReady2 == false) {
				upgradeReady2 = true;
			}
			
	    	System.out.println(this.cList[1].fallRate);
			p.draw(c);


			if(this.p.returnLives() <= 0 ) {
				state = 2;
				c.text("Game Over", 200, 200);

			}
			break;
		case 2:
			c.background(10);
			c.textSize(50);
			c.fill(255,0,0);
			c.text("Square Evade", 60, 80);
			c.textSize(25);
			c.text("Game Over", 150, 150);
			c.text("Your Score: "+ this.p.returnScore(), 130,200);;
			break;
		
		}
		return c;
	}

	/**
	 * Produces an updated scene where the squares are further down on the screen
	 * and if prompted by the user the player to the left or right
	 */
	public SquareEvade update() {


		switch(state) {
		case 1:
			Enemy updatedEnemies[] = new Enemy[numEnemies];
			Collect updatedCollects[] = new Collect[numC];
			
			for (int i = 0; i < numEnemies; i++) {
				updatedEnemies[i] = this.eList[i].fallDown();
				if (this.p.collisionE(updatedEnemies[i])) {
					this.p.loseALife();
					updatedEnemies[i]= this.eList[i].respawn();
					//System.out.println(eList[i]);

				}
			}
			for (int i = 0; i < numC; i++) {
				updatedCollects[i] = this.cList[i].fallDown();
				if (this.p.collisionC(updatedCollects[i])) {
					System.out.println("collect");
					this.p.addPoint();
					updatedCollects[i]= this.cList[i].respawn();
					//System.out.println(eList[i]);

				}
			}
			
			this.p.updateP();
			this.eList = updatedEnemies;
			this.cList = updatedCollects;

			
			break;
			
		case 2:
			
			for(int i = 0; i < numEnemies; i++ ) {
				this.eList[i] = this.eList[i].respawn();
			}
			for(int i = 0; i < numC; i++ ) {
				this.cList[i] = this.cList[i].respawn();
			}
			
			break;
		}
		return this;
	}

	/**
	 * does nothing
	 */
	public SquareEvade mousePressed(MouseEvent mev) {
		// return new SquareEvade(e1.fallDown(), e2.fallDown(), e3.fallDown(),
		// p.move());
		return this;
	}

	/**
	 * controls the movement of the player using arrow keys
	 */
	public SquareEvade keyPressed(KeyEvent kev) {
		this.p = this.p.keyHandle(kev);
		if (kev.getKeyCode() == 32) {
			
			if(state == 0) {state = 1;}
			else if(state == 2) { 
				p.resetP();
				for (int i = 0; i < cList.length; i++) {
					this.cList[i].resetSpeed();
				}
				
				for (int i = 0; i < eList.length; i++) {
					this.eList[i].resetSpeed();
				}
				
				state = 1;}
			
		}
		return this;

}
	public SquareEvade keyReleased(KeyEvent kev) {
		this.p = this.p.keyRelease(kev);
		return this;

	}
}


