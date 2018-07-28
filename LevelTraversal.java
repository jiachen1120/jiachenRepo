package jiachen.algorithm;

import java.util.LinkedList;
import java.util.Queue;

public class LevelTraversal {
	public static void levelTraversal(BinaryTreeNode root) {
		Queue<BinaryTreeNode> que = new LinkedList<>();
		que.offer(root);
		while (!que.isEmpty()) {
			int size = que.size();
			for (int i = 0; i < size; i++) {
				BinaryTreeNode temp = que.poll();
				System.out.print(temp + " ");
				if (temp.left != null) {
					que.offer(temp.left);
				}
				if (temp.right != null) {
					que.offer(temp.right);
				}
			}
			System.out.print("\n");
		}
	}
}
