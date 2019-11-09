package Tree;

import org.junit.Test;

/**
 * @author mac Given a binary tree, find its minimum depth.
 * 
 *         The minimum depth is the number of nodes along the shortest path from
 *         the root node down to the nearest leaf node.
 * 
 *         Note: A leaf is a node with no children.
 * 
 *         Example:
 * 
 *         Given binary tree [3,9,20,null,null,15,7],
 * 
 *         3 / \ 9 20 / \ 15 7 return its minimum depth = 2.
 */
public class MinimumDepthTree111 {
	public int minDepth(TreeNode root) {
		 if(root == null) return 0;
	        int left = minDepth(root.left);
	        int right = minDepth(root.right);
	        return (left == 0 || right == 0) ? left + right + 1: Math.min(left,right) + 1;
	       
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
		System.out.println(minDepth(p));
	}

}
