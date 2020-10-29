package graphics.RenderHell.bullet;

import java.util.HashMap;

import graphics.RenderHell.interfaces.Drawable;
import graphics.RenderHell.interfaces.Logicable;

public class BulletMaster implements Logicable, Drawable{
	private static BulletMaster mInstance = null;

	public HashMap<Integer, Bullet> bulletTracker;

	private BulletMaster(){
		bulletTracker = new HashMap<>();
	}

	public static BulletMaster getInstance(){
		if(mInstance == null){
			mInstance = new BulletMaster();
		}

		return mInstance;
	}

	public void addBullet(Bullet newBullet){
		bulletTracker.put(newBullet.bulletId, newBullet);
	}

	@Override
	public int getX() {
		System.out.println("WARNING DO NOT CALL ON BULLET MASTER");
		return 0;
	}

	@Override
	public int getY() {
		System.out.println("WARNING DO NOT CALL ON BULLET MASTER");
		return 0;
	}

	@Override
	public int getWidth() {
		System.out.println("WARNING DO NOT CALL ON BULLET MASTER");
		return 0;
	}

	@Override
	public int getHeight() {
		System.out.println("WARNING DO NOT CALL ON BULLET MASTER");
		return 0;
	}

	@Override
	public void draw() {
		for (Bullet bullet : bulletTracker.values()) {
			bullet.draw();
		}

	}

	@Override
	public void update() {
		for (Bullet bullet : bulletTracker.values()) {
			bullet.update();
		}

	}





	




}
