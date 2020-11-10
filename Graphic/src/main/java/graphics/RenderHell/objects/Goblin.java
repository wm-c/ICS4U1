package graphics.RenderHell.objects;

import java.awt.Color;
import java.awt.Graphics2D;

import graphics.RenderHell.Constants;
import graphics.RenderHell.Constants.Units;
import graphics.RenderHell.bullet.BulletMaster;
import graphics.RenderHell.bullet.StandardRound;
import graphics.RenderHell.collision.CollisionController;
import graphics.RenderHell.interfaces.Collidable;
import graphics.RenderHell.utils.Pose;
import graphics.RenderHell.utils.Rotation;
import graphics.RenderHell.utils.Utils;
import graphics.RenderHell.utils.Vector;

public class Goblin extends BaseMob {

	private int shotCounter;
	private Vector movementVector;
	private Player player = Player.getPlayer();
	public static boolean colliding = false;

	public Goblin(int x, int y, int width, int height, int health) {
		super(x, y, width, height, health);
		shotCounter = 0;
		movementVector = new Vector(0, 0);
	}

	@Override
	public void draw(Graphics2D g2d) {
		super.draw(g2d);
		g2d.setColor(Color.green);

		g2d.drawRect((int) x, (int) y, 15, 15);

		g2d.setColor(Color.black);

	}

	@Override
	public void update(Vector playerVector) {

		calculatePath();

		for (Collidable collidable : CollisionController.getInstance().getHittable()) {

			if (Utils.rectCollide((int) (x + movementVector.getXComponent()),
					(int) (y + movementVector.getYComponent()), width, height, collidable.getX(), collidable.getY(),
					collidable.getWidth(), collidable.getHeight())) {
				movementVector = new Vector(0, 0);
				colliding = true;
			}
		}
		movementVector = movementVector
				.add(new Vector(playerVector.getXComponent() * -1, playerVector.getYComponent() * -1));

		x += movementVector.getXComponent();
		y += movementVector.getYComponent();
		attack();
	}

	@Override
	public void die() {
		// TODO make this do something

	}

	@Override
	protected void attack() {
		if (shotCounter == 1000) {
			Rotation angle = new Rotation(Math.atan2(player.getY() - (y - Constants.Player.playerWidth / 2),
					player.getX() - (x - Constants.Player.playerHeight / 2)));

			StandardRound newBullet = new StandardRound(new Vector(angle, .5), (int) x, (int) y,
					Constants.Units.GOBLIN);
			BulletMaster.bulletTracker.put(newBullet.bulletId, newBullet);
			shotCounter = 0;
			return;
		}

		shotCounter++;

	}

	@Override
	protected void calculatePath() {
		Pose moveToPoint = Pose.midpoint(player.getX(), player.getY(), (int) x, (int) y);

		// Clear vector
		movementVector = new Vector(0, 0);

		if (moveToPoint.distance(new Pose(player.getX(), player.getY())) < 30) {

			return;
		}

		if (moveToPoint.poseX > x) {
			movementVector.setXComponent(.25);

		} else if (moveToPoint.poseX < x) {
			movementVector.setXComponent(-.25);
		}

		if (moveToPoint.poseY > y) {
			movementVector.setYComponent(.25);

		} else if (moveToPoint.poseY < y) {
			movementVector.setYComponent(-.25);
		}

	}

	@Override
	public boolean isDead() {
		if (health <= 0) {
			return true;
		}
		return false;
	}

	@Override
	public void hit() {
		health -= 1;

	}

	@Override
	public Units getUnit() {
		return Units.GOBLIN;
	}

}
