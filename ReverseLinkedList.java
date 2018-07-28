package jiachen.algorithm;

public class ReverseLinkedList {

	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode reverse = head;
		ListNode todo = head.next;
		reverse.next = null;
		while (todo != null) {
			ListNode temp = todo;
			todo = todo.next;
			temp.next = reverse;
			reverse = temp;
		}
		return reverse;
	}

	public ListNode reverseList2(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		ListNode reverse = reverseList2(head.next);
		head.next.next = head;
		head.next = null;
		return reverse;
	}

}
