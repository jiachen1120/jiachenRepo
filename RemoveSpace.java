package jiachen.algorithm;

import java.util.ArrayList;

public class RemoveSpace {
	public static StringBuilder remove(String input) {
		char[] ch = input.toCharArray();
		StringBuilder list = new StringBuilder ();
		if (ch == null || ch.length < 1) {
			return null;
		}
		for (char c : ch) {
			if (c != ' ') {
				list.append(c);
			}
		}
		return list;
	}
}
