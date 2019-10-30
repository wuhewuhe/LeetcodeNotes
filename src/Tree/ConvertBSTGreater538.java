package Tree;

import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given a Binary Search Tree (BST), convert it to a Greater Tree
 *         such that every key of the original BST is changed to the original
 *         key plus sum of all keys greater than the original key in BST.
 * 
 *         Example:
 * 
 *         Input: The root of a Binary Search Tree like this: 5 / \ 2 13
 * 
 *         Output: The root of a Greater Tree like this: 18 / \ 20 13
 */
public class ConvertBSTGreater538 {
	int sum = 0;
	public TreeNode convertBST(TreeNode root) {
		helper(root);
		return root;
	}
	private void helper(TreeNode root) {
		if(root == null) return;
		helper(root.right);
		sum+=root.val;
		root.val = sum;
		helper(root.left);
	}

	@Test
	public void test() {
		TreeNode p = new TreeNode(3);
		TreeNode p1 = new TreeNode(9);
		TreeNode p2 = new TreeNode(20);
		
		p.left = p1;
		p.right = p2;

		System.out.println(convertBST(p));
	}
}
