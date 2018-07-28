package jiachen.algorithm;

import java.util.HashMap;
import java.util.Map;

public class ArrayProblem {
	public static int[] findArray(int[] arr) {
		int[] opt = new int[arr.length]; 
		Map<Integer,Integer> map = new HashMap<Integer,Integer> ();
		for (int x = 0; x < arr.length; x++) {
			if (map.get(arr[x]) == null) {
				int count = 1;
				map.put(arr[x], count);
			} else {
				int temp = map.get(arr[x]);
				temp ++;
				map.put(arr[x], temp);
			}
		}
		for (int i = 0; i < arr.length; i++) {
			int temp = map.get(arr[i]);
			temp --;
			map.put(arr[i], temp);
			int result = 0;
			for (int j = 0; j < arr[i]; j ++) {
				if (map.get(j) == null) {
					continue;
				} else {
					result += map.get(j); 
				}
			}
			opt[i] = result;
		}
		return opt;
	}
	
}
