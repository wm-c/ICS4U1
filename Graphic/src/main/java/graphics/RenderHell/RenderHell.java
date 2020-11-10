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
	

	Timer draw = new Timer(5, new DrawClass());
	Timer logic = new Timer(1, new LogicClass());
	static Movement movement = new Movement();

	GameCanvas canvas = GameCanvas.getInstance();
	

	public static void main(String[] args) {
		// This is for linux 
		System.setProperty("sun.java2d.opengl", "true");
		new RenderHell();
	}

	public RenderHell(){
		JFrame window = new JFrame();
		window.setTitle("Render Hell");
	

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.add(canvas);
		window.pack();
		window.setVisible(true);

		
		
		
		draw.start();
		logic.start();


	}

	public class DrawClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			canvas.repaint();
		}
	}

	public class LogicClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Player.getPlayer().update(null);
			TerrainMaster.getInstance().update(Player.getPlayer().getMovementVector());
			BulletMaster.getInstance().update(Player.getPlayer().getMovementVector());
			MobMaster.getInstance().update();
			CollisionController.getInstance().checkCollison();
			
			
		}
	}









}
