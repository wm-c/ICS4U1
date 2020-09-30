package graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Event1b extends JFrame {

	JPanel panel;

	public static void main(String[] args) {
		new Event1b();
	}

	public Event1b() {
		this.setSize(500, 500);

		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		panel = new JPanel();

		JButton btn1 = new JButton("Go");
		JButton btn2 = new JButton("Stop");

		MyAL al = new MyAL();

		btn1.addActionListener(al);
		btn2.addActionListener(al);


		panel.add(btn1);
		panel.add(btn2);

		this.add(panel);

		this.setVisible(true);

	}

	public class MyAL implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getActionCommand().equals("Go")){
				panel.setBackground(Color.green);
			}
			if(e.getActionCommand().equals("Stop")){
				panel.setBackground(Color.red);
			}
			
			panel.repaint();

		}

	}


	
}
