package OA;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class p1 {
	
	// input
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		String str;
		StringBuilder sb = new StringBuilder();
		while ((str = br.readLine()) != null) {
			sb.append(str);
			sb.append(" ");
		}
		String[] ipts = sb.toString().split(" ");
		p1 test = new p1();
		System.out.println(test.checkInt(ipts));
	}
	
	public String checkInt(String[] ipt) {
		int n = Integer.parseInt(ipt[0]);
		int p = Integer.parseInt(ipt[1]);
		int q = Integer.parseInt(ipt[2]);
		String rst = "";
		for (int i = n; i > 0; i--) {
			int num = i;
			if (num % p == 0 || num % q == 0) {
				rst += "OUT";
			}
			while (num != 0) {
				int digit = num % 10;
				if (digit == p || digit == q) {
					rst += "THINK";
					break;
				} else {
					num = num / 10;
				}
			}
			if (rst.length() == 0 || rst.charAt(rst.length() - 1) == ',') {
				rst += String.valueOf(i);
			}
			rst += ",";
		}
		rst = rst.substring(0, rst.length() - 1);
		return rst;
	}
}
