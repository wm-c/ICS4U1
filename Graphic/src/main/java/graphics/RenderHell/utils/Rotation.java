package graphics.RenderHell.utils;

public class Rotation {
	
	private double angle;

	/**
	 * Creates a rotation of 0 rads
	 */
	public Rotation(){
		this(0);
	}


	/**
	 * Creates a rotation with the angle in radians
	 * @param angle angle in radians
	 */
	public Rotation(double angle){
		this.angle = angle;
	}



	/**
	 * gets the angle in degrees
	 * @return returns the angle in degrees
	 */
	public Double getDegrees(){
		return Math.toDegrees(angle);
	}


	/**
	 * Gets radian value of angle
	 * @return returns radian value of angle
	 */
	public Double getRadians(){
		return angle;
	}


	/**
	 * 
	 * @param angle angle in degrees
	 * @return a new rotation
	 */
	public static Rotation degRotation(double angle){
		return new Rotation(Math.toRadians(angle));
	}


}
