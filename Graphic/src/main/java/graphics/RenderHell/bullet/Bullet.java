package graphics.RenderHell.bullet;

import graphics.RenderHell.interfaces.Drawable;
import graphics.RenderHell.interfaces.Logicable;
import graphics.RenderHell.utils.Vector;

public abstract class Bullet implements Drawable, Logicable{
	
	protected Vector flightVector;
	protected int x;
	protected int y;
	public static int bulletCount = 0;
	public int bulletId;

	public Bullet(Vector vector){

		flightVector = vector;
		bulletId = bulletCount;
		bulletCount++;
	}


	

	@Override
	public void update() {
		x += flightVector.getXComponent();
		y += flightVector.getYComponent();		
	}

	public abstract void onCollision();



}
