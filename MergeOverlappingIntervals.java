package jiachen.algorithm;

import java.util.ArrayList;

public class MergeOverlappingIntervals {
	public static void moli(ArrayList<Tuple<Integer, Integer>> v1) {
		if (v1 == null || v1.size() == 0) {
			return;
		}
		ArrayList<Tuple<Integer, Integer>> v2 = new ArrayList<>();
		v2.add(v1.get(0));

		for (int i = 0; i < v1.size(); i++) {
			int x1 = v1.get(i).x;
			int y1 = v1.get(i).y;
			int y2 = v2.get(v2.size() - 1).y;
			if (y2 >= x1) {
				v2.get(v2.size() - 1).y = Math.max(y1, y2);
			} else {
				v2.add(v1.get(i));
			}
		}
		for (int i = 0; i < v2.size(); i++) {
			System.out.println(v2.get(i));
		}
	}
}
