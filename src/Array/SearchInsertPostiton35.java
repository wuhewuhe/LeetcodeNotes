package Array;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author he.wu Given a sorted array and a target value, return the index if
 *         the target is found. If not, return the index where it would be if it
 *         were inserted in order.
 * 
 *         You may assume no duplicates in the array.
 * 
 *         Example 1:
 * 
 *         Input: [1,3,5,6], 5 Output: 2 Example 2:
 * 
 *         Input: [1,3,5,6], 2 Output: 1 Example 3:
 * 
 *         Input: [1,3,5,6], 7 Output: 4 Example 4:
 * 
 *         Input: [1,3,5,6], 0 Output: 0
 */
public class SearchInsertPostiton35 {

	public int searchInsert(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return 0;
		int ans = Arrays.binarySearch(nums, target);
		return ans >= 0 ? ans : -(ans + 1);
	}

	@Test
	public void test() {
		int[] nums = { 1, 3, 5, 6 };
		System.out.println(searchInsert(nums, 7));
	}
}
