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
	// high：寻找比target小，但是其右边比target大的坐标
	// low：寻找比target大，但是左边比target小的坐标
	public static int[] twoSumBest(int[] numbers, int target) {
		int low = 0;
		int high = numbers.length - 1;
		while (low < high) {
			if ((numbers[low] + numbers[high]) > target) {
				int start = low + 1;
				int end = high;
				while (start < end) {
					int mid = (start + end) / 2;
					if ((numbers[low] + numbers[mid]) > target) {
						end = mid - 1;
					} else if ((numbers[low] + numbers[mid]) < target) {
						start = mid + 1;
					} else {
						end = mid;
						break;
					}
				}
				if ((numbers[low] + numbers[end]) > target)
					end--;
				high = end;
			} else if ((numbers[low] + numbers[high]) < target) {
				int start = low;
				int end = high - 1;
				while (start < end) {
					int mid = (start + end) / 2;
					if ((numbers[high] + numbers[mid]) > target) {
						end = mid - 1;
					} else if ((numbers[high] + numbers[mid]) < target) {
						start = mid + 1;
					} else {
						end = mid;
						break;
					}
				}
				if ((numbers[end] + numbers[high]) < target)
					end++;
				low = end;
			} else {
				break;
			}
		}
		return new int[] { low + 1, high + 1 };
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
		int[] nums = { 5, 25, 75, 120 };
		System.out.println(twoSumBest(nums, 100)[0] + " " + twoSumBest(nums, 100)[1]);
	}
}
