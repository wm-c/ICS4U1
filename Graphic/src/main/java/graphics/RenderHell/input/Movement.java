package graphics.RenderHell.input;

import java.awt.event.*;

import graphics.RenderHell.Constants;
import graphics.RenderHell.objects.Goblin;
import graphics.RenderHell.objects.MobMaster;
import graphics.RenderHell.objects.Player;
import graphics.RenderHell.utils.Utils;
import graphics.RenderHell.utils.Vector;

public class Movement implements KeyListener {

	private Player player = Player.getPlayer();

	@Override
	public void keyPressed(KeyEvent e) {
		Vector playerMovement = player.getMovementVector();

		// Sets movement vector
		if (e.getKeyCode() == KeyEvent.VK_W) {
			player.setMovementVector(new Vector(playerMovement.getXComponent(), Constants.Player.speed * -1));

		}

		if (e.getKeyCode() == KeyEvent.VK_S) {
			player.setMovementVector(new Vector(playerMovement.getXComponent(), Constants.Player.speed));
		}

		if (e.getKeyCode() == KeyEvent.VK_A) {
			player.setMovementVector(new Vector(Constants.Player.speed * -1, playerMovement.getYComponent()));
		}

		if (e.getKeyCode() == KeyEvent.VK_D) {
			player.setMovementVector(new Vector(Constants.Player.speed, playerMovement.getYComponent()));
		}

		// if(player.getMovementVector().getMagnitude() > 1 || player.getMovementVector().getMagnitude() < -1){
		// 	System.out.println("TO FAST");
		// }

		playerMovement.setMagnitude(Utils.clamp(playerMovement.getMagnitude(), Constants.Player.maxSpeed, Constants.Player.minSpeed));



		if (e.getKeyCode() == KeyEvent.VK_P) {
			System.out.printf("Vector Direction %.2f Magnitude %.2f %n", playerMovement.getDirection().getDegrees(), playerMovement.getMagnitude());
			
		}

		
		//System.out.println(Utils.clamp(playerMovement.getMagnitude(), 1, -1));

	}

	@Override
	public void keyReleased(KeyEvent e) {
		Vector playerMovement = player.getMovementVector();

		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
			player.setMovementVector(new Vector(playerMovement.getXComponent(), 0));

		}

		if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D) {
			player.setMovementVector(new Vector(0, playerMovement.getYComponent()));
		}

		// TODO stop going over max speed on and angle
		

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
