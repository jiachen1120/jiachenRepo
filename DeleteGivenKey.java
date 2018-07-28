package jiachen.algorithm;

public class DeleteGivenKey {
	public static ListNode deleteGivenKey(ListNode head, int key) {
		if (head == null) {
			return head;
		}
		ListNode pre = null;
		ListNode current = head;
		while (current != null) {
			if (current.val == key) {
				if (current == head) {
					head = head.next;
					current = current.next;
				} else {
					pre.next = current.next;
					current = current.next;
				}
			} else {
				pre = current;
				current = current.next;
			}
		}
		return head;
	}
}
