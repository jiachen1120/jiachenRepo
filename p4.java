package OA;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class p4 {
	public static void main(String args[]) throws IOException, ParseException {
		BufferedReader br = new BufferedReader(new FileReader("test.txt"));
		String str;
		StringBuilder sb = new StringBuilder();
		while ((str = br.readLine()) != null) {
			sb.append(str);
			sb.append("|");
		}
		sb.deleteCharAt(sb.length() - 1); // 删除最后一个杠杠
		String[] ipt = sb.toString().split("\\|");
		p4 test = new p4();
		System.out.println(test.statis(ipt));
	}

	public String statis(String[] ipt) throws ParseException {
		if (ipt.length == 0) {
			return null;
		}
		StringBuilder opt = new StringBuilder();
		Map<String, String> map = new HashMap<>();
		Set<Date> set = new HashSet<>();
		Date[] dateArray = new Date[ipt.length];
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		for (int i = 0; i < ipt.length; i++) {
			String[] pair = ipt[i].split(" ", 2);
			if (map.containsKey(pair[0])) {
				String rst = combine(map.get(pair[0]), pair[1]);
				map.put(pair[0], rst);
			} else {
				map.put(pair[0], pair[1]);
			}
			dateArray[i] = format.parse(pair[0]);
		}
		mergeSort(dateArray);
		for (Date date : dateArray) {
			if (set.add(date)) {
				String pair2 = map.get(format.format(date));
				if (!Character.isDigit(pair2.charAt(0))) {
					pair2 = combine(pair2, null);
				}
				opt.append(format.format(date));
				opt.append(" ");
				opt.append(pair2);
				opt.append("\n");
			}
		}
		return opt.toString();
	}

	// 排序部分
	public static void mergeSort(Date arr[]) {
		if (arr == null || arr.length <= 1) {
			return;
		}
		Date[] temp = new Date[arr.length];
		mergeSort_rec(arr, temp, 0, arr.length - 1);
	}

	public static void mergeSort_rec(Date arr[], Date temp[], int str, int end) {
		if (str >= end) {
			return;
		}
		int mid = str + (end - str) / 2;
		mergeSort_rec(arr, temp, str, mid);
		mergeSort_rec(arr, temp, mid + 1, end);
		merge(arr, temp, str, mid, end);
	}

	public static void merge(Date[] arr, Date[] temp, int str, int mid, int end) {
		int s1 = str;
		int s2 = mid + 1;
		int s = 0;
		while (s1 <= mid && s2 <= end) {
			if (arr[s1].before(arr[s2])) {
				temp[s++] = arr[s1++];
			} else {
				temp[s++] = arr[s2++];
			}
		}
		while (s1 <= mid) {
			temp[s++] = arr[s1++];
		}
		while (s2 <= end) {
			temp[s++] = arr[s2++];
		}
		for (int i = 0; i < end - str + 1; i++) {
			arr[str + i] = temp[i];
		}
	}

	// 统计部分
	public static String combine(String ipt1, String ipt2) {
		StringBuilder sb = new StringBuilder();
		if (ipt2 == null) {
			String[] ipts1 = ipt1.split(" ");
			int num1 = Integer.parseInt(ipts1[1]);
			sb.append(num1);
			sb.append(" ");
			sb.append(1);
			return sb.toString();
		}
		String[] ipts1 = ipt1.split(" ");
		String[] ipts2 = ipt2.split(" ");
		int num1 = Integer.parseInt(ipts1[1]);
		int num2 = Integer.parseInt(ipts2[1]);
		int price1 = Integer.parseInt(ipts1[2]);
		int price2 = Integer.parseInt(ipts2[2]);
		if (ipts1[0] == "apple") {
			sb.append(num1 + num2);
			sb.append(" ");
			sb.append((float) (num1 * price1) / (num2 * price2));
			return sb.toString();
		} else {
			sb.append(num1 + num2);
			sb.append(" ");
			sb.append((float) (num2 * price2) / (num1 * price1));
			return sb.toString();
		}
	}
}
