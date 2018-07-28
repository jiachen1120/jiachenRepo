package jiachen.algorithm;

public class BinarySearch {
	public static int search1(int[] a, int search, int low, int high) {
		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if (search == a[mid]) {
			return mid;
		} else if (a[mid] < search) {
			return search1(a, search, mid + 1, high);
		} else {
			return search1(a, search, low, mid - 1);
		}
	}

	public static int binarySearch(int[] a, int search) {
		return search1(a, search, 0, a.length - 1);
	}

	public static int search2(int[] a, int search) {
		int low = 0;
		int high = a.length - 1;
		while (low <= high) {
			int mid = low + (high - low) / 2;
			if (search == a[mid]) {
				return mid;
			} else if (search < a[mid]) {
				high = mid - 1;
			} else {
				low = mid + 1;
			}
		}
		return -1;
	}
}