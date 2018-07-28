package jiachen.algorithm;

public class PalindromeSubset {
	public static int findPalindrome(String ch, int j, int k) {
		int count = 0;
		while (j >= 0 && k < ch.length()) {
			if (ch.charAt(j) == ch.charAt(k)) {
				System.out.println(ch.substring(j, k + 1));
				count++;
				j--;
				k++;
			} else {
				break;
			}
		}
		return count;
	}

	public static int findPalindrome(String ch) {
		int count = 0;
		if (ch == null) {
			return -1;
		}
		if (ch.length() == 1) {
			System.out.println(ch + "\t");
			count++;
			return count;
		}
		for (int i = 0; i < ch.length(); i++) {
			count += findPalindrome(ch, i, i + 1);
			count += findPalindrome(ch, i - 1, i + 1);
		}
		return count;
	}
}
