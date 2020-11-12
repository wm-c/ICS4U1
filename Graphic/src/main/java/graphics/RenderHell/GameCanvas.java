package graphics.RenderHell;

import java.awt.Dimension;

import javax.swing.JPanel;

import graphics.RenderHell.bullet.BulletMaster;
import graphics.RenderHell.input.Movement;
import graphics.RenderHell.input.PlayerShooting;
import graphics.RenderHell.objects.MobMaster;
import graphics.RenderHell.objects.Player;
import graphics.RenderHell.objects.terrain.TerrainMaster;
import graphics.Terrain.Terrain;

import java.awt.*;

public class GameCanvas extends JPanel{
	// Creates instance
	private static GameCanvas mInstance = null;

	// gets the player
	Player player = Player.getPlayer();	
	
	

	private GameCanvas(){
		// Sets up screen based on constant
		this.setPreferredSize(new Dimension(Constants.Display.screenHeight, Constants.Display.screenWidth));
		this.setBackground(Color.white);
		setFocusable(true);

		// Adds event listeners for keyboard input and mouse input
		addKeyListener(new Movement());
		addMouseListener(new PlayerShooting());
	}

	// Returns the game canvas instance
	public static GameCanvas getInstance(){
		if(mInstance == null){
			mInstance = new GameCanvas();
		}

		return mInstance;
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Converts to graphics2d
		Graphics2D g2d = (Graphics2D) g;

		// If the game is running draw
		if(RenderHell.alive){

			// Draw player, bullets, mobs, and terrain
			BulletMaster.getInstance().draw(g2d);
			MobMaster.getInstance().draw(g2d);
			TerrainMaster.getInstance().draw(g2d);
			player.draw(g2d);
		}else{
			// Draw end game screen and show score
			g2d.setFont(new Font("TimesRoman", Font.PLAIN, 20));
			g2d.drawString(String.format("Score: %d", player.score), getWidth() / 2 - 20, getHeight() / 2);
		}
		
		
		
	}

	



}
