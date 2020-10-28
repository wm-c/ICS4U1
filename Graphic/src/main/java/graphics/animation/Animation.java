package graphics.animation;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * Loading Animation
 * William Meathrel
 * 16/10/2020
 */
public class Animation {

	public JFrame screen;
	public Canvas canvas;
	public final int width = 500;
	public final int height = 500;

	public static void main(String[] args) {
		// This is for linux 
		System.setProperty("sun.java2d.opengl", "true");
		new Animation();

	}

	// Makes JFrame and displays
	public Animation() {
		screen = new JFrame("Loading Icon");

		screen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		screen.setResizable(false);
		screen.setSize(new Dimension(width, height));

		canvas = new Canvas(width, height);

		screen.add(canvas);

		screen.setVisible(true);

		
	}



}
