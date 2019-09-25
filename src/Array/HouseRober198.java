package Array;

import java.util.Arrays;

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
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = nums[1];
		for (int i = 2; i < nums.length; i++) {
			int tem = dp[i - 2] + nums[i];
			dp[i] = Math.max(dp[i - 1], tem);
		}
		int max = Arrays.stream(dp).max().getAsInt();
		return max;
	}

	@Test
	public void test() {
		int[] nums = { 2,7,9,3,1 };
		System.out.println(HouseRobber(nums));
	}
}
