package Tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given a binary search tree, write a function kthSmallest to
 *         find the kth smallest element in it.
 * 
 *         Note: You may assume k is always valid, 1 ≤ k ≤ BST's total elements.
 * 
 *         Example 1:
 * 
 *         Input: root = [3,1,4,null,2], k = 1 3 / \ 1 4 \ 2 Output: 1 Example
 *         2:
 * 
 *         Input: root = [5,3,6,2,4,null,null,1], k = 3 5 / \ 3 6 / \ 2 4 / 1
 *         Output: 3
 */
public class KthSmallest230 {
	@Test
	public void test() {
		TreeNode p = new TreeNode(10);
		TreeNode p1 = new TreeNode(9);
		TreeNode p2 = new TreeNode(15);
		TreeNode p3 = new TreeNode(11);
		TreeNode p4 = new TreeNode(20);
		p.left = p1;
		p.right = p2;
		p2.left = p3;
		p2.right = p4;
		System.out.println(kthSmallest(p,1));
	}

	public int kthSmallest(TreeNode root, int k) {
		List<Integer> res = new ArrayList<Integer>();
		helper(res, root);
		return k > res.size() ? res.get(res.size()-1) : res.get(k-1);
	}

	private void helper(List<Integer> res, TreeNode root) {
		if (root != null) {
			helper(res, root.left);
			res.add(root.val);
			helper(res, root.right);
		}
	}
}
