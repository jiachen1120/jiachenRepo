package jiachen.algorithm;

public class Power {
	public static double power_rec(double x, int n) {
		if (n == 0) {
			return 1;
		}
		if (n == 1) {
			return x;
		}
		double temp = power_rec(x, n/2);
		if (n % 2 == 0) {
			return temp * temp;
		} else {
			return x * temp * temp;
		}
	}
	public static double power(double x, int n) {
		boolean isNegative = false;
		if (n < 0) {
			isNegative = true;
			n *= -1;
		}
		double temp = power_rec(x, n);
		if (isNegative) {
			return 1/temp;
		}
		return temp;
	}
}
