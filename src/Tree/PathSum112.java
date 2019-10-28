package Tree;

import java.util.Stack;

/**
 * @author he.wu Given a binary tree and a sum, determine if the tree has a
 *         root-to-leaf path such that adding up all the values along the path
 *         equals the given sum.
 * 
 *         Note: A leaf is a node with no children.
 * 
 *         Example:
 * 
 *         Given the below binary tree and sum = 22,
 * 
 *         5 / \ 4 8 / / \ 11 13 4 / \ \ 7 2 1 return true, as there exist a
 *         root-to-leaf path 5->4->11->2 which sum is 22.
 */
public class PathSum112 {
	// recursion
	public boolean hasPathSum(TreeNode root, int sum) {
		if (root == null)
			return false;

		if (root.left == null && root.right == null)
			return sum == root.val;

		return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
	}

	// iterative
//	public boolean hasPathSum2(TreeNode root, int sum) {
//		if (root == null)
//			return false;
//		Stack<TreeNode> stack = new Stack<TreeNode>();
//		TreeNode prev = null;
//		while (root != null || !stack.isEmpty()) {
//			while (root != null) {
//				stack.add(root);
//				sum -= root.val;
//				prev = root;
//				root = root.left;
//			}
//		}
//	}
	public boolean HasPathSum(TreeNode root, int sum) {
		if (root == null) return false;
		Stack<TreeNode> s = new Stack<>();
		s.push(root);
		while (!s.isEmpty()) {    
			TreeNode curr = s.pop();
			// From root to leaf;
			if (curr.left == null && curr.right == null && curr.val == sum) return true;

			if (curr.left != null){
				curr.left.val += curr.val;
				s.push(curr.left);
			}
			if (curr.right != null){
				curr.right.val += curr.val;
				s.push(curr.right);
			}
		}
		return false;
	}
}
