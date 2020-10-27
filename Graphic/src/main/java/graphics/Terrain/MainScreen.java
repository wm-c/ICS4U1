package graphics.Terrain;

import javax.swing.JFrame;

public class MainScreen {
	
	Terrain terrain;

	public MainScreen(){
		JFrame window = new JFrame();
		terrain = new Terrain();

		window.setTitle("My Window");

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.add(terrain);
		window.pack();
		window.setVisible(true);
	
	}

}
