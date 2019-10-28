package Tree;

import java.util.Stack;

import org.junit.Test;

/**
 * @author he.wu Given a binary tree, determine if it is a valid binary search
 *         tree (BST).
 * 
 *         Assume a BST is defined as follows:
 * 
 *         The left subtree of a node contains only nodes with keys less than
 *         the node's key. The right subtree of a node contains only nodes with
 *         keys greater than the node's key. Both the left and right subtrees
 *         must also be binary search trees.
 * 
 *         Example 1:
 * 
 *         2 / \ 1 3
 * 
 *         Input: [2,1,3] Output: true Example 2:
 * 
 *         5 / \ 1 4 / \ 3 6
 * 
 *         Input: [5,1,4,null,null,3,6] Output: false Explanation: The root
 *         node's value is 5 but its right child's value is 4.
 * 
 */
public class ValidateBinarySearchTree98 {

	// recursion
	public boolean isValidBST(TreeNode root) {
		return helper(root, null, null);
	}

	public boolean helper(TreeNode root, Integer low, Integer up) {
		if (root == null)
			return true;
		int val = root.val;
		if (low != null && val <= low)
			return false;
		if (up != null && val >= up)
			return false;
		if (!helper(root.right, val, up))
			return false;
		if (!helper(root.left, low, val))
			return false;
		return true;
	}

	// Iterative
//	LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
//	LinkedList<Integer> uppers = new LinkedList<Integer>(), lowers = new LinkedList<Integer>();
//
//	public void update(TreeNode root, Integer lower, Integer upper) {
//		stack.add(root);
//		lowers.add(lower);
//		uppers.add(upper);
//	}
//
//	public boolean isValidBST2(TreeNode root) {
//		Integer low = null, up = null, val;
//		update(root, low, up);
//
//		while (!stack.isEmpty()) {
//			root = stack.poll();
//			low = lowers.poll();
//			up = uppers.poll();
//			if (root == null)
//				continue;
//			val = root.val;
//			if (low != null && val <= low)
//				return false;
//			if (up != null && val >= up)
//				return false;
//			update(root.right, val, up);
//			update(root.left, low, val);
//		}
//		return true;
//	}

	/*
	 * DFS postorder is from bottom to top left -> right-> mid DFS pre-order is from
	 * top to bottom, mid -> left -> right DFS in-order is from bottom to top, left
	 * -> mid -> right BFS if from top to bottom, left to right
	 */
	public boolean isValidBST3(TreeNode cur) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		double inorder = -Double.MAX_VALUE;
		while (cur != null || !stack.isEmpty()) {
			while (cur != null) {
				stack.add(cur);
				cur = cur.left;
			}
			cur = stack.pop();
			if (cur.val <= inorder)
				return false;
			inorder = cur.val;
			cur = cur.right;
		}
		return true;
	}

	@Test
	public void test() {
		TreeNode p1 = new TreeNode(5);
		TreeNode p2 = new TreeNode(1);
		TreeNode p3 = new TreeNode(4);
		TreeNode p4 = new TreeNode(3);
		TreeNode p5 = new TreeNode(6);
		p1.left = p2;
		p1.right = p3;
		p3.left = p4;
		p3.right = p5;
		System.out.println(isValidBST3(p1));
	}
}
