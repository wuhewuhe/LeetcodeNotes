package Tree;

import java.util.LinkedList;
import java.util.List;

import LinkedList.ListNode;

/**
 * @author mac Given a singly linked list where elements are sorted in ascending
 *         order, convert it to a height balanced BST.
 * 
 *         For this problem, a height-balanced binary tree is defined as a
 *         binary tree in which the depth of the two subtrees of every node
 *         never differ by more than 1.
 * 
 *         Example:
 * 
 *         Given the sorted linked list: [-10,-3,0,5,9],
 * 
 *         One possible answer is: [0,-3,9,-10,null,5], which represents the
 *         following height balanced BST:
 * 
 *         0 / \ -3 9 / / -10 5
 */
public class ConvertSortedListToBST109 {
	public TreeNode sortedListToBST(ListNode head) {
		List<Integer> list = new LinkedList<Integer>();
		while (head != null) {
			list.add(head.val);
			head = head.next;
		}
		return convertListToBST(0, list.size() - 1, list);

	}

	private TreeNode convertListToBST(int start, int end, List<Integer> list) {
		if (start > end)
			return null;
		int mid = (start + end) / 2;
		TreeNode root = new TreeNode(list.get(mid));
		root.left = convertListToBST(start, mid - 1, list);
		root.right = convertListToBST(mid + 1, end, list);
		return root;
	}
	
	
//	private ListNode head;
//
//	  private int findSize(ListNode head) {
//	    ListNode ptr = head;
//	    int c = 0;
//	    while (ptr != null) {
//	      ptr = ptr.next;  
//	      c += 1;
//	    }
//	    return c;
//	  }
//
//	  private TreeNode convertListToBST(int l, int r) {
//	    // Invalid case
//	    if (l > r) {
//	      return null;
//	    }
//
//	    int mid = (l + r) / 2;
//
//	    // First step of simulated inorder traversal. Recursively form
//	    // the left half
//	    TreeNode left = this.convertListToBST(l, mid - 1);
//
//	    // Once left half is traversed, process the current node
//	    TreeNode node = new TreeNode(this.head.val);
//	    node.left = left;
//
//	    // Maintain the invariance mentioned in the algorithm
//	    this.head = this.head.next;
//
//	    // Recurse on the right hand side and form BST out of them
//	    node.right = this.convertListToBST(mid + 1, r);
//	    return node;
//	  }
//
//	  public TreeNode sortedListToBST(ListNode head) {
//	    // Get the size of the linked list first
//	    int size = this.findSize(head);
//
//	    this.head = head;
//
//	    // Form the BST now that we know the size
//	    return convertListToBST(0, size - 1);
//	  }
}
