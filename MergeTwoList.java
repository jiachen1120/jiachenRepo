package jiachen.algorithm;

public class MergeTwoList {
	public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		if (l1 == null) {
			return l2;
		}
		if (l2 == null) {
			return l1;
		}
		ListNode head1 = l1;
		ListNode head2 = l2;
		ListNode dummyNode = new ListNode(0);
		ListNode temp = dummyNode;
		while (head1 != null && head2 != null) {
			if (head1.val < head2.val) {
				temp.next = head1;
				head1 = head1.next;
				temp = temp.next;
			} else {
				temp.next = head2;
				head2 = head2.next;
				temp = temp.next;
			}
		}
		if (head1 != null) {
			temp.next = head1;
		}
		if (head2 != null) {
			temp.next = head2;
		}
		return dummyNode.next;
	}
}
