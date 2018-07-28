package jiachen.algorithm;

public class MergeSort {
//	public static void sort(int arr[]) {
//		if (arr == null || arr.length <= 1) {
//			return;
//		}
//		int[] temp = new int[arr.length];
//		sort1(arr, temp, 0, arr.length - 1);
//	}
//
//	public static void sort1(int arr[], int temp[], int left, int right) {
//		if (left >= right) {
//			return;
//		}
//		int mid = left + (right - left) / 2;
//		sort1(arr, temp, left, mid);
//		sort1(arr, temp, mid + 1, right);
//		merge(arr, temp, left, mid, right);
//	}
//
//	public static void merge(int arr[], int temp[], int left, int mid, int right) {
//		// int[] temp = new int[right - left + 1];
//		int s1 = left;
//		int s2 = mid + 1;
//		int s = 0;
//		while (s1 <= mid && s2 <= right) {
//			if (arr[s1] > arr[s2]) {
//				temp[s++] = arr[s2++];
//			} else {
//				temp[s++] = arr[s1++];
//			}
//		}
//		while (s1 <= mid) {
//			temp[s++] = arr[s1++];
//		}
//		while (s2 <= right) {
//			temp[s++] = arr[s2++];
//		}
//		for (int x = 0; x < (right - left + 1); x++) {
//			arr[x + left] = temp[x];
//		}
//	}
	
	public static void mergeSort(int arr[]) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		int[] temp = new int[arr.length];
		mergeSort_rec(arr, temp, 0, arr.length - 1);
	}
	
	public static void mergeSort_rec(int arr[], int temp[], int str, int end) {
		if (str >= end) {
			return;
		}
		int mid = str + (end - str) / 2;
		mergeSort_rec(arr, temp, str, mid);
		mergeSort_rec(arr, temp, mid + 1, end);
		merge(arr, temp, str, mid, end);
	}
	
	public static void merge(int[] arr, int[] temp, int str, int mid, int end) {
		int s1 = str;
		int s2 = mid + 1;
		int s = 0;
		while (s1 <= mid && s2 <= end) {
			if (arr[s1] < arr[s2]) {
				temp[s++] = arr[s1++];
			} else {
				temp[s++] = arr[s2++];
			}
		}
		while (s1 <= mid) {
			temp[s++] = arr[s1++];
		}
		while (s2 <= end) {
			temp[s++] = arr[s2++];
		}
		for (int i = 0; i < end - str + 1; i++) {
			arr[str + i] = temp[i];
		}
	}
}
