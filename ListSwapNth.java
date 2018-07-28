package jiachen.algorithm;

public class ListSwapNth {
	public static ListNode listSwap(ListNode head, int n) {
		if (head == null) {
			return head;
		}
		if (n == 1) {
			return head;
		}
		ListNode pre = null;
		ListNode cur = head;
		while (n > 1 && cur != null) {
			pre = cur;
			cur = cur.next;
			n--;
		}
		if (n > 1) {
			return null;
		}
		pre.next = head;
		ListNode temp = head.next;
		head.next = cur.next;
		cur.next = temp;
		return cur;
	}
}
