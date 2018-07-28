package jiachen.algorithm;

import java.util.HashSet;

public class StringSegement {
	public static boolean isSegememt(HashSet<String> dic, String input) {
		if (input == null || input.length() < 1) {
			return false;
		}
		for (int i = 1; i <= input.length(); i++) {
			String first = input.substring(0, i);
			if (dic.contains(first)) {
				String second = input.substring(i);
				if (second == null || second.length() == 0 || dic.contains(second)) {
					return true;
				} else if (isSegememt(dic, second)) {
					return true;
				}
			}
		}
		return false;
	}
}
