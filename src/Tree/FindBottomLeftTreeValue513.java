package Tree;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * @author he.wu Given a binary tree, find the leftmost value in the last row of
 *         the tree.
 * 
 *         Example 1: Input:
 * 
 *         2 / \ 1 3
 * 
 *         Output: 1 Example 2: Input:
 * 
 *         1 / \ 2 3 / / \ 4 5 6 / 7
 * 
 *         Output: 7
 */

public class FindBottomLeftTreeValue513 {
	int ans = 0, h = 0;

	public int findBottomLeftValue(TreeNode root) {
		if (root == null)
			return 0;
		helper(root, 1);
		return ans;
	}

	private void helper(TreeNode root, int depth) {
		if (h < depth) {
			ans = root.val;
			h = depth;
		}
		if (root.left != null)
			helper(root.left, depth + 1);
		if (root.right != null)
			helper(root.right, depth + 1);
	}

	// iterative queue
	public int findLeftMostNode(TreeNode root) {
		if (root == null)
			return 0;

		int result = 0;
		Queue<TreeNode> queue = new LinkedList<>();
		queue.add(root);

		while (!queue.isEmpty()) {
			int size = queue.size();
			for (int i = 0; i < size; i++) {
				TreeNode node = queue.poll();
				if (i == 0)
					result = node.val;
				if (node.left != null)
					queue.add(node.left);
				if (node.right != null)
					queue.add(node.right);
			}
		}

		return result;
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
		System.out.println(findBottomLeftValue(p));
	}
}
