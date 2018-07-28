package jiachen.algorithm;

import java.util.ArrayList;
import java.util.HashSet;

public class AllSubset {
	public static int getBit(int i, int j) {
		int temp = (1 << j);
		temp = temp & i;
		if (temp == 0) {
			return 0;
		} else {
			return 1;
		}
	}
	public static void allSub(ArrayList<Integer> list, ArrayList<HashSet<Integer>> sets) {
		int sub_count = (int) Math.pow((double)2, (double)list.size());
		for (int i = 0; i < sub_count; i ++) {
			HashSet<Integer> set = new HashSet<> ();
			for (int j = 0; j < list.size(); j++) {
				if (getBit(i,j) == 1) {
					set.add(list.get(j));
				}
			}
			sets.add(set);
		}
		System.out.println(sets);
	}
}
