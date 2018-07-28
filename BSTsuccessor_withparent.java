package jiachen.algorithm;

public class BSTsuccessor_withparent {
	public static BinaryTreeNode findMin(BinaryTreeNode root) {
		while (root.left != null) {
			root = root.left;
		}
		return root;
	}
	public static BinaryTreeNode findSuccessor(BinaryTreeNode root, int key) {
		if (root == null) {
			return null;
		}
		while (root != null) {
			if (root.val > key) {
				root = root.left;
			} else if (root.val < key) {
				root = root.right;
			} else {
				if (root.right != null) {
					return findMin(root.right);
				} else {
					while (root.parent != null) {
						if (root.parent.left == root) {
							return root.parent;
						}
						root = root.parent;
					}
				}
			}
		}
		return null;
	}
}
