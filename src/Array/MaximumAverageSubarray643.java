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
	
	//cumulative sum
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

	@Test
	public void test() {
		int[] nums = { 1, 12, -5, -6, 50, 3 };
		int k = 4;
		System.out.println(FindMaxAverage(nums, k));
	}
}
