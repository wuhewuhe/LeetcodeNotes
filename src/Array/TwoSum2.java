package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author he.wu Given an array of integers that is already sorted in ascending
 *         order, find two numbers such that they add up to a specific target
 *         number.
 * 
 *         The function twoSum should return indices of the two numbers such
 *         that they add up to the target, where index1 must be less than
 *         index2.
 * 
 *         Note:
 * 
 *         Your returned answers (both index1 and index2) are not zero-based.
 *         You may assume that each input would have exactly one solution and
 *         you may not use the same element twice. Example:
 * 
 *         Input: numbers = [2,7,11,15], target = 9 Output: [1,2] Explanation:
 *         The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 */

public class TwoSum2 {
	// best solution log n
	public static int[] twoSumBest(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			int x = Arrays.binarySearch(nums, target - nums[i]);
			if (x > 0 && nums[x] + nums[i] == target)
				return nums[i] != nums[i+1] ?  new int[] { i + 1, x + 1 } : new int[] { i + 1, x + 2 };
		}

		throw new IllegalArgumentException("No two sum solution");
	}

	// loop normal
	public int[] twoSumRevo(int[] nums, int target) {
		Map<Integer, Integer> record = new HashMap<Integer, Integer>();
		for (int i = 0; i < nums.length; i++) {
			if (record.containsKey(target - nums[i])) {
				return new int[] { record.get(target - nums[i]) + 1, i + 1 };
			} else {
				record.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	// two pointer
	public static int[] twoSum(int[] numbers, int target) {
		// int indexes[] = new int[2];
		int low = 0, high = numbers.length - 1;
		while (low < high) {
			if ((numbers[low] + numbers[high]) == target) {
				return new int[] { low + 1, high + 1 };
			} else if ((numbers[low] + numbers[high]) > target) {
				high--;
			} else if ((numbers[low] + numbers[high]) < target) {
				low++;
			}
		}
		throw new IllegalArgumentException("No two sum solution");
	}

	public static void main(String[] args) {
		int[] nums = { 5, 25, 75 };
		System.out.println(twoSumBest(nums, 100)[1]);
	}
}
