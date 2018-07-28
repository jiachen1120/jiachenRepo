package jiachen.algorithm;

import java.util.EmptyStackException;
import java.util.Stack;

public class InorderIterative {
	public static void inorderIterative(BinaryTreeNode root) throws EmptyStackException {
		if (root == null) {
			return;
		}
		Stack<BinaryTreeNode> stk = new Stack<>();
		while (root != null || !stk.isEmpty()) {
			while (root != null) {
				stk.push(root);
				root = root.left;
			}
			BinaryTreeNode temp = stk.pop();
			System.out.println(temp);
			root = temp.right;
		}
	}
}
