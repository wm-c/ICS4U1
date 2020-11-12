package graphics.RenderHell.input;

import java.awt.event.*;

import graphics.RenderHell.GameCanvas;
import graphics.RenderHell.Constants.Units;
import graphics.RenderHell.bullet.Bullet;
import graphics.RenderHell.bullet.BulletMaster;
import graphics.RenderHell.bullet.StandardRound;
import graphics.RenderHell.objects.Player;
import graphics.RenderHell.utils.Rotation;
import graphics.RenderHell.utils.Vector;
import java.awt.MouseInfo;

public class PlayerShooting extends MouseAdapter {

	// Variable for if a bullet should be added
	private static boolean shouldAddBullet = false;

	@Override
	public void mousePressed(MouseEvent e) {
		// Allows bullets to be fired
		shouldAddBullet = true;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// stops allowing shooting
		shouldAddBullet = false;
	}

	public static void addBullet() {
		// adds a bullet if a bullet can be added
		if (!shouldAddBullet) {
			return;
		}

		Rotation angle;

		// if the mouse leaves the screen npe occurs
		try {
			// Calculates the rotation that the bullet needs travel
			angle = new Rotation(
					Math.atan2(GameCanvas.getInstance().getMousePosition().getY() - Player.getPlayer().getY(),
							GameCanvas.getInstance().getMousePosition().getX() - Player.getPlayer().getX()));
		} catch (NullPointerException e) {
			return;
		}

		// Creates a new bullet with the angle and a magnitude of 2
		Bullet bullet = new StandardRound(new Vector(angle, 2), Player.getPlayer().getX(), Player.getPlayer().getY(), Units.PLAYER);

		// Adds bullet to bullet master
		BulletMaster.bulletTracker.put(bullet.bulletId, bullet);

	}

}
