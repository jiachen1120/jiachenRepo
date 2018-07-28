package jiachen.algorithm;

public class BubbleSort {
	public static void sort(int[] data) {
		for (int x = 0; x < data.length; x++) {
			for(int y = 1; y < data.length - x; y++) {
				if(data[y] < data[y-1]) {
					int temp = data[y];
					data[y] = data[y-1];
					data[y-1] = temp;
				}
			}
		}
	}
}
