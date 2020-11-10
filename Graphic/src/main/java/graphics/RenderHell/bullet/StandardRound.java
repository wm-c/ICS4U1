package graphics.RenderHell.bullet;

import graphics.RenderHell.utils.Vector;
import graphics.RenderHell.Constants;
import graphics.RenderHell.Constants.Units;
import java.awt.*;


public class StandardRound extends Bullet {

	private Units owner;

	public StandardRound(Vector vector, int initalX, int initalY, Units ownerUnit) {
		super(vector, initalX, initalY);
		owner = ownerUnit;
	}

	@Override
	public void draw(Graphics2D g2d) {
		g2d.drawRect(getX(), getY(), Constants.Bullets.bulletWidth, Constants.Bullets.bulletHeight);
		
	}


	


	@Override
	public void onCollision() {
		// TODO Auto-generated method stub

	}

	@Override
	public Units getSource() {
		return owner;
	}
	
}
