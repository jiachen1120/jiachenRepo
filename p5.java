package OA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class p5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		String str;
		StringBuilder sb = new StringBuilder();
		while ((str = br.readLine()) != null) {
			sb.append(str);
			sb.append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		String[] ipt = sb.toString().split(",");
		//≤‚ ‘
		p5 test = new p5();
		System.out.println(test.prefix(ipt));
	}
	public String prefix(String[] ipt) {
		StringBuilder sb = new StringBuilder();
		List<String> list = new ArrayList<> ();
		String pf = ipt[0].toLowerCase();
		System.out.println(pf);
		for (int i = 1; i < ipt.length; i++) {
			String p = ipt[i].substring(0, Math.min(pf.length(), ipt[i].length())).toLowerCase();
			if (p.equals(pf)) {
				list.add(ipt[i]);
			}
		}
		Collections.sort(list, new Comparator<String> () {
			@Override
			public int compare(String arg0, String arg1) {
				// TODO Auto-generated method stub
				return arg0.compareTo(arg1);
			}
		});
		for (int i = 0; i < 2; i++) {
			sb.append(list.get(i));
			sb.append(",");
		}
		sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
}
