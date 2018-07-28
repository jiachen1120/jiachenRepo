package jiachen.algorithm;

import java.util.HashSet;
import java.util.Set;

public class RemoveDuplicate {
	public static ListNode removeDup(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode current = head;
		Set<Integer> set = new HashSet<> ();
		set.add(current.val);
		while (current != null && current.next != null) {
			if (set.contains(current.next.val)) {
				current.next = current.next.next;
			} else {
				set.add(current.next.val);
				current = current.next;
			}
		}
		return head;
	}
}
