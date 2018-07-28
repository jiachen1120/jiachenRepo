package jiachen.algorithm;

import java.util.ArrayList;

public class AllSum {
	public static void print_list(ArrayList<Integer> list) {
		for (int x : list) {
			System.out.print(x + ",");
		}
		System.out.println("");
	}

	public static void allSum(int target, int current_sum, int start, ArrayList<Integer> list) {
		if (current_sum == target) {
			print_list(list);
		}
		for (int i = start; i < target; i++) {
			int temp_sum = current_sum + i;
			if (temp_sum <= target) {
				list.add(i);
				allSum(target, temp_sum, start, list);
				list.remove(list.size() - 1);
			} else {
				return;
			}
		}
	}

	public static void allSum(int target) {
		ArrayList<Integer> list = new ArrayList<>();
		allSum(target, 0, 1, list);
	}
}
