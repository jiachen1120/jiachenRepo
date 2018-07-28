package jiachen.algorithm;

public class RotateList {
	public static ListNode rotate(ListNode head, int n) {
		ListNode list1 = head;
		ListNode pre = head;
		ListNode cur = null;
		int length = getLength(head);
		if (n < 0) {
			n = length + n;
		}
		if (n >= length) {
			n = length % n;
		}
		if (n == 0 || length < 2) {
			return head;
		}
		n = length - n - 1;
		while (n > 0) {
			pre = pre.next;
			n--;
		}
		ListNode temp = pre.next;
		pre.next = null;
		cur = temp;
		return merge(cur, list1);
	}

	public static int getLength(ListNode head) {
		int length = 0;
		while (head != null) {
			head = head.next;
			length++;
		}
		return length;
	}

	public static ListNode merge(ListNode l1, ListNode l2) {
		ListNode res = l1;
		while (l1.next != null) {
			l1 = l1.next;
		}
		l1.next = l2;
		return res;
	}
}
