package graphics.RenderHell;

import graphics.RenderHell.utils.Vector;

public class Constants {

	// Constants for display
	public static class Display{

		// Screen width
		public static final int screenWidth = 500;
		
		// Screen height
		public static final int screenHeight = 500;




	}

	// Constants for player
	public static class Player{

		// Max player speeds
		public static final double maxSpeed = .05;
		public static final double minSpeed = -.05;
		
		// Inital player pose
		public static final int initialXPose = Display.screenWidth / 2;
		public static final int initialYPose = Display.screenHeight / 2;

		// Player width and height
		public static final int playerWidth = 10;
		public static final int playerHeight = 10;

		// inital vector
		public static final Vector initialVector = new Vector(0, 0);

		// Player speed to set
		public static final int speed = 1;
		


	}


	// bullet config
	public static class Bullets{

		
		// bullet width and height
		public static final int bulletWidth = 4;
		public static final int bulletHeight = 4;


	}

	// unit types
	public enum Units{
		PLAYER,
		GOBLIN
	}












}