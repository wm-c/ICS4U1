package graphics.RenderHell.input;

import java.awt.event.*;

import graphics.RenderHell.Constants;
import graphics.RenderHell.objects.Goblin;
import graphics.RenderHell.objects.MobMaster;
import graphics.RenderHell.objects.Player;
import graphics.RenderHell.utils.Utils;
import graphics.RenderHell.utils.Vector;

public class Movement implements KeyListener {

	// Gets player instance
	private Player player = Player.getPlayer();

	@Override
	public void keyPressed(KeyEvent e) {
		// Gets the player movement vector
		Vector playerMovement = player.getMovementVector();

		// Sets movement vector based on input and previous vector
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

		// Sets a maximum speed the player can travel
		playerMovement.setMagnitude(Utils.clamp(playerMovement.getMagnitude(), Constants.Player.maxSpeed, Constants.Player.minSpeed));

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// Gets player movement vector
		Vector playerMovement = player.getMovementVector();

		// sets the speed to zero if a key is released
		if (e.getKeyCode() == KeyEvent.VK_W || e.getKeyCode() == KeyEvent.VK_S) {
			player.setMovementVector(new Vector(playerMovement.getXComponent(), 0));

		}

		if (e.getKeyCode() == KeyEvent.VK_A || e.getKeyCode() == KeyEvent.VK_D) {
			player.setMovementVector(new Vector(0, playerMovement.getYComponent()));
		}
		

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		return;
	}

}
