package jiachen.algorithm;

import java.util.Stack;

public class BSTsuccessor {
//	public static BinaryTreeNode getSuccessor(BinaryTreeNode root, int d) {
//		Stack<BinaryTreeNode> stk = new Stack<>();
//		if (root == null) {
//			return null;
//		}
//		while (root != null || !stk.isEmpty()) {
//			while (root != null) {
//				stk.push(root);
//				root = root.left;
//			}
//			BinaryTreeNode Val = stk.pop();
//			BinaryTreeNode temp = Val.right;
//			while (temp != null) {
//				stk.push(temp);
//				temp = temp.left;
//			}
//			if (Val.val == d) {
//				return stk.pop();
//			}
//		}
//		return null;
//	}
	public static BinaryTreeNode getSuccessor(BinaryTreeNode root, int d) {
		if (root == null) {
			return null;
		}
		BinaryTreeNode successor = null;
		while (root != null) {
			if (root.val > d) {
				successor = root;
				root = root.left;
			} else if (root.val < d) {
				root = root.right;
			} else {
				if (root.right != null) {
					BinaryTreeNode temp = root.right;
					while (temp.left != null) {
						temp = temp.left;
					}
					successor = temp;
				}
				break;
			}	
		}
		return successor;
	}
}
