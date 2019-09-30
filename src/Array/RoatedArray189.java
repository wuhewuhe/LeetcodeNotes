package Array;

import org.junit.Test;

/**
 * @author he.wu Given an array, rotate the array to the right by k steps, where
 *         k is non-negative.
 * 
 *         Example 1:
 * 
 *         Input: [1,2,3,4,5,6,7] and k = 3 Output: [5,6,7,1,2,3,4] Explanation:
 *         rotate 1 steps to the right: [7,1,2,3,4,5,6] rotate 2 steps to the
 *         right: [6,7,1,2,3,4,5] rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *         Example 2:
 * 
 *         Input: [-1,-100,3,99] and k = 2 Output: [3,99,-1,-100] Explanation:
 *         rotate 1 steps to the right: [99,-1,-100,3] rotate 2 steps to the
 *         right: [3,99,-1,-100]
 */
public class RoatedArray189 {

	// create a new array
	public void Roate(int[] nums, int k) {
		if (nums.length == 0 || nums == null)
			throw new IllegalArgumentException("verify ur array");
		int[] a = new int[nums.length];
		for (int i = 0; i < nums.length; i++) {
			a[(i + k) % nums.length] = nums[i];
		}
		for (int i = 0; i < nums.length; i++) {
			nums[i] = a[i];
		}
	}

	// cyclic replacement
	public void Rotate2(int[] nums, int k) {
		k = k % nums.length;
		int count = 0;
		for (int start = 0; count < nums.length; start++) {
			int current = start;
			int prev = nums[start];
			do {
				int next = (current + k) % nums.length;
				int temp = nums[next];
				nums[next] = prev;
				prev = temp;
				current = next;
				count++;
			} while (start != current);
		}
	}

	// using reverse
	/*
	 * in this approach, we inverse all the array, then we inverse respectively 0 -
	 * k-1 and k - n Original List : 1 2 3 4 5 6 7 After reversing all numbers : 7 6
	 * 5 4 3 2 1 After reversing first k numbers : 5 6 7 4 3 2 1 After revering last
	 * n-k numbers : 5 6 7 1 2 3 4 --> Result
	 */
	public void Rotate3(int[] nums, int k) {
		k %= nums.length;
		reverse(nums, 0, nums.length - 1);
		reverse(nums, 0, k - 1);
		reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
		while (start < end) {
			int temp = nums[start];
			nums[start] = nums[end];
			nums[end] = temp;
			start++;
			end--;
		}
	}

	@Test
	public void test() {

	}
}
