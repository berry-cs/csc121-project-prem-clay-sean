import processing.core.PApplet;

public class Collect {
	int red;
	int green;
	int blue;
	double x;
	double y;
	double fallRate;
	int size = 20;

	// hitbox vars
	double CTop;
	double CBot;
	double CLeft;
	double CRight;

	public Collect() {
		this(Math.random() * (375) + 1, Math.random() * (-500), 255, 0, 0, 5);
	}

	public Collect(double x, double y, int red, int green, int blue, double fallRate) {
		this.x = x;
		this.y = y;

		this.CTop = y;
		this.CBot = y + size;
		this.CLeft = x;
		this.CRight = x + size;

		this.red = red;
		this.green = green;
		this.blue = blue;
		this.fallRate = fallRate;

	}
	
	/** puts the squares on the screens with the appropriate color. */
	public PApplet draw(PApplet s) {
		s.fill(this.red, this.green, this.blue);
		s.square((int) this.x, (int) this.y, size);

		return s;
	}

	/** makes the Collect reappear at a random x along the top */
	public Collect respawn() {
		return new Collect((Math.random() * 400 + 1), Math.random() * (-300), this.red, this.green, this.blue,
				this.fallRate);
	}

	/** moves the Collect down or respawns when it hits the bottom */
	public Collect fallDown() {
		if (this.y < 400) {
			return new Collect(this.x, this.y + this.fallRate, this.red, this.green, this.blue, this.fallRate);
		} else {
			return this.respawn();
		}
	}

	
	/** sets the appropriate speeds of the squares. */
	public void speedUp() {
		this.fallRate += .5;
	}

	public void resetSpeed() {
		this.fallRate = 5;
	}

	/** returns the hitbox Vars */
	public double CL() {
		return this.CLeft;
	}

	public double CT() {
		return this.CTop;
	}

	public double CB() {
		return this.CBot;
	}

	public double CR() {
		return this.CRight;
	}

	/** returns values for the color vars */
	public int getR() {
		return this.red;
	}

	public int getG() {
		return this.green;
	}

	public int getB() {
		return this.blue;
	}

	public void changeColor() {

		this.red = (int) (Math.random() * (255) + 70);
		this.green = (int) (Math.random() * (255) + 70);
		this.blue = (int) (Math.random() * (255) + 70);

	}

}