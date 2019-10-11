package ProgrammingDynamique;

/**
 * @author he.wu Given n balloons, indexed from 0 to n-1. Each balloon is
 *         painted with a number on it represented by array nums. You are asked
 *         to burst all the balloons. If the you burst balloon i you will get
 *         nums[left] * nums[i] * nums[right] coins. Here left and right are
 *         adjacent indices of i. After the burst, the left and right then
 *         becomes adjacent.
 * 
 *         Find the maximum coins you can collect by bursting the balloons
 *         wisely.
 * 
 *         Note:
 * 
 *         You may imagine nums[-1] = nums[n] = 1. They are not real therefore
 *         you can not burst them. 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100 Example:
 * 
 *         Input: [3,1,5,8] Output: 167 Explanation: nums = [3,1,5,8] -->
 *         [3,5,8] --> [3,8] --> [8] --> [] coins = 3*1*5 + 3*5*8 + 1*3*8 +
 *         1*8*1 = 167
 */
public class BrustBallon312 {
	public int maxCoins(int[] nums) {
		int n = nums.length;
		if (n <= 0)
			return 0;
		int[][] DP = new int[n][n];
		for (int len = 1; len <= n; len++) {//brust one ballon to n ballon
			for (int i = 0; i <= n - len; i++) {
				int j = i + len - 1;
				int max = 0;
				for (int k = i; k <= j; k++) {
					int left = i == 0 ? 1 : nums[i - 1];
					int right = j == n - 1 ? 1 : nums[j + 1];
					int leftVal = k == i ? 0 : DP[i][k - 1];
					int rightVal = k == j ? 0 : DP[k + 1][j];
					max = Math.max(max, left * nums[k] * right + leftVal + rightVal);
				}
				DP[i][j] = max;
			}
		}
		return DP[0][n - 1];

	}
}
