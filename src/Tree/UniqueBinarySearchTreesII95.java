package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @author he.wu Given an integer n, generate all structurally unique BST's
 *         (binary search trees) that store values 1 ... n.
 * 
 *         Example:
 * 
 *         Input: 3 Output: [ [1,null,3,2], [3,2,null,1], [3,1,null,null,2],
 *         [2,1,3], [1,null,2,null,3] ] Explanation: The above output
 *         corresponds to the 5 unique BST's shown below:
 * 
 *         1 3 3 2 1 \ / / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
 */
public class UniqueBinarySearchTreesII95 {

//	public TreeNode[] recursion(int s, int e, int[] dp) {
//		TreeNode[] roots = null;
//		int curlen = 0;
//		if (s > e) {
//			roots = new TreeNode[1];
//			roots[0] = null;
//			return roots;
//		}
//		roots = new TreeNode[dp[e - s + 1]];
//		for (int i = s; i <= e; i++) {
//			TreeNode[] lefts = recursion(s, i - 1, dp);
//			TreeNode[] rights = recursion(i + 1, e, dp);
//			for (TreeNode left : lefts) {
//				for (TreeNode right : rights) {
//					TreeNode root = new TreeNode(i);
//					root.left = left;
//					root.right = right;
//					roots[curlen++] = root;
//				}
//			}
//		}
//		return roots;
//	}
//
//	public List<TreeNode> generateTrees(int n) {
//		if (n == 0)
//			return new ArrayList<TreeNode>();
//		else {
//			int[] dp = new int[n + 1];
//			dp[0] = 1;
//			dp[1] = 1;
//			for (int i = 2; i <= n; i++)
//				for (int j = 1; j <= i; j++)
//					dp[i] += dp[j - 1] * dp[i - j];
//			TreeNode[] resarr = recursion(1, n, dp);
//			List<TreeNode> res = new ArrayList<>();
//			for (TreeNode node : resarr) {
//				res.add(node);
//			}
//			return res;
//		}
//	}

	public List<TreeNode> generateTrees(int n) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		if (n == 0)
			return list;
		return generateTree(1, n + 1);

	}

	private List<TreeNode> generateTree(int min, int max) {
		List<TreeNode> list = new ArrayList<TreeNode>();
		// base case
		if (min >= max) {
			TreeNode node = null;
			list.add(node);
		}
		// general case
		for (int i = min; i < max; i++) {
			List<TreeNode> left = generateTree(min, i);
			List<TreeNode> right = generateTree(i + 1, max);
			for (int p = 0; p < left.size(); p++) {
				for (int q = 0; q < right.size(); q++) {
					TreeNode root = new TreeNode(i);
					root.left = left.get(p);
					root.right = right.get(q);
					list.add(root);
				}
			}
		}
		return list;
	}
}
