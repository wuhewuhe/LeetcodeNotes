package SortAlgorithme;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author mac Given an unsorted array nums, reorder it such that nums[0] <
 *         nums[1] > nums[2] < nums[3]....
 * 
 *         Example 1:
 * 
 *         Input: nums = [1, 5, 1, 1, 6, 4] Output: One possible answer is [1,
 *         4, 1, 5, 1, 6]. Example 2:
 * 
 *         Input: nums = [1, 3, 2, 2, 3, 1] Output: One possible answer is [2,
 *         3, 1, 3, 1, 2]. Note: You may assume all input has valid answer.
 * 
 *         Follow Up: Can you do it in O(n) time and/or in-place with O(1) extra
 *         space?
 */
public class WiggleSortII324 {
	public void wiggleSort(int[] nums) {
		Arrays.sort(nums);
		int n = nums.length, mid = n % 2 == 0 ? n / 2 - 1 : n / 2;
		int[] temp = Arrays.copyOf(nums, n);
		int index = 0;
		for (int i = 0; i <= mid; i++) {
			nums[index] = temp[mid - i];
			if (index + 1 < n)
				nums[index + 1] = temp[n - i - 1];
			index += 2;
		}
	}

	@Test
	public void test() {
		int[] nums = { 1, 5, 1, 1, 6, 4 };
		wiggleSort(nums);
		System.out.println(nums);
	}
}
