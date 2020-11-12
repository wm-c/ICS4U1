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

	// Counts time since last shot
	private int shotCounter;

	// movement vector
	private Vector movementVector;

	// player instance
	private Player player = Player.getPlayer();

	// variable for if its colliding
	public static boolean colliding = false;

	// creates a new goblin at the specified x,y with a specified height and width, health
	public Goblin(int x, int y, int width, int height, int health) {
		super(x, y, width, height, health);
		shotCounter = 0;
		movementVector = new Vector(0, 0);
	}

	@Override
	public void draw(Graphics2D g2d) {
		super.draw(g2d);
		// Sets color
		g2d.setColor(Color.green);

		// Draws goblin
		g2d.drawRect((int) x, (int) y, 15, 15);

		// resets color
		g2d.setColor(Color.black);

	}

	@Override
	public void update(Vector playerVector) {

		// Calculates new path
		calculatePath();

		// Check if we collide
		for (Collidable collidable : CollisionController.getInstance().getHittable()) {

			// if we hit set vector to 0,0
			if (Utils.rectCollide((int) (x + movementVector.getXComponent()),
					(int) (y + movementVector.getYComponent()), width, height, collidable.getX(), collidable.getY(),
					collidable.getWidth(), collidable.getHeight())) {
				movementVector = new Vector(0, 0);
				colliding = true;
			}
		}
		// adds inverse player vector to current movement vector
		movementVector = movementVector
				.add(new Vector(playerVector.getXComponent() * -1, playerVector.getYComponent() * -1));

		// Adds x y componets to x and y
		x += movementVector.getXComponent();
		y += movementVector.getYComponent();
		// attacks
		attack();
	}

	@Override
	public void die() {
		// When the mob dies increase score by 1
		player.score++;

	}

	@Override
	protected void attack() {
		// if we've waited 1000 ticks shoot
		if (shotCounter == 1000) {
			// Angle to player center
			Rotation angle = new Rotation(Math.atan2(player.getY() - (y - Constants.Player.playerWidth / 2),
					player.getX() - (x - Constants.Player.playerHeight / 2)));

			// Creates new bullet at mob spot
			StandardRound newBullet = new StandardRound(new Vector(angle, .5), (int) x, (int) y,
					Constants.Units.GOBLIN);

			// adds new bullet
			BulletMaster.bulletTracker.put(newBullet.bulletId, newBullet);
			// resets shot counter
			shotCounter = 0;
			return;
		}

		// increases shot counter
		shotCounter++;

	}

	// Calculates point to go to
	@Override
	protected void calculatePath() {
		// gets a center mid point between player and goblin
		Pose moveToPoint = Pose.midpoint(player.getX(), player.getY(), (int) x, (int) y);

		// Clear vector
		movementVector = new Vector(0, 0);

		// returns if we are in range
		if (moveToPoint.distance(new Pose(player.getX(), player.getY())) < 30) {

			return;
		}

		// changes vectors based on position relative to midpoint
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

	// returns true if health is less than 0
	@Override
	public boolean isDead() {
		if (health <= 0) {
			return true;
		}
		return false;
	}

	// if hit subtract health by 1
	@Override
	public void hit() {
		health -= 1;

	}

	// gets the current unit
	@Override
	public Units getUnit() {
		return Units.GOBLIN;
	}

}
