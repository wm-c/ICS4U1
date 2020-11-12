package graphics.RenderHell;

import javax.swing.Timer;

import graphics.RenderHell.bullet.BulletMaster;
import graphics.RenderHell.collision.CollisionController;
import graphics.RenderHell.input.Movement;
import graphics.RenderHell.objects.MobMaster;
import graphics.RenderHell.objects.Player;
import graphics.RenderHell.objects.terrain.TerrainMaster;



import javax.swing.*;
import java.awt.event.*;

public class RenderHell {
	
	// Creates different timer for logic and drawing.
	Timer draw = new Timer(5, new DrawClass());
	Timer logic = new Timer(1, new LogicClass());

	// tell if the game should still run
	public static boolean alive = true;

	
	

	public static void main(String[] args) {
		// This is for linux 
		System.setProperty("sun.java2d.opengl", "true");
		new RenderHell();
	}

	public RenderHell(){

		// General start up stuff
		JFrame window = new JFrame();
		window.setTitle("Render Hell");
	

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		// Adds tehe game canvas to the window
		window.add(GameCanvas.getInstance());
		window.pack();
		window.setVisible(true);

		
		
		// Starts both timers
		draw.start();
		logic.start();


	}

	// creates the action listener that repaints the screen
	public class DrawClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Calls the repaint from the canvas
			GameCanvas.getInstance().repaint();
		}
	}

	// Logic action listener
	public class LogicClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// Update if the player is allive
			if(alive){
				
				// update the terain with the new player vector
				TerrainMaster.getInstance().update(Player.getPlayer().getMovementVector());

				// Update bullet master with player vector
				BulletMaster.getInstance().update(Player.getPlayer().getMovementVector());

				// Updates mobs
				MobMaster.getInstance().update();

				// Check collison
				CollisionController.getInstance().checkCollison();
			}
			
		}
	}


	









}
