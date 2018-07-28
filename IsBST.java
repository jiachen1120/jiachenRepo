package jiachen.algorithm;

import java.util.Stack;

public class IsBST {
	static BinaryTreeNode pre = null;

	public static boolean isBST(BinaryTreeNode root, int min, int max) {
		if (root == null) {
			return true;
		}
		if (root.val < min || root.val > max) {
			return false;
		}
		return isBST(root.left, min, root.val) && isBST(root.right, root.val, max);
	}

	public static boolean isBST(BinaryTreeNode root) {
		return isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public static boolean isBST2(BinaryTreeNode root) {
		if (root == null) {
			return true;
		}
		if (!isBST2(root.left)) {
			return false;
		}
		if (pre != null && pre.val > root.val) {
			return false;
		}
		if (!isBST2(root.right)) {
			return false;
		}
		return true;
	}

	public static boolean isBST3(BinaryTreeNode root) {
		if (root == null) {
			return true;
		}
		Stack<BinaryTreeNode> stk = new Stack<>();
		while (root != null) {
			stk.push(root);
			root = root.left;
		}
		while (!stk.isEmpty()) {
			BinaryTreeNode Val = stk.pop();
			BinaryTreeNode temp = Val.right;
			if (temp != null) {
				stk.push(temp);
				temp = temp.left;
			}
			if (!stk.isEmpty()) {
				if (Val.val > stk.peek().val) {
					return false;
				}
			}
		}
		return true;
	}
}
