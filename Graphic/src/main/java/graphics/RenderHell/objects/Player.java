package graphics.RenderHell.objects;

import graphics.RenderHell.Constants;
import graphics.RenderHell.interfaces.Drawable;
import graphics.RenderHell.interfaces.Logicable;
import graphics.RenderHell.utils.Vector;

public class Player implements Drawable, Logicable{
	public static Player mInstance = null;

	private Vector movementVector;


	// Drawable Data
	private double x;
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
	public void update() {
		x += movementVector.getXComponent();
		y += movementVector.getYComponent();
	}

	

	@Override
	public void draw() {
		// TODO Auto-generated method stub

	}

	@Override
	public int getX() {
		
		return (int)(x);
		
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




	






	
	














}
