
public class GeometryTools {
	public static final double EPSILON = .0001;

	public static boolean detectInCircle(double px, double py, double circleX, double circleY, double radius) {
		return Math.pow(px - circleX, 2) + Math.pow(py - circleY, 2) < Math.pow(radius, 2) + GeometryTools.EPSILON;
	}

	public static boolean detectInPolygon(double px, double py, double[] xCoords, double[] yCoords) {

		boolean positive = false;

		for (int i = 0; i < xCoords.length; i++) {

			double vx = xCoords[(i + 1) % xCoords.length] - xCoords[i];
			double vy = yCoords[(i + 1) % yCoords.length] - yCoords[i];

			double ux = px - xCoords[i];
			double uy = py - yCoords[i];

			double cross = vx * uy - vy * ux;

			if (i == 0) {
				positive = cross > 0;
			}

			if ((cross > 0) != positive) {
				return false;
			}
		}

		return true;
	}
}
