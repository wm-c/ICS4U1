package graphics.RenderHell.bullet;

import java.util.HashMap;
import java.util.Iterator;

import graphics.RenderHell.input.PlayerShooting;
import graphics.RenderHell.interfaces.Drawable;
import graphics.RenderHell.interfaces.Logicable;
import graphics.RenderHell.objects.BaseMob;
import graphics.RenderHell.objects.MobMaster;
import graphics.RenderHell.objects.Player;
import graphics.RenderHell.utils.Utils;
import graphics.RenderHell.utils.Vector;

import java.awt.*;

public class BulletMaster implements Logicable, Drawable {
	// Stores instance
	private static BulletMaster mInstance = null;

	// creates a hashmap for bullets
	public static HashMap<Integer, Bullet> bulletTracker;
	
	// used to initalize bullet master
	private BulletMaster() {
		bulletTracker = new HashMap<>();
	}

	// Returns bullet master instance
	public static BulletMaster getInstance() {
		if (mInstance == null) {
			mInstance = new BulletMaster();
		}

		return mInstance;
	}

	@Override
	public void draw(Graphics2D g2d) {

		// Draws all bullets in the hashmap
		for (Bullet bullet : bulletTracker.values()) {
			bullet.draw(g2d);
		}

	}

	@Override
	public void update(Vector playerVector) {
		// gets player instance
		Player player = Player.getPlayer();

		// runs add bullet
		PlayerShooting.addBullet();

		// loops through an iterator of all bullets removes the ones that hit targets
		for (Iterator<Bullet> i = bulletTracker.values().iterator(); i.hasNext();) {
			Bullet bullet = i.next();

			// Updates bullets pose
			bullet.update(playerVector);

			// Iterates over the mobs to check collision
			for(Iterator<BaseMob> j = MobMaster.getInstance().getMobs().values().iterator(); j.hasNext();){
				BaseMob currentMob = j.next();
				if(Utils.collide((int)currentMob.x, (int)currentMob.y, currentMob.width, currentMob.height, bullet.getX(), bullet.getY()) && bullet.getSource() != currentMob.getUnit()){
					// Removes bullets and runs the hit method on whatever mob was hit
					i.remove();
					currentMob.hit();
					break;
				}
			}
			
			// if the bullet hits a player remove it and run player hit function
			if(Utils.collide(player.getX(), player.getY(), player.getWidth(), player.getHeight(), bullet.getX(), bullet.getY()) && bullet.getSource() != player.getUnit()){
				i.remove();
				player.hit();
				break;
			}


			
		}

	}

	

}
