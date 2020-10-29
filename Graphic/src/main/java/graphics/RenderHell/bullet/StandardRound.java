package graphics.RenderHell.bullet;

import graphics.RenderHell.utils.Vector;

public class StandardRound extends Bullet {

	public StandardRound(Vector vector) {
		super(vector);
	}

	@Override
	public int getX() {
		return super.x;
	}

	@Override
	public int getY() {
		return super.y;
	}

	@Override
	public int getWidth() {
		
		return 5;
	}

	@Override
	public int getHeight() {
		
		return 5;
	}

	@Override
	public void draw() {
		

	}

	@Override
	public void onCollision() {
		// TODO Auto-generated method stub

	}
	
}
