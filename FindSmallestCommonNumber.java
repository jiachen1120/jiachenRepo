package jiachen.algorithm;

public class FindSmallestCommonNumber {
	public static int findSmallestCommonNum(int arr1[], int arr2[], int arr3[]) {
		if (arr1 == null || arr2 == null || arr3 == null) {
			return -1;
		}
		int i = 0;
		int j = 0;
		int k = 0;
		while (i < arr1.length && j < arr2.length && k < arr3.length) {
			if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
				return arr1[i];
			}
			if (arr1[i] <= arr2[j] && arr1[i] <= arr3[k]) {
				i++;
			} else if (arr2[j] <= arr1[i] && arr2[j] <= arr3[k]) {
				j++;
			} else if (arr3[k] <= arr1[i] && arr3[k] <= arr2[j]) {
				k++;
			}
		}
		return -1;
	}
}
