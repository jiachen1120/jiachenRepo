package jiachen.algorithm;

import java.util.HashSet;
import java.util.Set;

public class TwoSum {
	public static boolean twoSum(int[] arr, int sum) {
		if(arr == null || arr.length < 2) {
			return false;
		}
		Set<Integer> set = new HashSet<> ();
		for (int i = 0; i < arr.length; i++) {
			if (set.contains(sum - arr[i])) {
				return true;
			} else {
				set.add(arr[i]);
			}
		}
		return false;
	}
	public static boolean twoSum2(int[] arr, int sum) {
		int i = 0;
		int j = arr.length - 1;
		while (i < j) {
			int val = arr[i] + arr[j];
			if (val == sum) {
				return true;
			}
			if (val < sum) {
				i++;
			} else  {
				j--;
			}
		}
		return false;
	}
}
