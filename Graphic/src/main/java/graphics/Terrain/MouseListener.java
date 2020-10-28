package graphics.Terrain;

import java.awt.Color;
import java.awt.event.*;
import java.util.ArrayList;

public class MouseListener extends MouseAdapter {

	// Variable to store the position which box the cursor is
	public static int horizontalBox = 0;
	public static int verticalBox = 0;

	// Creates a terrain and a list of poses
	private Terrain terrain;
	private ArrayList<int[]> positions = new ArrayList<>();
	private Color waterColor = Terrain.lake;

	@Override
	public void mousePressed(MouseEvent e) {
		super.mousePressed(e);

		// Defines the terrain
		terrain = MainScreen.terrain;

		// Gets the current box the cursor is in
		getBox(e.getX(), e.getY());

		// if the box already contains stuff stuff
		if (terrain.map[verticalBox][horizontalBox] != null) {
			return;
		}

		// Generate Lakes
		generateLake(verticalBox, horizontalBox);

		// Redraw the screen
		terrain.repaint();

	}

	private void getBox(int x, int y) {

		// Finds the box the mouse is in by dividing the position by the size of the box
		horizontalBox = x / Terrain.boxWidth;
		verticalBox = y / Terrain.boxHeight;

	}

	// Generates lake
	private void generateLake(int y, int x) {

		// Recursavly checks tiles for valid water spots
		checkTile(y, x);

		// Fills in all spots if its an ocean
		if (waterColor == Terrain.ocean) {
			for (int[] pose : positions) {
				terrain.map[pose[0]][pose[1]] = waterColor;
			}

			waterColor = Terrain.lake;
		}

		// Resets list
		positions = new ArrayList<>();

	}

	private void checkTile(int y, int x) {
		
		if(terrain.map[y][x] == null){
				positions.add(new int[] {y , x});
				terrain.map[y][x] = Terrain.lake;

				// Checks is to close to wall
				if(y > 0){
					checkTile(y - 1, x);
				}else{
					waterColor = Terrain.ocean;
				}

				// Check if to close to wall
				if(y < Terrain.gridDimesions - 1){
					checkTile(y + 1, x);		
				}else{
					waterColor = Terrain.ocean;
				}
				
				// Checks if to close to wall
				if(x < Terrain.gridDimesions - 1){
					checkTile(y, x + 1);
				}else{
					waterColor = Terrain.ocean;
				}

				// Checks if next to wall
				if(x > 0){
					checkTile(y, x - 1);
				}else{
					waterColor = Terrain.ocean;
				}	
		}
	}

}
