package graphics.RenderHell.utils;

public class Utils {
	


	public static double clamp(double number, double max, double min){
		return Math.min(max, Math.max(number, min));
	}


}
