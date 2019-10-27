package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

public class AverageOfLevel637 {
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
		System.out.println(levelTravelAverage(p));
	}

	private List<Double> levelTravelAverage(TreeNode p) {
		// TODO Auto-generated method stub
		List<Double> res = new ArrayList<Double>();
		if (p == null)
			return res;
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(p);
		while (!queue.isEmpty()) {
			int size = queue.size();
			double sum = 0, copy = size;
			while (size-- > 0) {
				TreeNode pp = queue.poll();
				sum += pp.val;
				if (pp.left != null)
					queue.offer(pp.left);
				if (pp.right != null)
					queue.offer(pp.right);
			}
			sum = sum / copy;
			res.add(sum);
		}
		return res;
	}

}
