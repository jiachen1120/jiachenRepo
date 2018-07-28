package jiachen.algorithm;

public class PermuteString {
	public static void swap(char[] input, int i, int j) {
		char temp = input[i];
		input[i] = input[j];
		input[j] = temp;
	}

	public static void permute(char[] input, int current_index, int end_index) {
		if (current_index == end_index) {
			System.out.println(input);
			System.out.println();
			return;
		}
		for (int i = current_index; i <= end_index; i++) {
			swap(input, current_index, i);
			permute(input, current_index + 1, end_index);
			swap(input, current_index, i);
		}
	}

	public static void permute(char[] input) {
		permute(input, 0, input.length - 1);
	}
}
