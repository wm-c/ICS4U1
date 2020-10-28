package graphics.Terrain;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.Graphics2D;
import java.util.Random;


public class Terrain extends JPanel{

	// Creates different variables to quantify sizes of the board
	public static final int gridDimesions = 20;
	private static final int gridSize = gridDimesions * gridDimesions;
	public static final int screenHeight = 500;
	public static final int screenWidth = 1000;
	public static final int boxHeight = screenHeight / gridDimesions;
	public static final int boxWidth = screenWidth / gridDimesions;

	// Defines the color to use
	public static final Color ground = Color.GREEN;
	public static final Color lake = new Color(3, 207, 252);
	public static final Color ocean = new Color(0, 0, 255);

	// Creates the map
	public Color[][] map;

	// Tracks the number of tile used as terrain
	private int terrainTiles = 0;

	// Creates Terrain object and generates land
	public Terrain(){
		this.setPreferredSize(new Dimension(screenWidth, screenHeight));
		this.setBackground(Color.white);
		addMouseListener(new MouseListener());

		// Creates map of required size and generates terrain
		map = new Color[gridDimesions][gridDimesions];
		generateTerrain();
	}


	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;

		// Draw the lines
		for(int i = 0; i < gridDimesions; i++){

			// Draw Vertical Lines
			g2d.drawLine(boxWidth * i, 0, boxWidth * i, screenHeight);

			// Draw Horizonal Lines
			g2d.drawLine(0, boxHeight * i, screenWidth, boxHeight * i);
		}

		// Draw tile color
		for(int i = 0; i < gridDimesions; i++){
			for(int j = 0; j < gridDimesions; j++){
				Color tileColor = map[i][j];

				if(tileColor == null){
					continue;
				}
				
				// Sets the required color and draws
				g2d.setColor(tileColor);
				g2d.fillRect(j * boxWidth, i * boxHeight, boxWidth, boxHeight);
				g2d.setColor(Color.black);
			}
		}

		

		

	}


	// Generates the terrain
	private void generateTerrain(){
				
		// While we dont ha
		while(terrainTiles < gridSize / 2){

			// Generates a random position for new piece of terrain
			int randX = new Random().nextInt(20);
			int randY = new Random().nextInt(20);
			
		
			addTiles(randX, randY, 1);




		}



	}

	private void addTiles(int y, int x, int odds){
		try {
		
			// If terrain is empty and we get the right chance generate terrain
			if(map[y][x] == null && 2 > new Random().nextInt(odds)){
				map[y][x] = ground;

				// Increase terrain count
				terrainTiles++;

				// Add a new piece of land for each tile around it
				addTiles(y + 1, x, odds+= 3);
				addTiles(y - 1, x, odds+= 3);
				addTiles(y, x + 1, odds+= 3);
				addTiles(y, x - 1, odds+= 3);
				addTiles(y + 1, x + 1, odds+= 3);
				addTiles(y - 1, x - 1, odds+= 3);
				addTiles(y - 1, x + 1, odds+= 3);
				addTiles(y + 1, x - 1, odds+= 3);
				
			}
		} catch (ArrayIndexOutOfBoundsException e) {
			return;
		}
		

		return;


	}

}
