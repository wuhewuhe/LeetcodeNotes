package TwoPointer;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

/**
 * @author he.wu Given an array A of 0s and 1s, we may change up to K values
 *         from 0 to 1.
 * 
 *         Return the length of the longest (contiguous) subarray that contains
 *         only 1s.
 * 
 * 
 * 
 *         Example 1:
 * 
 *         Input: A = [1,1,1,0,0,0,1,1,1,1,0], K = 2 Output: 6 Explanation:
 *         [1,1,1,0,0,1,1,1,1,1,1] Bolded numbers were flipped from 0 to 1. The
 *         longest subarray is underlined. Example 2:
 * 
 *         Input: A = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], K = 3 Output: 10
 *         Explanation: [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1] Bolded numbers
 *         were flipped from 0 to 1. The longest subarray is underlined.
 * 
 * 
 *         Note:
 * 
 *         1 <= A.length <= 20000 0 <= K <= A.length A[i] is 0 or 1
 */
public class MaxConsecutiveOnesIII1004 {
	// sliding window
	public int longestOnes(int[] nums, int k) {
		if (nums.length == 0 || nums == null)
			return 0;
		int count = 0;
		for (int i : nums) {
			if (i == 0)
				count++;
		}
		if (k >= count)
			return nums.length;
		count = 0;
		int l = 0, res = 0;
		Queue<Integer> queue = new LinkedList<Integer>(); // record index of changing
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] == 0) {
				count++;
				queue.add(i);
			}
			if (queue.size() > k) {
				int tem = queue.poll();
				l = tem + 1;
				count--;
			}
			res = Math.max(res, i - l + 1);
		}
		return res;
	}

	// find the longest subarray at most k zeros
	public int longestOnes2(int[] nums, int k) {
		int left = 0, i;
		for (i = 0; i < nums.length; i++) {
			if (nums[i] == 0)
				k--;
			if (k < 0) {
				if (nums[left] == 0)
					k++;
				left++;
			}
		}
		return i - left;
	}

	@Test
	public void test() {
		int[] nums = { 1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0 };
		int k = 2;
		System.out.println(longestOnes2(nums, k));
	}
}
