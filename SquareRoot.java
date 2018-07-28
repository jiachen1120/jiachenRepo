package jiachen.algorithm;

public class SquareRoot {
	private static final double EPSILON = 0.000001;
	public static double squareRoot(double input) {
		double low = 0;
		double high = 1 + (input/2);
		while (low < high) {
			double mid = low + (high - low) / 2;
			double sqr = mid * mid;
			double diff = Math.abs(input - sqr);
			if (diff <= EPSILON) {
				return mid;
			} else if (sqr < input) {
				low = mid;
			} else {
				high = mid;
			}
		}
		return -1;
	}
}
