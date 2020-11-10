package graphics.RenderHell.collision;

import java.util.ArrayList;
import java.util.Iterator;

import graphics.RenderHell.RenderHell;
import graphics.RenderHell.bullet.Bullet;
import graphics.RenderHell.bullet.BulletMaster;
import graphics.RenderHell.interfaces.Collidable;
import graphics.RenderHell.objects.BaseMob;
import graphics.RenderHell.objects.MobMaster;
import graphics.RenderHell.objects.Player;
import graphics.RenderHell.objects.terrain.Wall;
import graphics.RenderHell.utils.Utils;
import graphics.RenderHell.utils.Vector;

public class CollisionController {
	private static CollisionController mInstance = null;

	private ArrayList<Collidable> hittable;

	public static CollisionController getInstance() {
		if (mInstance == null) {
			mInstance = new CollisionController();
		}

		return mInstance;
	}

	private CollisionController() {
		hittable = new ArrayList<>();
	}

	public void checkCollison() {
		Player player = Player.getPlayer();

		// Does special check for player
		for (Collidable collidable : hittable) {
			if (Utils.rectCollide(player.getX() + (int) player.getMovementVector().getXComponent(),
					player.getY() + (int) player.getMovementVector().getYComponent(), player.getWidth(), player.getHeight(),
					collidable.getX(), collidable.getY(), collidable.getWidth(), collidable.getHeight())) {
				player.setMovementVector(new Vector(0, 0));
			}
		}

		// Checks if a bullet hits a wall
		for (Iterator<Bullet> i = BulletMaster.bulletTracker.values().iterator(); i.hasNext();) {
			Bullet bullet = i.next();
				
			for (Collidable collidable : hittable) {
				

				if (Utils.collide(collidable.getX(), collidable.getY(), collidable.getWidth(), collidable.getHeight(), bullet.getX(), bullet.getY())) {
					i.remove();
					collidable.hit();
					break;
				}

			}
			
		}
	}

	public ArrayList<Collidable> getHittable(){
		return hittable;
	}


	public void addHittable(Collidable newColliable){
		hittable.add(newColliable);
	}
}
