package Tree;

import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given a binary tree, return the tilt of the whole tree.
 * 
 *         The tilt of a tree node is defined as the absolute difference between
 *         the sum of all left subtree node values and the sum of all right
 *         subtree node values. Null node has tilt 0.
 * 
 *         The tilt of the whole tree is defined as the sum of all nodes' tilt.
 * 
 *         Example: Input: 1 / \ 2 3 Output: 1 Explanation: Tilt of node 2 : 0
 *         Tilt of node 3 : 0 Tilt of node 1 : |2-3| = 1 Tilt of binary tree : 0
 *         + 0 + 1 = 1
 */
public class BinaryTreeTilt563 {

	// postorder
	int sum = 0;

	public int findTilt(TreeNode root) {
		helper(root);
		return sum;
	}

	public int helper(TreeNode root) {
		if (root == null)
			return 0;
		int left = helper(root.left);
		int right = helper(root.right);
		sum += Math.abs(left - right);
		return left + right + root.val;
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
		p2.left = p3;
		p2.right = p4;
		System.out.println(findTilt(p));
	}
}
