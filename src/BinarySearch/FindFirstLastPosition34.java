package BinarySearch;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author mac Given an array of integers nums sorted in ascending order, find
 *         the starting and ending position of a given target value.
 * 
 *         Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 *         If the target is not found in the array, return [-1, -1].
 * 
 *         Example 1:
 * 
 *         Input: nums = [5,7,7,8,8,10], target = 8 Output: [3,4] Example 2:
 * 
 *         Input: nums = [5,7,7,8,8,10], target = 6 Output: [-1,-1]
 */
public class FindFirstLastPosition34 {
	public int[] searchRange(int[] nums, int target) {
		if (nums == null || nums.length == 0 || target > nums[nums.length - 1] || target < nums[0]) {
			return new int[] { -1, -1 };
		}

		int[] res = new int[2];
		res[0] = findFirstIndex(target, nums);
		res[1] = findLastIndex(target, nums);
		return res;
	}

	public static int findFirstIndex(int target, int[] nums) {
		int index = -1;
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] >= target) {
				r = mid - 1;
			} else {
				l = mid + 1;
			}

			if (nums[mid] == target) {
				index = mid;
			}
		}
		return index;
	}

	public static int findLastIndex(int target, int[] nums) {
		int index = -1;
		int l = 0, r = nums.length - 1;
		while (l <= r) {
			int mid = l + (r - l) / 2;
			if (nums[mid] <= target) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}

			if (nums[mid] == target) {
				index = mid;
			}
		}
		return index;
	}

	@Test
	public void test() {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		System.out.println(Arrays.toString(searchRange(nums, 8)));
	}
}
