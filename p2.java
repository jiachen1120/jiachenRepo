package OA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class p2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		String str;
		StringBuilder sb = new StringBuilder();
		while ((str = br.readLine()) != null) {
			sb.append(str);
			sb.append(" ");
		}
		String[] ipt = sb.toString().split("\\|");
		p2 test = new p2();
		System.out.print(test.filterDup(ipt));
	}
	
	public String filterDup(String[] ipt) {
		if (ipt.length == 0) {
			return "";
		}
		String rst = ipt[0];
		int max_length = handleMessage(ipt[0]);
		for (String ea : ipt) {
			int length = handleMessage(ea);
			if (length > max_length) {
				rst = ea;
				max_length = length;
			} else if (length == max_length && ea.length() < rst.length()) {
				rst = ea;
			}
		}
		return rst;
	}
	
	public int handleMessage(String str) {
		int length = 0;
		String[] strs = str.split(" +");
		for (String ea : strs) {
			char[] filter = ea.trim().toCharArray();
			for (char c : filter) {
				if (Character.isLetterOrDigit(c)) {
					length++;
				}
			}
		}
		return length;
	}
}
