package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * @author he.wu Given a binary search tree with non-negative values, find the
 *         minimum absolute difference between values of any two nodes.
 * 
 *         Example:
 * 
 *         Input:
 * 
 *         1 \ 3 / 2
 * 
 *         Output: 1
 * 
 *         Explanation: The minimum absolute difference is 1, which is the
 *         difference between 2 and 1 (or between 2 and 3).
 * 
 * 
 *         Note: There are at least two nodes in this BST.
 */
public class MinimumAbsoluteDifferenceBST530 {
	int minDiff = Integer.MAX_VALUE;
	TreeNode prev;

	public int getMinimumDifference(TreeNode root) {
		inorder(root);
		return minDiff;
	}

	public void inorder(TreeNode root) {
		if (root == null)
			return;
		inorder(root.left);
		if (prev != null)
			minDiff = Math.min(minDiff, root.val - prev.val);
		prev = root;
		inorder(root.right);
	}

	public int getMinimumDifference2(TreeNode root) {
		if (root == null)
			return 0;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode prev = null;
		int min = Integer.MAX_VALUE;
		//inorder traverse this tree;
		while (root != null || !stack.isEmpty()) {
			while(root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			if(prev != null)
				min = Math.min(min, root.val -prev.val);
			prev = root;
			root = root.right;
		}
		return min;
	}
		
	@Test
	public void test() {
		TreeNode p = new TreeNode(1);
		TreeNode p1 = new TreeNode(3);
		TreeNode p2 = new TreeNode(2);
		p.right = p1;
		p1.left = p2;
		System.out.println(getMinimumDifference2(p));
	}

}
