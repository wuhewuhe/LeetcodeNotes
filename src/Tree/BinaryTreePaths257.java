package Tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given a binary tree, return all root-to-leaf paths.
 * 
 *         Note: A leaf is a node with no children.
 * 
 *         Example:
 * 
 *         Input:
 * 
 *         1 / \ 2 3 \ 5
 * 
 *         Output: ["1->2->5", "1->3"]
 * 
 *         Explanation: All root-to-leaf paths are: 1->2->5, 1->3
 */
public class BinaryTreePaths257 {
	// recursion
	public List<String> binaryTreePaths(TreeNode root) {
		List<String> res = new ArrayList<String>();
		if (root == null)
			return res;
		helper(root, "", res);
		return res;
	}

	private void helper(TreeNode root, String path, List<String> res) {
		if (root.left == null && root.right == null)
			res.add(path + root.val);
		if (root.left != null)
			helper(root.left, path + root.val + "->", res);
		if (root.right != null)
			helper(root.right, path + root.val + "->", res);
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
		System.out.println(binaryTreePaths(p));
	}
}
