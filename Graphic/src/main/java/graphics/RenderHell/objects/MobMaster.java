package graphics.RenderHell.objects;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import graphics.RenderHell.bullet.Bullet;
import graphics.RenderHell.bullet.BulletMaster;
import graphics.RenderHell.interfaces.Drawable;
import graphics.RenderHell.interfaces.Logicable;
import graphics.RenderHell.objects.terrain.TerrainMaster;
import graphics.RenderHell.objects.terrain.Wall;
import graphics.RenderHell.utils.Utils;

public class MobMaster implements Drawable {
	private static MobMaster mInstance = null;

	private HashMap<Integer, BaseMob> mobTracker;

	private Random rand;

	private MobMaster() {
		mobTracker = new HashMap<>();
		addMob(new Goblin(50, 500, 20, 20, 100));
		rand = new Random();
	}

	public static MobMaster getInstance() {
		if (mInstance == null) {
			mInstance = new MobMaster();
		}

		return mInstance;
	}

	public void addMob(BaseMob newMob) {

		mobTracker.put(newMob.getMobId(), newMob);

	}

	@Override
	public void draw(Graphics2D g2d) {
		for (BaseMob mob : mobTracker.values()) {
			mob.draw(g2d);
		}

	}

	public void update() {
		
		for (Iterator<BaseMob> i = mobTracker.values().iterator(); i.hasNext();) {
			BaseMob mob = i.next();
			if (mob.isDead()) {
				mob.die();
				i.remove();
				continue;
				}
			mob.update(Player.getPlayer().getMovementVector());
			
		}

		addMob();

	}

	public void removeMob(int id){
		mobTracker.remove(id);
	}

	public HashMap<Integer, BaseMob> getMobs(){
		return mobTracker;
	}


	private void addMob(){
		if(!(rand.nextInt(5000) < 5)){
			return;
		}
		ArrayList<Wall> terrain = TerrainMaster.getInstance().getTerrain();

		int x1 = terrain.get(0).getX() + 50;
		int y1 = terrain.get(0).getY() + 50;
		
		
		
		// add less so it doesnt spawn in a wall
		int x2 = x1 + 1400;
		int y2 = y1 + 500;


		x2 -= rand.nextInt(1410);
		y2 -= rand.nextInt(500);

		Goblin newGoblin = new Goblin(x2, y2, 25, 25, 20 + rand.nextInt(300));

		mobTracker.put(newGoblin.getMobId(), newGoblin);


	}

	
	
}
