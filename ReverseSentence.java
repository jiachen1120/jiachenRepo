package jiachen.algorithm;

public class ReverseSentence {
	public static void word_rev(char[] ch) {
		if (ch == null || ch.length < 2) {
			return;
		}
		all_rev(ch, 0, ch.length - 1);
		int str = 0;
		int end = get_next_space(ch, str);
		while (end != -1) {
			all_rev(ch, str, end - 1);
			str = end + 1;
			end = get_next_space(ch,str);
		}
	}

	public static void all_rev(char[] ch, int str, int end) {
		while (str < end) {
			char temp = ch[str];
			ch[str] = ch[end];
			ch[end] = temp;
			str++;
			end--;
		}
	}
	public static int get_next_space(char[] ch, int str) {
		int end = str + 1;
		if (end > ch.length - 1) {
			return -1;
		}
		while (end < ch.length && ch[end] != ' ') {
			end++;
		}
		return end;
	}
}
