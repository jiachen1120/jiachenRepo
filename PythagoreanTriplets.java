package jiachen.algorithm;

import java.util.ArrayList;

public class PythagoreanTriplets {
	public static ArrayList<int[]> pythagorean(int[] arr) {
		if (arr.length < 3) {
			return null;
		}
		MergeSort.sort(arr);
		ArrayList<int[]> list = new ArrayList<>();
		for (int i = 0; i < arr.length; i++) {
			if (arr[i] == 0) {
				continue;
			}
			int c2 = arr[i] * arr[i];
			int j = 0;
			int k = arr.length - 1;
			while (j < k) {
				if (i == j || arr[j] == 0) {
					j++;
					continue;
				}
				if (k == i || arr[k] == 0) {
					k--;
					continue;
				}
				int a2 = arr[j] * arr[j];
				int b2 = arr[k] * arr[k];

				if (a2 + b2 == c2) {
					list.add(new int[] { arr[i], arr[j], arr[k] });
					break;
				} else if (a2 + b2 - c2 > 0) {
					k--;
				} else {
					j++;
				}
			}
		}
		return list;
	}
}
