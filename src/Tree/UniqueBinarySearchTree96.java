package Tree;

import org.junit.Test;

/**
 * @author he.wu Given n, how many structurally unique BST's (binary search
 *         trees) that store values 1 ... n?
 * 
 *         Example:
 * 
 *         Input: 3 Output: 5 Explanation: Given n = 3, there are a total of 5
 *         unique BST's:
 * 
 *         1 3 3 2 1 \ / / / \ \ 3 2 1 1 3 2 / / \ \ 2 1 2 3
 */
public class UniqueBinarySearchTree96 {

	// programming dynamique
	public int numTrees(int n) {
		int[] dp = new int[n + 1];
		dp[0] = 1;
		dp[1] = 1;
		for (int level = 2; level <= n; level++)
			for (int root = 0; root < level; root++)
				dp[level] += dp[level - root -1] * dp[root];
		return dp[n];
	}

	/*
	 * for ex n =5
	 * 
	 */
	public int numTrees2(int n) {
		if (n <= 1)
			return 1;
		int res = 0;
		for (int i = 0; i < n; i++) {
			res += numTrees2(i) * numTrees2(n - i - 1);
		}
		return res;
	}

	@Test
	public void test() {
		System.out.println(numTrees(4));
	}
}
