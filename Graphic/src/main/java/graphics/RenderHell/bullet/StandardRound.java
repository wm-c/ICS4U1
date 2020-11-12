package graphics.RenderHell.bullet;

import graphics.RenderHell.utils.Vector;
import graphics.RenderHell.Constants;
import graphics.RenderHell.Constants.Units;
import java.awt.*;


public class StandardRound extends Bullet {

	// unit
	private Units owner;

	// sets flight vector, start x and y as well as the unit that shot it
	public StandardRound(Vector vector, int initalX, int initalY, Units ownerUnit) {
		super(vector, initalX, initalY);
		owner = ownerUnit;
	}

	// draws the bullet
	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawRect(getX(), getY(), Constants.Bullets.bulletWidth, Constants.Bullets.bulletHeight);
		
	}

	// returns the source
	@Override
	public Units getSource() {
		return owner;
	}
	
}
