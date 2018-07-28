package jiachen.algorithm;

public class RotateSearch {
	public static int rotateSearch(int arr[], int low, int high, int key) {
		if (low > high) {
			return -1;
		}
		int mid = low + (high - low) / 2;
		if (arr[mid] == key) {
			return mid;
		}
		if (arr[mid] < arr[high] && key > arr[mid] && key <= arr[high]) {
			return rotateSearch(arr, mid + 1, high, key);
		} else if (arr[mid] > arr[low] && key >= arr[low] && key < arr[mid]) {
			return rotateSearch(arr, low, mid - 1, key);
		} else if (arr[mid] < arr[low]) {
			return rotateSearch(arr, low, mid - 1, key);
		} else if (arr[mid] > arr[high]) {
			return rotateSearch(arr, mid + 1, high, key);
		}
		return -1;
	}
}
