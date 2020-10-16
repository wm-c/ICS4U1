package graphics.Game;

import java.awt.*;
import javax.swing.*;

public class Canvas extends JPanel{
	
	int rectX;
	int rectY;

	public Canvas(){
		this.setPreferredSize(new Dimension(1000, 800));
		this.setBackground(Color.white);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawLine(0, 400, 1000, 400);

		g.drawLine(100, 0, 100, 800);

		for(int i = -5; i < 45; i++){
			g.drawLine((i * 20) + 100, 400 - i * 2 + (30 * -1), ((i + 1) * 20) + 100, 400 - (i + 1) * 2 + (30 * -1));
		}

		
		
		
	}




}
