package jiachen.algorithm;

public class MirrorTree {
	public static void mirrorTree(BinaryTreeNode root) {
		if (root == null) {
			return;
		}
		if (root.left != null) {
			mirrorTree(root.left);
		}
		if (root.right != null) {
			mirrorTree(root.right);
		}
		BinaryTreeNode temp = root.right;
		root.right = root.left;
		root.left = temp;
	}
}
