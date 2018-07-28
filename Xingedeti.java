package jiachen.algorithm;

public class Xingedeti {
	public static void xinge(int[] arr, int low, int high) {
		if (high < arr[0] || high < low || arr[arr.length - 1] < low) {
			return;
		}
		if (low < arr[0]) {
			if (low < arr[0] - 2) {
				System.out.print(low + "-" + (arr[0] - 1));
			} else if (low == arr[0] - 2) {
				System.out.print(low + "," + (arr[0] - 1) + ",");
			} else {
				System.out.print(low + ",");
			}
		}
		int j = 0;
		for (int i = arr[0]; i < arr[arr.length - 1]; i++) {
			if (i < low) {
				i = arr[j];
			}
			if (arr[j] != i) {
				int low_temp = i;
				int high_temp = arr[j] - 1;
				if (low_temp == high_temp) {
					System.out.print(low_temp + ",");
				} else if (low_temp == high_temp - 1) {
					System.out.print(low_temp + "," + high_temp + ",");
				} else {
					System.out.print(low_temp + "-" + high_temp + ",");
				}
				i = arr[j];
			}
			if (i >= high) {
				break;
			}
			j++;
		}
		if (high > arr[arr.length - 1]) {
			if (arr[arr.length - 1] + 1 < high - 1) {
				System.out.print((arr[arr.length - 1] + 1) + "-" + high);
			} else if (arr[arr.length - 1] == high - 2) {
				System.out.print((arr[arr.length - 1] + 1) + "," + high + ",");
			} else {
				System.out.print((arr[arr.length - 1] + 1) + ",");
			}
		}
	}
}
