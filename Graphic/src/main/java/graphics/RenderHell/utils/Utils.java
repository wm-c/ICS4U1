package graphics.RenderHell.utils;

public class Utils {
	


	public static double clamp(double number, double max, double min){
		return Math.min(max, Math.max(number, min));
	}

	public static boolean rectCollide(int x1, int y1, int width1, int height1, int x2, int y2, int width2, int height2) {
		if (x1 < x2 + width2 && x1 + width1 > x2 && y1 < y2 + height2 && y1 + height1 > y2) {
			return true;
		}

		return false;
	}

	public static boolean collide(int x1, int y1, int width, int height, int x2, int y2) {
		if (x2 >= x1 && x2 <= x1 + width && y2 >= y1 && y2 <= y1 + height) {
			return true;
		}

		return false;
	}
}
