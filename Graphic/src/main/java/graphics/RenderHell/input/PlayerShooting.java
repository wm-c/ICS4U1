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

	private static boolean shouldAddBullet = false;

	@Override
	public void mousePressed(MouseEvent e) {
		shouldAddBullet = true;

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		shouldAddBullet = false;
	}

	public static void addBullet() {
		if (!shouldAddBullet) {
			return;
		}

		Rotation angle;
		// if the mouse leaves the screen npe occurs
		try {
			angle = new Rotation(
					Math.atan2(GameCanvas.getInstance().getMousePosition().getY() - Player.getPlayer().getY(),
							GameCanvas.getInstance().getMousePosition().getX() - Player.getPlayer().getX()));
		} catch (NullPointerException e) {
			return;
		}

		Bullet bullet = new StandardRound(new Vector(angle, 2), Player.getPlayer().getX(), Player.getPlayer().getY(), Units.PLAYER);
		BulletMaster.bulletTracker.put(bullet.bulletId, bullet);

	}

}
