package Tree;

import org.junit.Test;

/**
 * @author mac Given a binary tree, determine if it is height-balanced.
 * 
 *         For this problem, a height-balanced binary tree is defined as:
 * 
 *         a binary tree in which the left and right subtrees of every node
 *         differ in height by no more than 1.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Given the following tree [3,9,20,null,null,15,7]:
 * 
 *         3 / \ 9 20 / \ 15 7 Return true.
 * 
 *         Example 2:
 * 
 *         Given the following tree [1,2,2,3,3,null,null,4,4]:
 * 
 *         1 / \ 2 2 / \ 3 3 / \ 4 4
 */
public class BalancedBinaryTree110 {
	// recursion
	public boolean isBalanced(TreeNode root) {
		if (root == null)
			return true;
		return isHelper(root) != -1;
	}

	private int isHelper(TreeNode root) {
		if (root == null) {
			return 0;
		}
		int left = isHelper(root.left);
		int right = isHelper(root.right);
		if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
			return -1;
		}
		return Math.max(left, right) + 1;
	}

	@Test
	public void test() {
		TreeNode p = new TreeNode(3);
		TreeNode p1 = new TreeNode(9);
		TreeNode p2 = new TreeNode(20);
		TreeNode p3 = new TreeNode(15);
		TreeNode p4 = new TreeNode(7);
		p.left = p1;
		p.right = p2;
		p2.left=p3;
		p2.left=p4;
		System.out.println(isBalanced(p));
	}
}
