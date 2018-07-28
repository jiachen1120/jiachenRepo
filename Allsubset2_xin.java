package jiachen.algorithm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Allsubset2_xin {
	public static int getBit(int i, int j) {
		int temp = (1 << j);
		temp = temp & i;
		if (temp == 0) {
			return 0;
		} else {
			return 1;
		}
	}

	public static void allSub(ArrayList<Character> list) {
		int sub_count = (int) Math.pow((double)2, (double)list.size());
		HashMap<Integer, ArrayList<HashSet<Character>>> map = new HashMap<> ();
		for (int i = 0; i < sub_count; i ++) {
			HashSet<Character> set = new HashSet<> ();
			for (int j = 0; j < list.size(); j++) {
				if (getBit(i,j) == 1) {
					set.add(list.get(j));
				}
			}
			if (map.get(set.size()) == null) {
			ArrayList<HashSet<Character>> temp = new ArrayList<> (); 
			temp.add(set);
			map.put(set.size(), temp);
			} else {
				ArrayList<HashSet<Character>> temp = map.get(set.size()); 
				temp.add(set);
				map.put(set.size(), temp);
			}
			
		}
		for (int i = 1; i <= list.size(); i++) {
			System.out.println(map.get(i));
		}
	}
}
