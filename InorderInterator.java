package jiachen.algorithm;

import java.util.Stack;

public class InorderInterator {
	private static Stack<BinaryTreeNode> sta = new Stack<>();

	 public InorderInterator(BinaryTreeNode root) {
	 inorder(root);
	 }
	
	 public static void inorder(BinaryTreeNode root) {
	 if (root == null) {
	 return;
	 }
	 if (root.right != null) {
	 inorder(root.right);
	 }
	 sta.push(root);
	 if (root.left != null) {
	 inorder(root.left);
	 }
	 }
	
	 public static boolean hasNext() {
	 if (!sta.isEmpty()) {
	 return true;
	 }
	 return false;
	 }
	
	 public static BinaryTreeNode getNext() {
	 return sta.pop();
	 }
//	public InorderInterator(BinaryTreeNode root) {
//		while (root != null) {
//			sta.push(root);
//			root = root.left;
//		}
//	}
//
//	public static boolean hasNext() {
//		return !sta.isEmpty();
//	}
//
//	public static BinaryTreeNode getNext() {
//		BinaryTreeNode next = sta.pop();
//		BinaryTreeNode temp = next.right;
//		while (temp != null) {
//			sta.push(temp);
//			temp = temp.left;
//		}
//		return next;
//	}
}
