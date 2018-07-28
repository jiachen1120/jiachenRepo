package jiachen.algorithm;

public class IdenticalTree {
	public static boolean isIdentical(BinaryTreeNode root1, BinaryTreeNode root2) {
		if (root1 == null && root2 == null) {
			return true;
		}
		if (root1 != null && root2 != null) {
			if (root1.val == root2.val) {
				return isIdentical(root1.left, root2.left) && isIdentical(root1.right, root2.right);
			}
		}
		return false;
	}
}
