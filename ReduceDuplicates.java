package jiachen.algorithm;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class ReduceDuplicates {
	public static ArrayList<Character> reduceDup(String input) {
		char[] ch = input.toCharArray();
		Set<Character>  set = new HashSet<> ();
		ArrayList<Character> list = new ArrayList<> ();
		for (char c : ch) {
			if (!set.contains(c)) {
				set.add(c);
				list.add(c);
			}
		}
		return list;
	}
}
