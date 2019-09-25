package Array;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

/**
 * @author he.wu Given an integer array nums, find the contiguous subarray
 *         within an array (containing at least one number) which has the
 *         largest product.
 * 
 *         Example 1:
 * 
 *         Input: [2,3,-2,4] Output: 6 Explanation: [2,3] has the largest
 *         product 6. Example 2:
 * 
 *         Input: [-2,0,-1] Output: 0 Explanation: The result cannot be 2,
 *         because [-2,-1] is not a subarray.
 */
public class MaximumProductSubarray152 {

	public int MaximumProductSubarray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int maxToCurrent = nums[0], minToCurrent = nums[0], sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int nextMax = maxToCurrent * nums[i];
			int nextMin = minToCurrent * nums[i];
			maxToCurrent = Math.max(nums[i], Math.max(nextMax, nextMin));
			minToCurrent = Math.min(nums[i], Math.min(nextMax, nextMin));
			sum = Math.max(sum, maxToCurrent);
		}
		return sum;
	}

	public int MinimumProductSubarray(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int maxToCurrent = nums[0], minToCurrent = nums[0], sum = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int nextMax = maxToCurrent * nums[i];
			int nextMin = minToCurrent * nums[i];
			maxToCurrent = Math.max(nums[i], Math.max(nextMax, nextMin));
			minToCurrent = Math.min(nums[i], Math.min(nextMax, nextMin));
			sum = Math.min(sum, minToCurrent);
		}
		return sum;
	}

	public int MaximumProductSubarray3(int[] nums) {
		if (nums.length == 0 || nums == null)
			return 0;
		int max = 0, min = 0, product = 0;
		for (int i = 1; i > nums.length; i++) {
			if (nums[i] < 0) {
				int temp = max;
				max = min;
				min = temp;
			}

			max *= nums[i];
			if (min > nums[i])
				min = nums[i];
			if (max > product)
				product = max;
		}
		return product;
	}

	// dynamic programming array
	public int MaximumProductSubarray2(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int[] dp = new int[nums.length];
		int maxToCurrent = nums[0], minToCurrent = nums[0];
		dp[0] = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int nextMax = maxToCurrent * nums[i];
			int nextMin = minToCurrent * nums[i];
			maxToCurrent = Math.max(nums[i], Math.max(nextMax, nextMin));
			minToCurrent = Math.min(nums[i], Math.min(nextMax, nextMin));
			dp[i] = Math.max(nums[i], maxToCurrent);
		}
		Arrays.sort(dp);
		return dp[dp.length - 1];
	}

	public int maxProduct(int[] nums) {
		int n = nums.length;
		if (n == 0)
			return 0;
		int[] maxprodtillnow = new int[n];
		int[] minprodtillnow = new int[n];
		maxprodtillnow[0] = nums[0];
		minprodtillnow[0] = nums[0];
		for (int i = 1; i < n; i++) {
			if (nums[i] >= 0) {
				maxprodtillnow[i] = Math.max(maxprodtillnow[i - 1] * nums[i], nums[i]);
				minprodtillnow[i] = Math.min(minprodtillnow[i - 1] * nums[i], nums[i]);
			} else {
				maxprodtillnow[i] = Math.max(minprodtillnow[i - 1] * nums[i], nums[i]);
				minprodtillnow[i] = Math.min(maxprodtillnow[i - 1] * nums[i], nums[i]);
			}
		}
		int maxval = Integer.MIN_VALUE;
		for (int i = 0; i < n; i++)
			if (maxval < maxprodtillnow[i])
				maxval = maxprodtillnow[i];
		return maxval;
	}

	@Test
	public void test() {
		int[] nums = { 2, 3, -2, 4 };
		System.out.println(maxProduct(nums));
	}
}
