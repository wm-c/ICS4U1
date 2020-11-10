package graphics.RenderHell;

import java.awt.Dimension;

import javax.swing.JPanel;

import graphics.RenderHell.bullet.BulletMaster;
import graphics.RenderHell.input.Movement;
import graphics.RenderHell.input.PlayerShooting;
import graphics.RenderHell.objects.MobMaster;
import graphics.RenderHell.objects.Player;
import graphics.RenderHell.objects.terrain.TerrainMaster;
import graphics.Terrain.Terrain;

import java.awt.*;

public class GameCanvas extends JPanel{
	private static GameCanvas mInstance = null;


	Player player = Player.getPlayer();	
	
	

	private GameCanvas(){
		this.setPreferredSize(new Dimension(500, 500));
		this.setBackground(Color.white);
		setFocusable(true);
		addKeyListener(RenderHell.movement);
		addMouseListener(new PlayerShooting());
	}

	public static GameCanvas getInstance(){
		if(mInstance == null){
			mInstance = new GameCanvas();
		}

		return mInstance;
	}


	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Graphics2D g2d = (Graphics2D) g;

		

		BulletMaster.getInstance().draw(g2d);
		MobMaster.getInstance().draw(g2d);
		TerrainMaster.getInstance().draw(g2d);
		player.draw(g2d);

		
		
		
	}




}
