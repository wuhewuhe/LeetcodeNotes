package Array;

import org.junit.Test;

/**
 * @author he.wu You are a professional robber planning to rob houses along a
 *         street. Each house has a certain amount of money stashed, the only
 *         constraint stopping you from robbing each of them is that adjacent
 *         houses have security system connected and it will automatically
 *         contact the police if two adjacent houses were broken into on the
 *         same night.
 * 
 *         Given a list of non-negative integers representing the amount of
 *         money of each house, determine the maximum amount of money you can
 *         rob tonight without alerting the police.
 * 
 *         Input: [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and
 *         then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
 * 
 *         Input: [2,7,9,3,1] Output: 12 Explanation: Rob house 1 (money = 2),
 *         rob house 3 (money = 9) and rob house 5 (money = 1). Total amount you
 *         can rob = 2 + 9 + 1 = 12.
 */
public class HouseRober198 {

	public int HouseRobber(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int[] robberies = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			robberies[i] = nums[i];
			for (int j = i - 2; j >= 0; j--) {
				robberies[i] = Math.max(robberies[i], nums[i] + robberies[j]);
			}
		}
		int max = Integer.MIN_VALUE;
		for (int i : robberies) {
			max = Math.max(i, max);
		}
		return max;
	}

	// dp bottom up
	public int HouseRobber2(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		return Math.max(dp[dp.length - 1], dp[dp.length - 2]);
	}

	// Method3()- ****most efficient solution****
	// time complexity - O(n)
	// space complexity - O(1)
	public int HouseRobber3(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int prev2 = 0, prev1 = 0;
		for (int i = 0; i < nums.length; i++) {
			int tem = Math.max(prev2+nums[i], prev1);
			prev2 = prev1;
			prev1 = tem;
		}
		return prev1;
	}

	int[] dp;

	public int rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		dp = new int[nums.length];
		return HouseRobber4(nums, nums.length - 1);
	}

	// memorization + recursion
	public int HouseRobber4(int[] nums, int i) {
		if (i < 0)
			return 0;
		if (dp[i] != 0)
			return dp[i];
		int ith_house_is_selected = HouseRobber4(nums, i - 2) + nums[i];
		int ith_house_is_not_selected = HouseRobber4(nums, i - 1);
		return dp[i] = Math.max(ith_house_is_selected, ith_house_is_not_selected);
	}

	@Test
	public void test() {
		int[] nums = { 2, 1, 1, 2 };
		System.out.println(HouseRobber3(nums));

	}

}
