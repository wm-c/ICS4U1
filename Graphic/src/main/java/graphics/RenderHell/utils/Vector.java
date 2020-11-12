package graphics.RenderHell.utils;

// Class for doing vector math
public class Vector {
	
	// Stores values
	private Rotation direction;
	private double magnitude;
	private double xComponent;
	private double yComponent;

	// Creates a vector from to components
	public Vector(double xComponent, double yComponent){
		this(new Rotation(Math.atan2(yComponent, xComponent)), Math.hypot(xComponent, yComponent));
	}

	// Creates a vector from direction and magnitude
	public Vector(Rotation direction, double magnitude){
		// Store direction and magnitude
		this.direction = direction;
		this.magnitude = magnitude;

		// calculate the x and y components
		yComponent = magnitude * Math.sin(direction.getRadians());
		xComponent = magnitude * Math.cos(direction.getRadians());
	}

	

	// Get and sets for each value
	public Rotation getDirection(){
		return direction;
	}

	public double getMagnitude(){
		return magnitude;
	}


	public double getXComponent(){
		return xComponent;
	}

	public double getYComponent(){
		return yComponent;
	}

	// updates direction and magnitude
	public void setXComponent(double xComponent){
		direction = new Rotation(Math.atan2(getYComponent(), xComponent));
		magnitude = Math.hypot(xComponent, getYComponent());
		this.xComponent = xComponent;
	}

	// updates direction and magnitude
	public void setYComponent(double yComponent){
		direction = new Rotation(Math.atan2(yComponent, getXComponent()));
		magnitude = Math.hypot(getXComponent(), yComponent);
		this.yComponent = yComponent;
	}


	public void setMagnitude(double magnitude){
		this.magnitude = magnitude;
	}

	// Adds a vector to a vector
	public Vector add(Vector newVector){
		return new Vector(getXComponent() + newVector.getXComponent(), getYComponent() + newVector.getYComponent());
	}

	// to string method used for debugging
	@Override
	public String toString() {
		return String.format("Magnitude: %f, Direction: %f", magnitude, direction.getRadians());
	}

}
