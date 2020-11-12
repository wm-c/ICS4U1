package graphics.RenderHell.utils;

// Used to do math with poses
public class Pose {
	

	public double poseX;
	public double poseY;

	// Creates x and y poses
	public Pose(double poseX, double poseY){
		this.poseX = poseX;
		this.poseY = poseY;
	}


	// gets distance between the 2 poses
	public double distance(Pose additonalPose){
		return Math.hypot(poseX - additonalPose.poseX, poseY - additonalPose.poseY);
	}

	// Finds the midpoint between 2 poses
	public Pose midPoint(Pose additonalPose){

		return new Pose((poseX + additonalPose.poseX)/2, (poseY + additonalPose.poseY)/2);

	}

	// Static method for the midpoint of 2 points
	public static Pose midpoint(int x1, int y1, int x2, int y2){
		return new Pose((x1 + x2)/2, (y1 + y2)/2);
	}

	// tostring method for debugging
	@Override
	public String toString() {
		
		return String.format("X: %.2f Y: %.2f", poseX, poseY);
	}



}
