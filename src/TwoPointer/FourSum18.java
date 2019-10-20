package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mac Given an array nums of n integers and an integer target, are
 *         there elements a, b, c, and d in nums such that a + b + c + d =
 *         target? Find all unique quadruplets in the array which gives the sum
 *         of target.
 * 
 *         Note:
 * 
 *         The solution set must not contain duplicate quadruplets.
 * 
 *         Example:
 * 
 *         Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 *         A solution set is: [ [-1, 0, 0, 1], [-2, -1, 1, 2], [-2, 0, 0, 2] ]
 */
public class FourSum18 {
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length < 4)
			return res;
		Arrays.sort(nums);
		int n = nums.length;
		for (int i = 0; i < n - 3; i++) {
			if (nums[i] + nums[n - 3] + nums[n - 2] + nums[n - 1] < target)
				continue;
			for (int j = i + 1; j < n - 2; j++) {

				if (nums[i] + nums[j] + nums[n - 2] + nums[n - 1] < target)
					continue;
				int left = j + 1, right = n - 1;
				while (left < right) {
					int sum = nums[i] + nums[j] + nums[left] + nums[right];
					if (sum == target) {
						res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
						left++;
						right--;
						while (left < n && nums[left] == nums[left - 1])
							left++;
						while (right > i && nums[right] == nums[right + 1])
							right--;
					} else if (sum > target)
						right--;
					else
						left++;

				}
				while (j < n - 2 && nums[j] == nums[j + 1])
					j++;
			}
			while (i < n - 3 && nums[i] == nums[i + 1])
				i++;
		}
		return res;
	}

	public static void main(String[] args) {
		int[] nums = { 1, -2, -5, -4, -3, 3, 3, 5 };
		System.out.println(fourSum(nums, -11));
	}
}
