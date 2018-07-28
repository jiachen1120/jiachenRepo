package jiachen.algorithm;

import java.util.Stack;

public class TreePathSum {

	public static void pathSum(BinaryTreeNode root, int sum) {
		Stack<BinaryTreeNode> stk = new Stack<>();
		pathSum(root, sum, stk);
		if (root.left != null && stk.isEmpty())
			pathSum(root.left, sum, stk);
		if (root.right != null && stk.isEmpty())
			pathSum(root.right, sum, stk);
		System.out.println(!stk.isEmpty());
		while (!stk.isEmpty()) {
			System.out.println(stk.pop());
		}
	}

	public static void pathSum(BinaryTreeNode root, int sum, Stack<BinaryTreeNode> stk) {
		if (sum < 0 || root == null) {
			return;
		}
		if (root.val == sum) {
			stk.push(root);
			return;
		}
		pathSum(root.left, sum - root.val, stk);
		pathSum(root.right, sum - root.val, stk);
		if (!stk.isEmpty()) {
			if (root.left == stk.peek() || root.right == stk.peek()) {
				stk.push(root);
			}
		}
	}
}
