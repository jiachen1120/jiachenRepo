package jiachen.algorithm;

import java.util.LinkedList;

public class NthLargest {
	public static void findNthlargest(BinaryTreeNode root, int key) {
		if (root == null) {
			return;
		}
		LinkedList<BinaryTreeNode> stk = new LinkedList<BinaryTreeNode> ();
		int count = 0;
		while (root != null || !stk.isEmpty()) {
			while (root != null) {
				stk.offerFirst(root);
				root = root.right;
			}
			BinaryTreeNode temp = stk.pollFirst();
			count++;
			if (temp.val == key) {
				System.out.println(count);
				break;
			}
			root = temp.left;
		}
	}
}
