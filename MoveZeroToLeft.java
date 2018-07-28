package jiachen.algorithm;

public class MoveZeroToLeft {
	public static void moveZeroToLeft(int[] arr) {
		if (arr == null) {
			return;
		}
		int read_index = arr.length - 1;
		int write_index = arr.length - 1;
		while (read_index >= 0) {
			if (arr[read_index] != 0) {
				arr[write_index--] = arr[read_index];
			}
			read_index--;
		}
		while (write_index >= 0) {
			arr[write_index--] = 0;
		}
	}
}
