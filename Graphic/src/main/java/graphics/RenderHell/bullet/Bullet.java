package graphics.RenderHell.bullet;

import graphics.RenderHell.interfaces.Drawable;
import graphics.RenderHell.interfaces.Logicable;
import graphics.RenderHell.utils.Vector;

import graphics.RenderHell.Constants.Units;

// abstract class for bullets
public abstract class Bullet implements Drawable, Logicable{
	
	// Variables for bullet characteritics
	protected Vector flightVector;
	private double x;
	private double y;
	public static int bulletCount = 0;
	public int bulletId;

	public Bullet(Vector vector, int initalX, int initalY){

		flightVector = vector;

		// assigns unique bullet id
		bulletId = bulletCount;
		bulletCount++;

		x = initalX;
		y = initalY;
	}
	
	
	// updates bullet bases on player vector and flight vector
	@Override
	public void update(Vector playerVector) {
		x += flightVector.getXComponent() + (playerVector.getXComponent() * -1);
		y += flightVector.getYComponent() + (playerVector.getYComponent() * -1);	
	}


	// x getter
	public int getX(){
		return (int)x;
	}

	// y getter
	public int getY(){
		return (int)y;
	}

	// get the flight vector
	public Vector getFlightVector(){
		return flightVector;
	}

	// bullet source
	public abstract Units getSource();

}
