package jiachen.algorithm;

public class BinaryTreeNode {
	public int val;
	public BinaryTreeNode left;
	public BinaryTreeNode right;
	public BinaryTreeNode next;
	public BinaryTreeNode parent;
	public BinaryTreeNode(int val) {
		this.val = val;
	}
	@Override
	public String toString() {
		return "[" + val + "]";
	}
	
}
