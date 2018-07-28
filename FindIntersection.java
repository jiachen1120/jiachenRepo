package jiachen.algorithm;
import jiachen.algorithm.ListNode;

public class FindIntersection {
	public static ListNode findInterseaction(ListNode list1, ListNode list2) {
		if (list1 == null || list2 == null) {
			return null;
		}
		int list1Length = getLength(list1);
		int list2Length = getLength(list2);
		ListNode head1 = null;
		ListNode head2 = null;
		int length_different = 0;
		if (list1Length >= list2Length) {
			length_different = list1Length - list2Length;
			head1 = list1;
			head2 = list2;
		} else {
			length_different = list2Length - list1Length;
			head1 = list2;
			head2 = list1;
		}
		while (length_different > 0) {
			head1 = head1.next;
			length_different--;
		}
		while (head1 != null) {
			if (head1 == head2) {
				return head1;
			} else {
				head1 = head1.next;
				head2 = head2.next;
			}
		}
		return null;
	}

	public static int getLength(ListNode list) {
		int length = 0;
		while (list != null) {
			list = list.next;
			length++;
		}
		return length;
	}
}
