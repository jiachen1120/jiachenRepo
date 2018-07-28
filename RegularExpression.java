package jiachen.algorithm;

public class RegularExpression {
	public static boolean regx_match(String text, String pattern) {
		if (text.isEmpty() && pattern.isEmpty()) {
			return true;
		}
		if (!text.isEmpty() && pattern.isEmpty()) {
			return false;
		}
		if (pattern.length() > 1 && pattern.charAt(1) == '*') {
			String remaining_pattern = pattern.substring(2);
			String remaining_text = text;
			for (int i = 0; i < text.length() + 1; i++) {
				if (regx_match(remaining_text, remaining_pattern)) {
					return true;
				}
				if (remaining_text.isEmpty()) {
					return false;
				}
				if (pattern.charAt(0) != '.' && remaining_text.charAt(0) != pattern.charAt(0)) {
					return false;
				}
				remaining_text = remaining_text.substring(1);
			}
		}
		if (pattern.isEmpty() || text.isEmpty()) {
			return false;
		}
		if (pattern.charAt(0) == '.' || pattern.charAt(0) == text.charAt(0)) {
			String remaining_pattern = "";
			if (pattern.length() > 1) {
				remaining_pattern = pattern.substring(1);
			}
			String remaining_text = "";
			if (text.length() > 1) {
				remaining_text = text.substring(1);
			}
			return regx_match(remaining_text, remaining_pattern);
		}
		return false;
	}

	// Function 2
	public static boolean regx_match_rec(String text, String pattern, int i, int j) {
		if (text.length() == i && pattern.length() == j) {
			return true;
		}
		if (text.length() > i && pattern.length() == j) {
			return false;
		}
		if (pattern.length() > j + 1 && pattern.charAt(j + 1) == '*') {
			for (int k = i; k < text.length() + 1; k++) {
				if (regx_match_rec(text, pattern, k, j + 2)) {
					return true;
				}
				if (k == text.length()) {
					return false;
				}
				if (pattern.charAt(j) != '.' || pattern.charAt(j) != text.charAt(k)) {
					return false;
				}
			}
		}
		if (text.length() == i || pattern.length() == j) {
			return false;
		}
		if (pattern.charAt(j) == '.' || pattern.charAt(j) == text.charAt(i)) {
			if (pattern.length() > 1) {
				j++;
			}
			if (text.length() > 1) {
				i++;
			}
			return regx_match_rec(text, pattern, i, j);
		}
		return false;
	}
}
