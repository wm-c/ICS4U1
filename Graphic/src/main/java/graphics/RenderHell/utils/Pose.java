package graphics.RenderHell.utils;

public class Pose {
	

	public double poseX;
	public double poseY;

	public Pose(double poseX, double poseY){
		this.poseX = poseX;
		this.poseY = poseY;
	}



	public double distance(Pose additonalPose){
		return Math.hypot(poseX - additonalPose.poseX, poseY - additonalPose.poseY);
	}


	public Pose midPoint(Pose additonalPose){

		return new Pose((poseX + additonalPose.poseX)/2, (poseY + additonalPose.poseY)/2);

	}

	public static Pose midpoint(int x1, int y1, int x2, int y2){
		return new Pose((x1 + x2)/2, (y1 + y2)/2);
	}

	@Override
	public String toString() {
		
		return String.format("X: %.2f Y: %.2f", poseX, poseY);
	}



}
