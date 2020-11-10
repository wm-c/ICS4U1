package graphics.RenderHell.bullet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

import graphics.RenderHell.Constants;
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
	private static BulletMaster mInstance = null;

	public static HashMap<Integer, Bullet> bulletTracker;
	

	private BulletMaster() {
		bulletTracker = new HashMap<>();
	}

	public static BulletMaster getInstance() {
		if (mInstance == null) {
			mInstance = new BulletMaster();
		}

		return mInstance;
	}

	@Override
	public void draw(Graphics2D g2d) {

		for (Bullet bullet : bulletTracker.values()) {
			bullet.draw(g2d);
		}

	}

	@Override
	public void update(Vector playerVector) {

		PlayerShooting.addBullet();
		for (Iterator<Bullet> i = bulletTracker.values().iterator(); i.hasNext();) {
			Bullet bullet = i.next();
			bullet.update(playerVector);
			for(Iterator<BaseMob> j = MobMaster.getInstance().getMobs().values().iterator(); j.hasNext();){
				BaseMob currentMob = j.next();
				if(Utils.collide((int)currentMob.x, (int)currentMob.y, currentMob.width, currentMob.height, bullet.getX(), bullet.getY()) && bullet.getSource() != currentMob.getUnit()){
					i.remove();
					currentMob.hit();
					break;
				}
			}
			



			Player player = Player.getPlayer();


			

			if(Utils.collide(player.getX(), player.getY(), player.getWidth(), player.getHeight(), bullet.getX(), bullet.getY()) && bullet.getSource() != player.getUnit()){
				i.remove();
				player.hit();
				break;
			}


			
		}

	}

	

}
