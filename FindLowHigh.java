package jiachen.algorithm;

public class FindLowHigh {
	public static void findLowHigh(int[] arr, int k) {
		if (arr == null) {
			return;
		}
		System.out.println(searchLow(arr, k) + "," + searchHigh(arr, k));
	}

	public static int searchLow(int[] arr, int k) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (arr[mid] < k) {
				low = mid + 1;
			} else {
				high = mid - 1;
			}
		}
		if (arr[low] == k) {
			return low;
		}
		return -1;
	}

	public static int searchHigh(int[] arr, int k) {
		int low = 0;
		int high = arr.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if(arr[mid] > k) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		if (arr[high] == k) {
			return high;
		}
		return -1;
	}
}
