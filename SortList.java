package jiachen.algorithm;

public class SortList {
	public static ListNode sortList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode cur = head;
		ListNode sort = null;
		while (cur != null) {
			ListNode temp = cur.next;
			sort = sortList(cur, sort);
			cur = temp;
		}
		return sort;
	}
	public static ListNode sortList(ListNode head, ListNode sort) {
		if (sort == null || head.val <= sort.val) {
			head.next = sort;
			return head;
		}
		ListNode cur = sort;
		while (cur.next != null && cur.next.val < head.val) {
			cur = cur.next;
		}
		head.next = cur.next;
		cur.next = head;
		return sort;
	}
}
