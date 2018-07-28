package jiachen.algorithm;

public class FindMissingNum {
	public static void findMiss(int[] arr) {
		int miss = 0;
		int sum_act = 0;
		int sum_arr = 0;
		sum_act = ((1 + arr.length + 1) * (arr.length + 1))/2;
		for (int i = 0; i < arr.length; i++) {
			sum_arr = sum_arr + arr[i];
		}
		miss = sum_act - sum_arr;
		System.out.println(miss); 
	}
}
