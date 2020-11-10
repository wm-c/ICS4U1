package graphics.RenderHell.bullet;

import graphics.RenderHell.interfaces.Drawable;
import graphics.RenderHell.interfaces.Logicable;
import graphics.RenderHell.objects.Player;
import graphics.RenderHell.utils.Vector;

import graphics.RenderHell.Constants.Units;

public abstract class Bullet implements Drawable, Logicable{
	
	protected Vector flightVector;
	private double x;
	private double y;
	public static int bulletCount = 0;
	public int bulletId;

	public Bullet(Vector vector, int initalX, int initalY){

		flightVector = vector;
		bulletId = bulletCount;
		bulletCount++;
		x = initalX;
		y = initalY;
	}
	

	@Override
	public void update(Vector playerVector) {
		x += flightVector.getXComponent() + (playerVector.getXComponent() * -1);
		y += flightVector.getYComponent() + (playerVector.getYComponent() * -1);	
	}

	public abstract void onCollision();

	public int getX(){
		return (int)x;
	}

	public int getY(){
		return (int)y;
	}

	public Vector getFlightVector(){
		return flightVector;
	}

	public abstract Units getSource();

}
