package jiachen.algorithm;

public class NthFromLast {
	public static ListNode findNthFromLast(ListNode head, int n) {
		if (head == null) {
			return null;
		}
		ListNode i = head;
		ListNode j = head;
		int count = n;
		while (count > 0) {
			j = j.next;
			if (j == null) {
				return null;
			}
			count--;
		}
		while (j != null) {
			i = i.next;
			j = j.next;
		}
		return i;
	}
}
