package Tree;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * @author he.wu Invert a binary tree.
 * 
 *         Example:
 * 
 *         Input:
 * 
 *         4 / \ 2 7 / \ / \ 1 3 6 9 Output:
 * 
 *         4 / \ 7 2 / \ / \ 9 6 3 1
 */
public class InvertBinaryTree226 {
	// recursion
	public TreeNode invertTree(TreeNode root) {
		if (root == null)
			return null;
		TreeNode right = invertTree(root.right);
		TreeNode left = invertTree(root.left);
		root.left = right;
		root.right = left;
		return root;
	}

	// iterative bfs swap treenode
	public TreeNode invertTree2(TreeNode root) {
		if (root == null)
			return null;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			TreeNode cur = queue.poll();
			TreeNode tem = cur.left;
			cur.left = cur.right;
			cur.right = tem;
			if (cur.left != null)
				queue.offer(cur.left);
			if (cur.right != null)
				queue.offer(cur.right);
		}
		return root;
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
		System.out.println(invertTree(p1));
	}
}
