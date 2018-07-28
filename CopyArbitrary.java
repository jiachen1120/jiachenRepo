package jiachen.algorithm;

import java.util.HashMap;
import java.util.Map;

public class CopyArbitrary {
	public static ListNode copy(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode new_head = null;
		ListNode new_prev = null;
		ListNode current = head;
		Map<ListNode, ListNode> map = new HashMap<>();
		while (current != null) {
			ListNode new_node = new ListNode(current.val);
			new_node.arbitrary_pointer = current.arbitrary_pointer;
			if (new_head == null) {
				new_head = new_node;
			} else {
				new_prev.next = new_node;
			}
			map.put(current, new_node);
			new_prev = new_node;
			current = current.next;
		}
		ListNode new_current = new_head;
		while (new_current != null) {
			if (new_current.arbitrary_pointer != null) {
				ListNode node = map.get(new_current.arbitrary_pointer);
				new_current.arbitrary_pointer = node;
			}
			new_current = new_current.next;
		}
		return new_head;
	}
}
