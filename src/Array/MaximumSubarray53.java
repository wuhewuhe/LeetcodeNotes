package Array;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author he.wu Given an integer array nums, find the contiguous subarray
 *         (containing at least one number) which has the largest sum and return
 *         its sum.
 * 
 *         Example:
 * 
 *         Input: [-2,1,-3,4,-1,2,1,-5,4], Output: 6 Explanation: [4,-1,2,1] has
 *         the largest sum = 6. Follow up:
 * 
 *         If you have figured out the O(n) solution, try coding another
 *         solution using the divide and conquer approach, which is more subtle.
 */
public class MaximumSubarray53 {

	// the largest sum in an array
	public int MaximumValue(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return nums[1];
		Arrays.sort(nums);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] > 0)
				sum += nums[i];
		}
		return sum;
	}

	// best solution
	public int MaximumSubarray(int[] nums) {
		int sum = 0, max = Integer.MIN_VALUE;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			if (sum > max)
				max = sum;
			if (sum < 0)
				sum = 0;
		}
		return max;
	}

	public int MaximumSubarray2(int[] nums) {
		int sum = 0, min = 0, max = Integer.MIN_VALUE;
		for (int i : nums) {
			sum+=i;
			if(sum -min > max) max = sum - min;
			if(min>sum) min = sum;
		}
		return max;
	}
	
	public int MaximumSubarray3(int[] nums) {
		int max = nums[0], sum = nums[0];
		for (int i = 0; i < nums.length; i++) {
			max = Math.max(nums[i], max+nums[i]);
			sum = Math.max(sum, max);
		}
		return sum;
	}
	
	//dynamic programming array
	public int MaximumSubarray4(int[] nums) {
		if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException();
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int maxSum = nums[0];
        //maximum sub array, so we have two choice, use this value or not
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxSum = Math.max(maxSum, dp[i]);
        }
        return maxSum;
	}

	@Test
	public void test() {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
		System.out.println(MaximumSubarray4(nums));
	}
}
