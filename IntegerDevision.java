package jiachen.algorithm;

public class IntegerDevision {
	public static int divide(int x, int y) {
		if (y == 0) {
			return -1;
		}
		if (x < y) {
			return 0;
		} else if (x == y) {
			return 1;
		} else if (y == 1) {
			return x;
		}
		int q = 1;
		int val = y;
		while (val < x) {
			q <<= 1;
			val <<= 1;
		}
		if (val > x) {
			q >>= 1;
			val >>= 1;
			return q + divide(x - val, y);
		}
		return q;
	}
}
