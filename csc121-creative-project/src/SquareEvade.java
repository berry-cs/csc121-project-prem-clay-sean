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

	private boolean isPlaying;


	public SquareEvade() {
		numEnemies = 3;
		numC = 2;
		p = new Player();
		eList = new Enemy[numEnemies];
		cList = new Collect[numC];
		isPlaying = true;
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
		isPlaying = true;

		// this.lives = 5;
	}

	/**
	 * Renders a picture of an array of square, circle player, and the score/lives
	 */
	public PApplet draw(PApplet c) {
		c.background(42);
		c.textSize(25);
		c.text("Score: " + this.p.returnScore(), 20, 40);
		c.text("Lives: " + this.p.returnLives(), 300, 40);

		for (int i = 0; i < eList.length; i++) {
			this.eList[i].draw(c);
		}
		for (int i = 0; i < cList.length; i++) {
			this.cList[i].draw(c);
		}
		p.draw(c);


		if(this.p.returnLives() <= 0 ) {
			isPlaying = false;
			c.text("Game Over", 200, 200);

		}
		return c;
	}

	/**
	 * Produces an updated scene where the squares are further down on the screen
	 * and if prompted by the user the player to the left or right
	 */
	public SquareEvade update() {

		//boolean isInGracePeriod = false;

		

		Enemy updatedEnemies[] = new Enemy[numEnemies];
		Collect updatedCollects[] = new Collect[numC];



		if(this.isPlaying == true) {

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

			return this;
		}
		else {
			return this;
		}
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
		return this;

}
	public SquareEvade keyReleased(KeyEvent kev) {
		this.p = this.p.keyRelease(kev);
		return this;

	}
}


