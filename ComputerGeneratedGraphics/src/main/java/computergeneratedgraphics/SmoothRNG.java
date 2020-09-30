package computergeneratedgraphics;

import java.util.Random;

public class SmoothRNG{
	
	private int groundLevel;
	public int maxGroundChange;
	private int currentLevel;
	private int previousGroundChange;

	public SmoothRNG(int groundLevel, int maxGroundChange){
		// I dont yet know how i want to initialize
		this.groundLevel = groundLevel;
		this.currentLevel = groundLevel;
		this.maxGroundChange = maxGroundChange;
	}

	public int nextValue(){
		currentLevel = 3;

		return 0;
	}

	public int clamp(){ return 0;}



	public int getGroundLevel(){
		return groundLevel;
	}



	
	
	
}
