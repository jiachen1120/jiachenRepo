package jiachen.algorithm;


public class sum {
	public static int rotateBinarySearch(int[] arr, int low, int high, int key) {
		if(low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if (arr[mid] == key) {
			return mid;
		}
		if (arr[mid] <= arr[high] && arr[mid] < key && key <= arr[high]) {
			return rotateBinarySearch(arr, mid + 1, high, key);
		} else if (arr[low] <= arr[mid] && arr[low] <= key && key < arr[mid]) {
			return rotateBinarySearch(arr, low, mid - 1, key);
		} else if (arr[mid] > arr[high]) {
			return rotateBinarySearch(arr, mid + 1, high, key);
		} else if (arr[mid] < arr[low]) {
			return rotateBinarySearch(arr, low, mid - 1, key);
		}
		return -1;
	}
}