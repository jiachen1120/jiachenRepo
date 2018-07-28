package jiachen.algorithm;

import java.util.ArrayDeque;

public class Find_Max_Sliding_Window {
	public static void maxSlidingWindow(int[] arr, int window_size) {
		if (arr.length < window_size) {
			return;
		}
		ArrayDeque<Integer> window = new ArrayDeque<>();
		for (int i = 0; i < window_size; i++) {
			while (!window.isEmpty() && arr[i] >= arr[window.peekLast()]) {
				window.removeLast();
			}
			window.addLast(i);
		}
		System.out.println(arr[window.peekFirst()]);
		for (int i = window_size; i < arr.length; i++) {
			while (!window.isEmpty() && arr[i] >= arr[window.peekLast()]) {
				window.removeLast();
			}
			window.addLast(i);
			if (!window.isEmpty() && window.peekFirst() <= i - window_size) {
				window.removeFirst();
			}
			System.out.println(arr[window.peekFirst()]);
		}
	}
}
