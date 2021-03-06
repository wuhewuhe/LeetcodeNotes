package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;

/**
 * @author mac Given an unsorted array of integers, find the length of longest
 *         increasing subsequence.
 * 
 *         Example:
 * 
 *         Input: [10,9,2,5,3,7,101,18] Output: 4 Explanation: The longest
 *         increasing subsequence is [2,3,7,101], therefore the length is 4.
 *         Note:
 * 
 *         There may be more than one LIS combination, it is only necessary for
 *         you to return the length. Your algorithm should run in O(n2)
 *         complexity. Follow up: Could you improve it to O(n log n) time
 *         complexity?
 */

public class LongestIncreasingSubsequence300 {
	public int lengthOfLIS(int[] nums) {
		if (nums.length == 0) {
			return 0;
		}
		int[] dp = new int[nums.length];
		dp[0] = 1;
		int maxans = 1;
		for (int i = 1; i < dp.length; i++) {
			int maxval = 0;
			for (int j = 0; j < i; j++) {
				if (nums[i] > nums[j]) {
					maxval = Math.max(maxval, dp[j]);
				}
			}
			dp[i] = maxval + 1;
			maxans = Math.max(maxans, dp[i]);
		}
		return maxans;
	}

	// binary search
	public int lengthOfLIS2(int[] nums) {
		int[] dp = new int[nums.length];
		int len = 0;
		for (int num : nums) {
			int i = Arrays.binarySearch(dp, 0, len, num);
			if (i < 0) {
				i = -(i + 1);
			}
			dp[i] = num;
			if (i == len) {
				len++;
			}
		}
		return len;
	}

	@Test
	public void test() {
		int[] nums = { 1, 3, 5, 6, 7, 4, 10 };
		System.out.println(lengthOfLIS2(nums));
	}
}
