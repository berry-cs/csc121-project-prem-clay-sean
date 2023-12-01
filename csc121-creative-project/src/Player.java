
import processing.core.*;


/** this class includes the player and the player's movements for collecting squares and avoiding the enemy square. */ 
public class Player {

	private double x = 200;
	private double y = 350;
	private int moveRate = 5;
	private int size = 25;
	private int lives;
	private int score = 0;
	private int highScore;
	private String username;

	// hitbox vars
	private double pTop;
	private double pBot;
	private double pLeft;
	private double pRight;
	private boolean movingLeft;
	private boolean movingRight;

	private int red;
	private int green;
	private int blue;

	public Player() {
		this.x = 200;
		this.y = 350;
		this.moveRate = 5;
		this.size = 25;
		this.lives = 5;
		this.score = 0;
		this.pTop = this.y - size / 2;
		this.pBot = this.y + size / 2;
		this.pLeft = this.x - size / 2;
		this.pRight = this.x + size / 2;
		this.highScore = 0;
		this.username = "";

	}

	public Player(double x, double y, int lives, int score) {
		this.x = x;
		this.y = y;
		this.lives = lives;
		this.score = score;
		this.pTop = this.y - size / 2;
		this.pBot = this.y + size / 2;
		this.pLeft = this.x - size / 2;
		this.pRight = this.x + size / 2;
		this.highScore = 0;
		this.username = "";

	}

	public PApplet draw(PApplet c) {
		c.fill(this.red, this.blue, this.green);
		c.circle((int) this.x, (int) this.y, this.size);

		return c;
	}

	/** retrieves the collect squares */
	public void getColor(Collect c) {
		this.red = c.getR();
		this.green = c.getG();
		this.blue = c.getB();

	}

	public Player keyHandle(processing.event.KeyEvent kev) {

		if (kev.getKeyCode() == PApplet.RIGHT) {
			this.movingRight = true;
			this.movingLeft = false;

		}

		if (kev.getKeyCode() == PApplet.LEFT) {
			this.movingRight = false;
			this.movingLeft = true;
		}
		return this;
	}

	public Player keyRelease(processing.event.KeyEvent kev) {
		if (kev.getKeyCode() == PApplet.LEFT) {
			this.movingLeft = false;
		}
		if (kev.getKeyCode() == PApplet.RIGHT) {
			this.movingRight = false;
		}
		return this;

	}

	// updates the position of the player
	public Player updateP() {

		if (this.movingLeft == true) {
			this.x -= moveRate;
			this.pLeft -= moveRate;
			this.pRight -= moveRate;

		}

		if (this.movingRight == true) {
			this.x += moveRate;
			this.pRight += moveRate;
			this.pLeft += moveRate;
		}

		return this;
	}

	// handles collision with enemy
	public boolean collisionE(Enemy e) {

		return (this.pRight > e.EL() && this.pLeft < e.ER() && this.pBot > e.ET() && this.pTop < e.EB());

	}

	// checks collision of clayer with a Colect
	public boolean collisionC(Collect c) {

		return (this.pRight > c.CL() && this.pLeft < c.CR() && this.pBot > c.CT() && this.pTop < c.CB());

	}

	// subtracts a life
	public void loseALife() {
		this.lives -= 1;
		System.out.println("LOST A LIFE");
	}

	public void gainALife() {
		if (this.lives < 5) {
			this.lives++;
		}
	}

	// adds a point to player score
	public void addPoint() {
		this.score++;
		System.out.println("Score");
	}

	// return player lives
	public int returnLives() {
		return this.lives;
	}

	// returns the score
	public int returnScore() {
		return this.score;
	}

	public void resetP() {
		this.lives = 5;
		this.score = 0;
	}

	public void assignHighScore(int hs) {
		this.highScore = hs;
	}

	public int returnHighScore() {
		return highScore;
	}

	public void setUsername(String s) {
		this.username = s;
	}

}
