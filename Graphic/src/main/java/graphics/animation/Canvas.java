package graphics.animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.RenderingHints;


import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics2D;

public class Canvas extends JPanel implements ActionListener {

	/**
	 * This is here to make vscode happy
	 */
	private static final long serialVersionUID = 1L;

	// A list of color to loop through
	private static Color[] dotColor = { Color.green, Color.red, Color.blue, Color.yellow };

	// Timer and sinTimer
	private Timer timer;
	public int sinTimer = 0;

	// Creates new canvas and configs it
	public Canvas(int preferredWidth, int preferredHeight) {
		setPreferredSize(new Dimension(preferredWidth, preferredHeight));
		setBackground(Color.WHITE);
		setVisible(true);
		setFocusable(true);
		
		// Starts timer
		timer = new Timer(10, this);
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);

		// Converts graphics to graphic2d, enables anti-aliasing
		Graphics2D g2d = (Graphics2D) g;
		g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		// Values for spacing

		// X position of balls
		int xPos = 200;

		// X spacing of balls
		int xSpacing = 20;

		// Y position of balls
		int yPos = 200;

		// Y spacing of balls
		int ySpacing = 20;

		// Amplitude of balls
		int amplitude = 30;

		// Draws circles
		for (int i = 0; i < 4; i++) {
			// Set color to the next one in list
			g2d.setColor(dotColor[i]);

			// Calculate postions
			int x = xPos + xSpacing * i;
			int y = (int)(Math.sin(Math.toRadians(sinTimer + ySpacing * i))  * amplitude)+ yPos;

			// Draw shadow
			g2d.setColor(Color.black);
			g2d.drawOval(x, (int)(Math.sin(Math.toRadians((sinTimer - 1) + ySpacing * i))  * amplitude)+ yPos, 20, 20);

			// Draw colored dot
			g2d.setColor(dotColor[i]);
			g2d.fillOval(x, y, 20, 20);

			// Draw black border
			g2d.setColor(Color.black);
			g2d.drawOval(x, y, 20, 20);
		}


		// Sets to orgin to center of dots
		g2d.translate(xPos + xSpacing * 3/2 - 7, (yPos + ySpacing * 3/2) - 7);
	
	
		// For each color add its section
		for(int i = 0; i < 4; i++){
			// Set dot color
			g2d.setColor(dotColor[i]);

			// Draw 1/4 of the circle
			for(int j = 0; j < 90; j++){
				// Calculates positions and draws
				int[] pos = calculatePosition(sinTimer + i * 90 + j);
				g2d.fillOval(pos[0], pos[1], 15, 15);
			}
		}

	}

	@Override
	public void actionPerformed(ActionEvent action) {
		// Increases loop count
		sinTimer++;
		// Repaint
		repaint();
	}


	private int[] calculatePosition(double value){
		// Caluclates position along circle with trig
		int x = (int) Math.round(150 * Math.cos(Math.toRadians(value)));
        int y = (int) Math.round(150 * Math.sin(Math.toRadians(value)));
		
		return new int[]{x,y};
	}

	

}
