package graphics.RenderHell.interfaces;

import graphics.RenderHell.utils.Vector;

public interface Collidable {
	
	public int getX();

	public int getY();

	public int getWidth();

	public int getHeight();

	public Vector getMovementVector();

	public void setMovementVector(Vector newVector);

	public void hit();


}
