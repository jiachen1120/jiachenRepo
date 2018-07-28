package jiachen.algorithm;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

interface token {
	boolean isOperator();
}

class token_operator implements token {
	char ch;

	public token_operator() {
		this.ch = 0;
	}

	public token_operator(char ch) {
		this.ch = ch;
	}

	public void set(char ch) {
		this.ch = ch;
	}

	public char get() {
		return this.ch;
	}

	@Override
	public boolean isOperator() {
		// TODO Auto-generated method stub
		return true;
	}
}

class token_operand implements token {
	double d;

	public token_operand() {
		this.d = 0;
	}

	public token_operand(double d) {
		this.d = d;
	}

	public void set(double d) {
		this.d = d;
	}

	public double get() {
		return this.d;
	}

	@Override
	public boolean isOperator() {
		// TODO Auto-generated method stub
		return false;
	}
}

public class ExpressionEvaluation {
	public static boolean isOperator(char ch) {
		return ch == '+' || ch == '-' || ch == '/' || ch == '*';
	}

	public static boolean preced(char opt1, char opt2) {
		if (opt1 == '*' || opt1 == '/') {
			return true;
		}
		if (opt1 == '+' || opt1 == '-') {
			if (opt2 == '+' || opt2 == '-') {
				return true;
			}
		}
		return false;
	}

	public static boolean isDigit(char ch) {
		return ch >= '0' && ch <= '9';
	}

	public static Tuple<Double, Integer> str_to_double(String s, int index) {
		int len = s.length();
		if (index >= len) {
			return null;
		}
		StringBuilder temp = new StringBuilder();
		while (index < len && (s.charAt(index) == ' ' || s.charAt(index) == '\t')) {
			index++;
		}
		if (index >= len) {
			return null;
		}
		if (s.charAt(index) == '-') {
			temp.append('-');
			index++;
		}
		while (index < len) {
			char ch = s.charAt(index);
			if (ch != '.' && !isDigit(ch)) {
				break;
			}
			temp.append(ch);
			index++;
		}
		return new Tuple<Double, Integer>(Double.parseDouble(temp.toString()), index);
	}
	public static List<token> postFix(String exp) {
		List<token> list = new ArrayList<> ();
		Stack<Character> operator = new Stack<> ();
		int len = exp.length();
		for (int i = 0; i < len;) {
			char ch = exp.charAt(i);
			if (ch == ' ' || ch == '\t') {
				continue;
			}
			if (isOperator(ch)) {
				while(!operator.isEmpty() && preced(operator.peek(), ch)) {
					list.add(new token_operator(operator.pop()));
				}
				operator.push(ch);
				i++;
			} else {
				Tuple<Double, Integer> pair = str_to_double(exp, i);
				list.add(new token_operand(pair.x));
				i = pair.y;
			}
		}
		while (!operator.isEmpty()) {
			list.add(new token_operator(operator.pop()));
		}
		return list;
	}
	public static double evaluate(List<token> list) {
		Stack<Double> operands = new Stack<> ();
		for (token x : list) {
			if (!x.isOperator()) {
				operands.push(((token_operand)x).get());
			} else {
				double val1 = operands.pop();
				double val2 = operands.pop();
				if (((token_operator)x).get() == '+') {
					operands.push(val1 + val2);
				}
				if (((token_operator)x).get() == '-') {
					operands.push(val2 - val1);
				}
				if (((token_operator)x).get() == '*') {
					operands.push(val1 * val2);
				}
				if (((token_operator)x).get() == '/') {
					operands.push(val2 / val1);
				}
			}
		}
		return operands.pop();
	}
	public static double evaluate(String exp) {
		List<token> list = postFix(exp);
		return evaluate(list);
	}
	
}
