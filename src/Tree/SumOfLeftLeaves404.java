package Tree;

import java.util.Stack;

import org.junit.Test;

/**
 * @author he.wu Find the sum of all left leaves in a given binary tree.
 * 
 *         Example:
 * 
 *         3 / \ 9 20 / \ 15 7
 * 
 *         There are two left leaves in the binary tree, with values 9 and 15
 *         respectively. Return 24.
 */
public class SumOfLeftLeaves404 {
	public int sumOfLeftLeaves(TreeNode root) {
		if (root == null)
			return 0;
		return helper(root, false);
	}

	private int helper(TreeNode root, boolean isLeft) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			if (isLeft)
				return root.val;
			else
				return 0;
		}
		return helper(root.left, true) + helper(root.right, false);
	}

	// iterative preorder root -> left - right
	public int sumOfLeftLeaves2(TreeNode root) {
		if (root == null)
			return 0;
		int ans = 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.empty()) {
			TreeNode node = stack.pop();
			if (node.right != null) {
				stack.push(node.right);
			}
			if (node.left != null) {
				if (node.left.left == null && node.left.right == null) {
					ans += node.left.val;
				}
				stack.push(node.left);
			}
		}
		return ans;
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
		System.out.println(sumOfLeftLeaves2(p));
	}

}
