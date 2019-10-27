package Tree;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * @author mac Given a binary tree, find its maximum depth.
 * 
 *         The maximum depth is the number of nodes along the longest path from
 *         the root node down to the farthest leaf node.
 * 
 *         Note: A leaf is a node with no children.
 * 
 *         Example:
 * 
 *         Given binary tree [3,9,20,null,null,15,7],
 * 
 *         3 / \ 9 20 / \ 15 7 return its depth = 3.
 */
public class MaximumDepthBinaryTree104 {
	// recursion dfs
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		// return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return 1 + Math.max(left, right);
	}

	// Iterative bfs queue
	public int maxDepth2(TreeNode root) {
		if (root == null)
			return 0;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int count = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			while (size-- > 0) {
				TreeNode node = queue.poll();
				if (node.left != null) {
					queue.offer(node.left);
				}
				if (node.right != null) {
					queue.offer(node.right);
				}
			}
			count++;
		}
		return count;
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
		System.out.println(maxDepth(p));
	}
}
