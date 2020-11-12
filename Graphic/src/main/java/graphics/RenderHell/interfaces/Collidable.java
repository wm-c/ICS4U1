package graphics.RenderHell.interfaces;

import graphics.RenderHell.utils.Vector;

// interface for class the can collide
public interface Collidable {
	
	// Getters and setters for data
	public int getX();

	public int getY();

	public int getWidth();

	public int getHeight();

	public Vector getMovementVector();

	public void setMovementVector(Vector newVector);

	public void hit();


}
