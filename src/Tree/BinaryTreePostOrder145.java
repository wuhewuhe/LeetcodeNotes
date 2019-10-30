package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * @author he.wu Given a binary tree, return the postorder traversal of its
 *         nodes' values.
 * 
 *         Example:
 * 
 *         Input: [1,null,2,3] 1 \ 2 / 3
 * 
 *         Output: [3,2,1] Follow up: Recursive solution is trivial, could you
 *         do it iteratively?
 */
public class BinaryTreePostOrder145 {
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
		List<Integer> res = postorderTraversal2(p);
		System.out.println(res);
	}

	// recursion
	public List<Integer> postorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		helper(root, res);
		return res;
	}

	private void helper(TreeNode root, List<Integer> res) {
		if (root != null) {
			helper(root.left, res);
			helper(root.right, res);
			res.add(root.val);
		}
	}

	// iterative stack
	public List<Integer> postorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			TreeNode curr = stack.pop();
			res.add(0, curr.val);
			if (curr.left != null)
				stack.push(curr.left);
			if (curr.right != null)
				stack.push(curr.right);
		}
		return res;
	}

}
