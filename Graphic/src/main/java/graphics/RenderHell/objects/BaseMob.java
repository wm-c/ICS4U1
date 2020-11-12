package graphics.RenderHell.objects;

import java.awt.Color;
import java.awt.Graphics2D;

import graphics.RenderHell.Constants.Units;
import graphics.RenderHell.interfaces.Collidable;
import graphics.RenderHell.interfaces.Drawable;
import graphics.RenderHell.interfaces.Logicable;

public abstract class BaseMob implements Drawable, Logicable{
	
	// Stores important mob values
	public int health;
	public int width;
	public int height;
	public double x;
	public double y;
	
	// stores mobIds
	private static int mobCount = 0;
	private int mobId;

	// Constructor for mobs
	public BaseMob(int x, int y, int width, int height, int health){
		this.health = health;
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

		// assignes a unique mob id
		mobId = mobCount;
		mobCount++;

	}

	// gets the mobid
	public int getMobId(){
		return mobId;
	}

	// draws the mob health bar
	@Override
	public void draw(Graphics2D g2d) {
		drawHealthBar(g2d);
	}


	private void drawHealthBar(Graphics2D g2d){
		// set color to red
		g2d.setColor(Color.red);
		// draw health bar
		g2d.fillRect((int)x, (int)y + height + 5, width * health / 100, 5);
		
		// resets color
		g2d.setColor(Color.black);
	}


	// abstract methods for mobs
	public abstract void hit();

	public abstract void die();

	protected abstract void attack();

	protected abstract void calculatePath();

	public abstract boolean isDead();

	public abstract Units getUnit();

}
