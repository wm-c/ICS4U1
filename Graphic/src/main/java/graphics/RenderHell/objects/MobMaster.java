package graphics.RenderHell.objects;

import java.awt.Graphics2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

import graphics.RenderHell.interfaces.Drawable;
import graphics.RenderHell.interfaces.Logicable;
import graphics.RenderHell.objects.terrain.TerrainMaster;
import graphics.RenderHell.objects.terrain.Wall;

public class MobMaster implements Drawable {
	// creates mobmaster instance
	private static MobMaster mInstance = null;

	// Stors mobs
	private HashMap<Integer, BaseMob> mobTracker;

	// Random number generator
	private Random rand;

	// initializes variables
	private MobMaster() {
		mobTracker = new HashMap<>();
		rand = new Random();
	}

	// returns instance of mobmaster
	public static MobMaster getInstance() {
		if (mInstance == null) {
			mInstance = new MobMaster();
		}

		return mInstance;
	}

	// adds a new mob to mobtracker
	public void addMob(BaseMob newMob) {

		mobTracker.put(newMob.getMobId(), newMob);

	}

	@Override
	public void draw(Graphics2D g2d) {
		//draws all mobs
		for (BaseMob mob : mobTracker.values()) {
			mob.draw(g2d);
		}

	}

	// Checks if mobs have died and removes them also update poses on screen
	public void update() {
		
		for (Iterator<BaseMob> i = mobTracker.values().iterator(); i.hasNext();) {
			BaseMob mob = i.next();
			if (mob.isDead()) {
				mob.die();
				i.remove();
				continue;
				}
			// updates mob pose based on player position
			mob.update(Player.getPlayer().getMovementVector());
			
		}

		// adds new mob
		addMob();

	}

	// removes a mob from mobtracker
	public void removeMob(int id){
		mobTracker.remove(id);
	}

	// returns the mob list
	public HashMap<Integer, BaseMob> getMobs(){
		return mobTracker;
	}


	// adds a new mob
	private void addMob(){
		// randomly decides if mobs should spawn
		if(!(rand.nextInt(5000) < 5)){
			return;
		}

		// gets the terrain
		ArrayList<Wall> terrain = TerrainMaster.getInstance().getTerrain();

		// X, Y positions of top of the box
		int x1 = terrain.get(0).getX() + 50;
		int y1 = terrain.get(0).getY() + 50;
		
		
		
		// add less so it doesnt spawn in a wall
		int x2 = x1 + 1410;
		int y2 = y1 + 500;

		// subtracts a random number to get the spot it should spawn
		x2 -= rand.nextInt(1410);
		y2 -= rand.nextInt(500);

		// generates a mob with random health
		Goblin newGoblin = new Goblin(x2, y2, 25, 25, 20 + rand.nextInt(300));

		// adds new mob
		mobTracker.put(newGoblin.getMobId(), newGoblin);


	}

	
	
}
