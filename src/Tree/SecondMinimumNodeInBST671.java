package Tree;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

/**
 * @author he.wu Given a non-empty special binary tree consisting of nodes with
 *         the non-negative value, where each node in this tree has exactly two
 *         or zero sub-node. If the node has two sub-nodes, then this node's
 *         value is the smaller value among its two sub-nodes. More formally,
 *         the property root.val = min(root.left.val, root.right.val) always
 *         holds.
 * 
 *         Given such a binary tree, you need to output the second minimum value
 *         in the set made of all the nodes' value in the whole tree.
 * 
 *         If no such second minimum value exists, output -1 instead.
 * 
 *         Example 1:
 * 
 *         Input: 2 / \ 2 5 / \ 5 7
 * 
 *         Output: 5 Explanation: The smallest value is 2, the second smallest
 *         value is 5.
 * 
 * 
 *         Example 2:
 * 
 *         Input: 2 / \ 2 2
 * 
 *         Output: -1 Explanation: The smallest value is 2, but there isn't any
 *         second smallest value.
 */
public class SecondMinimumNodeInBST671 {
	@Test
	public void test() {
		TreeNode p = new TreeNode(2);
		TreeNode p1 = new TreeNode(2);
		TreeNode p2 = new TreeNode(2);
		TreeNode p3 = new TreeNode(2);
		TreeNode p4 = new TreeNode(Integer.MAX_VALUE);
		p.left = p1;
		p.right = p2;
		p2.left = p3;
		p2.right = p4;
		System.out.println(findSecondMinimumValue2(p));
	}

	public int findSecondMinimumValue(TreeNode root) {
		Set<Integer> set = new HashSet<Integer>();
		helper(set, root);
		if (set.size() < 2)
			return -1;
		else {
			List<Integer> res = set
					// Create stream from the Set
					.stream()
					// Convert the set to list and collect it
					.collect(Collectors.toList());
			Collections.sort(res);
			return res.get(1);
		}
	}

	public void helper(Set<Integer> set, TreeNode root) {
		if (root != null) {
			set.add(root.val);
			helper(set, root.left);
			helper(set, root.right);
		}
	}
	
	 public void dfs(TreeNode root, Set<Integer> uniques) {
	        if (root != null) {
	            uniques.add(root.val);
	            dfs(root.left, uniques);
	            dfs(root.right, uniques);
	        }
	    }
	    public int findSecondMinimumValue2(TreeNode root) {
	        Set<Integer> uniques = new HashSet<Integer>();
	        dfs(root, uniques);

	        int min1 = root.val;
	        long ans = Long.MAX_VALUE;
	        for (int v : uniques) {
	            if (min1 < v && v < ans) ans = v;
	        }
	        return ans < Long.MAX_VALUE ? (int) ans : -1;
	    }
}
