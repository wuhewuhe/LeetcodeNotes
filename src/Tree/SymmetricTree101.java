package Tree;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * @author mac Given a binary tree, check whether it is a mirror of itself (ie,
 *         symmetric around its center).
 * 
 *         For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 * 
 *         1 / \ 2 2 / \ / \ 3 4 4 3
 * 
 * 
 *         But the following [1,2,2,null,3,null,3] is not:
 * 
 *         1 / \ 2 2 \ \ 3 3
 * 
 * 
 *         Note: Bonus points if you could solve it both recursively and
 *         iteratively.
 */
public class SymmetricTree101 {

	// recursion
	public boolean isSymmetric(TreeNode root) {
		return isHelper(root, root);
	}

	private boolean isHelper(TreeNode root1, TreeNode root2) {
		if (root1 == null && root2 == null)
			return true;
		if (root1 == null || root2 == null)
			return false;
		return root1.val == root2.val && isHelper(root1.left, root2.right) && isHelper(root1.right, root2.left);
	}

	// Iterative BFS
	public boolean isSymmetric2(TreeNode root) {
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.add(root);
		queue.add(root);
		while (!queue.isEmpty()) {
			TreeNode p = queue.poll();
			TreeNode q = queue.poll();
			if (p == null && q == null)
				continue;
			if (p == null || q == null)
				return false;
			if (p.val != q.val)
				return false;
			queue.add(p.left);
			queue.add(q.right);
			queue.add(p.right);
			queue.add(q.left);
		}
		return true;
	}

	
	@Test
	public void test() {
		TreeNode p1 = new TreeNode(1);
		TreeNode p2 = new TreeNode(2);
		TreeNode q2 = new TreeNode(2);
		TreeNode p3 = new TreeNode(3);
		TreeNode q3 = new TreeNode(4);
		TreeNode p32 = new TreeNode(4);
		TreeNode q32 = new TreeNode(3);
		p1.left = p2;
		p1.right = q2;
		p2.left = p3;
		p2.right = q3;
		q2.left = p32;
		q2.right = q32;
		System.out.println(isSymmetric2(p1));
	}

}
