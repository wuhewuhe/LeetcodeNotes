package TwoPointer;

import org.junit.Test;

/**
 * @author mac 238. Product of Array Except Self Medium
 * 
 *         2920
 * 
 *         251
 * 
 *         Favorite
 * 
 *         Share Given an array nums of n integers where n > 1, return an array
 *         output such that output[i] is equal to the product of all the
 *         elements of nums except nums[i].
 * 
 *         Example:
 * 
 *         Input: [1,2,3,4] Output: [24,12,8,6] Note: Please solve it without
 *         division and in O(n).
 * 
 *         Follow up: Could you solve it with constant space complexity? (The
 *         output array does not count as extra space for the purpose of space
 *         complexity analysis.)
 */
public class ProfuctArratExceptSelf238 {

	public int[] productExceptSelf(int[] nums) {
		if (nums.length == 0 || nums == null)
			return null;
		if (nums.length == 1)
			return nums;
		int[] res = new int[nums.length];
		int n = 1;
		for (int i : nums)
			n *= i;
		for (int i = 0; i < res.length; i++) {
			res[i] = n / nums[i];
		}
		return res;
	}

	public int[] productExceptSelf2(int[] nums) {
		if (nums.length == 0 || nums == null)
			return null;
		if (nums.length == 1)
			return nums;
		int[] res = new int[nums.length];
		for (int i = 0; i < res.length; i++) {
			int tem = 1;
			for (int j = 0; j < res.length; j++) {
				if (j != i)
					tem *= nums[j];
			}
			res[i] = tem;
		}
		return res;
	}

	public int[] productExceptSelf3(int[] nums) {

		// The length of the input array
		int length = nums.length;

		// The left and right arrays as described in the algorithm
		int[] left = new int[length];
		int[] right = new int[length];
		left[0] = 1;
		right[length - 1] = 1;
		for (int i = 1; i < length; i++)
			left[i] = left[i - 1] * nums[i - 1];
		for (int i = length - 2; i >= 0; i--)
			right[i] = right[i + 1] * nums[i + 1];
		for (int i = 0; i < length; i++)
			nums[i] = right[i] * left[i];
		return nums;

	}

	// constant space
	public int[] productExceptSelf4(int[] nums) {
		// The length of the input array
		int length = nums.length;

		// Final answer array to be returned
		int[] answer = new int[length];

		// answer[i] contains the product of all the elements to the left
		// Note: for the element at index '0', there are no elements to the left,
		// so the answer[0] would be 1
		answer[0] = 1;
		for (int i = 1; i < length; i++) {

			// answer[i - 1] already contains the product of elements to the left of 'i - 1'
			// Simply multiplying it with nums[i - 1] would give the product of all
			// elements to the left of index 'i'
			answer[i] = nums[i - 1] * answer[i - 1];
		}

		// R contains the product of all the elements to the right
		// Note: for the element at index 'length - 1', there are no elements to the
		// right,
		// so the R would be 1
		int R = 1;
		for (int i = length - 1; i >= 0; i--) {

			// For the index 'i', R would contain the
			// product of all elements to the right. We update R accordingly
			answer[i] = answer[i] * R;
			R *= nums[i];
		}

		return answer;
	}

	@Test
	public void test() {
		int[] nums = { 1, 2, 3, 4 };
		System.out.println(productExceptSelf2(nums));
	}

}
