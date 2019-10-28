package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
 * @author he.wu Given a binary tree, return the zigzag level order traversal of
 *         its nodes' values. (ie, from left to right, then right to left for
 *         the next level and alternate between).
 * 
 *         For example: Given binary tree [3,9,20,null,null,15,7], 3 / \ 9 20 /
 *         \ 15 7 return its zigzag level order traversal as: [ [3], [20,9],
 *         [15,7] ]
 */
public class BinaryTreeZigzagLevelOrderTraversal103 {
	public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		int i = 0;
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> tem = new ArrayList<Integer>();
			while (size-- > 0) {
				TreeNode p = queue.poll();
				if (p.left != null)
					queue.offer(p.left);
				if (p.right != null)
					queue.offer(p.right);
				tem.add(p.val);
			}
			if (i++ % 2 == 0)
				res.add(tem);
			else {
				Collections.reverse(tem);
				res.add(tem);
			}
		}
		return res;
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
		System.out.println(zigzagLevelOrder(p));
	}

}
