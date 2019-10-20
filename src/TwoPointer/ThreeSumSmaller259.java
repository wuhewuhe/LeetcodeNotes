package TwoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author mac Given an array of n integers nums and a target, find the number
 *         of index triplets i, j, k with 0 <= i < j < k < n that satisfy the
 *         condition nums[i] + nums[j] + nums[k] < target.
 * 
 *         For example, given nums = [-2, 0, 1, 3], and target = 2.
 * 
 *         Return 2. Because there are two triplets which sums are less than 2:
 * 
 *         [-2, 0, 1] [-2, 0, 3] Follow up: Could you solve it in O(n2) runtime?
 */
public class ThreeSumSmaller259 {

	public int threeSumSmaller2(int[] nums, int target) {
		int count = 0;

		Arrays.sort(nums);
		for (int i = 0; i < nums.length - 2; i++) {
			int start = i + 1;
			int end = nums.length - 1;
			while (start < end) {
				// If i + start + end less than target then that means everything between
				// Second and third element also meets condition, so count all of them and move
				// middle by one
				if (nums[i] + nums[start] + nums[end] < target) {
					count += end - start;
					start++;
				} else {
					// Sum is too big only way to get it down is by reducing last element
					end--;
				}
			}
		}
		return count;
	}

	// no duplicate
	public static List<List<Integer>> threeSumSmaller3(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length < 3)
			return res;
		Arrays.sort(nums);
		if (nums[0] >= target)
			return res;
		int n = nums.length;
		for (int i = 0; i < n - 2; i++) {
			if (nums[i] >= target || nums[i] + nums[i + 1] + nums[i + 2] >= target)
				break;
			int left = i + 1, right = n - 1;
			while (left < right) {
				if (nums[i] + nums[left] + nums[right] < target) {
					right--;
					while (right > left && nums[right] == nums[right + 1]) {
						right--;
					}
					if (right == left)
						break;
					if (nums[i] + nums[right + 1] + nums[right] < target)
						res.add(Arrays.asList(nums[i], nums[right], nums[right + 1]));
					if (nums[i] + nums[right + 1] + nums[right + 2] < target)
						res.add(Arrays.asList(nums[i], nums[right + 1], nums[right + 2]));
					if (nums[left] == nums[right])
						res.add(Arrays.asList(nums[i], nums[left], nums[right]));

				} else
					right--;
			}

		}
		return res;

	}


	public static void main(String[] args) {
		int[] nums = { -2, 1, 1, 1, 0, 0, 2, 2, 2 };
		System.out.println(threeSumSmaller3(nums, 2));
	}
}
