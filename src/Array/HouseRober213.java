package Array;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author he.wu You are a professional robber planning to rob houses along a
 *         street. Each house has a certain amount of money stashed. All houses
 *         at this place are arranged in a circle. That means the first house is
 *         the neighbor of the last one. Meanwhile, adjacent houses have
 *         security system connected and it will automatically contact the
 *         police if two adjacent houses were broken into on the same night.
 * 
 *         Given a list of non-negative integers representing the amount of
 *         money of each house, determine the maximum amount of money you can
 *         rob tonight without alerting the police.
 * 
 *         Example 1:
 * 
 *         Input: [2,3,2] Output: 3 Explanation: You cannot rob house 1 (money =
 *         2) and then rob house 3 (money = 2), because they are adjacent
 *         houses. Example 2:
 * 
 *         Input: [1,2,3,1] Output: 4 Explanation: Rob house 1 (money = 1) and
 *         then rob house 3 (money = 3). Total amount you can rob = 1 + 3 = 4.
 */
public class HouseRober213 {

	// dp, two possible take first and give up last or take last and ignore first
	// time o(n) space o(n)
	public int Rob(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int[] dp = new int[nums.length];
		int max = 0;
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		int last = nums[nums.length - 1];
		nums[nums.length - 1] = 0;
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		max = Math.max(dp[nums.length - 1], dp[nums.length - 2]);
		Arrays.fill(dp, 0);
		nums[nums.length - 1] = last;
		nums[0] = 0;
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
		}
		max = Math.max(max, Math.max(dp[nums.length - 1], dp[nums.length - 2]));
		return max;
	}

	// same like the house rob 1 and add constraint: if u rob the first and then can
	// not rob last vice versa, time o(n) space o(1)
	public int Rob2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if(nums.length == 2) return Math.max(nums[0], nums[1]);
		int left = 0, right = nums.length-1;
		return Math.max(Rob2(nums, left, right), Rob2(nums, left + 1, right + 1));
	}

	public int Rob2(int[] nums, int left, int right) {
		int pre2 = 0, pre1 = 0;
		for (; left < right; left++) {
			int tem = Math.max(pre1, pre2 + nums[left]);
			pre2 = pre1;
			pre1 = tem;
		}
		return pre1;
	}

	@Test
	public void test() {
		int[] nums = { 1,2,3,1 };
		System.out.println(Rob2(nums));
	}
}
