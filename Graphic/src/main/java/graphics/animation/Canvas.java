package graphics.animation;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Graphics2D;


public class Canvas extends JPanel implements ActionListener {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private Timer timer;
	public int x = 30;

	public Canvas(int preferredWidth, int preferredHeight) {
		setPreferredSize(new Dimension(preferredWidth, preferredHeight));
		setBackground(Color.WHITE);
		setVisible(true);
		setFocusable(true);


		timer = new Timer(100, this);
		timer.start();
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D)g;

		g.setColor(Color.red);
		g.fillRect(x, 30, 30, 30);
	}

	@Override
	public void actionPerformed(ActionEvent action) {
		x++;
		repaint();
	}
}
