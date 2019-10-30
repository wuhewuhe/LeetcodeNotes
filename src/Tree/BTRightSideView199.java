package Tree;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

/**
 * @author he.wu Given a binary tree, imagine yourself standing on the right
 *         side of it, return the values of the nodes you can see ordered from
 *         top to bottom.
 * 
 *         Example:
 * 
 *         Input: [1,2,3,null,5,null,4] Output: [1, 3, 4] Explanation:
 * 
 *         1 <--- / \ 2 3 <--- \ \ 5 4 <---
 */
public class BTRightSideView199 {
	public List<Integer> rightSideView(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		helper(root, res, 0);
		return res;
	}

	private void helper(TreeNode root, List<Integer> res, int depth) {
		if (root == null)
			return;
		if(depth == res.size())
			res.add(root.val);
		helper(root.right,res,depth+1);
		helper(root.left,res,depth+1);
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
		System.out.println(rightSideView(p));
	}
}
