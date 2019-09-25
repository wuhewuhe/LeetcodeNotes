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
		if (nums.length == 0 || nums == null)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int[] dp = new int[nums.length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			int tem = dp[i - 2] + nums[i];
			dp[i] = Math.max(dp[i - 1], tem);
		}
		int max = Arrays.stream(dp).max().getAsInt();
		return max;
	}

	
	//dp bottom up 
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
		int prev2 = nums[0], prev1 = Math.max(nums[0], nums[1]);
		for (int i = 2; i < nums.length; i++) {
			int tem = prev1;
			prev1 = Math.max(prev2 + nums[i], prev1);
			prev2 = tem;
		}
		return prev1;
	}

//	// memorization
//	public int HouseRobber3(int[] nums) {
//
//	}

	// no dp, just understanding for question
	public int HouseRobber4(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;
		if (nums.length == 1)
			return nums[0];
		int prev = nums[0], max = 0;
		for (int i = 1; i < nums.length; i++) {
			int temp = prev;
			prev = max + nums[i];
			max = Math.max(temp, max);
		}
		return Math.max(max, prev);
	}
	
	int cache[];
	
	//recursion
	public int HouseRobber5(int[] nums, int i) {
		if (nums.length == 0 || nums == null)
			return 0;
		if (nums.length == 1)
			return nums[0];
		if(i<0) return 0;
		if(cache[i] != 0)
			return cache[i];
		int ith_house_select = HouseRobber5(nums, i-2) + nums[i];
		int ith_house_not_select = HouseRobber5(nums, i-1);
		return cache[i] = Math.max(ith_house_select, ith_house_not_select);
	}

	@Test
	public void test() {
		int[] nums = { 2, 7, 9, 3, 1 };
		System.out.println(HouseRobber4(nums));
		
		cache = new int[nums.length];
		System.out.println("robM2A1 result:" + HouseRobber5(nums, nums.length - 1));
	}

}
