package OA;

import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class p4v2 {
	public static void main(String args[]) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		String str;
		StringBuilder sb = new StringBuilder();
		while ((str = br.readLine()) != null) {
			sb.append(str);
			sb.append("|");
		}
		sb.deleteCharAt(sb.length() - 1); // 删除最后一个杠杠
		String[] ipt = sb.toString().split("\\|");
		p4v2 test = new p4v2();
		System.out.println(test.statis(ipt));
	}
	// core code
	public String statis(String[] ipt) {
		StringBuilder rst = new StringBuilder();
		Map<String, String> map = new HashMap<>();
//		Map<String, String> map = new TreeMap<>();
		
		// base case
		if (ipt.length == 0) {
			return null;
		}
		// split date and detail and store in map
		for (String ea : ipt) {
			String[] pair = ea.split(",", 2);
			map.put(pair[0], map.containsKey(pair[0]) ? map.get(pair[0]) + "|" + pair[1] : pair[1]);
		}
		// sort
		List<Map.Entry<String, String>> list = new ArrayList<> (map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, String>>() {
			@Override
			public int compare(Map.Entry<String,String> arg0, Map.Entry<String,String> arg1) {
				return arg0.getKey().compareTo(arg1.getKey());
			}
		});
		
		// process result
		for (Map.Entry<String, String> mapping : list) {
			rst.append(mapping.getKey() + " ");
			rst.append(process(mapping.getValue()));
			rst.append("\r\n");
		}
		rst.deleteCharAt(rst.length() - 1);
		return rst.toString();
	}
	
	// process detail
	public static String process(String ipt) {
		StringBuilder sb = new StringBuilder();
		String[] ipts = ipt.split("\\|");
		int qualities = 0;
		int type = 0;
		Set<String> set = new HashSet<> ();
		for (String ea : ipts) {
			String[] info = ea.split(",");
			qualities = qualities + Integer.parseInt(info[0]);
			if (set.add(info[1])) {
				type++;
			}
		}
		sb.append(qualities);
		sb.append(",");
		sb.append((float)qualities / type);
		return sb.toString();
	}
}
