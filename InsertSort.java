package jiachen.algorithm;

public class InsertSort {
	public static void sort(int[] data) {
		for(int x = 1; x < data.length; x++) {
			int current = data[x];
			int y = x - 1;
			while(y >= 0 && data[y] >= current) {
				data[y + 1] = data[y];
				y--;
			}
			data[y + 1] = current;
		}
	}
}
