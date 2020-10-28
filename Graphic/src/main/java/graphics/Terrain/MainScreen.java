package graphics.Terrain;

import java.awt.Dimension;

import javax.swing.JFrame;

/**
 * William Meathrel
 * A Program for generating terrain with 2d arrays
 */
public class MainScreen {
	
	static Terrain terrain;

	public static void main(String[] args) {
		// This is for linux 
		System.setProperty("sun.java2d.opengl", "true");

		// Creates a new mainscreen
		new MainScreen();
	}


	public MainScreen(){
		// Creates jframe and new terrain jpanel
		JFrame window = new JFrame();
		terrain = new Terrain();

		// Sets name
		window.setTitle("Terrain Generation");

		// Config Window
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(false);

		// Packs terrain and displays
		window.add(terrain);
		window.pack();
		window.setVisible(true);
	
	}

}
