package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author he.wu Given an array nums of n integers, are there elements a, b, c
 *         in nums such that a + b + c = 0? Find all unique triplets in the
 *         array which gives the sum of zero.
 * 
 *         Note:
 * 
 *         The solution set must not contain duplicate triplets.
 * 
 *         Example:
 * 
 *         Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 *         A solution set is: [ [-1, 0, 1], [-1, -1, 2] ]
 */
public class ThreeSum15 {
	public static List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (nums.length < 3)
			return list;
		Arrays.sort(nums);
		int n = nums.length;
		for (int i = 0; i < nums.length - 2; i++) {
			if (nums[i] > 0)
				break;
			if (nums[i] + nums[n - 1] + nums[n - 2] < 0)
				continue;
			if (i > 0 && nums[i] == nums[i - 1]) { // skip same result
				continue;
			}
			int left = i + 1, right = n - 1;
			while (left < right) {
				if (nums[left] + nums[right] + nums[i] == 0) {
					list.add(Arrays.asList(nums[i], nums[left], nums[right]));
					left++;
					right--;
					while (left < right && nums[left] == nums[left - 1])
						left++;
					while (right > 0 && nums[right] == nums[right + 1])
						right--;
				} else if (nums[left] + nums[right] + nums[i] < 0)
					left++;
				else
					right--;
			}
		}
		return list;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 0, 0, 2, 2 };
		System.out.println(threeSum(nums));
	}
}
