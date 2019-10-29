package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import org.junit.Test;

/**
 * @author he.wu Given an n-ary tree, return the level order traversal of its
 *         nodes' values. (ie, from left to right, level by level).
 * 
 *         For example, given a 3-ary tree:
 * 
 * 
 * 
 * 
 * 
 * 
 * 
 *         We should return its level order traversal:
 * 
 *         [ [1], [3,2,4], [5,6] ]
 * 
 * 
 *         Note:
 * 
 *         The depth of the tree is at most 1000. The total number of nodes is
 *         at most 5000.
 */
public class NArrayTreeLevelTravel429 {
	@Test
	public void test() {
		
	}

	public List<List<Integer>> levelOrder(Node root) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (root == null)
			return res;
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		while (!queue.isEmpty()) {
			int size = queue.size();
			List<Integer> tem = new ArrayList<Integer>();
			while (size-- > 0) {
				Node p = queue.poll();
				tem.add(p.val);
				if(p.children != null) {
					for (Node node : p.children) {
						queue.offer(node);
					}
				}
			}
			res.add(tem);
		}
		return res;
	}
}
