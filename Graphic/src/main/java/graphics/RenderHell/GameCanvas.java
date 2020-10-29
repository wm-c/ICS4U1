package graphics.RenderHell;

import java.awt.Dimension;

import javax.swing.JPanel;

import graphics.RenderHell.input.Movement;
import graphics.RenderHell.objects.Player;

import java.awt.*;

public class GameCanvas extends JPanel{
	Player player = Player.getPlayer();	

	public GameCanvas(){
		this.setPreferredSize(new Dimension(500, 500));
		this.setBackground(Color.white);
		setFocusable(true);
		addKeyListener(new Movement());
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;


		g2d.drawRect(player.getX(), player.getY(), player.getWidth(), player.getHeight());
		

		
		
		
	}




}
