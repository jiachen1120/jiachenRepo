package jiachen.algorithm;

public class QuickSort {
	public static void quickSort(int[] arr) {
		if (arr == null) {
			return;
		}
		quickSort_rec(arr, 0, arr.length - 1);
	}

	public static int partition(int[] arr, int low, int high) {
		int i = low;
		int j = high;
		int pivot = arr[low];
		while (i < j) {
			while (i <= high && arr[i] <= pivot)
				i++;
			while (arr[j] > pivot)
				j--;
			if (i < j) {
				int temp = arr[i];
				arr[i] = arr[j];
				arr[j] = temp;
			}
		}
		arr[low] = arr[j];
		arr[j] = pivot;
		return j;
	}

	public static void quickSort_rec(int[] arr, int low, int high) {
		if (low < high) {
			int pivot_index = partition(arr, low, high);
			quickSort_rec(arr, low, pivot_index - 1);
			quickSort_rec(arr, pivot_index + 1, high);
		}
	}
}
