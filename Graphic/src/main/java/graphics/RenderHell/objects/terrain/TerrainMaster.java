package graphics.RenderHell.objects.terrain;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.ArrayList;

import graphics.RenderHell.collision.CollisionController;
import graphics.RenderHell.interfaces.Drawable;
import graphics.RenderHell.interfaces.Logicable;
import graphics.RenderHell.utils.Vector;

public class TerrainMaster implements Logicable, Drawable {
	private static TerrainMaster mInstance = null;

	private static ArrayList<Wall> terrain;

	public static TerrainMaster getInstance() {
		if (mInstance == null) {
			mInstance = new TerrainMaster();
		}

		return mInstance;
	}

	private TerrainMaster() {
		terrain = new ArrayList<>();

		addTerrain(new Wall(-50, -50, 1500 + 15, 50));
		addTerrain(new Wall(-50, 550, 1000 + 15, 50));
		addTerrain(new Wall(-50, 0, 50, 550 + 15));
		addTerrain(new Wall(950, 550, 50, 550 + 15));
		addTerrain(new Wall(950, 1100, 500 + 15, 50));
		addTerrain(new Wall(1450, -50, 50, 1200));
	}

	private void addTerrain(Wall newTerrain) {
		terrain.add(newTerrain);
		CollisionController.getInstance().addHittable(newTerrain);
	}

	@Override
	public void update(Vector playerVector) {
		for (Wall wall : terrain) {
			wall.update(playerVector);
		}

	}

	@Override
	public void draw(Graphics2D g2d) {
		
		for (Wall wall : terrain) {
			
			wall.draw(g2d);
		}

	}
	
	public ArrayList<Wall> getTerrain(){
		return terrain;
	}

}
