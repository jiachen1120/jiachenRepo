package jiachen.algorithm;

public class ListMergeSort {
	public static ListNode mergeSort(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		Tuple<ListNode, ListNode> pair = new Tuple<>(null, null);
		split(head, pair);
		pair.x = mergeSort(pair.x);
		pair.y = mergeSort(pair.y);
		return MergeTwoList.mergeTwoLists(pair.x, pair.y);
	}

	public static void split(ListNode head, Tuple<ListNode, ListNode> pair) {
		ListNode fast = head.next;
		ListNode slow = head;
		while (fast != null) {
			fast = fast.next;
			if (fast != null) {
				fast = fast.next;
				slow = slow.next;
			}
		}
		pair.x = head;
		pair.y = slow.next;

		slow.next = null;
	}
}
