package jiachen.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class ConectSibling {
	public static void connect(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		Queue<BinaryTreeNode> que = new LinkedList<>();
		que.offer(root);
		while (!que.isEmpty()) {
			int size = que.size();
			BinaryTreeNode pre = null;
			for (int i = 0; i < size; i++) {
				BinaryTreeNode temp = que.poll();
				if (pre != null) {
					pre.next = temp;
				}
				pre = temp;
				if (temp.left != null) que.offer(temp.left);
				if (temp.right != null) que.offer(temp.right);
			}
		}
	}
}
