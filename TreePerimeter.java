package jiachen.algorithm;

import java.util.Stack;

public class TreePerimeter {
	public static void treePerimeter(BinaryTreeNode root) {
		printLeft(root);
		printLeaf(root);
		printRight(root);
	}

	public static void printLeft(BinaryTreeNode root) {
		while (root.left != null) {
			System.out.print(root);
			root = root.left;
		}
	}

	public static void printLeaf(BinaryTreeNode root) {
		if (root != null) {
			if (root.left == null && root.right == null) {
				System.out.print(root);
			}
			printLeaf(root.left);
			printLeaf(root.right);
		}
	}

	public static void printRight(BinaryTreeNode root) {
		Stack<BinaryTreeNode> stk = new Stack<>();
		root = root.right;
		while (root.right != null) {
			stk.push(root);
			root = root.right;
		}
		while (!stk.isEmpty()) {
			System.out.print(stk.pop());
		}
	}
}
