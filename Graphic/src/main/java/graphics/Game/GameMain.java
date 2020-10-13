package graphics.Game;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class GameMain{

	Timer timer = new Timer(1, new ActionClass());
	
	Canvas canvas = new Canvas();
	public static void main(String[] args) {
		new GameMain();
	}

	public GameMain(){
		JFrame window = new JFrame();
		window.setTitle("My Window");

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		window.add(canvas);
		window.pack();
		window.setVisible(true);
		timer.start();


	}

	public class ActionClass implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent arg0) {
			canvas.repaint();
			canvas.rectX++;

		}
	}

}
