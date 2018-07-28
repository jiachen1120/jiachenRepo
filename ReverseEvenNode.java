package jiachen.algorithm;

public class ReverseEvenNode {
	public static ListNode reverseEvenNode(ListNode head) {
		ListNode cur = head;
		ListNode evenList = null;
		while (cur != null && cur.next != null) {
			ListNode even = cur.next;
			cur.next = even.next;
			even.next = evenList;
			evenList = even;
			
			cur = cur.next;
		}
		return merge(head, evenList);
	}
	public static ListNode merge(ListNode list1, ListNode list2) {
		ListNode l1 = list1;
		ListNode l2 = list2;
		ListNode head = l1;
		while (l1.next != null && l2 != null) {
			ListNode temp = l2;
			l2 = l2.next;
			
			temp.next = l1.next; 
			l1.next = temp;
			
			l1 = temp.next;
		}
		if (l1.next == null) {
			l1.next = l2;
		}
		return head;
	}
}
