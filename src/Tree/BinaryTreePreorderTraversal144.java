package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * @author he.wu Given a binary tree, return the preorder traversal of its
 *         nodes' values.
 * 
 *         Example:
 * 
 *         Input: [1,null,2,3] 1 \ 2 / 3
 * 
 *         Output: [1,2,3] Follow up: Recursive solution is trivial, could you
 *         do it iteratively?
 */
public class BinaryTreePreorderTraversal144 {
	public List<Integer> inOrderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (!stack.isEmpty() || root != null) {
			while (root != null) {
				stack.push(root);
				root = root.left;
			}
			root = stack.pop();
			res.add(root.val);
			root = root.right;
		}
		return res;
	}

	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		stack.push(root);
		while (!stack.isEmpty()) {
			root = stack.pop();
			res.add(root.val);
			if(root.right != null) 
				stack.push(root.right);
			if(root.left != null)
				stack.push(root.left);
		}
		return res;
	}

	// recursive
	public List<Integer> preorderTraversal2(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		helper(root, res);
		return res;
	}

	private void helper(TreeNode root, List<Integer> res) {
		if (root != null) {
			res.add(root.val);
			helper(root.left, res);
			helper(root.right, res);
		}

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
		List<Integer> res = preorderTraversal(p);
		System.out.println(res);
	}
}
