package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class BinaryTreeLevelOrder102 {
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
		System.out.println(levelTravel2(p));
	}

	// recursion
	private List<List<Integer>> levelTravel(TreeNode p) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (p == null)
			return list;
		helper(p, list);
		return list;
	}

	private void helper(TreeNode p, List<List<Integer>> list) {
		// TODO Auto-generated method stub

	}

	// iterative queue bfs
	private List<List<Integer>> levelTravel2(TreeNode p) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (p == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(p);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> list = new LinkedList<Integer>();
			while (size-- > 0) {
				TreeNode pp = queue.poll();
				list.add(pp.val);
				if (pp.left != null)
					queue.offer(pp.left);
				if (pp.right != null)
					queue.offer(pp.right);
			}
			res.add(list);
		}
		return res;
	}
}
