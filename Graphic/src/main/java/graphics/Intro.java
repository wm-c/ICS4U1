package graphics;

import java.awt.*;  
import javax.swing.*;




public class Intro {

	int winw = 1000;
	int winh = 800;
	JFrame window;

	public Intro() {
		window = new JFrame();
		window.setTitle("My Window");
		window.setSize(winw, winh);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setLayout(new GridLayout(3, 4));

		for(int i = 0; i < 12; i++){
			panel.add(new myButton(Integer.toString(i)));
		}
		// BoxLayout experimentLayout = new Box(0,2);
		window.add(panel, BorderLayout.EAST);

		window.setVisible(true);
		
	}

	class myButton extends JButton{

		public myButton(String text){
			super(text);

			this.setBackground(Color.BLACK);
		}


		
		
	}

}
