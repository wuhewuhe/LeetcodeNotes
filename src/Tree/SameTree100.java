package Tree;

import java.util.ArrayDeque;

import org.junit.Test;

/**
 * @author he.wu Given two binary trees, write a function to check if they are
 *         the same or not.
 * 
 *         Two binary trees are considered the same if they are structurally
 *         identical and the nodes have the same value.
 * 
 *         Example 1:
 * 
 *         Input: 1 1 / \ / \ 2 3 2 3
 * 
 *         [1,2,3], [1,2,3]
 * 
 *         Output: true Example 2:
 * 
 *         Input: 1 1 / \ 2 2
 * 
 *         [1,2], [1,null,2]
 * 
 *         Output: false Example 3:
 * 
 *         Input: 1 1 / \ / \ 2 1 1 2
 * 
 *         [1,2,1], [1,1,2]
 * 
 *         Output: false
 */

public class SameTree100 {

	// Definition for a binary tree node.
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	// recursion
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (p == null || q == null)
			return false;
		if (p.val != q.val)
			return false;
		return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
	}

	// iterator
	public boolean check(TreeNode p, TreeNode q) {
		// p and q are null
		if (p == null && q == null)
			return true;
		// one of p and q is null
		if (q == null || p == null)
			return false;
		if (p.val != q.val)
			return false;
		return true;
	}

	public boolean isSameTree2(TreeNode p, TreeNode q) {
		if (p == null && q == null)
			return true;
		if (!check(p, q))
			return false;

		// init deques
		ArrayDeque<TreeNode> deqP = new ArrayDeque<TreeNode>();
		ArrayDeque<TreeNode> deqQ = new ArrayDeque<TreeNode>();
		deqP.addLast(p);
		deqQ.addLast(q);

		while (!deqP.isEmpty()) {
			p = deqP.removeFirst();
			q = deqQ.removeFirst();

			if (!check(p, q))
				return false;
			if (p != null) {
				// in Java nulls are not allowed in Deque
				if (!check(p.left, q.left))
					return false;
				if (p.left != null) {
					deqP.addLast(p.left);
					deqQ.addLast(q.left);
				}
				if (!check(p.right, q.right))
					return false;
				if (p.right != null) {
					deqP.addLast(p.right);
					deqQ.addLast(q.right);
				}
			}
		}
		return true;
	}

	@Test
	public void test() {
		TreeNode p = new TreeNode(1);
		TreeNode p1 = new TreeNode(2);
		TreeNode p2 = new TreeNode(3);
		p.left = p1;
		p.right = p2;
		TreeNode q = new TreeNode(1);
		TreeNode q1 = new TreeNode(2);
		TreeNode q2 = new TreeNode(3);
		q.left = q1;
		q.right = q2;
		System.out.println(isSameTree(p, q));
	}

}
