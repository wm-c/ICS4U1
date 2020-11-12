package graphics.RenderHell.objects;

import graphics.RenderHell.Constants;
import graphics.RenderHell.RenderHell;
import graphics.RenderHell.Constants.Units;
import graphics.RenderHell.interfaces.Collidable;
import graphics.RenderHell.interfaces.Drawable;
import graphics.RenderHell.interfaces.Logicable;
import graphics.RenderHell.utils.Vector;
import java.awt.*;


// Class for player control
public class Player implements Drawable, Collidable{
	// Stores player instance
	public static Player mInstance = null;

	// Creates a movementVector for player
	private Vector movementVector;

	// Sets the heath
	public int health = 50;

	// Drawable Data
	private int x;
	private int y;
	private int width;
	private int height;
	public int score = 0;


	// Creates a player based of a config
	private Player(){
		
		this.x = Constants.Player.initialXPose;
		this.y = Constants.Player.initialYPose;

		this.width = Constants.Player.playerWidth;
		this.height = Constants.Player.playerHeight;


		this.movementVector = Constants.Player.initialVector;

	}






	/**
	 * Gets Instance
	 * @return Player Instance
	 */
	public static Player getPlayer(){
		if(mInstance == null){
			mInstance = new Player();
		}

		return mInstance;
	}


	public void setMovementVector(Vector newVector){
		movementVector = newVector;
	}

	public Vector getMovementVector(){
		return movementVector;
	}

	

	@Override
	public void draw(Graphics2D g2d) {

		// Draws player square
		g2d.drawRect(x, y, width, height);

		// heath box
		g2d.setColor(Color.red);
		g2d.fillRect(10, 10, 200 * health / 100, 20);
		
		g2d.setColor(Color.black);
	}

	// gets x
	@Override
	public int getX() {
		return x;
	}

	// gets y
	@Override
	public int getY() {
		return y;
	}

	// gets width
	@Override
	public int getWidth() {
		return width;
	}

	// gets height
	@Override
	public int getHeight() {
		return height;
	}

	// does if player is hit
	@Override
	public void hit() {
		// lower players health and checks if the player has died
		health--;
		if(health <= 0){
			RenderHell.alive = false;
		}
	}


	// returns the type of unit the player is
	public Units getUnit() {
		return Units.PLAYER;
	}

	


}
