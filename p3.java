package OA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class p3 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		String str;
		StringBuilder sb = new StringBuilder();
		while ((str = br.readLine()) != null) {
			sb.append(str);
			sb.append(" ");
		}
		sb.deleteCharAt(sb.length() - 1);
		String[] ipt = sb.toString().split(",");
		p3 test = new p3();
		System.out.println(test.getManager(ipt));
	}
	public String getManager(String[] ipt) {
		Map<String,String> map = new HashMap<> ();
		for (int i = 0; i < ipt.length - 2; i++) {
			String[] relation = ipt[i].split("->");
			map.put(relation[1], relation[0]);
		}
		System.out.println(map);
		String p1 = ipt[ipt.length - 2];
		String p2 = ipt[ipt.length - 1];
		System.out.println("[" + p1 + ", " + p2 + "]");
		String manager1 = p1;
		String manager2 = p2;
		Set<String> set = new HashSet<> ();
		while (map.containsKey(manager1) || map.containsKey(manager2)) {
			if (map.containsKey(manager1)) {
				manager1 = map.get(manager1);
				if (!set.add(manager1)) {
					return manager1;
				}
			}
			if (map.containsKey(manager2)) {
				manager2 = map.get(manager2);
				if (!set.add(manager2)) {
					return manager2;
				}
			}
		}
		System.out.println(set);
		return "";
	}
}
