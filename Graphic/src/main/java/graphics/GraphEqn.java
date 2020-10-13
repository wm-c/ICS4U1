package graphics;

import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GraphEqn {
	public static void main(String[] args) {
		new GraphEqn();
	}
	//global variables
	int panW = 800, panH = 600;
	double xmin = -5.0;
	double xmax = +5.0;
	double ymin = -5.0;
	double ymax = +5.0;
	JFrame window = new JFrame();	

	public static int maxIter = 300;
	DrawingPanel drPanel = new DrawingPanel();	
	GraphEqn(){			
		//drPanel = new DrawingPanel();	
		window.add(drPanel);	
		window.setTitle("Graphing Equations");
		window.pack();
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setLocationRelativeTo(null);
		window.setVisible(true);
	}
	/********** inner drawing panel class ***********/
	private class DrawingPanel extends JPanel{		
		DrawingPanel(){
			this.setBackground(Color.WHITE);
			this.setPreferredSize(new Dimension(panW, panH));
		}		
		@Override
		public void paintComponent(Graphics g) {
			super.paintComponent(g);

			//*** handle resizing window ***
			panW = this.getSize().width;		
			panH = this.getSize().height;	
			
			

			//each pixel covers this much on the graph
			double xstep = (xmax-xmin)/panW; 
			double ystep = (ymax-ymin)/panH; 
			//double ystep = (ymax-ymin)/panH;
			for(double x = xmin; x < xmax; x += xstep) {
				for(double y = ymin; y < ymax; y += ystep){
					Color c;
					int n = recurse(x,y);
					if(n == 0){
						c = Color.black;
					}else{
						c = Color.getHSBColor(n/255.0f, 1.0f, 1.0f);
					}

					g.setColor(c);
					plotPt(x, y, g);
				}
			}	

			
		}

		//This will plot a point in the correct pixel location
		// based on the window size and the graph variables
		void plotPt(double x, double y, Graphics g) {
			int px = (int) ((x - xmin)* panW/(xmax - xmin)); 
			int py = (int) ((y - ymin)* panH/(ymax - ymin));
			py = panH-py;
			g.drawLine(px, py, px, py);
		}			


		int recurse(double cReal, double cImag){
			double zReal, zImag, temp;
			zReal = zImag = 0.0;
			int i = 0;
			while(i++ <= maxIter){
				temp = zReal * zReal - zImag * zImag + cReal;
				zImag = 2 * zReal * zImag + cImag;
				zReal = temp;
				
				if(Math.hypot(zReal, zImag) > 4){
					break;
				}
			}
			return (i>maxIter) ? 0 : i;
		}
	}
}