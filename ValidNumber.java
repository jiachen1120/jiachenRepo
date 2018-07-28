package jiachen.algorithm;

enum STATE {
	START, INTEGER, DECIMAL, UNKNOWN
}

public class ValidNumber {
	public static STATE get_next_state(STATE current_STATE, char ch) {
		switch (current_STATE) {
		case START:
		case INTEGER:
			if (ch == '.') {
				return STATE.DECIMAL;
			} else if (ch >= '0' && ch <= '9') {
				return STATE.INTEGER;
			} else {
				return STATE.UNKNOWN;
			}
		case DECIMAL:
			if (ch >= '0' && ch <= '9') {
				return STATE.DECIMAL;
			} else {
				return STATE.UNKNOWN;
			}
		default:
			break;
		}
		return STATE.UNKNOWN;
	}

	public static boolean isValid(String input) {
		if (input.isEmpty()) {
			return true;
		}
		char[] ch = input.toCharArray();
		STATE current_state = STATE.START;
		int i = 0;
		if (ch[i] == '+' || ch[i] == '-') {
			i++;
		}
		while (i < ch.length) {
			current_state = get_next_state(current_state, ch[i]);
			if (current_state == STATE.UNKNOWN) {
				return false;
			}
			i++;
		}
		return true;
	}
}
