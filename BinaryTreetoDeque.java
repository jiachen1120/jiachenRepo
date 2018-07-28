package jiachen.algorithm;

import java.util.Stack;

public class BinaryTreetoDeque {
	public static BinaryTreeNode convert(BinaryTreeNode root) {
		BinaryTreeNode pre = null;
		BinaryTreeNode head = null;
		while (root == null) {
			return head;
		}
		Stack<BinaryTreeNode> stk = new Stack<> ();
		while (root != null || !stk.isEmpty()) {
			while (root != null) {
				stk.push(root);
				root = root.left;
			}
			BinaryTreeNode cur = stk.pop();
			BinaryTreeNode temp = cur.right;
			if (temp != null) {
				stk.push(temp);
				temp = temp.left;
			}
			if (pre != null) {
				pre.right = cur;
				cur.left = pre;
			} else {
				head = cur;
			}
			pre = cur;
		}
		return head;
	}
	
	/******************************************/
	// merge(fuse) two sorted linked lists
	static BinaryTreeNode concatenate_lists(
	    BinaryTreeNode head1, 
	    BinaryTreeNode head2) {
	    
	    if (head1 == null) {
	        return head2;
	    }
	    
	    if (head2 == null) {
	        return head1;
	    }
	    
	    // use left for previous.
	    // use right for next.
	    BinaryTreeNode tail1 = head1.left;
	    BinaryTreeNode tail2 = head2.left;
	    
	    tail1.right = head2;
	    head2.left = tail1;
	    
	    head1.left = tail2;
	    tail2.right = head1;
	    return head1;
	}


	public static BinaryTreeNode convert_to_linked_list(
	    BinaryTreeNode root) {
	    
	    if (root == null) {
	        return null;
	    }
	    
	    BinaryTreeNode list1 = convert_to_linked_list(root.left);
	    BinaryTreeNode list2 = convert_to_linked_list(root.right);
	    
	    root.left = root.right = root;
	    BinaryTreeNode result = concatenate_lists(list1, root);
	    result = concatenate_lists(result, list2);
	    
	    return result;
	}
}
