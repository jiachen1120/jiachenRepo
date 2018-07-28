package jiachen.algorithm;

import java.util.ArrayList;

public class Permutation {
	public static int factorial(int n) {
		if (n == 0 || n == 1) {
			return 1;
		}
		return n * factorial(n - 1);
	}
	public static void permutation(ArrayList<Integer> v, int k, ArrayList<Integer> result) {
		if (v.isEmpty()) {
			return;
		}
		int n = v.size();
		int count = factorial(n - 1);
		int total = n * count;
		if (k > total) {
			return;
		}
		int selected = (k - 1) / count;
		result.add(v.get(selected));
		k = k - count * selected;
		v.remove(selected);
		permutation(v, k, result);
	}
	public static void permutation(ArrayList<Integer> v, int k) {
		ArrayList<Integer> result = new ArrayList<> ();
		permutation(v, k, result);
		System.out.println(result);
	}
}
