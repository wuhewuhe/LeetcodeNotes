package Array;

import org.junit.Test;

/**
 * @author he.wu Given an array consisting of n integers, find the contiguous
 *         subarray of given length k that has the maximum average value. And
 *         you need to output the maximum average value.
 * 
 *         Example 1:
 * 
 *         Input: [1,12,-5,-6,50,3], k = 4 Output: 12.75 Explanation: Maximum
 *         average is (12-5-6+50)/4 = 51/4 = 12.75
 * 
 * 
 *         Note:
 * 
 *         1 <= k <= n <= 30,000. Elements of the given array will be in the
 *         range [-10,000, 10,000].
 */
public class MaximumAverageSubarray643 {

	// cumulative sum time o(n) space o(n)
	/*
	 * We know that in order to obtain the averages of subarrays with length k, we
	 * need to obtain the sum of these kk length subarrays sum[i] - sum[i-k],by
	 * doing more one iteration over the sum array, and determine the maximum
	 * average
	 * 
	 */
	public double FindMaxAverage(int[] nums, int k) {
		int[] sum = new int[nums.length];
		sum[0] = nums[0];
		for (int i = 1; i < nums.length; i++)
			sum[i] = sum[i - 1] + nums[i];
		double res = sum[k - 1] * 1.0 / k;
		for (int i = k; i < nums.length; i++) {
			res = Math.max(res, (sum[i] - sum[i - k]) * 1.0 / k);
		}
		return res;
	}

	public double FindMaxAverage2(int[] nums, int k) {
		double sum = 0;
		for (int i = 0; i < k; i++) {
			sum+=nums[i];
		}
		double res = sum;
		for(int i =k;i<nums.length;i++) {
			sum += (nums[i] - nums[i-k]);
			res =Math.max(sum, res);
		}
		return res/4;
	}

	@Test
	public void test() {
		int[] nums = { 1, 12, -5, -6, 50, 3 };
		int k = 4;
		System.out.println(FindMaxAverage2(nums, k));
	}
}
