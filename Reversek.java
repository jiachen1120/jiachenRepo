package jiachen.algorithm;

public class Reversek {
	public static ListNode reversek(ListNode head, int k) {
		if (k <= 1 || head == null || head.next == null) {
			return head;
		}
		ListNode reversed = null;
		ListNode pre_tail = null;
		while (head != null) {
			ListNode cur_head = null;
			ListNode cur_tail = head;
			
			int n = k;
			while (n > 0 && head != null) {
				ListNode temp = head.next;
				head.next = cur_head;
				cur_head = head;
				head = temp;
				n--;
			}
			
			if (reversed == null) {
				reversed = cur_head;
			}
			
			if (pre_tail != null) {
				pre_tail.next = cur_head;
			}
			pre_tail = cur_tail;
		}
		
		return reversed;
	}
}
