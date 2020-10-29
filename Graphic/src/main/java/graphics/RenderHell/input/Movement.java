package graphics.RenderHell.input;

import java.awt.event.*;

import graphics.RenderHell.Constants;
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

		if (e.getKeyCode() == KeyEvent.VK_P) {
			System.out.printf("X: %d, Y: %d%n", player.getX(), player.getY());
			System.out.println(playerMovement.toString());
		}

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
		// player.getMovementVector().setMagnitude(
		//  		Utils.clamp(playerMovement.getMagnitude(), 1, -1));

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub

	}

}
