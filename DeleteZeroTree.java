package jiachen.algorithm;

public class DeleteZeroTree {
	public static int delete_rec(BinaryTreeNode root) {
		if (root == null) {
			return 0;
		}

		int i = delete_rec(root.left);
		if (i == 0) {
			root.left = null;
		}

		int j = delete_rec(root.right);
		if (j == 0) {
			root.right = null;
		}

		return root.val + i + j;
	}
	public static void delete(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		if (delete_rec(root) == 0) {
			root = null;
		}
	}
}
