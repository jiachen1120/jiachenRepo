package jiachen.algorithm;

public class RotateArray {
	public static void rotateArray(int[] arr, int k) {
		if(arr.length <= 1 && k == 0) {
			return;
		}
		k = k % arr.length;
		if(k < 0) {
			k = k + arr.length;
		}
		reverse(arr, 0, arr.length - 1);
		reverse(arr, 0, k - 1);
		reverse(arr, k, arr.length - 1);
	}

	public static void reverse(int[] arr, int st, int end) {
		while (st < end) {
			int temp = arr[st];
			arr[st] = arr[end];
			arr[end] = temp;
			st++;
			end--;
		}
	}
}
