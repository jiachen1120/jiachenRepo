package jiachen.algorithm;

public class fibonacci {
	public static int get(int num) {
		int n1 = 0;
		int n2 = 1;
		int res = 0;
		
		for (int i = 2; i <= num; i++) {
			res = n1 + n2;
			n1 = n2;
			n2 = res;
		}
		return res;
	}
}
