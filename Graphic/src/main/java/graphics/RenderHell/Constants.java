package graphics.RenderHell;

import graphics.RenderHell.utils.Vector;

public class Constants {


	public static class Display{

		public static final int screenWidth = 500;
		
		public static final int screenHeight = 500;




	}


	public static class Player{

		public static final double maxSpeed = .15;
		public static final double minSpeed = -.15;
		
		public static final int initialXPose = Display.screenWidth / 2;
		public static final int initialYPose = Display.screenHeight / 2;

		public static final int playerWidth = 10;
		public static final int playerHeight = 10;

		public static final Vector initialVector = new Vector(0, 0);

		public static final int speed = 1;
		


	}


	public static class Bullets{

		public static final int maxBulletRange = 900;

		public static final int bulletWidth = 4;
		public static final int bulletHeight = 4;


	}


	public enum Units{
		PLAYER,
		GOBLIN
	}












}