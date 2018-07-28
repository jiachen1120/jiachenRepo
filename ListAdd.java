package jiachen.algorithm;

public class ListAdd {
	public static ListNode add(ListNode l1, ListNode l2) {
		ListNode head = null;
		ListNode tail = null;
		int car = 0;
		while (l1 != null || l2 != null || car > 0) {
			int firstInteger = (l1 == null ? 0 : l1.val);
			int secondInteger = (l2 == null ? 0 : l2.val);
			int sum = firstInteger + secondInteger + car;
			car = sum / 10;
			ListNode newNode = new ListNode(sum % 10);
			if (head == null) {
				head = newNode;
			} else {
				tail.next = newNode;
			}
			tail = newNode;
			if (l1 != null) {
				l1 = l1.next;
			}
			if (l2 != null) {
				l2 = l2.next;
			}
		}
		return head;
	}
}
