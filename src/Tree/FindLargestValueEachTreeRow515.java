package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
 * @author he.wu You need to find the largest value in each row of a binary
 *         tree.
 * 
 *         Example: Input:
 * 
 *         1 / \ 3 2 / \ \ 5 3 9
 * 
 *         Output: [1, 3, 9]
 */
public class FindLargestValueEachTreeRow515 {

	//bfs
	public List<Integer> largestValues(TreeNode root) {
		List<Integer> res = new ArrayList<Integer>();
		if (root == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			int max = Integer.MIN_VALUE;
			while (size-- > 0) {
				TreeNode p = queue.poll();
				max = Math.max(max, p.val);
				if(p.left != null) queue.offer(p.left);
				if(p.right != null) queue.offer(p.right);
			}
			res.add(max);
		}
		return res;
	}
	
	//recursion preorder 

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
		System.out.println(largestValues(p));
	}

}
