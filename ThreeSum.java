package jiachen.algorithm;

public class ThreeSum {
	public static boolean threeSum(int[] arr, int target) {
		if (arr == null || arr.length < 2) {
			return false;
		}
		MergeSort.mergeSort(arr);
		for (int i = 0; i < arr.length - 2; i++) {
			int e = target - arr[i];
			int left = i + 1;
			int right = arr.length - 1;
			while (left < right) {
				if (e - (arr[left] + arr[right]) == 0) {
					return true;
				}
				if (e - (arr[left] + arr[right]) > 0) {
					left++;
				} else {
					right--;
				}
			}
		}
		return false;
	}
}
