package graphics.RenderHell.objects;

import graphics.RenderHell.Constants;
import graphics.RenderHell.Constants.Units;
import graphics.RenderHell.interfaces.Collidable;
import graphics.RenderHell.interfaces.Drawable;
import graphics.RenderHell.interfaces.Logicable;
import graphics.RenderHell.utils.Vector;
import java.awt.*;



public class Player implements Drawable, Logicable, Collidable{
	public static Player mInstance = null;

	private Vector movementVector;

	public int health = 1000;

	// Drawable Data
	private int x;
	private int y;
	private int width;
	private int height;




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
	public void update(Vector playerVector) {
		// x += movementVector.getXComponent();
		// y += movementVector.getYComponent();
	}



	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawRect(x, y, width, height);

		// heath box
		g2d.setColor(Color.red);
		g2d.fillRect(10, 10, width * health / 100, 20);
		
		g2d.setColor(Color.black);
	}

	@Override
	public int getX() {
		return x;
	}

	@Override
	public int getY() {
		return y;
	}

	@Override
	public int getWidth() {
		return width;
	}

	@Override
	public int getHeight() {
		return height;
	}

	@Override
	public void hit() {
		health--;
	}






	public Units getUnit() {
		return Units.PLAYER;
	}

	


}
