package Tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
 * @author he.wu Given a binary tree, return the bottom-up level order traversal
 *         of its nodes' values. (ie, from left to right, level by level from
 *         leaf to root).
 * 
 *         For example: Given binary tree [3,9,20,null,null,15,7], 3 / \ 9 20 /
 *         \ 15 7 return its bottom-up level order traversal as: [ [15,7],
 *         [9,20], [3] ]
 */
public class BinaryTreeLevelOrderTravel107 {
	//reverse list
	public List<List<Integer>> levelOrderBottom(TreeNode root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> tem = new ArrayList<Integer>();
			while(size-->0) {
				TreeNode p = queue.poll();
				tem.add(p.val);
				if(p.left != null) queue.offer(p.left);
				if(p.right != null) queue.offer(p.right);
			}
			//res.add(tem);
			 res.add(0,tem);
		}
		//Collections.reverse(res);
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
		System.out.println(levelOrderBottom(p));
	}
}
