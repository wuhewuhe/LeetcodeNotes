package Array;

import org.junit.Test;

public class LongestContinuousIncreasingSubsequence674 {
	
	//time o(n) space o(n)
	public int findLengthOfLCIS(int[] nums) {
		if (nums == null || nums.length == 0)
			return 0;
		int i = 1;
		int[] ans = new int[nums.length];
		ans[0] = 1;
		while (i < nums.length) {
			ans[i] = nums[i] > nums[i - 1] ? ans[i - 1] + 1 : 1;
			i++;
		}
		int max = 1;
		for (int ele : ans) {
			max = Math.max(ele, max);
		}
		return max;
	}

	
	
	@Test
	public void test() {
		int[] nums = { 1, 3, 5, 4, 7 };
		System.out.println(findLengthOfLCIS(nums));
	}
}
