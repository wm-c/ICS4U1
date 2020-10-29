package graphics.RenderHell.utils;

public class Vector {
	
	private Rotation direction;
	private double magnitude;


	public Vector(double xComponent, double yComponent){
		this(new Rotation(Math.atan2(yComponent, xComponent)), Math.hypot(xComponent, yComponent));
	}


	public Vector(Rotation direction, double magnitude){
		this.direction = direction;
		this.magnitude = magnitude;
	}

	


	public Rotation getDirection(){
		return direction;
	}

	public double getMagnitude(){
		return magnitude;
	}


	public double getXComponent(){
		return magnitude * Math.cos(direction.getRadians());
	}

	public double getYComponent(){
		return magnitude * Math.sin(direction.getRadians());
	}


	public void setXComponent(double xComponent){
		direction = new Rotation(Math.atan2(getYComponent(), xComponent));
		magnitude = Math.hypot(xComponent, getYComponent());
	}

	public void setYComponent(double yComponent){
		direction = new Rotation(Math.atan2(yComponent, getXComponent()));
		magnitude = Math.hypot(getXComponent(), yComponent);
	}


	public void setMagnitude(double magnitude){
		this.magnitude = magnitude;
	}


	public Vector add(Vector newVector){
		return new Vector(getXComponent() + newVector.getXComponent(), getYComponent() + newVector.getYComponent());
	}


	@Override
	public String toString() {
		return String.format("Magnitude: %f, Direction: %f", magnitude, direction.getRadians());
	}

}
