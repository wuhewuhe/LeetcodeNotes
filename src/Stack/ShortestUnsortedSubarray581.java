package Stack;

import java.util.Arrays;
import java.util.Stack;

import org.junit.Test;

/**
 * @author mac Given an integer array, you need to find one continuous subarray
 *         that if you only sort this subarray in ascending order, then the
 *         whole array will be sorted in ascending order, too.
 * 
 *         You need to find the shortest such subarray and output its length.
 * 
 *         Example 1: Input: [2, 6, 4, 8, 10, 9, 15] Output: 5 Explanation: You
 *         need to sort [6, 4, 8, 10, 9] in ascending order to make the whole
 *         array sorted in ascending order. Note:
 * 
 *         Then length of the input array is in range [1, 10,000]. The input
 *         array may contain duplicates, so ascending order here means <=.
 */

public class ShortestUnsortedSubarray581 {

	// approach brute force
	public int findUnsortedSubarray(int[] nums) {
		int res = nums.length;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i; j <= nums.length; j++) {
				int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE, prev = Integer.MIN_VALUE;
				for (int k = i; k < j; k++) {
					min = Math.min(min, nums[k]);
					max = Math.max(max, nums[k]);
				}
				if ((i > 0 && nums[i - 1] > min) || (j < nums.length && nums[j] < max))
					continue;
				int k = 0;
				while (k < i && prev <= nums[k]) {
					prev = nums[k];
					k++;
				}
				if (k != i)
					continue;
				k = j;
				while (k < nums.length && prev <= nums[k]) {
					prev = nums[k];
					k++;
				}
				if (k == nums.length) {
					res = Math.min(res, j - i);

				}
			}
		}
		return res;
	}

	/*
	 * make sure the shortest subarray means that we should know the left and righr
	 * boundary time complex n^2 space complex o(1)
	 */
	public int FindUnsortedSubarray(int[] nums) {
		int right = 0, left = nums.length;
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] > nums[j]) {
					left = Math.min(left, i);
					right = Math.max(right, j);
				}
			}
		}
		return right - left > 0 ? right - left + 1 : 0;
	}

	/*
	 * using array sorted and then compare these time complex o(nlogn) space complex
	 * o(n)
	 */
	public int FindUnsortedSubarray2(int[] nums) {
		int[] copy = nums.clone();
		Arrays.sort(nums);
		int left = nums.length, right = 0;
		for (int i = 0; i < copy.length; i++) {
			if (copy[i] != nums[i]) {
				left = Math.min(left, i);
				right = Math.max(right, i);
			}
		}
		return right - left > 0 ? right - left + 1 : 0;
	}

	/*
	 * Monastic stack we need determine the correct position of minimum and maximum
	 * element in the unsorted subarray make use of stack, we traverse over the nums
	 * array starting from begining, as we go on facing elements in ascending order
	 * we keep on pushing element indice over the stack. When encounter a failling
	 * slope, we pop a element form a stack until correspond his correct indice
	 * 
	 */
	public int FindUnsortedSubarray3(int[] nums) {
		if (nums.length < 2)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int left = nums.length, right = 0;
		for (int i = 0; i < nums.length; i++) {
			while (!stack.isEmpty() && nums[stack.peek()] > nums[i])
				left = Math.min(left, stack.pop());
			stack.push(i);
		}
		stack.clear();
		for (int i = nums.length - 1; i >= 0; i--) {
			while (!stack.isEmpty() && nums[stack.peek()] < nums[i])
				right = Math.max(right, stack.pop());
			stack.push(i);
		}
		return right - left > 0 ? right - left + 1 : 0;
	}

	// change while and use i --
	public int FindUnsortedSubarray4(int[] nums) {
		if (nums.length < 2)
			return 0;
		Stack<Integer> stack = new Stack<Integer>();
		int left = nums.length - 1, right = 0;
		for (int i = 0; i < nums.length; i++) {
			if (stack.isEmpty() || nums[stack.peek()] <= nums[i])
				stack.push(i);
			else {
				left = Math.min(left, stack.pop());
				i--;
			}
		}
		stack.clear();
		for (int i = nums.length - 1; i >= 0; i--) {
			if (stack.isEmpty() || nums[stack.peek()] >= nums[i])
				stack.push(i);
			else {
				right = Math.max(right, stack.pop());
				i++;
			}
		}
		return right - left > 0 ? right - left + 1 : 0;
	}

	// without using extra space
	public int FindUnsortedSubarray5(int[] nums) {
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		boolean flag = false;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] < nums[i - 1])
				flag = true;
			if (flag)
				min = Math.min(min, nums[i]);
		}
		flag = false;
		for (int i = nums.length - 2; i >= 0; i--) {
			if (nums[i] > nums[i + 1])
				flag = true;
			if (flag)
				max = Math.max(max, nums[i]);
		}
		int left, right;
		for (left = 0; left < nums.length; left++) {
			if (min < nums[left])
				break;
		}
		for (right = nums.length - 1; right >= 0; right--) {
			if (max > nums[right])
				break;
		}
		return right - left < 0 ? 0 : right - left + 1;
	}

	@Test
	public void test() {
		int[] nums = { 2, 6, 4, 8, 10, 9, 15 };
		System.out.println(FindUnsortedSubarray5(nums));
	}
}
