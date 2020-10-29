package graphics.RenderHell;

import javax.swing.Timer;

import graphics.RenderHell.bullet.BulletMaster;
import graphics.RenderHell.objects.Player;
import graphics.RenderHell.utils.Vector;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RenderHell {
	

	Timer draw = new Timer(1, new DrawClass());
	Timer logic = new Timer(1, new LogicClass());


	GameCanvas canvas = new GameCanvas();
	

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
			BulletMaster.getInstance().draw();


			canvas.repaint();
		}
	}

	public class LogicClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			Player.getPlayer().update();
			BulletMaster.getInstance().update();

		}
	}









}
