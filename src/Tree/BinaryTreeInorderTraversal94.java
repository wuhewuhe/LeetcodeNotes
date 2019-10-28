package Tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

import org.junit.Test;

/**
 * @author mac
 * 
 *         Given a binary tree, return the inorder traversal of its nodes'
 *         values.
 * 
 *         Example:
 * 
 *         Input: [1,null,2,3]
 * 
 *         1 \ 2 / 3
 * 
 *         Output: [1,3,2] Follow up: Recursive solution is trivial, could you
 *         do it iteratively?
 */
public class BinaryTreeInorderTraversal94 {
	List<Integer> list = new ArrayList<Integer>();

	// recursion
	public List<Integer> inorderTraversal(TreeNode node) {
		if (node != null) {
			list = inorderTraversal(node.left);
			list.add(node.val);
			list = inorderTraversal(node.right);
		}
		return list;
	}

	// Iterate, simulation by stack
	public List<Integer> inorderTraversal2(TreeNode curr) {
		List<Integer> res = new ArrayList<Integer>();
		Stack<TreeNode> stack = new Stack<TreeNode>();
		//TreeNode curr = node;
		while (curr != null || !stack.isEmpty()) {
			while (curr != null)
			{
				stack.push(curr);
				curr = curr.left;
			}
			curr = stack.pop();
			res.add(curr.val);
            curr = curr.right;
		}
		return res;
	}

	public void inOrder(TreeNode TreeNode) {
		if (TreeNode != null) {
			inOrder(TreeNode.left);
			System.out.println(TreeNode.val);
			inOrder(TreeNode.right);
		}
	}

	// morris travel

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
		list = inorderTraversal(p);
		System.out.println(list);
	}
}
