package Array;

import org.junit.Test;

/**
 * @author mac Given an integer array, you need to find one continuous subarray
 *         that if you only sort this subarray in ascending order, then the
 *         whole array will be sorted in ascending order, too.
 * 
 *         You need to find the shortest such subarray and output its length.
 * 
 *         Example 1: Input: [2, 6, 4, 8, 10, 9, 15] Output: 5 Explanation: You
 *         need to sort [6, 4, 8, 10, 9] in ascending order to make the whole
 *         array sorted in ascending order. Note:
 * 
 *         Then length of the input array is in range [1, 10,000]. The input
 *         array may contain duplicates, so ascending order here means <=.
 */
public class ShortestUnsortedSubarray581 {

	// approach brute force
	public int findUnsortedSubarray(int[] nums) {
		int res = nums.length;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j <= nums.length; j++) {
				int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, prev = Integer.MIN_VALUE;
				for (int k = i; k < j; k++) {
					min = Math.min(min, nums[k]);
					max = Math.max(max, nums[k]);
				}
				if ((i > 0 && nums[i - 1] > min) || (j < nums.length && nums[j] < max))
					continue;
				int k = 0;
				while (k < i && prev <= nums[k]) {
					prev = nums[k];
					k++;
				}
				if (k != i)
					continue;
				k = j;
				while (k < nums.length && prev <= nums[k]) {
					prev = nums[k];
					k++;
				}
				if (k == nums.length) {
					res = Math.min(res, j - i);

				}
			}
		}
		return res;
	}
	
	 public int findUnsortedSubarray2(int[] nums) {
	        int l = nums.length, r = 0;
	        for (int i = 0; i < nums.length - 1; i++) {
	            for (int j = i + 1; j < nums.length; j++) {
	                if (nums[j] < nums[i]) {
	                    r = Math.max(r, j);
	                    l = Math.min(l, i);
	                }
	            }
	        }
	        return r - l < 0 ? 0 : r - l + 1;
	    }


	@Test
	public void test() {
		int[] nums = {2,6,4,8,10,9,15};
		System.out.println(findUnsortedSubarray2(nums));
	}
}
