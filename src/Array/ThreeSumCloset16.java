package Array;

import java.util.Arrays;

import org.junit.Test;

/**
 * @author he.wu Given an array nums of n integers and an integer target, find
 *         three integers in nums such that the sum is closest to target. Return
 *         the sum of the three integers. You may assume that each input would
 *         have exactly one solution.
 * 
 *         Example:
 * 
 *         Given array nums = [-1, 2, 1, -4], and target = 1.
 * 
 *         The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 */
public class ThreeSumCloset16 {

	public int threeSumClosest(int[] nums, int target) {
		if (nums == null || nums.length == 0)
			return 0;
		if (nums.length == 1)
			return Math.abs(target - nums[0]);
		int result = nums[0] + nums[1] + nums[nums.length - 1];
		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int low = i + 1, high = nums.length - 1;
			while (low < high) {
				int sum = nums[i] + nums[low] + nums[high];
				if (sum > target)
					high--;
				else
					low++;
				if (Math.abs(sum - target) < Math.abs(result - target)) {
					result = sum;
				}
			}
		}
		return result;
	}

	public int threeSumClosest2(int[] nums, int target) {
		Arrays.sort(nums);
		int closest = 0;
		int minDiff = Integer.MAX_VALUE;
		for (int i = 0; i < nums.length; i++) {
			int j = i + 1;
			int k = nums.length - 1;
			while (j < k) {
				int sum = nums[i] + nums[j] + nums[k];
				if (sum == target)
					return sum;
				if (sum < target)
					j++;
				else
					k--;
				int diff = Math.abs(sum - target);
				if (diff < minDiff) {
					minDiff = diff;
					closest = sum;
				}
			}
		}
		return closest;
	}

	@Test
	public void test() {
		int[] nums = { -1, 1, 2, 4 };
		System.out.println(threeSumClosest2(nums,2));
	}
}
