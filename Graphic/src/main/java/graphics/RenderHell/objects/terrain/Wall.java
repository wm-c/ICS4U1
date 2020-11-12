package graphics.RenderHell.objects.terrain;

import java.awt.Graphics2D;

import graphics.RenderHell.interfaces.Collidable;
import graphics.RenderHell.interfaces.Drawable;
import graphics.RenderHell.interfaces.Logicable;
import graphics.RenderHell.utils.Vector;


public class Wall implements Logicable, Drawable, Collidable{

	// Stores positional data
	public int x; 
	public int y;
	public int width;
	public int height;

	// creates new wall
	public Wall(int x, int y, int width, int height){
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;
	}


	// updates x and y position of the walls
	@Override
	public void update(Vector playerVector) {
		x += playerVector.getXComponent() * -1;
		y += playerVector.getYComponent() * -1;

	}

	@Override
	public void draw(Graphics2D g2d) {
		// Draws the rectangle
		g2d.fillRect(x, y, width, height);

	}

	// Getters and Setters
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
	public Vector getMovementVector() {
		return null;
	}

	@Override
	public void hit() {
		return;

	}

	@Override
	public void setMovementVector(Vector newVector) {
		
		return;
	}
	










}
